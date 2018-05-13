package cuc.waimai.util;

import cuc.waimai.po.ServerPath;
import cuc.waimai.util.logger.MyLogger;
import cuc.waimai.util.logger.MyLoggerImpl;
import org.apache.ibatis.annotations.Param;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipException;

public class FileOperationUtil {
    private static final String TAG = "FileOperationUtil.class";
    private MyLogger myLogger;

    public FileOperationUtil(@Param("logPath") String logPath) {
        myLogger = new MyLoggerImpl(logPath, TAG);
    }

    /**
     * 解压目录/文件
     *
     * @param file
     * @throws IOException
     * @throws ZipException
     */
    public boolean unZipFile(File file) {
        if (file.isDirectory()) {// 目录
            File[] files = file.listFiles();
            for (File tempFile : files) {
                unZipFile(tempFile);
            }
        } else {// 文件
            try {
                if (!file.getName().endsWith(".zip"))
                    return false;
                ZipFile zipFile = new ZipFile(file.getPath(), "UTF8");
                Enumeration entries = zipFile.getEntries();
                String path = file.getParent(); // 获取相对路径
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    String fileName = zipEntry.getName();
                    File newFile = new File(path + "/" + fileName);
                    createFile(newFile, zipFile, zipEntry);
                }
                zipFile.close();//关闭压缩文件，否则不能删除压缩包
                file.delete();//删除压缩包

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /**
     * 解压压缩包里每个文件
     *
     * @param file
     * @param zipFile
     * @param zipEntry
     */
    public void createFile(File file, ZipFile zipFile, ZipEntry zipEntry) {
        if (file.isDirectory()) {
            if (!file.exists()) {
                file.mkdir();
            }
        } else {
            try {
                InputStream is = null;
                OutputStream os = null;
                is = zipFile.getInputStream(zipEntry);
                os = new FileOutputStream(file);
                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = is.read(bytes, 0, bytes.length)) != -1) {
                    os.write(bytes, 0, len);
                }
                is.close();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 复制文件夹里每个文件到新文件夹
     *
     * @param oldPath
     * @param newPath
     */
    public void copyFolder(String oldPath, String newPath) {

        try {
            (new File(newPath)).mkdirs(); //如果文件夹不存在 则建立新文件夹
            File a = new File(oldPath);
            String[] file = a.list();
            File temp = null;
            for (int i = 0; i < file.length; i++) {
                if (oldPath.endsWith(File.separator)) {
                    temp = new File(oldPath + file[i]);
                } else {
                    temp = new File(oldPath + File.separator + file[i]);
                }

                if (temp.isFile()) {
                    FileInputStream input = new FileInputStream(temp);
                    FileOutputStream output = new FileOutputStream(newPath + "/" +
                            (temp.getName()).toString());
                    myLogger.doLog("copyFolder" + "\r\n" +
                            oldPath + "--->>>" + "\r\n" +
                            newPath + "/" +
                            (temp.getName()).toString());
//                    logCreate(batchLog.getPath(),TAG+"copyFolder"+"\r\n"+
//                            oldPath+"--->>>"+"\r\n"+
//                            newPath + "/" +
//                            (temp.getName()).toString()+"\r\n");
//                    System.out.println(TAG+"copyFolder"+"\n"+
//                            oldPath+"--->>>"+"\n"+
//                            newPath + "/" +
//                            (temp.getName()).toString());
                    byte[] b = new byte[1024 * 5];
                    int len;
                    while ((len = input.read(b)) != -1) {
                        output.write(b, 0, len);
                    }
                    output.flush();
                    output.close();
                    input.close();
                }
                if (temp.isDirectory()) {//如果是子文件夹
                    copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
                }
            }
        } catch (Exception e) {
            myLogger.doLog("复制整个文件夹内容操作出错");
//            logCreate(batchLog.getPath(),"复制整个文件夹内容操作出错"+"\r\n");
//            System.out.println("复制整个文件夹内容操作出错");
            e.printStackTrace();

        }


    }

    /**
     * 读取文件夹里每个文件
     *
     * @param filePath
     */
    public List<File> readFiles(String filePath) {
        List<File> fileList = new ArrayList<>();
        File file = new File(filePath);
        File[] files = file.listFiles();// 获取目录下的所有文件或文件夹
        if (files == null) {// 如果目录为空，直接退出
            return null;
        }
        // 遍历，目录下的所有文件
        for (File f : files) {
            if (f.isFile()) {
                fileList.add(f);
            } else if (f.isDirectory()) {
                myLogger.doLog("readFiles:" + f.getAbsolutePath());
//                logCreate(batchLog.getPath(),TAG+"readFiles:"+f.getAbsolutePath()+"\r\n");
//                System.out.println(TAG+"readFiles"+f.getAbsolutePath());
                readFiles(f.getAbsolutePath());
            }
        }
        for (File f1 : fileList) {
//            logCreate(batchLog.getPath(),TAG+"readFiles"+f1.getName()+"\r\n");
//            System.out.println(TAG+"readFiles"+f1.getName());
            myLogger.doLog("readFiles:" + f1.getName());
        }
        return fileList;
    }

    /**
     * 删除某个文件夹下的所有文件夹和文件
     *
     * @param delpath String
     * @return boolean
     * @throws FileNotFoundException
     * @throws IOException
     */
    public boolean deletefile(String delpath) throws Exception {
        try {

            File file = new File(delpath);
            // 当且仅当此抽象路径名表示的文件存在且 是一个目录时，返回 true
            if (!file.isDirectory()) {
                file.delete();
            } else if (file.isDirectory()) {
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File delfile = new File(delpath + "/" + filelist[i]);
                    if (!delfile.isDirectory()) {
                        delfile.delete();
                        myLogger.doLog(delfile.getAbsolutePath() + "删除文件成功");
                    } else if (delfile.isDirectory()) {
                        deletefile(delpath + "/" + filelist[i]);

                        myLogger.doLog(file + "ssss");
                    }
                }
                if (!file.toString().equals(ServerPath.RESOURSES_PATH + "resources/batchdata/")) {
                    myLogger.doLog(TAG + file.toString() + "已清空");
                    file.delete();
                }
            }

        } catch (FileNotFoundException e) {

            myLogger.doLog("deletefile() Exception:" + e.getMessage());
        }
        return true;
    }

}
