package com.lbb.clothes.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.lbb.clothes.business.model.Article;
import com.lbb.clothes.business.model.Quotation;
import com.lbb.clothes.business.model.Tag;
import com.lbb.clothes.business.model.User;
import com.lbb.clothes.business.service.ArticleService;
import com.lbb.clothes.business.service.QuotationService;
import com.lbb.clothes.business.service.TagService;
import com.lbb.clothes.business.service.UserService;
import com.lbb.clothes.business.vo.ArticleVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Reference
    private ArticleService articleService;

    @Reference
    private QuotationService quotationService;

    @Reference
    private UserService userService;

    @Reference
    private TagService tagService;

    /**
     * 首页
     * @param pageNum
     * @param model
     * @param request
     * @return
     */
    @RequestMapping({"/", "/index"})
    public String index(String pageNum , Model model, HttpServletRequest request) {
        if(pageNum == null){
            pageNum="1";
        }
        ArticleVo articleVo = new ArticleVo();
        articleVo.setPageNum(Integer.parseInt(pageNum));
        PageInfo<Article> list = articleService.getArticlePage(articleVo);
        List<Article> articles = articleService.getArticleSix();
        Quotation quotation = quotationService.getQuotationRand();
        User user = userService.getBlogUser();
        List<Tag> tags = tagService.getAll();
        model.addAttribute("tags", tags);
        model.addAttribute("list", list);
        model.addAttribute("articles", articles);
        model.addAttribute("quotation",quotation);
        model.addAttribute("user", user);
        return "index";
    }

    /**
     * 文章详情
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("detail/{id}")
    public String detail(Model model, @PathVariable Long id) {
        List<Article> articles = articleService.getArticleSix();
        List<Tag> tags = tagService.getAll();
        model.addAttribute("articles", articles);
        model.addAttribute("tags", tags);
        model.addAttribute("article",articleService.getArticleById(id));
        return "blog/detail";
    }

    /**
     * 文章列表
     * @param pageNum
     * @param model
     * @param type
     * @return
     */
    @RequestMapping("article/{type}")
    public String article(String pageNum ,Model model, @PathVariable Integer type) {
        String name = "";
        if(type==1){
            name ="技术";
        }else if(type==2){
            name = "生活";
        }else{
            name = "游戏";
        }
        if(pageNum == null){
            pageNum="1";
        }
        ArticleVo articleVo = new ArticleVo();
        articleVo.setPageNum(Integer.parseInt(pageNum));
        PageInfo<Article> list = articleService.getArticlePage(articleVo);
        List<Article> articles = articleService.getArticleSix();
        model.addAttribute("articles", articles);
        model.addAttribute("tag", name);
        model.addAttribute("list", list);
        model.addAttribute("type", type);
        return "blog/article";
    }
}
