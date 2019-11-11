package com.softtek.academy.spring.service;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.softtek.academy.spring.dao.UserDao;

@Component
public class ImportatorUsrTaskServImpl implements ImportatorServiceInter{
	
	@Autowired
	FileLoaderServInter fileLoaderServInter;
	
	@Autowired 
	DataValidatorServiceInter dataValidatorServiceInter;
	
	@Autowired
	UserDao userDao;
	
	private List<List<String>> listaArchivoUsuarios;
	private List<List<String>> listaArchivoTareas;
	private List<List<String>> listaArchivoErroresUsuario;
	
	public void loadFile(String nombreArchivo, String table) {
		
		try {
			if(table == "User") {
				listaArchivoUsuarios = fileLoaderServInter.loadFile(nombreArchivo);
				
			}else if (table == "Task") {
				listaArchivoTareas = fileLoaderServInter.loadFile(nombreArchivo);
			}
			
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void validateData(String table) {
		listaArchivoErroresUsuario = dataValidatorServiceInter.validateListFileOnDB(listaArchivoUsuarios);
	}
	
	public void insertDataOnDB(String table) {
		if(table == "User") {
			userDao.insertAll(listaArchivoUsuarios);
		}
		
	}

	public void generateErrorFile(String table) {
		if(table == "User") {
//			userDao.insertAll(listaArchivoUsuarios);
		}
		
	}
	
}
