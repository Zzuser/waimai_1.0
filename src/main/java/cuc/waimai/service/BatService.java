package cuc.waimai.service;

import javax.servlet.http.HttpSession;
import java.io.File;

public interface BatService {
    public int bat(String filePathname, Integer shopId, String imgPathname, File log,HttpSession session);
}
