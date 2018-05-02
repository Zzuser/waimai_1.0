package cuc.waimai.controller.shopcontroller;

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
    @RequestMapping(value = "/fileUpload.do", method = RequestMethod.POST)
    @ResponseBody
    public int fileUpload(
            @RequestParam("shopId") String shopId,
            @RequestParam("uploadFile") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            //上传文件名
            String mainName = "s"+shopId + new Date();
            // 截取文件的扩展名(如.jpg)
            String oriName = file.getOriginalFilename();
            String extName = oriName.substring(oriName.lastIndexOf("."));
            //将上传文件保存到一个目标文件当中
            String pathname="/home/zz/ideaprojects/waimai/src/main/webapp/resources/batchdata/";
            file.transferTo(new File( pathname+ mainName + extName));
            return 200;
        } else {
            return 400;
        }
    }
}
