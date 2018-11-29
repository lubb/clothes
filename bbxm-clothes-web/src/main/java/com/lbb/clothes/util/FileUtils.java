package com.lbb.clothes.util;

import org.springframework.web.multipart.MultipartFile;
import java.io.File;

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
            file.transferTo(dest);
            return newFileName;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }

    }
}
