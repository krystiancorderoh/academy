package com.softtek.academy.spring.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;

@Component
public class FileLoaderServImpl implements FileLoaderServInter{

	public static final String FILE_PATH = "C:\\Archivos-Excel\\";
			
	public List<List<String>> loadFile(final String NOMBRE_ARCHIVO) throws IOException, InvalidFormatException{
		
		//Lista de renglones del archivo
		List<List<String>> listaArchivo = new ArrayList();
		
		Workbook myExcel = WorkbookFactory.create(new File(FILE_PATH + NOMBRE_ARCHIVO));
        
        // Getting the Sheet at index zero
        Sheet sheet = myExcel.getSheetAt(0);

        // this get each cell's value as String
        DataFormatter cellAsString = new DataFormatter();
                
        // this is for iterate over the rows and columns
        for (Row row: sheet) {
        	List<String> listaRenglon = new ArrayList();
            for(Cell cell: row) {
                String cellValue = cellAsString.formatCellValue(cell);
                listaRenglon.add(cellValue);
//                System.out.print(cellValue + "\t");
            }
            listaArchivo.add(listaRenglon);
//            System.out.println();
        }
        
        myExcel.close();
		return listaArchivo;
	}

}
