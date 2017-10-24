/**
 * 董再兴 FullCharConverter.java 2013年8月31日
 */
package com.ttgis.recruit.utility;

/**
 * @author 董再兴
 *	全角半角转换
 */
public class FullCharConverter {
	
	/**
	 * 半角转全角
	 * @param input	半角字符串
	 * @return 全角字符串
	 */
	public static String ToSBC(String input) {
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
          if (c[i] == ' ') {
            c[i] = '\u3000';
          } else if (c[i] < '\177') {
            c[i] = (char) (c[i] + 65248);
          }
        }
        return new String(c);
	}
	
	/**
	 * 全角转半角
	 * @param input 全角字符串
	 * @return 半角字符串
	 */
	public static String ToDBC(String input) {
	     char c[] = input.toCharArray();
	          for (int i = 0; i < c.length; i++) {
	            if (c[i] == '\u3000') {
	              c[i] = ' ';
	            } else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
	              c[i] = (char) (c[i] - 65248);
	            }
	          }
	          String returnString = new String(c);
	          return returnString;
	 }
	
}
