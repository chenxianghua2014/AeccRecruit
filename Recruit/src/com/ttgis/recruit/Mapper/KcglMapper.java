package com.ttgis.recruit.Mapper;

import java.util.List;

import com.ttgis.recruit.domain.Kcgl;
import com.ttgis.recruit.domain.QueryKcgl;

public interface KcglMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KCGL
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String kcglId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KCGL
     *
     * @mbggenerated
     */
    int insert(Kcgl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KCGL
     *
     * @mbggenerated
     */
    int insertSelective(Kcgl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KCGL
     *
     * @mbggenerated
     */
    Kcgl selectByPrimaryKey(String kcglId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KCGL
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Kcgl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KCGL
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Kcgl record);
    
    List<Kcgl> selectByWhere (QueryKcgl qk);
    int selectCount (QueryKcgl qk);
    
    List<Kcgl> queryKcgl();
    int queryKcrlByKcglName(String kcglName);
}