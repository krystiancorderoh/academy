package com.softtek.academy.spring.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.softtek.academy.jpa.domain.model.StateEntity;
import com.softtek.academy.jpa.exception.InvalidInputException;
import com.softtek.academy.jpa.service.StateService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/META-INF/spring/applicationContext.xml")
public class StateServiceTest {

    @Autowired
    private StateService stateService;

    @Test @Ignore
    public void getStates() throws SQLException {
        List<StateEntity> states = stateService.getStates();

        states.forEach(state -> System.out.println(state.toString()));
    }

    @Test
    public void saveState() throws InvalidInputException, SQLException {
        StateEntity state = new StateEntity();
        //state.setDescription("San Juan Chulula");

        stateService.save(state);

        this.getStates();
    }

    @Test @Ignore
    public void updateState() throws InvalidInputException, SQLException {
        StateEntity state = stateService.getState(34L);
        state.setDescription("San Juanicolous");

        stateService.update(state);

        this.getStates();
    }

    @Test @Ignore
    public void deleteState() throws InvalidInputException, SQLException {
        stateService.delete(33L);

        this.getStates();
    }

}
