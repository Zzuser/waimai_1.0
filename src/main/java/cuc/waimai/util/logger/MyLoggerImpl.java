package cuc.waimai.util.logger;

import org.apache.ibatis.annotations.Param;

import java.io.FileWriter;
import java.io.IOException;

public class MyLoggerImpl implements MyLogger {
    private String logPath;
    private String className;
    private String line;

    public MyLoggerImpl(@Param("logPath") String logPath){
        this.logPath=logPath;
        className="";
        line="======================================================================";
    }

    public MyLoggerImpl(@Param("logPath") String logPath,@Param("className") String className){
        this.logPath=logPath;
        this.className=className;
        line="======================================================================";
    }
    @Override
    public int doLog(String logContent) {
        try {
            if (logContent!=null){
            logCreate(logPath,className+"-->"+logContent+"\r\n");
//            System.out.println(className+"-->"+logContent);
            }
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public int doLog(String logContent, int lineWith) {
        switch (lineWith){
            case 0:{
                logCreate(logPath,line+"\r\n");
//                System.out.println(line);
               return doLog(logContent);
            }
            case 1:{
              return doLog(logContent+"\r\n"+line+"\r\n"
                        );

            }
            case 3:{
                logCreate(logPath,line+"\r\n");
//                System.out.println(line);
                return doLog(logContent+
                        "\r\n"+line+"\r\n"
                );

            }
            default:{
            return doLog(logContent);
            }

        }
    }

    /**
     * 追加文件：使用FileWriter
     *
     * @param fileName
     * @param content
     */
    public  void logCreate(String fileName, String content) {
        FileWriter writer = null;
        try {
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            writer = new FileWriter(fileName, true);
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
