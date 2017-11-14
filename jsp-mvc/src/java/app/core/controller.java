/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.core;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ofke
 */
public class controller extends view{
    public HttpServletRequest request;
    public HttpServletResponse response;
    public String str = "boş";
    
    //View sayfları yükleniyor.
    /**
     *
     * @param page
     * @param params
    */
    public void render(String page,String params) throws IOException, ServletException{
        view view = new view();
        view.str = this.str;
        view.request = this.request;
        view.response = this.response;
        view.render(page,params);
    }
}
