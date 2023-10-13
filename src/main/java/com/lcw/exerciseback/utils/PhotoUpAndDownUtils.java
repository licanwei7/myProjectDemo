package com.lcw.exerciseback.utils;

import java.io.*;

/**
 * @Author Licanwei
 * @Description:处理图片的上传以及下载类
 * @Date 2022/4/2 8:56
 */
public class PhotoUpAndDownUtils {

    /**
     * 文件的上传（到数据库，二进制）
     */
    public static InputStream upPhoto(File photo) throws FileNotFoundException {
        InputStream in=new FileInputStream(photo);
        return in;
    }



}
