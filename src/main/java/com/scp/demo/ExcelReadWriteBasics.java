		package com.scp.demo;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
		
		public class ExcelReadWriteBasics {
				public static void main(String[] args) throws IOException {
				
					
					//C:\Users\Yogesh\Documents\demo.xlsx
					//HSSFworkbook  -POi -- 2007
					//XSSFWorkbook --poi ooxml  -- 2007 and onwards
					
					XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\Yogesh\\Documents\\demo.xlsx");
					XSSFSheet sheet = workbook.getSheet("data");//workbook.getSheetAt(2);
					Iterator<Row> rows = sheet.rowIterator();
					
					while(rows.hasNext()){
							Row row = rows.next();
							Iterator<Cell> cells = row.cellIterator();
									while(cells.hasNext()){
										Cell cell = cells.next();
										System.out.print("\t "+cell.getStringCellValue());
									}
									System.out.println("\n");
					}
					
					
					
				}
		}
