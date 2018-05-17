package cuc.waimai.service.serviceImpl;

import cuc.waimai.entity.Category;
import cuc.waimai.entity.Food;
import cuc.waimai.entity.FoodShop;
import cuc.waimai.mapper.CategoryMapper;
import cuc.waimai.mapper.FoodMapper;
import cuc.waimai.mapper.FoodShopMapper;
import cuc.waimai.po.ServerPath;
import cuc.waimai.service.BatService;
import cuc.waimai.util.FileOperationUtil;
import cuc.waimai.util.ProgressMapUtil;
import cuc.waimai.util.logger.MyLogger;
import cuc.waimai.util.logger.MyLoggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.opencsv.CSVReader;


import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Map;

@Service
public class BatServiceImpl implements BatService {

    private static final String TAG = "BatServiceImpl.class";
    private boolean flag = false;

    @Autowired
    FoodMapper foodMapper;
    @Autowired
    FoodShopMapper foodShopMapper;
    @Autowired
    CategoryMapper categoryMapper;

    private MyLogger myLogger;

    @Override
    public int bat(String filePathname, Integer shopId, String imgPathname, File batchLog, HttpSession session) {
        ProgressMapUtil.progress.put(shopId,0);
        FileOperationUtil fileOperationUtil = new FileOperationUtil(batchLog.getPath());
        myLogger = new MyLoggerImpl(batchLog.getPath(), TAG);
        myLogger.doLog("批量导入开始", 3);
        String imgSavePathname = ServerPath.RESOURSES_PATH + "resources/imgofdata";
        String shopDir = "shop" + shopId + "img";
        fileOperationUtil.copyFolder(imgPathname, imgSavePathname + "/" + shopDir);
        myLogger.doLog("读取上传图片", 3);
        List<File> imgList = fileOperationUtil.readFiles(imgPathname);
        myLogger.doLog("读取上传数据", 3);
        List<String[]> list = CSVReader(filePathname);
        List<String[]> listFinal=new ArrayList<>();
        for(String[] ss : list){
            if(!ss[0].isEmpty()){
                listFinal.add(ss);
            }
        }
        listFinal.remove(0);
        System.out.println("listfinal长度"+listFinal.size());
        double finish=0;
        try {
            for (String[] ss : listFinal) {
                boolean imgFlag=false;
                if (ss[0].equals("")) {
                    System.out.println("break");
                    continue;
                } else if (ss[1].isEmpty()||ss[2].isEmpty()||ss[3].isEmpty()||ss[4].isEmpty()) {
                    myLogger.doLog("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    myLogger.doLog("错误数据", 3);
                    for (String s : ss) {
                        myLogger.doLog(s);
                    }
                    myLogger.doLog("", 0);
                    flag = true;
                    continue;
                }
                int i = 0;
                myLogger.doLog("上传数据内容");
                for (String s : ss) {
                    myLogger.doLog("[" + i + "]" + ">>>" + s);
                    i++;
                }
                myLogger.doLog("", 1);
                Integer catId;
                Integer foodId;
                Category category = categoryMapper.selectByCatName(ss[3]);
                if (category == null) {
                    category = new Category();
                    category.setCatName(ss[3]);
                    myLogger.doLog("创建新食品种类" + ss[3]);
                    categoryMapper.insert(category);
                    catId = category.getCatId();
                    myLogger.doLog("新食品种类ID:" + catId);
                } else {
                    catId = category.getCatId();
                    myLogger.doLog("已有食品种类ID:" + catId);
                }
                myLogger.doLog("", 1);
                Food food = foodMapper.selectByFoodName(ss[0]);
                if (food == null) {
                    food = new Food();
                    food.setFoodName(ss[0]);
                    myLogger.doLog("创建新食品" + ss[0]);
                    food.setCategoryId(catId);
                    foodMapper.insert(food);
                    foodId = food.getFoodId();
                    myLogger.doLog("新食品ID:" + foodId);
                } else {
                    foodId = food.getFoodId();
                    myLogger.doLog("已有食品ID:" + foodId);

                }
                myLogger.doLog("", 1);
                FoodShop foodShopData = foodShopMapper.selectByFoodIdAndShopId(foodId, shopId);
                FoodShop foodShop = new FoodShop();
                foodShop.setFoodId(foodId);
                foodShop.setShopId(shopId);
                foodShop.setFoodPrice(Double.parseDouble(ss[2]));
                foodShop.setFoodDes(ss[1]);
                String foodImgName = ss[4] + ".jpg";
                for (File file : imgList) {
                    if (foodImgName.equals(file.getName())) {
                        File rename = new File(imgSavePathname + "/" + shopDir + "/" + file.getName());
                        String newName = "food" + String.valueOf(shopId) + foodId + ".jpg";
                        rename.renameTo(new File(imgSavePathname + "/" + shopDir + "/" + newName));
                        foodShop.setFoodPic("resources/imgofdata/" + shopDir + "/" + newName);
                        imgFlag=true;
                        myLogger.doLog("foodImgName:" + foodImgName);
                        myLogger.doLog("file.getName:" + file.getName());

                    }

                }
                if (imgFlag){
                    myLogger.doLog(ss[0]+":图片录入成功");
                }else {
                    myLogger.doLog("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    myLogger.doLog(ss[0]+":图片录入失败，未找到图片");
                    myLogger.doLog("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    flag=true;
                }
                if (foodShopData == null) {
                    myLogger.doLog("商铺" + shopId + "新增食品条目：" + food.getFoodName());
                    foodShopMapper.insert(foodShop);
                } else {
                    myLogger.doLog("商铺" + shopId + "更新食品条目：" + food.getFoodName());
                    File deletImg = new File(ServerPath.RESOURSES_PATH + foodShopData.getFoodPic());
                    foodShop.setFoodShopId(foodShopData.getFoodShopId());
                    int r = foodShopMapper.updateByPrimaryKey(foodShop);
                    myLogger.doLog("更新结果" + r);

                }
                myLogger.doLog("", 1);
                finish=finish+1;
                double all=listFinal.size();
                int progress=(int)((finish/all)*100);
                System.out.println(progress);
                session.setAttribute("progress",progress);
            }


            myLogger.doLog("批量导入成功", 3);
            myLogger.doLog("删除缓存");
            try {
                fileOperationUtil.deletefile(ServerPath.RESOURSES_PATH + "resources/batchdata/" + "shop" + shopId + "data");
                fileOperationUtil.deletefile(ServerPath.RESOURSES_PATH + "resources/batchdata/" + "shop" + shopId + "img");
            } catch (Exception e) {
            }
            myLogger.doLog("", 1);
            if (flag) {
                return 2;
            } else {
                return 1;
            }

        } catch (Exception e) {
            myLogger.doLog("批量导入失败", 3);
            myLogger.doLog(e.getMessage());
            myLogger.doLog("删除缓存");
            try {
                fileOperationUtil.deletefile(ServerPath.RESOURSES_PATH + "resources/batchdata/" + "shop" + shopId + "data");
                fileOperationUtil.deletefile(ServerPath.RESOURSES_PATH + "resources/batchdata/" + "shop" + shopId + "img");
            } catch (Exception e1) {
            }
            e.printStackTrace();
            return 0;
        }
    }

    public List<String[]> CSVReader(String pathname) {
        File file = new File(pathname);
        try {
            FileReader fReader = new FileReader(file);
            CSVReader csvReader = new CSVReader(fReader);
            return csvReader.readAll();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
