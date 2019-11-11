package com.softtek.academy.spring.service;

import java.util.List;

public interface ImportatorServiceInter{
	
	public void loadFile(String nombreArchivo,String table);
	public void validateData(String table);
	public void insertDataOnDB(String table);
	public void generateErrorFile(String table);

}
