/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-10-30 03:02:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.city;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.softtek.academy.jsp.domain.dto.CityDto;
import com.softtek.academy.jsp.web.mapping.EntityMapper;
import com.softtek.academy.jsp.web.mapping.CityMapper;
import com.softtek.academy.jsp.service.CityService;
import com.softtek.academy.jsp.domain.model.CityEntity;
import org.apache.commons.lang3.StringUtils;
import com.softtek.academy.jsp.exception.InvalidInputException;
import com.softtek.academy.jsp.domain.model.StateEntity;
import com.softtek.academy.jsp.service.StateService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.List;

public final class add_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	static final Logger LOGGER = LoggerFactory.getLogger("CityAdd");

	EntityMapper<CityDto> cityMapper = new CityMapper();
	CityService cityService = new CityService();
	StateService stateService = new StateService();

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    \n");
    
    String msg = StringUtils.EMPTY;
    String disabled = StringUtils.EMPTY;

    CityDto cityDto = null;

    if (request.getParameter("save") == null) {
        cityDto = new CityDto(null, StringUtils.EMPTY, null);

    } else {
       cityDto = cityMapper.mapEntity(request);
        try {
            LOGGER.info("Saving: {}", cityDto);

            cityService.save(cityDto);
            msg = "Saved successfully";
            disabled = "disabled";

        } catch (InvalidInputException e) {
            msg = e.getMessage();
        }
    }
    
    List<StateEntity> states = stateService.getStates();
    
    String contextPath = request.getContextPath();

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Cities</title>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<h3>New City</h3>\n");
      out.write("\n");
      out.write("\t<form method=\"post\" action=\"\">\n");
      out.write("\t\t<table style=\"width: 30%;\">\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td width=\"30%\">Id</td>\n");
      out.write("\t\t\t\t<td width=\"70%\"><input type=\"text\" name=\"id\" value=\"");
      out.print(cityDto.getId());
      out.write('"');
      out.write(' ');
      out.print(disabled);
      out.write("></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td>Description</td>\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"description\"value=\"");
      out.print(cityDto.getDescription());
      out.write('"');
      out.write(' ');
      out.print(disabled);
      out.write("></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td>State</td>\n");
      out.write("\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t<select name=\"stateId\" ");
      out.print(disabled);
      out.write('>');
      out.write(' ');
 
						for (StateEntity state : states) { 
      out.write("\n");
      out.write("\t\t\t\t\t\t    <option value=\"");
      out.print( state.getId() );
      out.write('"');
      out.write(' ');
      out.print( state.getId().equals(cityDto.getStateId()) ? "selected" : StringUtils.EMPTY );
      out.write(">\n");
      out.write("\t\t\t\t\t\t    \t");
      out.print( state.getDescription() );
      out.write("\n");
      out.write("\t\t\t\t\t\t    </option> ");

						}						
					
      out.write("</select>\n");
      out.write("\t\t\t\t</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t</table>\n");
      out.write("\t\t<input type=\"submit\" name=\"save\" ");
      out.print(disabled);
      out.write(">\n");
      out.write("\t</form>\n");
      out.write("\n");
      out.write("\t<br>\n");
      out.write("\t<div>");
      out.print(msg);
      out.write("</div>\n");
      out.write("\n");
      out.write("\t<br>\n");
      out.write("\t<a href=\"");
      out.print(contextPath);
      out.write("/index.jsp\">Return to home</a>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
