package com.softtek.academy.jsp.dao;

import java.util.ArrayList;
import java.util.List;

import com.softtek.academy.jsp.domain.model.StateEntity;

public class StateDao {

    private static List<StateEntity> states;

    static {
        states = new ArrayList<>();
        states.add(new StateEntity(1L, "Baja California"));
        states.add(new StateEntity(2L, "Baja California Sur"));
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

    public StateEntity save(StateEntity state) {
        states.add(state);

        return state;
    }

    public StateEntity update(StateEntity state) {
        final StateEntity originalState = this.findOne(state.getId());
        originalState.setDescription(state.getDescription());

        return originalState;
    }
}