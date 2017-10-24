package com.ttgis.recruit.Mapper;

import java.util.List;
import java.util.Map;

import com.ttgis.recruit.domain.QueryJygl;
import com.ttgis.recruit.domain.Zzjg;

public interface ZzjgMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ZZJG
	 * 
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(String zzjgId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ZZJG
	 * 
	 * @mbggenerated
	 */
	int insert(Zzjg record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ZZJG
	 * 
	 * @mbggenerated
	 */
	int insertSelective(Zzjg record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ZZJG
	 * 
	 * @mbggenerated
	 */
	Zzjg selectByPrimaryKey(String zzjgId);

	Zzjg selectByBmglId(String bmglId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ZZJG
	 * 
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Zzjg record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ZZJG
	 * 
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Zzjg record);

	Zzjg CheckLogin(Zzjg zzjg);

	List<Zzjg> selectLsyh(Map<String, String> params);

	List<Zzjg> selectAllBkdw(Map<String, String> params);

	List<Zzjg> queryUserFO();

	List<Zzjg> queryUserSun();

	List<Zzjg> selectByWhere(QueryJygl qj);

	int selectCount(QueryJygl qj);

	int hfjy(String zzjgId);

	List<Zzjg> selectBySjdw(String sjdw);

	List<Zzjg> selectSanjidw(String sjdw);

	List<Zzjg> selectAll();

	List<Zzjg> fhyfySelectByWhere(QueryJygl qj);

	int fhyfySelectCount(QueryJygl qj);

	List<Zzjg> queryFhyfy();

	List<Zzjg> EJqueryUserFO(String zzjgId);

	List<Zzjg> EJqueryUserSun(String zzjgId);

	Zzjg selectZzjgIdByUserId(String userId);

	List<Zzjg> EJqueryUserSun2Q(String zzjgId);

	List<Zzjg> queryUserSunLevel2();
}