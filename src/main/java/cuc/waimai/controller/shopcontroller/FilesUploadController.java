package cuc.waimai.controller.shopcontroller;

import cuc.waimai.service.BatService;
import cuc.waimai.util.FileOperationUtil;
import cuc.waimai.util.XLS2CSV;
import cuc.waimai.util.XLSX2CSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
public class FilesUploadController {

    @Autowired
    BatService batService;

    @RequestMapping(value = "/fileUpload.do", method = RequestMethod.POST)
    @ResponseBody
    public int fileUpload(
            @RequestParam("shopId") String shopId,
            @RequestParam("uploadFile") MultipartFile file,
            @RequestParam("uploadZip") MultipartFile zip) throws IOException {
        String finalZipPathName="";
        String finalDataPathName="";
        if (!zip.isEmpty()) {
            //上传文件名
            String mainName = "s"+shopId + new Date();
            //生成目录名字
            String dirName = "shop"+shopId+"img";
            // 截取文件的扩展名(如.jpg)
            String oriName = zip.getOriginalFilename();
            String extName = oriName.substring(oriName.lastIndexOf("."));
            //将上传文件保存到一个目标文件当中
            String pathname="/home/zz/ideaprojects/waimai/src/main/webapp/resources/batchdata/";
            File tool=new File(pathname+dirName);
            if(!tool.exists()){
                tool.mkdirs();
            }

            zip.transferTo(new File( pathname+dirName+"/"+ mainName + extName));
            finalZipPathName=pathname+dirName+"/";
            File zipper=new File(finalZipPathName+mainName+extName);
            FileOperationUtil fileOperationUtil=new FileOperationUtil();
            try {
                fileOperationUtil.unZipFile(zipper);
            }catch (Exception e){
                e.printStackTrace();
                return 400;
            }

        }

        if (!file.isEmpty()) {
            //上传文件名
            String mainName = "s"+shopId + new Date();
            //生成目录名字
            String dirName = "shop"+shopId+"data";
            // 截取文件的扩展名(如.jpg)
            String oriName = file.getOriginalFilename();
            String extName = oriName.substring(oriName.lastIndexOf("."));
            //将上传文件保存到一个目标文件当中
            String pathname="/home/zz/ideaprojects/waimai/src/main/webapp/resources/batchdata/";
            File tool=new File(pathname+dirName);
            if(!tool.exists()){
                tool.mkdirs();
            }
            file.transferTo(new File( pathname+dirName+"/"+ mainName + extName));
            finalDataPathName=pathname+dirName+"/";
            //判断文件类型格式转换
            if (extName.equals(".xls")){
                System.out.println("我是xls");
                try {
                    XLS2CSV xls2CSV=new XLS2CSV(
                            finalDataPathName+mainName+extName,
                            finalDataPathName+mainName+ ".csv");
                    xls2CSV.process();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else if (extName.equals(".xlsx")){
                System.out.println("我是xlsx");
                try {
                    XLSX2CSV xlsx2CSV=new XLSX2CSV(
                            finalDataPathName+mainName+extName,
                            finalDataPathName+mainName+ ".csv");
                    xlsx2CSV.process();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else if (extName.equals(".csv")){
                System.out.println("我是csv");
            }else {
                return 400;
            }
           if (batService.bat(finalDataPathName+ mainName + ".csv",
                   Integer.parseInt(shopId),finalZipPathName)==1){
               return 200;
           }
            return 400;
        } else {
            return 400;
        }
    }

}
