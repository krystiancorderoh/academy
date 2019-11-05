package com.softtek.academy.jstl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.softtek.academy.jstl.dao.mapping.RowMapper;
import com.softtek.academy.jstl.dao.mapping.StateRowMapper;
import com.softtek.academy.jstl.domain.model.State;

public class StateDao extends AbstractDao {

    private RowMapper<State> stateRowMapper;


    public StateDao() {
        stateRowMapper = new StateRowMapper();
    }

    public State findOne(Long id) throws SQLException {
        State state = null;

        try (   Connection connection = super.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM state WHERE id = ?");) {

            preparedStatement.setLong(1, id);

            final ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                state = stateRowMapper.mapRow(rs);
            }
        }

        return state;
    }

    public List<State> findAll() throws SQLException {

        List<State> states = new ArrayList<>();

        try (   Connection connection = super.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM state");) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                states.add(stateRowMapper.mapRow(rs));
            }
        }

        return states;
    }

    public State save(String description) throws SQLException {
        String sqlWithParams = String.format("INSERT INTO state(description) VALUES('%s')", description);

        Long stateId = null;
        try (final Connection connection = super.getConnection();
                final Statement statement = connection.createStatement();) {

            statement.executeUpdate(sqlWithParams, Statement.RETURN_GENERATED_KEYS);
            final ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                stateId = rs.getLong(1);
            }
        }

        return findOne(stateId);
    }

    public State update(Long stateId, String description) throws SQLException {
        String sql = "UPDATE state set description = ? WHERE id = ?";

        try (   Connection connection = super.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, description);
            preparedStatement.setLong(2, stateId);

            preparedStatement.executeUpdate();
        }

        return findOne(stateId);
    }

    public boolean delete(Long stateId) throws SQLException {
        String sql = "DELETE FROM state WHERE id = ?";

        Integer rowsRemoved = null;
        try (   Connection connection = super.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setLong(1, stateId);

            rowsRemoved = preparedStatement.executeUpdate();
        }

        return rowsRemoved > 0;
    }

}