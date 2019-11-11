package com.softtek.academy.jstl.main;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;

public class LeerArchivoExcel {
	
	public static final String NOMBRE_ARCHIVO = "example3.xls";
	public static final String MY_FILE_PATH = "C:\\Archivos-Excel\\" + NOMBRE_ARCHIVO;

	public static void main(String[] args) throws IOException, InvalidFormatException {
        
		Workbook myExcel = WorkbookFactory.create(new File(MY_FILE_PATH));
            
        // Getting the Sheet at index zero
        Sheet sheet = myExcel.getSheetAt(0);

        // this get each cell's value as String
        DataFormatter cellAsString = new DataFormatter();
                
        // this is for iterate over the rows and columns
        for (Row row: sheet) {
            for(Cell cell: row) {
                String cellValue = cellAsString.formatCellValue(cell);
                System.out.print(cellValue + "\t");
            }
            System.out.println();
        }
        
        myExcel.close();
	}

}
