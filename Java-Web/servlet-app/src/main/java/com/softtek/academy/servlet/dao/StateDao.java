package com.softtek.academy.servlet.dao;

import java.util.ArrayList;
import java.util.List;

import com.softtek.academy.servlet.domain.model.StateEntity;

public class StateDao {

    private static List<StateEntity> states;

    static {
        states = new ArrayList<>();
        states.add(new StateEntity(1L, "Baja California"));
        states.add(new StateEntity(2L, "Baja California Sur"));
        states.add(new StateEntity(2L, "Sonora"));
    }

    public StateEntity findOne(final Long id) {
        for (final StateEntity state : states) {
            if (state.getId().equals(id)) {
                return state;
            }
        }

        return null;
    }

    public List<StateEntity> findAll() {
        return states;
    }

    public StateEntity save(final StateEntity state) {
        states.add(state);

        return state;
    }

}