package com.lcw.exerciseback.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Author Licanwei
 * @Description: 文件处理工具类
 * @Date 2022/4/15 15:25
 */
public class FileUtils {

    /**
     * 判断传参路径是否存在文件
     * @param dirPath
     * @return 存在true/不存在false
     */
    public static boolean isDirExist(String dirPath){
        File file = new File(dirPath);
        if (file.exists()){
            return true;
        }
        return false;
    }

    /**
     * 将本地路径文件图片转成流，以便显示在前端
     * @param file、response
     * @return 无
     */

    public static void transFile_Flow(File file,HttpServletResponse response) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        long size = file.length();
        byte[] temp = new byte[(int) size];
        fileInputStream.read(temp, 0, (int) size);
        fileInputStream.close();
        byte[] data = temp;
        response.setContentType("image/jpg");
        OutputStream os = response.getOutputStream();
        os.write(data);
        os.flush();
        os.close();
    }
}
