/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.core;

import app.controller.*;//controller içerisindeki tüm class yapılarını import ettim
import classes.string;
import java.io.File;
import java.io.IOException;
import static java.lang.System.out;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static java.time.Clock.system;
import static javafx.application.Platform.exit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.jasper.runtime.JspRuntimeLibrary;

/**
 *
 * @author ofke
 */
public class app extends classes.string{//String fonksiyonları kullanabilmek için string class yapısı entegre edliyor.
    public String _controller = null;//Sayfa için çalışcak olan controller dosyasını temsil eder
    public String _action = null;//
    public int paramsCount = 0;
    public String params;
    public String path = null;
    public HttpServletRequest request;
    public HttpServletResponse response;
    
    //Yapıcı class siteme dahil edildiğinde ilk çalışan
    /*
     * Url yapısında bölünen paremetre bilgilerini alır
     */
    public app(String parametres){
       //Kullanılmak üzere String sınıfımız projeye dahil ediliyor.
       string str = new string();
       int length = 0;
       //Url eğer parametre get ifade içeriyorsa
       if(parametres!=null && !"null".equals(parametres) && !"".equals(parametres)){
           //yukarıda aldığımız ur yapısı string sınıfımıza tanıtılıyor
           str.setString(parametres);
           
           //alınan url bilgisine ait uzunluk değeri alınıyor çünkü eğer 0 ise anasayfa üzerindeyiz
           length = str.getLength();
       } else{
           parametres = "";
           
           //yukarıda tanıttığımız url yapısı string sınıfımıza tanıtılıyor
           str.setString(parametres);
           
           //alınan url bilgisine ait uzunluk değeri alınıyor çünkü eğer 0 ise anasayfa üzerindeyiz
           length = str.getLength();
       }
       
       //String sınıfına tanıtılan ur yapımız / değerine uygun olarak bölünerek array içerisine alınıyor.
       if(length==0){
           this._controller = "defaultController"; //controller dosyasının adı belirleniyor
           this._action = "indexAction"; //Controller işlemleri için kullanılacak fonksiyon
           this.params = "";
       } else{
           String[] result;
           result = str.getSplit("/");
           
           this._controller = result[0];
           this._action = result[1];
           
           //parametrelere ait uzunluklar alınıyor
           this.paramsCount = result.length-2;
           
           //Parametre değerleri array içerisine atılıyor
           for(int i=2;i<result.length;i++){
               this.params = this.params.concat(result[i]+"/");
           }
       }
    }
    
    //Url yapılarımız tanıtıldıktan sonra sıra yönlendirme iişlemlerinin yapılmasına geldi.
    public String run() throws IOException, ServletException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException{
        //Controller dosyasının yolu belirtiliyor.
        File controllerFile = new File(this.path+"controller/"+this._controller+".java"); 
        String value = null;
       
        //Eğer controller class yapımız mevcut ise 
        if(controllerFile.exists()){
            //Controller sınıfı yükleniyor
            Class loadClass = Class.forName("app.controller."+this._controller);
            //Yüklenen sınıf objesi çağrılıyor
            Object useClass = loadClass.newInstance(); 

            String methodName = "";
            methodName =  this._action;
            //Kullanılacak method tanıtılıyor
            Method setNameMethod = useClass.getClass().getMethod(methodName, String.class,HttpServletResponse.class,HttpServletRequest.class);
            value = (String) setNameMethod.invoke(useClass,this.params,this.response,this.request);//Aksiyon methodumuz çalıştırılıyor
        } else {
            
        }
        return value;
    }

}
