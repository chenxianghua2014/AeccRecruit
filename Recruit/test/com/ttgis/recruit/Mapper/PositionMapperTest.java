/**   
* @Title PositionMapperTest.java 
* @Package com.ttgis.recruit.Mapper 
* @Description TODO 
* @author hua
* @date 2016年6月30日 下午2:03:48 
* @version V1.0   
*/
package com.ttgis.recruit.Mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ttgis.recruit.domain.MyApplication;
import com.ttgis.recruit.domain.Position;
import com.ttgis.recruit.domain.QueryZw;



/** 
* @ClassName PositionMapperTest 
* @Description TODO 
* @author cxh 
* @date 2016年6月30日 下午2:03:48 
*  
*/
public class PositionMapperTest {
    private ApplicationContext applicationContext;
    private PositionMapper positionMapper;
    private JtjlkMapper jtjlkMapper;
   
    /*陈向华的userid 60030F27-A73C-5E2D-4DE5-A5BBF6537D7E*/
    // 在setUp这个方法得到spring容器
    @Before
    public void setUp() throws Exception {
	applicationContext = new ClassPathXmlApplicationContext("classpath:spring/root-context.xml");
	positionMapper = (PositionMapper)applicationContext.getBean("positionMapper");
	jtjlkMapper = (JtjlkMapper)applicationContext.getBean("jtjlkMapper");
    }

    

    @Test
    public void testSelectByCompany() {
	List<Position> positions = positionMapper.selectByCompany("56CFC8DF-0782-284B-0A88-8AB746A33F73");
	System.out.println(positions);
    }
    
    @Test
    public void testSelectMyUniApplication() {
	List<MyApplication> positions = jtjlkMapper.selectMyUniApplication("60030F27-A73C-5E2D-4DE5-A5BBF6537D7E");
	System.out.println(positions);
    }
    
    @Test
    public void testSelectCount() {
	QueryZw qz = new QueryZw();
	qz.setPositionName("师");
	int num  = positionMapper.selectCount(qz);
	System.out.println(num);
    }


}
