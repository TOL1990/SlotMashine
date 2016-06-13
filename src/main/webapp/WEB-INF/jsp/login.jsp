<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Nice to see you again!</title>
</head>
<body>
<style>

    a.button1 {
        -moz-border-radius: 50px;
        -moz-box-shadow: #fff733 0px 0px 48px;
        -moz-transition: all 2s ease;
        -ms-transition: all 2s ease;
        -o-transition: all 2s ease;
        -webkit-border-radius: 50px;
        -webkit-box-shadow: #6E7849 0 0 10px;
        -webkit-transition: all 2s ease;
        background-color: #13d7ec;
        background-image: -moz-linear-gradient(90deg, #080807, #13d7ec);
        background-image: -ms-linear-gradient(90deg, #080807, #13d7ec);
        background-image: -o-linear-gradient(90deg, #080807, #13d7ec);
        background-image: -webkit-linear-gradient(90deg, #080807, #13d7ec);
        background-image: linear-gradient(90deg, #080807, #13d7ec);
        border-radius: 50px;
        border: 2px solid #000000;
        box-shadow: #fff733 0px 0px 48px;
        color: #e22c08;
        display: inline-block;
        font-size: 2.0em;
        margin: auto;
        padding: 10px;
        text-decoration: none;
        text-shadow: #000000 5px 5px 15px;
        transition: all 2s ease;
    }

    a.button1:active {
        top: 1px;
        box-shadow: none;
    }

    a.button1:hover {
        padding: 15px;
    }
</style>

<style>
    body {
        background: url(http://www.euroasiacasino.com/blog/wp-content/uploads/2013/01/shutterstock_88643578.jpg) no-repeat;
        background-size: 100%;
    }
</style>


<form method="registration.post" action="#">
    <p style="text-align: center;"><strong><span style="color:#00ff00"><span style="font-size:30px"><code>Login: <input
            name="login" type="text"/></code></span></span></strong></p>


    <p style="text-align: center;"><strong><span style="color:#00ff00"><span style="font-size:30px"><code>Password:
        <input name="password" type="text"/></code></span></span></strong></p>
</form>

<div style="text-align: center">
    <a href="<c:url value='/mashine/list' />" class="button1">LETS PLAY!</a>
</div>

<div style="text-align: center">
    <a href="<c:url value='/' />" class="button1">Back to Casino</a>
</div>


<%--<div style="position:absolute; left:0px; bottom: 0px;">--%>
<%--<form action="test.form" method="get">--%>
<%--<input type=number name="mashineId">--%>
<%--<input type="submit">--%>
<%--</form>--%>
<%--</div>--%>


</body>
</html>