/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.core;

import app.views.index;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ofke
 */
public class view extends index{
    public HttpServletRequest request;
    public HttpServletResponse response;
    public String str = "boş";
    
    //view yapısı alınarak ekrana yazılacak
    public void render(String page,String params) throws IOException, ServletException{
        index view = new index();
        view._page = page;
        view._str  = this.str;
//        String a = request.getParameter("mvc");
        view.index(request, response);
    }
    
}
