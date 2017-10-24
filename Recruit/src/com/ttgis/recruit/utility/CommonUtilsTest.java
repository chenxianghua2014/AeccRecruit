/**   
* @Title CommonUtilsTest.java 
* @Package com.ttgis.recruit.utility 
* @Description TODO 
* @author hua
* @date 2016年7月21日 上午8:43:51 
* @version V1.0   
*/
package com.ttgis.recruit.utility;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ttgis.recruit.domain.Jtjlk;

/** 
* @ClassName CommonUtilsTest 
* @Description TODO 
* @author cxh 
* @date 2016年7月21日 上午8:43:51 
*  
*/
public class CommonUtilsTest {

    /**
     * Test method for {@link com.ttgis.recruit.utility.CommonUtils#checkStuQuality(java.util.List)}.
     */
    @Test
    public void testCheckStuQuality() {
	List<Jtjlk> jtjlks = new ArrayList<Jtjlk>();
	Jtjlk jt1 = new Jtjlk();
	jt1.setJtjlkByxx("北京邮电大学");
	jt1.setJtjlkPositionId("aaaaaaaaaaaaaaa");
	jt1.setJtjlkZw("测试");
	
	Jtjlk jt2 = new Jtjlk();
	jt2.setJtjlkByxx("北京邮电大学");
	jt2.setJtjlkUniPositionId("aaaaaaaaaaaaaaa");
	//jt2.setJtjlkZw("测试");
	
	Jtjlk jt3 = new Jtjlk();
	jt3.setJtjlkByxx("清华大学");
	jt3.setJtjlkPositionId("aaaaaaaaaaaaaaa");
	jt3.setJtjlkZw("测试");
	
	Jtjlk jt4 = new Jtjlk();
	jt4.setJtjlkByxx("清华大学");
	jt4.setJtjlkUniPositionId("aaaaaaaaaaaaaaa");
	//jt4.setJtjlkZw("测试");
	jtjlks.add(jt1);
	jtjlks.add(jt2);
	jtjlks.add(jt3);
	
	jtjlks.add(jt4);
	List<Jtjlk> result = CommonUtils.checkStuQuality(jtjlks);
	System.out.println(result);
    }

}
