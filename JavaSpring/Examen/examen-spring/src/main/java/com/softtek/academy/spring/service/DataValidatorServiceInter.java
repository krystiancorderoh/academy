package com.softtek.academy.spring.service;

import java.util.List;

public interface DataValidatorServiceInter {
	
	public List<List<String>> validateListFileOnDB(List<List<String>> listaArchivo);
	
	public void validateListFileFormat(List<List<String>> listaArchivo);

}
