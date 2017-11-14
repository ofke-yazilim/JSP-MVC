<%-- 
    Document   : index.jsp
    Created on : 12.Kas.2017, 06:59:34
    Author     : Ömer Faruk KESMEZ
--%>

<%@page import="app.core.view"%>
<%@page import="app.core.app"%>
<%@page import="app.views.index"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="app.controller.defaultController"%>
<%@page import="java.io.File"%>
<%@page import="java.lang.String"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- Aşağıda kullanılacak class yapıları projeye dahil ediliyor --%>
<%@page import="classes.string"%>
<%@page import="classes.numeric"%>
<%@page import="app.core.app"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Mvc Proje Jsp</title>
</head>
<body>
    <!--<h1><%=request.getRequestURL()%></h1>
    <h2><%=request.getServletPath()%></h2>
    <h3><%=request.getRequestURI()%></h3>
    <h4><%=request.getParameter("id")%></h4>-->
    <% 
       /*
        *Url üzerinde mvc parametreleri alınıyor.
        *Örneğin ürün sayfasına gitmek için:
        *http://localhost:8084/jsp-mvc/index.jsp?mvc=/urun-detay-controller/urun-detay-action/urun-id/
        */
       String parametres = request.getParameter("mvc");
       
       //Yönlendirme işlmlerini yapacak ana class çağırılıyor
       app app = new app(parametres);
       app.request = request;//
       app.response = response;
       
       //Uygulama dosya yolumalınıyor
       ServletContext context = request.getServletContext();
       String realpath = context.getRealPath("").replace("\\","/");
       
       //Projeye ait uygulama yolu hazırlanıyor
       realpath = realpath.replace("build/","");
       realpath = realpath.replace("web","");
       realpath = realpath.concat("src/java/app/");
       
       application.setAttribute("Site","KOD5");
       
       //Alınan dosya yolu ana class üzerine tanıtılıyor.
       app.path = realpath;
       String d = app.run();
       //String d = "s";
       
%>
<span><%=d%></span>
    
</body>
</html>
