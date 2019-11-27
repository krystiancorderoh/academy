package com.softtek.academy.jstl.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softtek.academy.jstl.domain.dto.TaskToUserDto;
import com.softtek.academy.jstl.domain.model.Task;
import com.softtek.academy.jstl.domain.model.TaskToUser;

@Repository
public interface TaskToUserDaoInt extends JpaRepository<TaskToUser, Long>{
	
	
	
}
