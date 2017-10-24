package com.ttgis.recruit.Mapper;

import java.util.List;

import com.ttgis.recruit.domain.Ltbk;
import com.ttgis.recruit.domain.QueryLtbk;

public interface LtbkMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LTBK
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String ltbkId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LTBK
     *
     * @mbggenerated
     */
    int insert(Ltbk record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LTBK
     *
     * @mbggenerated
     */
    int insertSelective(Ltbk record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LTBK
     *
     * @mbggenerated
     */
    Ltbk selectByPrimaryKey(String ltbkId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LTBK
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Ltbk record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LTBK
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Ltbk record);
    
    List<Ltbk> selectByWhere(QueryLtbk ql);

  	int selectCount(QueryLtbk ql);
  	List<Ltbk> queryLtbk();
  	void delLtbkByTlqId(String tlqId);
  	List<Ltbk> queryLtbkByTlqId(String tlqId);
  	
  	int updateLtbkSJ(String ltbkId);
}