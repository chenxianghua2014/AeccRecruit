package com.ttgis.recruit.Mapper;

import com.ttgis.recruit.domain.Cjtsgl;

public interface CjtsglMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CJTSGL
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String cjtsglId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CJTSGL
     *
     * @mbggenerated
     */
    int insert(Cjtsgl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CJTSGL
     *
     * @mbggenerated
     */
    int insertSelective(Cjtsgl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CJTSGL
     *
     * @mbggenerated
     */
    Cjtsgl selectByPrimaryKey(String cjtsglId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CJTSGL
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Cjtsgl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CJTSGL
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Cjtsgl record);
}