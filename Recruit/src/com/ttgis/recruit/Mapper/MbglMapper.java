package com.ttgis.recruit.Mapper;

import java.util.List;
import java.util.Map;

import com.ttgis.recruit.domain.Mbgl;

public interface MbglMapper
{
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table MBGL
	 * 
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(String mbglId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table MBGL
	 * 
	 * @mbggenerated
	 */
	int insert(Mbgl record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table MBGL
	 * 
	 * @mbggenerated
	 */
	int insertSelective(Mbgl record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table MBGL
	 * 
	 * @mbggenerated
	 */
	Mbgl selectByPrimaryKey(String mbglId);

	List<Mbgl> selectByMbType(Map<String, String> params);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table MBGL
	 * 
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Mbgl record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table MBGL
	 * 
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Mbgl record);

	List<Mbgl> selectByWhere(Map<String, Object> params);

	int selectCount(Map<String, Object> params);
}