package cuc.waimai.util;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import javax.swing.*;
import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipException;

public class FileOperationUtil {

    /**
     * 解压目录/文件
     *
     * @param file
     * @throws IOException
     * @throws ZipException
     */
    public void unZipFile(File file) {
        if (file.isDirectory()) {// 目录
            File[] files = file.listFiles();
            for (File tempFile : files) {
                unZipFile(tempFile);
            }
        } else {// 文件
            try {
                if (!file.getName().endsWith(".zip"))
                    return;
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
            }
        }
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
            System.out.println("复制整个文件夹内容操作出错");
            e.printStackTrace();

        }


    }
}
