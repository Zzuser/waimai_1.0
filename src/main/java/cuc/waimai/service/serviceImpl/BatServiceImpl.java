package cuc.waimai.service.serviceImpl;

import cuc.waimai.Dao.Category;
import cuc.waimai.Dao.Food;
import cuc.waimai.Dao.FoodShop;
import cuc.waimai.mapper.CategoryMapper;
import cuc.waimai.mapper.FoodMapper;
import cuc.waimai.mapper.FoodShopMapper;
import cuc.waimai.po.ServerPath;
import cuc.waimai.service.BatService;
import cuc.waimai.util.FileOperationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;


import java.io.File;

@Service
public class BatServiceImpl implements BatService {

    private static final String TAG = "BatServiceImpl.class-->";
    @Autowired
    FoodMapper foodMapper;
    @Autowired
    FoodShopMapper foodShopMapper;
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public int bat(String filePathname, Integer shopId, String imgPathname, File batchLog) {
        FileOperationUtil fileOperationUtil = new FileOperationUtil();
        fileOperationUtil.logCreate(batchLog.getPath(), "================================================="+"\r\n");
        fileOperationUtil.logCreate(batchLog.getPath(), TAG + "批量导入开始" + ""+"\r\n");
        fileOperationUtil.logCreate(batchLog.getPath(), "================================================="+"\r\n");
        String imgSavePathname = ServerPath.RESOURSES_PATH + "resources/imgofdata";
        String shopDir = "shop" + shopId + "img";
        fileOperationUtil.copyFolder(imgPathname, imgSavePathname + "/" + shopDir,batchLog);
        fileOperationUtil.logCreate(batchLog.getPath(), "================================================="+"\r\n");
        fileOperationUtil.logCreate(batchLog.getPath(), TAG + "读取上传图片" + ""+"\r\n");
        List<File> imgList = fileOperationUtil.readFiles(imgPathname,batchLog);
        fileOperationUtil.logCreate(batchLog.getPath(), "================================================="+"\r\n");
        fileOperationUtil.logCreate(batchLog.getPath(), TAG + "读取上传数据" + "" + filePathname);
        List<String[]> list = CSVReader(filePathname);
        list.remove(0);
        fileOperationUtil.logCreate(batchLog.getPath(), "================================================="+"\r\n");
        try {
            fileOperationUtil.logCreate(batchLog.getPath(), "================================================="+"\r\n");
            for (String[] ss : list) {
                int i = 0;
                fileOperationUtil.logCreate(batchLog.getPath(), TAG + "上传数据内容" + ""+"\r\n");
                for (String s : ss) {
                    fileOperationUtil.logCreate(batchLog.getPath(), ">>>"+s+"\r\n");
                    i++;
                }
                fileOperationUtil.logCreate(batchLog.getPath(), "+++++++++++++++++++++++++++++++++++++++++++++"+"\r\n");
                Integer catId;
                Integer foodId;
                Category category = categoryMapper.selectByCatName(ss[3]);
                if (category == null) {
                    category = new Category();
                    category.setCatName(ss[3]);
                    fileOperationUtil.logCreate(batchLog.getPath(), TAG + "创建新食品种类" + ss[3]+"\r\n");
                    categoryMapper.insert(category);
                    catId = category.getCatId();
                    fileOperationUtil.logCreate(batchLog.getPath(), TAG + "新食品种类ID:" + catId+"\r\n");
                } else {
                    catId = category.getCatId();
                    fileOperationUtil.logCreate(batchLog.getPath(), TAG + "已有食品种类ID:" + catId+"\r\n");
                }
                fileOperationUtil.logCreate(batchLog.getPath(), "+++++++++++++++++++++++++++++++++++++++++++++"+"\r\n");
                Food food = foodMapper.selectByFoodName(ss[0]);
                if (food == null) {
                    food = new Food();
                    food.setFoodName(ss[0]);
                    fileOperationUtil.logCreate(batchLog.getPath(), TAG + "创建新食品" + ss[0]+"\r\n");
                    food.setCategoryId(catId);
                    foodMapper.insert(food);
                    foodId = food.getFoodId();
                    fileOperationUtil.logCreate(batchLog.getPath(), TAG + "新食品ID:" + foodId+"\r\n");
                } else {
                    foodId = food.getFoodId();
                    fileOperationUtil.logCreate(batchLog.getPath(), TAG + "已有食品ID:" + foodId+"\r\n");

                }
                fileOperationUtil.logCreate(batchLog.getPath(), "+++++++++++++++++++++++++++++++++++++++++++++"+"\r\n");
                FoodShop foodShopData = foodShopMapper.selectByFoodIdAndShopId(foodId, shopId);
                FoodShop foodShop = new FoodShop();
                foodShop.setFoodId(foodId);
                foodShop.setShopId(shopId);
                foodShop.setFoodPrice(Double.parseDouble(ss[2]));
                foodShop.setFoodDes(ss[1]);
                String foodImgName = food.getFoodName() + ".jpg";
                for (File file : imgList) {
                    if (foodImgName.equals(file.getName())) {
                        File rename = new File(imgSavePathname + "/" + shopDir + "/" + file.getName());
                        String newName = "food" + String.valueOf(shopId) + foodId + ".jpg";
                        rename.renameTo(new File(imgSavePathname + "/" + shopDir + "/" + newName));
                        foodShop.setFoodPic("resources/imgofdata/" + shopDir + "/" + newName);
                        fileOperationUtil.logCreate(batchLog.getPath(), TAG + "foodImgName:" + foodImgName+"\r\n");
                        fileOperationUtil.logCreate(batchLog.getPath(), TAG + "file.getName:" + file.getName()+"\r\n");
                        fileOperationUtil.logCreate(batchLog.getPath(), TAG + "图片录入成功"+"\r\n");
                    }

                }
                if (foodShopData == null) {
                    fileOperationUtil.logCreate(batchLog.getPath(), TAG + "商铺" + shopId + "新增食品条目：" + food.getFoodName()+"\r\n");
                    foodShopMapper.insert(foodShop);
                } else {
                    fileOperationUtil.logCreate(batchLog.getPath(), TAG + "商铺" + shopId + "更新食品条目：" + food.getFoodName()+"\r\n");
                    File deletImg = new File(ServerPath.RESOURSES_PATH + foodShopData.getFoodPic());
                    fileOperationUtil.logCreate(batchLog.getPath(), TAG + "原来的图片" + deletImg.getPath()+"\r\n");
//                    if (deletImg.exists()){
//                        deletImg.delete();
//                    }
                    foodShopMapper.updateByPrimaryKey(foodShop);
                }
                fileOperationUtil.logCreate(batchLog.getPath(), "================================================="+"\r\n");
            }
            fileOperationUtil.logCreate(batchLog.getPath(), "================================================="+"\r\n");
            fileOperationUtil.logCreate(batchLog.getPath(), TAG + "批量导入成功" + ""+"\r\n");
            fileOperationUtil.logCreate(batchLog.getPath(), "================================================="+"\r\n");
            fileOperationUtil.logCreate(batchLog.getPath(), TAG + "删除缓存" + ""+"\r\n");
            try {
                fileOperationUtil.deletefile(ServerPath.RESOURSES_PATH + "resources/batchdata/" + "shop" + shopId + "data",batchLog);
                fileOperationUtil.deletefile(ServerPath.RESOURSES_PATH + "resources/batchdata/" + "shop" + shopId + "img",batchLog);
            } catch (Exception e) {
            }
            fileOperationUtil.logCreate(batchLog.getPath(), "================================================="+"\r\n");
            return 1;
        } catch (Exception e) {
            fileOperationUtil.logCreate(batchLog.getPath(), "================================================="+"\r\n");
            fileOperationUtil.logCreate(batchLog.getPath(), TAG + "批量导入失败" + "");
            fileOperationUtil.logCreate(batchLog.getPath(), "================================================="+"\r\n");
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
