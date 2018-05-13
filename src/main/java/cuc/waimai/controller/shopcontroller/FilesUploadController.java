package cuc.waimai.controller.shopcontroller;

import cuc.waimai.po.ServerPath;
import cuc.waimai.service.BatService;
import cuc.waimai.util.FileOperationUtil;
import cuc.waimai.util.ProgressMapUtil;
import cuc.waimai.util.XLS2CSV;
import cuc.waimai.util.XLSX2CSV;
import cuc.waimai.util.logger.MyLogger;
import cuc.waimai.util.logger.MyLoggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
public class FilesUploadController {
    private static final String TAG = "FilesUploadController.class";
    private FileOperationUtil fileOperationUtil;
    private MyLogger myLogger;
    @Autowired
    BatService batService;

    @RequestMapping(value = "/fileUpload.do", method = RequestMethod.POST)
    public ModelAndView fileUpload(
            @RequestParam("shopId") String shopId
            , @RequestParam("uploadFile") MultipartFile file,
            @RequestParam("uploadZip") MultipartFile zip,
            HttpSession session
    ) throws IOException {
        ModelAndView mav = new ModelAndView();
        String logDirName = "shop" + shopId + "log";
        String logTxtName = "shoplog" + shopId + System.currentTimeMillis() + ".log";
        mav.addObject("logName", logTxtName);
        mav.addObject("logDirName", logDirName);
        File batchLog = new File(ServerPath.RESOURSES_PATH +
                "resources/logofshop/" + logDirName + "/" + logTxtName);
        File batchLogParent = batchLog.getParentFile();
        if (!batchLogParent.exists()) {
            batchLogParent.mkdirs();
        }
        if (!batchLog.exists()) {
            batchLog.createNewFile();
        }
        myLogger = new MyLoggerImpl(batchLog.getPath(), TAG);
        fileOperationUtil = new FileOperationUtil(batchLog.getPath());
        myLogger.doLog("商铺:" + "" + shopId, 0);
        myLogger.doLog("获得数据:" + "" + file.getOriginalFilename());
        myLogger.doLog("图片压缩包:" + "" + zip.getOriginalFilename(), 1);

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
            myLogger.doLog("上传压缩包文件名:" + "" + pathname + dirName + "/" + mainName + extName);
            finalZipPathName = pathname + dirName + "/";
            File zipper = new File(finalZipPathName + mainName + extName);
            try {
                if (fileOperationUtil.unZipFile(zipper)) {
                    myLogger.doLog("解压成功:", 1);
                } else {
                    myLogger.doLog("解压失败:");
                    myLogger.doLog("压缩包格式错误或已损坏", 1);
                    mav.setViewName("baterror");
                    return mav;
                }
            } catch (Exception e) {
                myLogger.doLog("解压失败:");
                myLogger.doLog("压缩包格式错误或已损坏", 1);
                e.printStackTrace();
                mav.setViewName("baterror");
                return mav;
            }
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
            myLogger.doLog("上传数据文件名:" + "" + pathname + dirName + "/" + mainName + extName);
            finalDataPathName = pathname + dirName + "/";
            //判断文件类型格式转换
            if (extName.equals(".xls")) {
                myLogger.doLog("上传数据格式为xls");
                try {
                    XLS2CSV xls2CSV = new XLS2CSV(
                            finalDataPathName + mainName + extName,
                            finalDataPathName + mainName + ".csv");
                    xls2CSV.process();
                    myLogger.doLog("上传数据格式转换成功" + "\r\n" + "转换为：" + finalDataPathName + mainName + ".csv");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (extName.equals(".xlsx")) {
                myLogger.doLog("上传数据格式为xlsx");
                try {
                    XLSX2CSV xlsx2CSV = new XLSX2CSV(
                            finalDataPathName + mainName + extName,
                            finalDataPathName + mainName + ".csv");
                    xlsx2CSV.process();
                    myLogger.doLog("上传数据格式转换成功" + "\r\n" + "转换为：" + finalDataPathName + mainName + ".csv");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (extName.equals(".csv")) {
                myLogger.doLog("上传数据格式为csv");
            } else {
                mav.setViewName("baterror");
                return mav;
            }
            myLogger.doLog("", 1);
            switch (batService.bat(finalDataPathName + mainName + ".csv",
                    Integer.parseInt(shopId), finalZipPathName, batchLog, session)) {

                case 0: {
                    session.setAttribute("progress",0);
                    mav.setViewName("baterror");
                    return mav;
                }
                case 1: {
                    session.setAttribute("progress",0);
                    mav.addObject("NOTOK", "全部成功");
                    mav.setViewName("batsuccess");
                    return mav;
                }
                case 2: {
                    session.setAttribute("progress",0);
                    mav.addObject("NOTOK", "部分数据存在错误！查看日志的错误记录可找到错误数据");
                    mav.setViewName("batsuccess");
                    return mav;
                }
                default: {
                    session.setAttribute("progress",0);
                    mav.setViewName("baterror");
                    return mav;
                }
            }
        } else {
            session.setAttribute("progress",0);
            mav.setViewName("baterror");
            return mav;
        }
    }

    @RequestMapping(value = "/batchProgress.do", method = RequestMethod.POST)
    @ResponseBody
    public int batchProgress(HttpSession session) {
        try {
            Integer prg = (int) session.getAttribute("progress");
            System.out.println(prg);
            return prg;
        } catch (Exception e) {
            return 0;
        }


    }
}
