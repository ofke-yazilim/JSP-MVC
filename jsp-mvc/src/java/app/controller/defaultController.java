/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.controller;

import app.core.controller;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ofke
 */
public class defaultController extends app.core.controller{//Ana controller class dahil ediliyor.
    public HttpServletRequest request;
    public HttpServletResponse response;
    
    //İndex sayfamıza ait aksiyonumuzu yapacaklarımızı gerçekliyoruz
    public void indexAction(String params,HttpServletResponse response,HttpServletRequest request) throws IOException, ServletException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException{
        //Model sınıfı sınıfı yükleniyor
        Class loadClass = Class.forName("app.model.index");
        //Yüklenen sınıf objesi çağrılıyor
        Object useClass = loadClass.newInstance(); 
            
        String methodName = "";
        methodName = "index";
        //Kullanılacak method tanıtılıyor
        Method setNameMethod = useClass.getClass().getMethod(methodName, String.class);
        //Model verileri alınıyor
        String value = (String) setNameMethod.invoke(useClass,params);//Aksiyon methodumuz çalıştırılıyor
        
        controller controller = new controller();//Ana controller fonksiyonları objeye atanıyor
        controller.str = value;
        controller.request = request;
        controller.response = response;
        controller.render("index",params);//controller sayfası rende çağrılarak view bilgileri çağrılıyor.
        //return true;
    }
}
