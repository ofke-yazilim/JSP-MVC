/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.views;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ofke
 */
public class index extends HttpServlet{
    public String _page = null;
    public String _str = null;
    public void index(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException 
    {
        request.setAttribute("str",_str);
        request.getRequestDispatcher("views/"+_page+".jsp").forward(request, response); 
    }  
}
