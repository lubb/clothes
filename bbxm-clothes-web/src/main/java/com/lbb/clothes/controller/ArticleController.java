package com.lbb.clothes.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.lbb.clothes.business.model.Article;
import com.lbb.clothes.business.service.ArticleService;
import com.lbb.clothes.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.util.Iterator;
import java.util.Map;

@Controller
@RequestMapping("article")
public class ArticleController {

    private final ResourceLoader resourceLoader;

    @Autowired
    public ArticleController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Value("${web.upload}")
    private String path;

    @Reference
    private ArticleService articleService;

    /**
     * 图片上传
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/upload")
    public JSONObject upload(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String msg = "";
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        Iterator<String> fileIterator = multipartRequest.getFileNames();
        while (fileIterator.hasNext()) {
            String fileKey = fileIterator.next();
            MultipartFile multipartFile = fileMap.get(fileKey);
            String newFileaName = FileUtils.upload(multipartFile, path);
            jsonObject.put("fileName", newFileaName);
        }
        return jsonObject;
    }

    /**
     * 保存文章
     * @param jsonObject
     */
    @ResponseBody
    @RequestMapping("/save")
    public void save(@RequestBody JSONObject jsonObject){
        Article article = new Article();
        article.setTagId(jsonObject.getLong("tagId"));
        article.setDescription(jsonObject.getString("description").getBytes());
        article.setTitle(jsonObject.getString("title"));
        article.setImg(jsonObject.getString("img"));
        article.setRemark(jsonObject.getString("remark"));
        articleService.saveArticle(article);
    }

    /**
     * 预览方法
     * @param fileName
     * @return
     */
    @ResponseBody
    @RequestMapping("/show/{fileName}")
    public ResponseEntity show(@PathVariable String fileName){
        return ResponseEntity.ok(resourceLoader.getResource("file:" + path + fileName));
    }
}
