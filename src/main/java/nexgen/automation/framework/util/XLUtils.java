package nexgen.automation.framework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




import nexgen.automation.framework.util.XLUtils;

import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ExecutionResult;



public class XLUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	static final  Logger log = Logger.getLogger(XLUtils.class);
	public void setExcelWBook(InputStream excelFile) throws IOException {
		wb = new XSSFWorkbook(excelFile);
	}

	public int getRowCount(String xlfile, String xlsheet) throws IOException {

		int rowcount;
		ZipSecureFile.setMinInflateRatio(0);
		fi = new FileInputStream(xlfile);

		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}

	public int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}

	public String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		String data=null;
		try {
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		wb.close();
		fi.close();
		return data;
	}

	public void writeToExcel(String text, String path, int row, int column){

		XSSFSheet sheet = null;
		try(FileInputStream file = new FileInputStream(new File(path));XSSFWorkbook workbook = new XSSFWorkbook(file);FileOutputStream outFile = new FileOutputStream(new File(path));)
		{
			  sheet = workbook.getSheetAt(0);
			  CellStyle style = null;
			if (text.equals("Pass")) {

				style = workbook.createCellStyle();
				style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				Font font = workbook.createFont();
				font.setColor(IndexedColors.BLACK.getIndex());
				style.setFont(font);

			} else {

				style = workbook.createCellStyle();
				style.setFillForegroundColor(IndexedColors.RED.getIndex());
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				Font font = workbook.createFont();
				font.setColor(IndexedColors.BLACK.getIndex());
				style.setFont(font);

			}
			// 'Write data to excel'
			sheet.getRow(row).createCell(column).setCellValue(text);
			sheet.getRow(row).getCell(column).setCellStyle(style);

			workbook.write(outFile);

		}
		catch (IOException e)
		{
			log.error(e.getMessage());
		}
		
	}

	public void writeToExcel(String Text, String fileName, String sheetName, int rowNumber, String columnName)
			throws IOException {

		String xlSheetName = sheetName;
		String cellData = "";
		String file = fileName;

		fi = new FileInputStream(file);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheetName);

		row = ws.getRow(0);

		int cellcount = row.getLastCellNum();

		for (int i = 0; i < cellcount; i++) {

			cell = row.getCell(i);
			DataFormatter formatter = new DataFormatter();
			cellData = formatter.formatCellValue(cell);
			CellStyle style = wb.createCellStyle();
			if (cellData.equalsIgnoreCase(columnName)) {
				row = ws.getRow(rowNumber);
				cell = row.getCell(i);

				if (Text.equalsIgnoreCase("Pass")) {

					style = wb.createCellStyle();
					style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
					style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
					Font font = wb.createFont();
					font.setColor(IndexedColors.BLACK.getIndex());
					style.setFont(font);

				} else if(Text.equalsIgnoreCase("Fail")) {

					style = wb.createCellStyle();
					style.setFillForegroundColor(IndexedColors.RED.getIndex());
					style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
					Font font = wb.createFont();
					font.setColor(IndexedColors.BLACK.getIndex());
					style.setFont(font);

					// 'Write data to excel'
					ws.getRow(rowNumber).createCell(i).setCellValue(Text);
					ws.getRow(rowNumber).getCell(i).setCellStyle(style);
				}
				ws.getRow(rowNumber).createCell(i).setCellValue(Text);
				ws.getRow(rowNumber).getCell(i).setCellStyle(style);

			}

		}

		FileOutputStream outFile = new FileOutputStream(new File(fileName));
		wb.write(outFile);
		wb.close();
		outFile.close();
		wb.close();

	}
	//Write the data in zephyr report file
	//public void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data)
	public void setCellData(String xlfile,int rownum, int colnum, String data)
	{

		try(FileInputStream file = new FileInputStream(new File(xlfile));XSSFWorkbook workbook = new XSSFWorkbook(file);FileOutputStream outFile =new FileOutputStream(new File(xlfile)))
		{
			
			XSSFSheet sheet = workbook.getSheetAt(0);

		if (colnum == 1) {

			sheet.createRow(rownum).createCell(colnum).setCellValue(data);

		} else {

			sheet.getRow(rownum).createCell(colnum).setCellValue(data);

		}
		workbook.write(outFile);
	}
	catch(Exception e)
	{
		log.error(e.getMessage());
	}
	
}

	public void cleanSheet(String xlfile, String xlsheet) throws IOException 
	{
		try(FileInputStream file = new FileInputStream(new File(xlfile));XSSFWorkbook workbook = new XSSFWorkbook(file);FileOutputStream outFile = new FileOutputStream(new File(xlfile)))
		{
		  XSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = getRowCount(xlfile, xlsheet);

		for (int rowNum = 0; rowNum < rowCount; rowNum++) {

			int rowNumber = rowNum + 1;

			sheet.removeRow(sheet.getRow(rowNumber));

		}
		workbook.write(outFile);
	}
	catch(Exception e)
	{
		log.error(e.getMessage());
	}
	
}

	public static String createWorkBook() {
		String file = null;
		
			String timeStamp = new SimpleDateFormat("HH_mm_ss_MM_dd_yyyy").format(new Date());

			File fileName = new File(System.getProperty("user.dir") + Constant.EXCELPATH + "_" + ExecutionResult.suitename
					+ "_" + timeStamp + ".xlsx");
			try(FileOutputStream fos = new FileOutputStream(fileName);XSSFWorkbook workbook = new XSSFWorkbook()) {

			workbook.createSheet("Sheet1");

			workbook.write(fos);
			fos.flush();

			file = fileName.toString();


		} catch (Exception ex) {

			log.error(ex.getMessage());

		}

		return file;

	}

	public String[] readDataFromExcelUsingColumnName(String columnName)
	{
		String xlSheetName = "Sheet1";
		String cellData = "";
		String userDetails = System.getProperty("user.dir") + Constant.LOGINDETAILS;
		String resturDetails[] = new String[2];
     try
     {
        fi = new FileInputStream(userDetails);
    	wb = new XSSFWorkbook(fi);
    	ws = wb.getSheet(xlSheetName);
		String user = "";
		String pass = "";
		row = ws.getRow(0);

		int cellcount = row.getLastCellNum();

		for (int i = 0; i < cellcount; i++) {

			cell = row.getCell(i);
			DataFormatter formatter = new DataFormatter();
			cellData = formatter.formatCellValue(cell);
			if (cellData.equalsIgnoreCase(columnName)) {
				log.info(cellData);

				row = ws.getRow(1);
				cell = row.getCell(i);
				DataFormatter formatter2 = new DataFormatter();
				user = formatter2.formatCellValue(cell);
				log.info(user);

				row = ws.getRow(2);
				cell = row.getCell(i);
				DataFormatter formatter3 = new DataFormatter();
				pass = formatter3.formatCellValue(cell);
				log.info(user);

			}

		}
		resturDetails[0] = user;

		resturDetails[1] = pass;
     }
	catch (Exception ex) {

		log.error(ex.getMessage());
	}
	   return resturDetails;
	}

	public String readUsingColName(String fileName, String sheetName, int rowNumber, String columnName)
			throws  IOException {
		String xlSheetName = sheetName;
		String cellData = "";
		String file = fileName;

		fi = new FileInputStream(file);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheetName);
		String value = "";

		row = ws.getRow(0);

		int cellcount = row.getLastCellNum();

		for (int i = 0; i < cellcount; i++) {

			cell = row.getCell(i);
			DataFormatter formatter = new DataFormatter();
			cellData = formatter.formatCellValue(cell);
			if (cellData.equalsIgnoreCase(columnName)) {
				row = ws.getRow(rowNumber);
				cell = row.getCell(i);
				DataFormatter formatter2 = new DataFormatter();
				value = formatter2.formatCellValue(cell);

			}

		}

		String resturDetails = value;

		wb.close();

		return resturDetails;

	}

	
	public String ReadUsingColName(String FileName, String sheetName, int rowNumber, String ColumnName)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		String SheetName = sheetName;
		String cellData = "";
		String file = FileName;

		fi = new FileInputStream(file);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(SheetName);
		String value = "";

		row = ws.getRow(0);

		int cellcount = row.getLastCellNum();

		for (int i = 0; i < cellcount; i++) {

			cell = row.getCell(i);
			DataFormatter formatter = new DataFormatter();
			cellData = formatter.formatCellValue(cell);
			if (cellData.equalsIgnoreCase(ColumnName)) {
				// System.out.println(cellData);
				row = ws.getRow(rowNumber);
				cell = row.getCell(i);
				DataFormatter formatter2 = new DataFormatter();
				value = formatter2.formatCellValue(cell);
				// System.out.println(value);

			}

		}

		String resturDetails = value;

		wb.close();

		return resturDetails;

	}


	public List<String> getDetails(List<String> input, int rowNumber, String sheetName,XLUtils xl,String filepath) throws Exception
    {
		int length=input.size();
		List<String> result=new ArrayList<String>();
		try
		{
		if (length>=1)
		{
			for(int i=0;i<length;i++)
			{
				

		        result.add(xl.ReadUsingColName(filepath, sheetName, rowNumber, input.get(i)));

		      
			}
		}}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		//result=loop(length,input,rowNumber, sheetName, xl,filepath);
		             
		return result;
    }

}