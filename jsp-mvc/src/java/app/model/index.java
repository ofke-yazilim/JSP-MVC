/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.model;

import classes.mysql;
import app.core.controller;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;

/**
 *
 * @author ofke
 */
public class index extends classes.mysql{
    public Connection connection = null;
    //Mysql sınıfı nesne larak yükleniyor
    mysql mysql = new mysql();
    controller c = new controller();
    
    public index(){
        //Mysql bağlantısı sağlanıyor
        this.connection = mysql.mysqlConnect();
    }
    
    //İndex sayfasında bulunan sql sorgularını içeririr
    public String index(String params) throws SQLException{
        String[][] result = new String[1][2];
//        result[0][0] = "omer";
        result = this.mysql.mysqlSelect("name,surname","`tt-member`","id=1","order by id desc",1,1);
        return result[0][0];
    }
}
