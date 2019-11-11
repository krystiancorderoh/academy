package com.softtek.academy.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.softtek.academy.spring.dao.UserDao;
import com.softtek.academy.spring.domain.model.User;

@Service
public class DataValidatorUsrServImpl implements DataValidatorServiceInter {
	@Autowired
	UserDao userDao;
	
	public List<List<String>> validateListFileOnDB(List<List<String>> listaArchivo) {
		List<User> users = userDao.findAll();
		List<List<String>> errorsListFile = new ArrayList<List<String>>();
		
		for(User user:users) {
			for(int i=0;i<listaArchivo.size(); i++) {
				List<String> renglon = listaArchivo.get(i);
				if(user.getEmail().equals(renglon.get(1))) {
					errorsListFile.add(renglon);
					listaArchivo.remove(i);
				}
			}
		}
		return errorsListFile;
	}

	public void validateListFileFormat(List<List<String>> listaArchivo) {
		// TODO Auto-generated method stub
		
	}


}
