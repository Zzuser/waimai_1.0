package cuc.waimai.controller.shopcontroller;

import cuc.waimai.po.ServerPath;
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
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
public class FilesUploadController {
    private static final String TAG = "FilesUploadController.class-->";
    @Autowired
    BatService batService;

    @RequestMapping(value = "/fileUpload.do", method = RequestMethod.POST)
    public ModelAndView fileUpload(
            @RequestParam("shopId") String shopId
                 , @RequestParam("uploadFile") MultipartFile file,
               @RequestParam("uploadZip") MultipartFile zip
    ) throws IOException {
        ModelAndView mav=new ModelAndView();
        String logDirName = "shop" + shopId + "log";
        String logTxtName = "shoplog" + shopId + System.currentTimeMillis()+".log";
        mav.addObject("logName",logTxtName);
        mav.addObject("logDirName",logDirName);
        File batchLog = new File(ServerPath.RESOURSES_PATH +
                "resources/logofshop/" + logDirName + "/" + logTxtName);
        File batchLogParent = batchLog.getParentFile();
        if (!batchLogParent.exists()) {
            batchLogParent.mkdirs();
        }
        if (!batchLog.exists()) {
            batchLog.createNewFile();
        }
        FileOperationUtil fileOperationUtil=new FileOperationUtil();
        fileOperationUtil.logCreate(batchLog.getPath(),"=================================================\r\n");
        fileOperationUtil.logCreate(batchLog.getPath(),TAG + "商铺:" + "" + shopId+"\r\n");
        fileOperationUtil.logCreate(batchLog.getPath(),TAG + "获得数据:" + "" + file.getOriginalFilename()+"\r\n");
        fileOperationUtil.logCreate(batchLog.getPath(),TAG + "图片压缩包:" + "" + zip.getOriginalFilename()+"\r\n");
        fileOperationUtil.logCreate(batchLog.getPath(),"=================================================\r\n");
        String finalZipPathName = "";
        String finalDataPathName = "";
        if (!zip.isEmpty()) {
            //上传文件名
            String mainName = "s" + shopId + new Date();
            //生成目录名字
            String dirName = "shop" + shopId + "img";
            // 截取文件的扩展名(如.jpg)
            String oriName = zip.getOriginalFilename();
            String extName = oriName.substring(oriName.lastIndexOf("."));
            //将上传文件保存到一个目标文件当中
            String pathname = ServerPath.RESOURSES_PATH + "resources/batchdata/";
            File tool = new File(pathname + dirName);
            if (!tool.exists()) {
                tool.mkdirs();
            }
            zip.transferTo(new File(pathname + dirName + "/" + mainName + extName));
            fileOperationUtil.logCreate(batchLog.getPath(),TAG + "上传压缩包文件名:" + "" + pathname + dirName + "/" + mainName + extName+"\r\n");

            finalZipPathName = pathname + dirName + "/";
            File zipper = new File(finalZipPathName + mainName + extName);
            try {
                if (fileOperationUtil.unZipFile(zipper)) {
                    fileOperationUtil.logCreate(batchLog.getPath(),TAG + "解压成功:" + ""+"\r\n");
                } else {
                    fileOperationUtil.logCreate(batchLog.getPath(),TAG + "解压失败:" + ""+"\r\n");
                    mav.setViewName("baterror");
                    return mav;
                }
            } catch (Exception e) {
                fileOperationUtil.logCreate(batchLog.getPath(),TAG + "解压失败:" + ""+"\r\n");
                e.printStackTrace();
                mav.setViewName("baterror");
                return mav;
            }
            fileOperationUtil.logCreate(batchLog.getPath(),"================================================="+"\r\n");
        }

        if (!file.isEmpty()) {
            //上传文件名
            String mainName = "s" + shopId + new Date();
            //生成目录名字
            String dirName = "shop" + shopId + "data";
            // 截取文件的扩展名(如.jpg)
            String oriName = file.getOriginalFilename();
            String extName = oriName.substring(oriName.lastIndexOf("."));
            //将上传文件保存到一个目标文件当中
            String pathname = ServerPath.RESOURSES_PATH + "resources/batchdata/";
            File tool = new File(pathname + dirName);
            if (!tool.exists()) {
                tool.mkdirs();
            }
            file.transferTo(new File(pathname + dirName + "/" + mainName + extName));
            fileOperationUtil.logCreate(batchLog.getPath(),TAG + "上传数据文件名:" + "" + pathname + dirName + "/" + mainName + extName+"\r\n");
            finalDataPathName = pathname + dirName + "/";
            //判断文件类型格式转换
            if (extName.equals(".xls")) {
                fileOperationUtil.logCreate(batchLog.getPath(),TAG + "上传数据格式为xls" + ""+"\r\n");
                try {
                    XLS2CSV xls2CSV = new XLS2CSV(
                            finalDataPathName + mainName + extName,
                            finalDataPathName + mainName + ".csv");
                    xls2CSV.process();
                    fileOperationUtil.logCreate(batchLog.getPath(),TAG + "上传数据格式转换成功" + "\r\n" + "转换为：" + finalDataPathName + mainName + ".csv"+"\r\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (extName.equals(".xlsx")) {
                fileOperationUtil.logCreate(batchLog.getPath(),TAG + "上传数据格式为xlsx" + ""+"\r\n");
                try {
                    XLSX2CSV xlsx2CSV = new XLSX2CSV(
                            finalDataPathName + mainName + extName,
                            finalDataPathName + mainName + ".csv");
                    xlsx2CSV.process();
                    fileOperationUtil.logCreate(batchLog.getPath(),TAG + "上传数据格式转换成功" + "\r\n" + "转换为：" + finalDataPathName + mainName + ".csv"+"\r\n");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (extName.equals(".csv")) {
                fileOperationUtil.logCreate(batchLog.getPath(),TAG + "上传数据格式为csv" + ""+"\r\n");
            } else {
                mav.setViewName("baterror");
                return mav;
            }
            fileOperationUtil.logCreate(batchLog.getPath(),"================================================="+"\r\n");
            if (batService.bat(finalDataPathName + mainName + ".csv",
                    Integer.parseInt(shopId), finalZipPathName,batchLog) == 1) {
                mav.setViewName("batsuccess");
                return mav;
            }
            mav.setViewName("baterror");
            return mav;
        } else {
            mav.setViewName("baterror");
            return mav;
       }
    }

}
