package com.lbb.clothes.mapper;

import com.lbb.clothes.business.model.Article;
import com.lbb.clothes.business.vo.ArticleVo;

import java.util.List;
import java.util.Map;

public interface ArticleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_article
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_article
     *
     * @mbg.generated
     */
    int insert(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_article
     *
     * @mbg.generated
     */
    Article selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_article
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_article
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Article record);

    List<Article> getArticlePage(ArticleVo articleVo);

    List<Map<String,Object>> getHotArticleTag();

    List<Article> getArticleSix();
}