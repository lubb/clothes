package com.lbb.clothes.mapper;

import com.lbb.clothes.business.model.Clothes;

public interface ClothesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xm_clothes
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xm_clothes
     *
     * @mbg.generated
     */
    int insert(Clothes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xm_clothes
     *
     * @mbg.generated
     */
    int insertSelective(Clothes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xm_clothes
     *
     * @mbg.generated
     */
    Clothes selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xm_clothes
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Clothes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xm_clothes
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Clothes record);
}