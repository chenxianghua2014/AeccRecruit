/**
 * 董再兴 CommonUtils.java 2013年7月3日
 */
package com.ttgis.recruit.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.axis2.databinding.types.soapencoding.Array;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.ttgis.recruit.domain.Jtjlk;

/**
 *@author 董再兴
 *
 */
public class CommonUtils {

    public static String parseHexStringFromBytes(final byte[] text) {
	StringBuffer buff = new StringBuffer(0);
	for (int i = 0; i < text.length; i++) {
	    byte _byte = text[i];
	    byte _bytel = (byte) (_byte & 0x000f);
	    byte _byteh = (byte) (_byte & 0x00f0);
	    getHexString(buff, (byte) ((_byteh >> 4) & 0x000f));
	    getHexString(buff, _bytel);
	}
	return buff.toString();
    }

    private static void getHexString(final StringBuffer buffer, final byte value) {
	if (value - 9 > 0) {
	    int index = value - 9;
	    switch (index) {
	    case 1:
		buffer.append("A");
		break;
	    case 2:
		buffer.append("B");
		break;
	    case 3:
		buffer.append("C");
		break;
	    case 4:
		buffer.append("D");
		break;
	    case 5:
		buffer.append("E");
		break;
	    case 6:
		buffer.append("F");
		break;
	    default:
		break;
	    }
	} else {
	    buffer.append(String.valueOf(value));
	}
    }

    public static byte[] parseBytesByHexString(final String hexString) {
	if (hexString == null || hexString.length() == 0 || hexString.equals("")) {
	    return new byte[0];
	}
	if (hexString.length() % 2 != 0) {
	    throw new IllegalArgumentException("hexString length must be an even number!");
	}
	StringBuffer sb = new StringBuffer(hexString);
	StringBuffer sb1 = new StringBuffer(2);
	int n = hexString.length() / 2;
	byte[] bytes = new byte[n];
	for (int i = 0; i < n; i++) {
	    if (sb1.length() > 1) {
		sb1.deleteCharAt(0);
		sb1.deleteCharAt(0);
	    }
	    sb1.append(sb.charAt(0));
	    sb1.append(sb.charAt(1));
	    sb.deleteCharAt(0);
	    sb.deleteCharAt(0);
	    bytes[i] = (byte) Integer.parseInt(sb1.toString(), 16);
	}
	return bytes;
    }

    /** 
    * @Title checkStuQuality  只填充，不删除
    * @Description  1.将职位中null值填充为“无”
    * 		2.检查学生是否符合9+3所高校并做处理：
    * 		符合：若只存在普通或者优才职位，填充null值为“无”
    * 		不符合：存在普通职位，将优才职位设为“无”
    * 		                不存在普通职位，过滤该条记录
    * <!--查询所有符合条件的简历：排除只申请了优才职位但学校不符合十二所高校的应聘者 -->
      <!--符合条件的简历：1.存在普通职位 2.不存在普通职位（必存在优才职位）且毕业学校符合条件 -->
    * @param jtjlk
    * @return  
    * @return Boolean     
    */
    public static List<Jtjlk> checkStuQuality(List<Jtjlk> jtjlks) {

	for (Jtjlk jtjlk : jtjlks) {
	    if (jtjlk.getJtjlkPositionId() == null || jtjlk.getJtjlkPositionId().isEmpty()) {
		jtjlk.setJtjlkPositionId("无");
		jtjlk.setJtjlkZw("无");
	    }
	    if (jtjlk.getJtjlkUniPositionId() == null || jtjlk.getJtjlkUniPositionId().isEmpty()) {
		jtjlk.setJtjlkUniPositionId("无");
		jtjlk.setJtjlkUniPositionZw("无");
	    }
	    if (!checkSchool(jtjlk.getJtjlkByxx())) {
		jtjlk.setJtjlkUniPositionZw("无");
		jtjlk.setJtjlkUniPositionId("无");
	    }
	}

	return jtjlks;

    }

    /** 
     * @Title checkStuQualityProc    填充并删除不符合要求的记录
     * @Description  1.将职位中null值填充为“无”
     * 		2.检查学生是否符合9+3所高校并做处理：
     * 		符合：若只存在普通或者优才职位，填充null值为“无”
     * 		不符合：存在普通职位，将优才职位设为“无”
     * 		                不存在普通职位，过滤该条记录
     * @param jtjlk
     * @return  
     * @return Boolean     
     */
    public static List<Jtjlk> checkStuQualityProc(List<Jtjlk> jtjlks) {

	List<Jtjlk> result = new ArrayList<Jtjlk>();
	for (Jtjlk jtjlk : jtjlks) {
	    if (checkSchool(jtjlk.getJtjlkByxx())) {
		if ((jtjlk.getJtjlkPositionId() == null || jtjlk.getJtjlkPositionId().isEmpty())
			&& (jtjlk.getJtjlkUniPositionId() == null || jtjlk.getJtjlkUniPositionId().isEmpty()))
		    continue;
		if (jtjlk.getJtjlkPositionId() == null || jtjlk.getJtjlkPositionId().isEmpty()) {
		    jtjlk.setJtjlkPositionId("无");
		    jtjlk.setJtjlkZw("无");
		}
		if (jtjlk.getJtjlkUniPositionId() == null || jtjlk.getJtjlkUniPositionId().isEmpty()) {
		    jtjlk.setJtjlkUniPositionId("无");
		    jtjlk.setJtjlkUniPositionZw("无");
		}
		result.add(jtjlk);
	    } else {
		if (!(jtjlk.getJtjlkPositionId() == null || jtjlk.getJtjlkPositionId().isEmpty())) {
		    jtjlk.setJtjlkUniPositionZw("无");
		    jtjlk.setJtjlkUniPositionId("无");
		    result.add(jtjlk);
		}
	    }
	}

	return result;

    }

    private static Boolean checkSchool(String school) {
	Map<String, Integer> shortlist = new HashMap<String, Integer>();
	shortlist.put("清华大学", 1);
	shortlist.put("北京大学", 2);
	shortlist.put("上海交通大学", 3);
	shortlist.put("复旦大学", 4);
	shortlist.put("浙江大学", 5);
	shortlist.put("南京大学", 6);
	shortlist.put("中国科学技术大学", 7);
	shortlist.put("哈尔滨工业大学", 8);
	shortlist.put("西安交通大学", 9);
	shortlist.put("北京航空航天大学", 10);
	shortlist.put("北京理工大学", 11);
	shortlist.put("西北工业大学", 12);
	return shortlist.containsKey(school);
    }
}
