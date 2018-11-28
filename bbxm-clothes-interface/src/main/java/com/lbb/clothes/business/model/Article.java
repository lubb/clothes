package com.lbb.clothes.business.model;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_article.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_article.title
     *
     * @mbg.generated
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_article.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_article.tag_id
     *
     * @mbg.generated
     */
    private Long tagId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_article.tag_name
     *
     * @mbg.generated
     */
    private String tagName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_article.description
     *
     * @mbg.generated
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_article.img
     *
     * @mbg.generated
     */
    private String img;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_article.click_num
     *
     * @mbg.generated
     */
    private Integer clickNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table blog_article
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_article.id
     *
     * @return the value of blog_article.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_article.id
     *
     * @param id the value for blog_article.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_article.title
     *
     * @return the value of blog_article.title
     *
     * @mbg.generated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_article.title
     *
     * @param title the value for blog_article.title
     *
     * @mbg.generated
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_article.create_time
     *
     * @return the value of blog_article.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_article.create_time
     *
     * @param createTime the value for blog_article.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_article.tag_id
     *
     * @return the value of blog_article.tag_id
     *
     * @mbg.generated
     */
    public Long getTagId() {
        return tagId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_article.tag_id
     *
     * @param tagId the value for blog_article.tag_id
     *
     * @mbg.generated
     */
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_article.tag_name
     *
     * @return the value of blog_article.tag_name
     *
     * @mbg.generated
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_article.tag_name
     *
     * @param tagName the value for blog_article.tag_name
     *
     * @mbg.generated
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_article.description
     *
     * @return the value of blog_article.description
     *
     * @mbg.generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_article.description
     *
     * @param description the value for blog_article.description
     *
     * @mbg.generated
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_article.img
     *
     * @return the value of blog_article.img
     *
     * @mbg.generated
     */
    public String getImg() {
        return img;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_article.img
     *
     * @param img the value for blog_article.img
     *
     * @mbg.generated
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_article.click_num
     *
     * @return the value of blog_article.click_num
     *
     * @mbg.generated
     */
    public Integer getClickNum() {
        return clickNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_article.click_num
     *
     * @param clickNum the value for blog_article.click_num
     *
     * @mbg.generated
     */
    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }
}