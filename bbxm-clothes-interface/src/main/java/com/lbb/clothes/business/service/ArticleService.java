package com.lbb.clothes.business.service;

import com.github.pagehelper.PageInfo;
import com.lbb.clothes.business.model.Article;
import com.lbb.clothes.business.vo.ArticleVo;

import java.util.List;
import java.util.Map;

public interface ArticleService {

    public Article getArticleById(Long id);

    public PageInfo<Article> getArticlePage(ArticleVo articleVo);

    public List<Article> getArticleTwelve();

    public List<Map<String,Object>> getHotArticleTag();

    void saveArticle(Article article);

    void updateArticle(Article article);

    void updateArticleContent(Article article);
}
