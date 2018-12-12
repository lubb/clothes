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
import com.lbb.clothes.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Quotation quotation = quotationService.getQuotationRand();
        User user = userService.getBlogUser();
        List<Tag> tags = tagService.getAll();
        commonDeal(model, articleVo);
        Map<String,Long> map = DateUtil.DateDiff(new Date());
        model.addAttribute("day", map.get("day"));
        model.addAttribute("hour", map.get("hour"));
        model.addAttribute("min", map.get("min"));
        model.addAttribute("tags", tags);
        model.addAttribute("quotation",quotation);
        model.addAttribute("user", user);
        Map<String,String> m = new HashMap<>();
        m.put("qq","http://connect.qq.com/widget/shareqq/index.html?url=http://www.bbximi.com&title=乐者无界&summary=兵兵博客&pics=http://www.bbximi.com/index/images/logo.png");
        m.put("zone","http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url=http://www.bbximi.com&title=乐者无界&summary=兵兵博客&pics=http://www.bbximi.com/index/images/logo.png");
        m.put("weibo","http://service.weibo.com/share/mobile.php?url=http://www.bbximi.com&title=乐者无界&summary=兵兵博客&pic=http://www.bbximi.com/index/images/logo.png");
        model.addAttribute("map", m);
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
        List<Article> articles = articleService.getArticleTwelve();
        Article article = articleService.getArticleById(id);
        List<Tag> tags = tagService.getAll();
        model.addAttribute("articles", articles);
        model.addAttribute("tags", tags);
        model.addAttribute("article",article);
        String content = new String(article.getDescription());
        model.addAttribute("content", content);
        model.addAttribute("qq","http://connect.qq.com/widget/shareqq/index.html?url=http://www.bbximi.com/detail/"+article.getId()+"&title="+article.getTitle()+"&summary="+article.getRemark()+"&pics=http://www.bbximi.com/images/"+article.getImg()+"");
        model.addAttribute("zone","http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url=http://www.bbximi.com/detail/"+article.getId()+"&title="+article.getTitle()+"&summary="+article.getRemark()+"&pics=http://www.bbximi.com/images/"+article.getImg()+"");
        model.addAttribute("weibo","http://service.weibo.com/share/mobile.php?url=http://www.bbximi.com/detail/"+article.getId()+"&title="+article.getTitle()+"&summary="+article.getRemark()+"&pic=http://www.bbximi.com/images/"+article.getImg()+"");
        articleService.updateArticle(article);
        return "blog/detail";
    }

    /**
     * 文章编辑
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        List<Article> articles = articleService.getArticleTwelve();
        List<Tag> tags = tagService.getAll();
        model.addAttribute("articles", articles);
        model.addAttribute("tags", tags);
        model.addAttribute("id", id);
        return "blog/edit";
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
        if(pageNum == null){
            pageNum="1";
        }
        ArticleVo articleVo = new ArticleVo();
        articleVo.setPageNum(Integer.parseInt(pageNum));
        articleVo.setCategoryId(Long.parseLong(type.toString()));
        commonDeal(model, articleVo);
        model.addAttribute("type", type);
        return "blog/article";
    }

    /**
     * 文章新增跳转
     * @param model
     * @return
     */
    @RequestMapping("add")
    public String add(Model model) {
        List<Article> articles = articleService.getArticleTwelve();
        List<Tag> tags = tagService.getAll();
        model.addAttribute("articles", articles);
        model.addAttribute("tags", tags);
        return "blog/add";
    }

    /**
     * 公共部分处理
     * @param model
     * @param articleVo
     */
    public void commonDeal(Model model, ArticleVo articleVo){
        PageInfo<Article> list = articleService.getArticlePage(articleVo);
        List<Article> articles = articleService.getArticleTwelve();
        model.addAttribute("list", list);
        model.addAttribute("articles", articles);
    }
}
