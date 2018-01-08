package testUtility;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class dataReaderUtility {

	//Method to read N number of rows and columns from excel
	public static List<String[]> readExcelData(int sheetNum){
		try{
			List<String[]> returnData = new ArrayList<String[]>();
			String[] rowArray = null;
			
			String excelFilePath = System.getProperty("user.dir")+"//xcelFile.xlsx";
	        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	        Workbook wrkb = new XSSFWorkbook(inputStream);
	        Sheet sh =wrkb.getSheetAt(0);
			Iterator<Row> iterator = sh.iterator();
	        int colCount =sh.getRow(0).getLastCellNum();
 	   
			while(iterator.hasNext())
			{
				int cnt = 0; 
				rowArray = new String[colCount];
				Row nextRow = iterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				while (cellIterator.hasNext()){
					Cell cell = cellIterator.next();
					
					String strVar = null;
					switch (cell.getCellType()) {
	                    case Cell.CELL_TYPE_STRING:
	                        strVar = cell.getStringCellValue();
	                        break;
	                    case Cell.CELL_TYPE_BOOLEAN:
	                        strVar = String.valueOf(cell.getBooleanCellValue());
	                        break;
	                    case Cell.CELL_TYPE_NUMERIC:
	                        strVar = String.valueOf(cell.getNumericCellValue());
	                        break;
	                }
	                rowArray[cnt] = strVar;
	                cnt++;
	            }
				returnData.add(rowArray);
	        }
			
	        inputStream.close();
	        return returnData; 
		}
		catch (Exception e) {
			return null;
		}
		
	}
}
