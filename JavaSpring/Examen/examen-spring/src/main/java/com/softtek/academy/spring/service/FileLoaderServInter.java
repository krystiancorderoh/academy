package com.softtek.academy.spring.service;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public interface FileLoaderServInter {
	public List<List<String>> loadFile(final String NOMBRE_ARCHIVO)throws IOException, InvalidFormatException;
}
