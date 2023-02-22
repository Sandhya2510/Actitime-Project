package com.Actitime.Generic_Library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibrary {
   String  path="./Testdata/commondaata.property";
	public String readDataFromPropertyFile(String key) throws IOException 
	{
		FileInputStream fis =new FileInputStream(path);
		Properties p =new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	
	
	public String readDataFromExcelFile(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis =new FileInputStream("./Testdata/Testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		 String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return value;
		
	}
}
