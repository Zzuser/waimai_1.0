package cuc.waimai.service.serviceImpl;

import com.opencsv.CSVReader;
import cuc.waimai.Dao.Category;
import cuc.waimai.Dao.Food;
import cuc.waimai.Dao.FoodShop;
import cuc.waimai.mapper.CategoryMapper;
import cuc.waimai.mapper.FoodMapper;
import cuc.waimai.mapper.FoodShopMapper;
import cuc.waimai.service.BatService;
import cuc.waimai.util.FileOperationUtil;
import cuc.waimai.util.ReadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BatServiceImpl implements BatService {
    @Autowired
    FoodMapper foodMapper;
    @Autowired
    FoodShopMapper foodShopMapper;
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public int bat(String filePathname, Integer shopId, String imgPathname) {
        String imgSavePathname = "/home/zz/ideaprojects/waimai/src/main/webapp/resources/imgofdata";
        String shopDir = "shop" + shopId + "img";

        FileOperationUtil fileOperationUtil=new FileOperationUtil();
        fileOperationUtil.copyFolder(imgPathname,imgSavePathname+"/"+shopDir);
        ReadFileUtil readFileUtil = new ReadFileUtil();
        List<File> imgList = readFileUtil.test(imgPathname);


        List<String[]> list = CSVReader(filePathname);
        list.remove(0);
        try {
            for (String[] ss : list) {
                int i = 0;
                Integer catId;
                Integer foodId;
                Category category = categoryMapper.selectByCatName(ss[3]);
                if (category == null) {
                    category = new Category();
                    category.setCatName(ss[3]);
                    categoryMapper.insert(category);
                    catId = category.getCatId();
                    System.out.println("CAT" + i + ":" + catId);
                } else {
                    catId = category.getCatId();
                }
                Food food = foodMapper.selectByFoodName(ss[0]);
                if (food == null) {
                    food = new Food();
                    food.setFoodName(ss[0]);
                    food.setCategoryId(catId);
                    foodMapper.insert(food);
                    foodId = food.getFoodId();
                    System.out.println("FOOD" + i + ":" + foodId);
                } else {
                    foodId = food.getFoodId();
                }
                System.out.println("CAT" + i + ":" + catId);
                System.out.println("FOOD" + i + ":" + foodId);
                System.out.println("SHOP" + i + ":" + shopId);
                FoodShop foodShopData = foodShopMapper.selectByFoodIdAndShopId(foodId, shopId);
                FoodShop foodShop = new FoodShop();
                foodShop.setFoodId(foodId);
                foodShop.setShopId(shopId);
                foodShop.setFoodPrice(Double.parseDouble(ss[2]));
                foodShop.setFoodDes(ss[1]);
                String foodImgName = food.getFoodName() + ".jpg";
                for (File file : imgList) {
                    if (foodImgName.equals(file.getName())) {
                        foodShop.setFoodPic("resources/imgofdata/" + shopDir + "/" + file.getName());
                        System.out.println("图片录入成功");
                    } else {
                        System.out.println("foodImgName:" + foodImgName);
                        System.out.println("file.getName:" + file.getName());
                        System.out.println("图片录入失败");
                    }

                }
                if (foodShopData == null) {
                    System.out.println("NEW FOOD");
                    foodShopMapper.insert(foodShop);
                } else {
                    System.out.println("OLD FOOD");
                    foodShopMapper.updateByPrimaryKey(foodShop);
                }

                for (String s : ss) {
                    System.out.println(s + "+++ss[" + i + "]");
                    i++;
                }
            }
            return 1;
        } catch (Exception e) {
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
