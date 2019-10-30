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
import com.softtek.academy.servlet.domain.model.CityEntity;
import com.softtek.academy.servlet.exception.InvalidInputException;
import com.softtek.academy.servlet.service.CityService;
import com.softtek.academy.servlet.web.mapping.EntityMapper;
import com.softtek.academy.servlet.web.mapping.CityMapper;

public class CityServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    public static final Logger LOGGER = LoggerFactory.getLogger(WelcomeServlet.class);

    private CityService cityService;
    private EntityMapper<CityEntity> cityMapper;

    @Override
    public void init() throws ServletException {
        cityService = new CityService();
        cityMapper = new CityMapper();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        LOGGER.info("Retrieving states:");

        final List<CityEntity> cities = cityService.getCities();
        cities.forEach(city -> LOGGER.info("{}", city));

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Cities</title></head>");
        out.println("<body>");

        out.println("   <h3>City List</h3>");

        out.println("   <div>Id - Description - State</div>");
        for (final CityEntity city : cities) {
            out.println("<div>" + city.getId() + " - " + city.getDescription() + " - " + city.getState().getDescription() + "</div>");
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
        out.println("<head><title>City</title></head>");
        out.println("<body>");

        try {
            CityEntity city = cityMapper.mapEntity(request);
            LOGGER.info("Saving state: {}", city);

            city = cityService.save(city);
            
            StateEntity state = city.getState();

            out.println("   <h3>Added:</h3>");
            out.println("   id: " + city.getId() + "<br>");
            out.println("   Description: " + city.getDescription() + "<br>");
            out.println("   Description: " + state.getDescription() + "<br>");

            out.println("       <br>");
            out.println("   <a href='/servlet-app/cities'>Return to State List</a>");

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
