package com.lbb.clothes.util;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileUtils {

    /**
     *
     * @param file 文件
     * @param path 文件存放路径
     * @return
     */
    public static String upload(MultipartFile file, String path){
        //使用原文件名
        String newFileName = FileNameUtils.getFileName(file.getOriginalFilename());
        String realPath = path + "/" + newFileName;
        File dest = new File(realPath);
        //判断文件父目录是否存在
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }
        try {
            //保存文件
            OutputStream outputStream = new FileOutputStream(dest);
            IOUtils.copy(file.getInputStream(), outputStream);
            return newFileName;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
