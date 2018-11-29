package com.lbb.clothes.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lbb.clothes.business.model.Article;
import com.lbb.clothes.business.model.Tag;
import com.lbb.clothes.business.service.ArticleService;
import com.lbb.clothes.business.vo.ArticleVo;
import com.lbb.clothes.key.KeyCreater;
import com.lbb.clothes.mapper.ArticleMapper;
import com.lbb.clothes.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private TagMapper  tagMapper;

    private KeyCreater keyCreater = new KeyCreater();

    @Override
    public Article getArticleById(Long id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Article> getArticlePage(ArticleVo articleVo) {
        PageHelper.startPage(articleVo.getPageNum(),articleVo.getPageSize());
        List<Article> list = articleMapper.getArticlePage(articleVo);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public List<Article> getArticleSix() {
        return articleMapper.getArticleSix();
    }

    /**
     * 获取最热标签
     * @return
     */
    @Override
    public List<Map<String, Object>> getHotArticleTag() {
        return articleMapper.getHotArticleTag();
    }

    @Override
    public void saveArticle(Article article) {
        Tag tag = tagMapper.selectByPrimaryKey(article.getTagId());
        article.setId(keyCreater.getKey().longValue());
        article.setClickNum(0);
        article.setCreateTime(new Date());
        article.setTagName(tag.getName());
        articleMapper.insert(article);
    }

    @Override
    public void updateArticle(Article article) {
        Article a = new Article();
        a.setId(article.getId());
        a.setClickNum(article.getClickNum()+1);
        articleMapper.updateByPrimaryKeySelective(a);
    }
}
