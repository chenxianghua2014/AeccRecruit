package com.ttgis.recruit.Mapper;

import java.util.List;

import com.ttgis.recruit.domain.Jk;
import com.ttgis.recruit.domain.QueryJk;

public interface JkMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JK
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String jkId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JK
     *
     * @mbggenerated
     */
    int insert(Jk record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JK
     *
     * @mbggenerated
     */
    int insertSelective(Jk record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JK
     *
     * @mbggenerated
     */
    Jk selectByPrimaryKey(String jkId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JK
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Jk record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JK
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Jk record);
    
    List<Jk> selectByWhere(QueryJk qj);
    int selectCount(QueryJk qj);
}