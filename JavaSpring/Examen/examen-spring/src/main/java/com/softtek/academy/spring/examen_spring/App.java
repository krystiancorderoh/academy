package com.softtek.academy.spring.examen_spring;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softtek.academy.spring.service.FileLoaderServImpl;
import com.softtek.academy.spring.service.FileLoaderServInter;
import com.softtek.academy.spring.service.ImportatorServiceInter;
import com.softtek.academy.spring.service.ImportatorUsrTaskServImpl;

/**
 * Importator of Users and Tasks
 *
 */
public class App 
{
    public static void main( String[] args ){
        
    	ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml");
    	
    	ImportatorServiceInter importatorServiceInter;
    	
    	importatorServiceInter = context.getBean(ImportatorUsrTaskServImpl.class);
    	
    	importatorServiceInter.loadFile("usr.xls", "User");
    	
    	importatorServiceInter.validateData("User");
    	
    	importatorServiceInter.insertDataOnDB("User");
    	
    	importatorServiceInter.generateErrorFile("User");
    }
}
