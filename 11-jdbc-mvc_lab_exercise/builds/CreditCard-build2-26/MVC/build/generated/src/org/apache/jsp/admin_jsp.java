package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title></title>\n");
      out.write("</head>\n");
      out.write("    <body>\n");
      out.write("        <div style=\"float:left;width:300px;position:fixed;background-color:#A5DF00\">\n");
      out.write("            <h3>Dance Lessons</h3>\n");
      out.write("            <a href=\"addItem.jsp\">Add Item</a>\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"\">Lindy Hop dance lessons</a></li>\n");
      out.write("                <li><a href=\"\">Texas Swing dance lessons</a></li>\n");
      out.write("                <li><a href=\"\">Texas Swing dance lessons</a></li>\n");
      out.write("            </ul>\n");
      out.write("            <h3>Costumes</h3>\n");
      out.write("            <a href=\"addItem.jsp\">Add Item</a>\n");
      out.write("            <ul><li><a href=\"\">Womens dress, size 8</a></li>\n");
      out.write("            </ul>\n");
      out.write("            <br>\n");
      out.write("            <a href=\"index.jsp\">Logout</a>\n");
      out.write("        </div>\n");
      out.write("        <div style=\"padding-left:310px\">\n");
      out.write("            <h1>Dance Society Auction</h1>\n");
      out.write("            <h2>Lindy Hop Lessons from Rachel</h2>\n");
      out.write("            <br>\n");
      out.write("            <p><b>Current Highest Bid:</b> </p>\n");
      out.write("            <p><b>Current Highest Bidder:</b> </p>\n");
      out.write("        </div>\n");
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
