/**   
* @Title MD5UtilTest.java 
* @Package com.ttgis.recruit.utility 
* @Description TODO 
* @author hua
* @date 2016年7月29日 下午9:52:59 
* @version V1.0   
*/
package com.ttgis.recruit.utility;

import static org.junit.Assert.*;

import org.junit.Test;

/** 
* @ClassName MD5UtilTest 
* @Description TODO 
* @author cxh 
* @date 2016年7月29日 下午9:52:59 
*  
*/
public class MD5UtilTest {

    @Test
    public void test() {
	System.out.println(MD5.getMD5ofStr("XPT2011144"));
    }

}
