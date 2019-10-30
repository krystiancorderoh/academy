package com.softtek.academy.servlet.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softtek.academy.servlet.domain.model.StateEntity;
import com.softtek.academy.servlet.exception.InvalidInputException;
import com.softtek.academy.servlet.service.StateService;
import com.softtek.academy.servlet.web.mapping.EntityMapper;
import com.softtek.academy.servlet.web.mapping.StateMapper;

public class StateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static final Logger LOGGER = LoggerFactory.getLogger(WelcomeServlet.class);

    private StateService stateService;
    private EntityMapper<StateEntity> stateMapper;

    @Override
    public void init() throws ServletException {
        stateService = new StateService();
        stateMapper = new StateMapper();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        LOGGER.info("Retrieving states:");

        final List<StateEntity> states = stateService.getStates();
        states.forEach(state -> LOGGER.info("{}", state));

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>States</title></head>");
        out.println("<body>");

        out.println("   <h3>State List</h3>");

        out.println("   <div>Id - Description</div>");
        for (final StateEntity state : states) {
            out.println("<div>" + state.getId() + " - " + state.getDescription() + "</div>");
        }

        out.println("	<br>");
        out.println("	<a href='/servlet-app/index.html'>Return to home</a>");

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>State</title></head>");
        out.println("<body>");

        try {
            StateEntity state = stateMapper.mapEntity(request);
            LOGGER.info("Saving state: {}", state);

            state = stateService.save(state);

            out.println("   <h3>Added:</h3>");
            out.println("   id: " + state.getId() + "<br>");
            out.println("   Description: " + state.getDescription() + "<br>");

            out.println("       <br>");
            out.println("   <a href='/servlet-app/states'>Return to State List</a>");

        } catch (InvalidInputException e) {
            LOGGER.error(e.getMessage(), e);

            out.println("   <h4>" + e.getMessage() + "</h4>");
            out.println("   <br>");
            out.println("   <a href='/servlet-app/view/stateAdd.html'>Return to Add State</a>");
        }

        out.println("</body>");
        out.println("</html>");
    }

}