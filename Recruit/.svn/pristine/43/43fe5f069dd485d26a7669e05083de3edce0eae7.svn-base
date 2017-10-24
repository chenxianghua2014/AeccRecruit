/**   
* @Title Test.java 
* @Package com.ttgis.recruit.controller.test 
* @Description TODO 
* @author hua
* @date 2016年9月5日 上午9:20:18 
* @version V1.0   
*/
package com.ttgis.recruit.controller.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


/** 
* @ClassName Test 
* @Description TODO 
* @author cxh 
* @date 2016年9月5日 上午9:20:18 
*  
*/
public class Test {

    /** 
    * @Title main 
    * @Description TODO 
    * @param args  
    * @return void     
     * @throws IOException 
    */
    public static void main(String[] args) throws IOException {
	// TODO Auto-generated method stub
	Properties pro = new Properties();
	FileInputStream in = new FileInputStream(Test.class.getClassLoader().getResource("db.properties").getPath());
	pro.load(in);
	System.out.println(pro.getProperty("jdbc.username"));
	
//	System.out.println(Test.class.getClassLoader().getResource("").getPath());   /D:/workspaces/Recruit/Recruit/build/classes/
    }

}
