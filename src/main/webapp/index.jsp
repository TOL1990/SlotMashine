<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>Adios bablos</title>
</head>
<body>
<p align="right"><font color="#B22222"><input name="btn_login" type="button" value="Войти"></font>&nbsp;
    <a href="<c:url value='/new' />">
        <input name="btn_registrarion" type="button" value="Зарегаться!" formtarget="/registration">
    </a>
    <a href="avaliableBets">
        <input name="btn_registrarion" type="button" value="Зарегаться!" formtarget="/registration">
    </a>
</p>

<h1 style="text-align: center;"><var><b>Добро пожаловать в казино!</b></var></h1>

<p>&nbsp;</p>

<h1 style="text-align: center;"><font color="#B22222">ADIOS&#39;BABLOS</font></h1>
<p align="center">
    <font color="#B22222">
        <img alt="" height="289" src="http://avtomaty-igrovye.info/assets/images/blog/casino/casino-nout.jpg" width="378">
    </font>
</p>
<form action="test.form" method="get">
    <input type=number name="mashineId">
    <input type="submit">
</form>

</body>
</html>
