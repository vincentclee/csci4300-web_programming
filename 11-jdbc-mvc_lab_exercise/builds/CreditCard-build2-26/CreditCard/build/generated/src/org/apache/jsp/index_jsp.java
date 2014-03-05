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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("    ");
      creditcard.CustomerAccount account = null;
      synchronized (session) {
        account = (creditcard.CustomerAccount) _jspx_page_context.getAttribute("account", PageContext.SESSION_SCOPE);
        if (account == null){
          account = new creditcard.CustomerAccount();
          _jspx_page_context.setAttribute("account", account, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("account"), "accountNo", "1", null, null, false);
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("account"), "custName", "Gordon Gecko", null, null, false);
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("account"), "custAddress", "1 Wall Street, NYC", null, null, false);
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("account"), "imageUrl", "http://cedricmnich.files.wordpress.com/2007/11/gordongecko.gif", null, null, false);
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("account"), "creditLimit", "10000000", null, null, false);
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("account"), "purchaseAmount", request.getParameter("purchaseAmount"), request, "purchaseAmount", false);
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\" >\n");
      out.write("<title>Customer Account</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<h1>E-Z Credit, Inc.</h1>\n");
      out.write("<img src=\"");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((creditcard.CustomerAccount)_jspx_page_context.findAttribute("account")).getImageUrl())));
      out.write("\" style=\"float:right\" width=\"226\" height=\"284\">\n");
      out.write("<p>Valued customer: ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((creditcard.CustomerAccount)_jspx_page_context.findAttribute("account")).getCustName())));
      out.write("</p>\n");
      out.write("<p>Address: ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((creditcard.CustomerAccount)_jspx_page_context.findAttribute("account")).getCustAddress())));
      out.write("</p>\n");
      out.write("\n");
      out.write("\n");
      out.write("<fmt:setLocale value=\"en_US\"/>\n");
      out.write("<p>Unpaid Balance: <fmt:formatNumber type=\"currency\">");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((creditcard.CustomerAccount)_jspx_page_context.findAttribute("account")).getUnpaidBalance())));
      out.write("</fmt:formatNumber></p>\n");
      out.write("<p>Credit Limit: <fmt:formatNumber type=\"currency\">");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((creditcard.CustomerAccount)_jspx_page_context.findAttribute("account")).getCreditLimit())));
      out.write("</fmt:formatNumber></p>\n");
      out.write("<p>Gordon Gecko image : cedricmnich.wordpress.com</p>\n");
      out.write("\n");
      out.write("\n");
      out.write("<h2>Enter a new Purchase</h2>\n");
      out.write("<form action=\"index.jsp\" method=\"POST\">\n");
      out.write("\n");
      out.write("<p>Purchase Amount: $<input name=\"purchaseAmount\"/>\n");
      out.write("<input type=\"submit\" value=\"Enter Purchase\">\n");
      out.write("<input type=\"reset\"></p>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("\n");
      out.write("<p style=\"color:red\">");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((creditcard.CustomerAccount)_jspx_page_context.findAttribute("account")).getErrorMessage())));
      out.write("</p>\n");
      out.write("</body>\n");
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
