package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("<title>Dance Society Auction</title>\n");
      out.write("</head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div style=\"float:left;width:300px;position:fixed;background-color:#A5DF00\">\n");
      out.write("            <h3>Dance Lessons</h3>\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"\">Lindy Hop dance lessons</a></li>\n");
      out.write("                <li><a href=\"\">Texas Swing dance lessons</a></li>\n");
      out.write("                <li><a href=\"\">Texas Swing dance lessons</a></li>\n");
      out.write("            </ul>\n");
      out.write("            <h3>Costumes</h3>\n");
      out.write("            <ul><li><a href=\"\">Womens dress, size 8</a></li>\n");
      out.write("            </ul>\n");
      out.write("            <ul>\n");
      out.write("                \n");
      out.write("                <form action=\"admin.jsp\" method=\"GET\">\n");
      out.write("                    <table>\n");
      out.write("                        <tr><td><b>Admin Login</b></td></tr>\n");
      out.write("                        <tr><td>Username:</td><td><input type=\"text\" name=\"user\"/></td></tr>\n");
      out.write("                        <tr><td>Password:</td><td><input type=\"text\" name=\"password\"/></td></tr>\n");
      out.write("                        <tr><td><input type=\"submit\" value=\"Login\"/></td></tr>\n");
      out.write("                    </table>\n");
      out.write("                </form>\n");
      out.write("                \n");
      out.write("            </ul>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div style=\"padding-left:310px\">\n");
      out.write("            <h1>Dance Society Auction</h1>\n");
      out.write("            <h2>Lindy Hop Lessons from Rachel</h2>\n");
      out.write("            <img src=\"LindyHop.jpg\" alt=\"Couple dancing the Lindy Hop\">\n");
      out.write("            <br>\n");
      out.write("            <p><b>Description:</b> Learn the exciting \"Lindy Hop\" style of swing dancing at\n");
      out.write("            Rachel's Dance Studio. Package of 6 one-hour lessons for a couple.</p>\n");
      out.write("            <p><b>Availability:</b> Classes meet Tuesday nights from 7 to 8 pm. New classes start monthly.\n");
      out.write("            Must be used by Jan 1, 2014.</p>\n");
      out.write("            <p><b>Minimum bid:</b>$100.</p>\n");
      out.write("            <p><b>Auction Closes: </b></p>\n");
      out.write("            <br>\n");
      out.write("            <br>            \n");
      out.write("            <form action=\"index.jsp\" method=\"GET\">\n");
      out.write("                <table>\n");
      out.write("                    <tr><td><b>Place Bid</b></td></tr>\n");
      out.write("                    <tr><td>Your bid:</td><td><input type=\"text\" name=\"bidAmt\"/></td></tr>\n");
      out.write("                    <tr><td>Name:</td><td><input type=\"text\" name=\"name\"/></td></tr>\n");
      out.write("                    <tr><td>Email:</td><td><input type=\"text\" name=\"email\"/></td></tr>\n");
      out.write("                    <tr><td>Phone number:</td><td><input type=\"text\" name=\"phone\"/></td></tr>\n");
      out.write("                    <tr><td><input type=\"submit\" value=\"Submit Bid\"/></td></tr>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <p style=\"font-size:8pt\">Lindy hop image: 4point4milliondays.com</p>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
