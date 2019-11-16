
package com.softtek.academy.jstl.dao.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



import com.softtek.academy.jstl.domain.model.Task;

@Repository
public class TaskRowMapper implements RowMapper<Task>{
	
	@Override
    public Task mapRow(final ResultSet rs, int rowNum) throws SQLException {

    	Task task = new Task();
    	task.setIdTask(rs.getInt("idTask"));
    	task.setName(rs.getString("name"));
    	task.setDescription(rs.getString("description"));
    	task.setCreationDate(rs.getTimestamp("creationDate").toLocalDateTime());
    	task.setDueDate(rs.getTimestamp("dueDate").toLocalDateTime());
    	
    	return task;
    }

	
}
