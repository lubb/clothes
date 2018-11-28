package com.lbb.clothes.business.service;

import com.github.pagehelper.PageInfo;
import com.lbb.clothes.business.model.Article;
import com.lbb.clothes.business.vo.ArticleVo;

import java.util.List;
import java.util.Map;

public interface ArticleService {

    public Article getArticleById(Long id);

    public PageInfo<Article> getArticlePage(ArticleVo articleVo);

    public List<Article> getArticleSix();

    public List<Map<String,Object>> getHotArticleTag();
}
