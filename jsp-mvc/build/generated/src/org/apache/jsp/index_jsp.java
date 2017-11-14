package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.File;
import java.lang.String;
import classes.string;
import classes.numeric;
import app.core.app;

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <title>Mvc Proje Jsp</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <!--<h1>");
      out.print(request.getRequestURL());
      out.write("</h1>\r\n");
      out.write("    <h2>");
      out.print(request.getServletPath());
      out.write("</h2>\r\n");
      out.write("    <h3>");
      out.print(request.getRequestURI());
      out.write("</h3>\r\n");
      out.write("    <h4>");
      out.print(request.getParameter("id"));
      out.write("</h4>-->\r\n");
      out.write("    ");
 
       /*
        *Url üzerinde mvc parametreleri alınıyor.
        *Örneğin ürün sayfasına gitmek için:
        *http://localhost:8084/jsp-mvc/index.jsp?mvc=/urun-detay-controller/urun-detay-action/urun-id/
        */
       String parametres = request.getParameter("mvc");
       
       //Yönlendirme işlmlerini yapacak ana class çağırılıyor
       app app = new app(parametres);
       File controllerFile = new File("newfile.txt");
       System.out.println(controllerFile.exists());
       String value = "";
         if(controllerFile.exists()){
            value =  "omer";
        } else {
            value =  "faruk";
        }
       //String d = app.run();
       
    
      out.write("\r\n");
      out.write("    <span>");
      out.print(value);
      out.write("</span>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
