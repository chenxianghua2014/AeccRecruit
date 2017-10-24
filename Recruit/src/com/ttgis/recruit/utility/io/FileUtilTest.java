/**   
* @Title FileUtilTest.java 
* @Package com.ttgis.recruit.utility.io 
* @Description TODO 
* @author hua
* @date 2016年9月5日 上午11:20:13 
* @version V1.0   
*/
package com.ttgis.recruit.utility.io;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

/** 
* @ClassName FileUtilTest 
* @Description TODO 
* @author cxh 
* @date 2016年9月5日 上午11:20:13 
*  
*/
public class FileUtilTest {

    /**
     * Test method for {@link com.ttgis.recruit.utility.io.FileUtil#readProAndCheckInWhiteList(java.lang.String, java.lang.String, java.lang.String)}.
     * @throws IOException 
     */
    @Test
    public void testReadProAndCheckInWhiteList() throws IOException {
	System.out.println(FileUtil.readProAndCheckInWhiteList("whiteList.properties","wl.img","cc"));
    }

}
