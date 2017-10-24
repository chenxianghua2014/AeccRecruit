/**   
* @Title ExcelTest.java 
* @Package com.ttgis.recruit.utility 
* @Description TODO 
* @author hua
* @date 2016年9月29日 下午2:25:09 
* @version V1.0   
*/
package com.ttgis.recruit.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;

import com.ttgis.recruit.utility.random.RandomGUIDUtil;

/** 
* @ClassName ExcelTest 
* @Description TODO 
* @author cxh 
* @date 2016年9月29日 下午2:25:09 
*  
*/
public class ExcelTest {
    /*
     * CellType 类型 值
     * CELL_TYPE_NUMERIC 数值型 0
     * CELL_TYPE_STRING 字符串型 1
     * CELL_TYPE_FORMULA 公式型 2
     * CELL_TYPE_BLANK 空值 3
     * CELL_TYPE_BOOLEAN 布尔型 4
     * CELL_TYPE_ERROR 错误 5
     */

    public static void main(String[] args) {
	String fileToBeRead = "E:\\needAddId.xls"; // excel位置
	try {
	    HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(fileToBeRead));
	    HSSFSheet sheet = workbook.getSheet("Sheet1");
	    // int columLength = 4; // 实际列数+1
	    int rowLength = sheet.getLastRowNum();
	    // System.out.println(RandomGUIDUtil.generateKey());
	    for (int i = 1; i <= rowLength; i++) {
		HSSFRow row = sheet.getRow(i);
		if (null == row) {
		    continue;
		} else {

		    row.getCell(0).setCellValue(RandomGUIDUtil.generateKey());
		    // System.out.println(row.getCell(1).getStringCellValue());
		    /*
		     * for (int j = 0; j <= columLength; j++) {
		     * HSSFCell cell = row.getCell(j);
		     * if (null == cell) {
		     * continue;
		     * } else {
		     * System.out.println(cell);
		     * cell.setCellValue("aa" + cell.toString());
		     * int temp = (int) cell.getNumericCellValue();
		     * cell.setCellValue(cell.getStringCellValue() + "1");
		     * }
		     * }
		     */
		    // RandomGUIDUtil.generateKey();
		    /*
		     * HSSFCell cell = row.getCell(8);
		     * HSSFRow rowUp = sheet.getRow(i-1);
		     */
		    /*
		     * if(row.getCell(5).getCellType() == 0){
		     * cell.setCellValue(String.valueOf((int)row.getCell(5).getNumericCellValue()));
		     * }
		     */

		    /*
		     * if(cell.getCellType() == 3){
		     * 
		     * cell.setCellValue(rowUp.getCell(8).getStringCellValue());
		     * }
		     */

		    // cell.setCellValue(row.getCell(5).getStringCellValue());
		    /* System.out.println(row.getCell(5).getCellType() + "------>" + i); */
		    /*
		     * if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
		     * 
		     * String tempString = String.valueOf((int)cell.getNumericCellValue());
		     * if(tempString.length() == 4){
		     * cell.setCellValue("0" + tempString);
		     * }
		     * //System.out.println(tempString);
		     * }
		     * if(cell.getCellType() == Cell.CELL_TYPE_STRING){
		     * if(cell.getStringCellValue().length() == 4)
		     * System.out.println("0" + cell.getStringCellValue());
		     * }
		     */

		    // System.out.println(cell.getCellType());
		    /*
		     * if(cell.toString().trim().length() == 4){
		     * cell.setCellValue("0" + cell.toString().trim());
		     * }
		     */

		}
	    }
	    FileOutputStream out = null;
	    try {
		out = new FileOutputStream(fileToBeRead);
		workbook.write(out);
	    } catch (IOException e) {
		e.printStackTrace();
	    } finally {
		try {
		    out.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

    @Test
    public void testExcel() {
	String fileToBeRead = "E:\\needAddId.xls"; // excel位置
	try {
	    HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(fileToBeRead));
	    HSSFSheet sheet = workbook.getSheet("Sheet1");
	    int columLength = 10; // 实际列数+1
	    int rowLength = sheet.getLastRowNum();
	    // System.out.println(RandomGUIDUtil.generateKey());
	    for (int i = 1; i <= rowLength; i++) {
		HSSFRow row = sheet.getRow(i);
		if (null == row) {
		    continue;
		} else {
		    HSSFCell cell = row.getCell(0);
		    cell.setCellValue(RandomGUIDUtil.generateKey());
		   

		}
	    }
	    FileOutputStream out = null;
	    try {
		out = new FileOutputStream(fileToBeRead);
		workbook.write(out);
	    } catch (IOException e) {
		e.printStackTrace();
	    } finally {
		try {
		    out.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void generateSql(){
	String fileToBeRead = "E:\\needAddId.xls"; // excel位置
	String sqlString = "INSERT [dbo].[ORGANIZATION] ([ORGANIZATION_ID], [ORGANIZATION_DWMC], [ORGANIZATION_DWDM], [ORGANIZATION_DWZH], [ORGANIZATION_ZHMM], [ORGANIZATION_SJDW], [ORGANIZATION_DWJC], [ORGANIZATION_FWQX], [ORGANIZATION_DWFZR], [ORGANIZATION_ZPLXR], [ORGANIZATION_LXRDH], [ORGANIZATION_LXREMAIL], [ORGANIZATION_DWJJ], [ORGANIZATION_AT], [ORGANIZATION_DEL], [SFJY], [YJNFY], [YFFY], [CPCS], [ORGANIZATION_EJMM], [ORGANIZATION_ORDER], [ORGANIZATION_GZDH]) VALUES (N'00BCE2E6-3BC6-AD8C-A80F-B9E21583AE3F', N'航天晨光（镇江）专用汽车有限公司', N'12016', N'12016', N'E10ADC3949BA59ABBE56E057F20F883E', N'095672E1-2EAF-BAAC-08F9-D60E2605D7D7', N'', N'2', N'', N'', N'', N'', NULL, CAST(0x0000A39400E55DF0 AS DateTime), 1, NULL, NULL, NULL, 2, NULL, NULL, N'')";
	try {
	    HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(fileToBeRead));
	    HSSFSheet sheet = workbook.getSheet("Sheet1");
	    int columLength = 10; 
	    int rowLength = sheet.getLastRowNum();
	    // System.out.println(RandomGUIDUtil.generateKey());
	    for (int i = 1; i <= rowLength; i++) {
		HSSFRow row = sheet.getRow(i);
		if (null == row) {
		    continue;
		} else {
		    HSSFCell cell = row.getCell(0);
		    cell.setCellValue(RandomGUIDUtil.generateKey());
		   

		}
	    }
	    FileOutputStream out = null;
	    try {
		out = new FileOutputStream(fileToBeRead);
		workbook.write(out);
	    } catch (IOException e) {
		e.printStackTrace();
	    } finally {
		try {
		    out.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
