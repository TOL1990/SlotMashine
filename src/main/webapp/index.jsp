<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hello, money bag!</title>
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

<%--<a href="<c:url value='/new' />">--%>

<h1 style="text-align:center"><span style="color:#FF0000"><kbd><span style="font-family:tahoma,geneva,sans-serif"><span style="font-size:36px">WELCOME TO THE CASINO!</span></span></kbd></span></h1>

<p>&nbsp;</p>

<h2 style="text-align: center;"><big><span style="font-size:48px"><span style="color:#ccff00">Machine of The Future!</span></span></big></h2>

<div style="text-align: center">
    <a href="<c:url value='/login' />", methods="GET" class="button1">LOGIN</a>
</div>
<div style="text-align: center">
    <a href="<c:url value='new' />" class="button1">Registration</a>
</div>
<div style="text-align: center">
    <a href="<c:url value='/mashine/list' />" class="button1">Available Machines</a>
</div>

<style>
    body {
        background: url(http://static.deathandtaxesmag.com/uploads/2014/10/man-saved-jail-slot-machine-jackpot-640x411.png) no-repeat;
        background-size: 100%;
    }
</style>



</body>
</html>
