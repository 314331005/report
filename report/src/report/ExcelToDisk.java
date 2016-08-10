package report;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Font;


public class ExcelToDisk {
	
	static Connection conn = null;
	static ResultSet res = null;
	//static String staticSql = "select IDNumber, CARDID, USERNAME from User_Infor_Message";
	static String staticSql = "SELECT * FROM test WHERE IDNumber IN (SELECT IDNumber FROM test  GROUP BY CARDID)";
	/**
	 * 价值数据
	 */
	private static List<Data> getData() throws Exception {
		
		List<Data> list = new ArrayList();  
		conn = DBToolkit.getConnection();
		res = DBToolkit.executeQuery(conn, staticSql);
		while(res.next()){
			
			String idNumber;
			String cardId;
			String userName;
			String idserial;
			idNumber = res.getString("IDNumber");
			cardId = res.getString("CARDID");
			userName = res.getString("USERNAME");
			//idserial = res.getString("IDSERIAL");
			
			
			Data d = new Data();
			d.setIdNumber(idNumber);
			d.setCardId(cardId);
			d.setUserName(userName);
			//d.setIdserial(idserial);
			list.add(d);
			
		}
		return list;
	}

	public static void expData() throws Exception {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("Sheet1");
		HSSFRow row = sheet.createRow((int) 0);
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 设置居中
		Font font = wb.createFont();
		font.setFontHeightInPoints((short)12);
		style.setFont(font);

		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("人员姓名");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("人员编号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("部门名称");
		cell.setCellStyle(style);
		cell = row.createCell((short) 3);
		cell.setCellValue("部门编号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 4);
		cell.setCellValue("ְ职务");
		cell.setCellStyle(style);
		cell = row.createCell((short) 5);
		cell.setCellValue("性别");
		cell.setCellStyle(style);
		cell = row.createCell((short) 6);
		cell.setCellValue("卡片自编号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 7);
		cell.setCellValue("卡号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 8);
		cell.setCellValue("个人密码");
		cell.setCellStyle(style);
		cell = row.createCell((short) 9);
		cell.setCellValue("民族");
		cell.setCellStyle(style);
		cell = row.createCell((short) 10);
		cell.setCellValue("手机");
		cell.setCellStyle(style);
		cell = row.createCell((short) 11);
		cell.setCellValue("地址ַ");
		cell.setCellStyle(style);

		List<Data> list = ExcelToDisk.getData();

		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow((int) i + 1);
			Data d = list.get(i);
			if(Hex.getHex(d.getCardId()).equals(""))  continue;
			row.createCell((short) 7).setCellValue(Hex.getHex(d.getCardId()));
			row.createCell((short) 0).setCellValue(d.getUserName());
			row.createCell((short) 1).setCellValue(d.getIdNumber());
			//row.createCell((short) 2).setCellValue(3);
			//row.createCell((short) 3).setCellValue(4);
			//row.createCell((short) 4).setCellValue(5);
			//row.createCell((short) 5).setCellValue(6);
			//row.createCell((short) 6).setCellValue(7);
			
			//row.createCell((short) 8).setCellValue(9);
			//row.createCell((short) 9).setCellValue(10);
			//row.createCell((short) 10).setCellValue(11);
			//row.createCell((short) 11).setCellValue(12);
		}
		//调整宽度
		sheet.setColumnWidth(0, 15 * 256);
		sheet.setColumnWidth(1, 15 * 256);
		sheet.setColumnWidth(2, 15 * 256);
		sheet.setColumnWidth(3, 15 * 256);
		sheet.setColumnWidth(4, 15 * 256);
		sheet.setColumnWidth(5, 15 * 256);
		sheet.setColumnWidth(6, 15 * 256);
		sheet.setColumnWidth(7, 15 * 256);
		sheet.setColumnWidth(8, 15 * 256);
		sheet.setColumnWidth(9, 15 * 256);
		sheet.setColumnWidth(10, 15 * 256);
		sheet.setColumnWidth(11, 15 * 256);
        
		//生成文件
		try {
			String path = DBToolkit.getProps().getProperty("file.path");
			String fileName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			String ext =".xls";
			FileOutputStream fout = new FileOutputStream(path + fileName + ext);
			wb.write(fout);
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 写入数据库
	 * @throws Exception
	 */
	public static void expDataToDb() throws Exception{
		
		Connection connection;
		PreparedStatement pstmt;
		List<Data> list = ExcelToDisk.getData();
		System.out.println(list.size());
		
		connection = DBToolkit.getConnection();
		 //用事务，必须设置setAutoCommit false，表示手动提交
		connection.setAutoCommit(false);
		 //设置事务的隔离级别。
		connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
		  
		// String sql1 = "insert into userinfo(username,pswd) values(?,?)";
		String sql2 = "update test1 set CardData=? where PCode = ?";
		for(Data d : list){
			pstmt = connection.prepareStatement(sql2);
			pstmt.setString(1, Hex.getHex(d.getCardId()));
			pstmt.setString(2, d.getIdNumber());               
			pstmt.executeUpdate();
		}
		 //提交事务
		connection.commit();
		
	}
}