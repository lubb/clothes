package com.lbb.clothes.mapper;

import com.lbb.clothes.business.model.Quotation;

public interface QuotationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_quotation
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_quotation
     *
     * @mbg.generated
     */
    int insert(Quotation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_quotation
     *
     * @mbg.generated
     */
    int insertSelective(Quotation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_quotation
     *
     * @mbg.generated
     */
    Quotation selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_quotation
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Quotation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_quotation
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Quotation record);

    /**
     * 随机获取一个
     * @return
     */
    Quotation getQuotationRand();
}