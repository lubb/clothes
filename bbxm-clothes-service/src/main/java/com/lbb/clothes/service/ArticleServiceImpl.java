package com.lbb.clothes.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lbb.clothes.business.model.Article;
import com.lbb.clothes.business.service.ArticleService;
import com.lbb.clothes.business.vo.ArticleVo;
import com.lbb.clothes.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

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
}
