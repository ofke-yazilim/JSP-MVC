<%-- 
    Document   : _index
    Created on : 12.Kas.2017, 20:03:16
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <h1>İlk Sayfa</h1>
    <span><%=request.getAttribute("str")%></span>
</body>
</html>
