<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Say your name!</title>
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
    background: url(http://themarchonwashingtondc.com/wp-content/uploads/2013/01/How-to-win-at-slots-and-video-poker.jpg) no-repeat;
    background-size: 100%;
  }
</style>


<form method="post" action="#">
  <p style="text-align: center;"><strong><span style="color:#3300ff"><span style="font-size:28px"><code>Login: <input name="login" type="text" /></code></strong></span></span></p>

  <p style="text-align: center;"><strong><span style="color:#3300ff"><span style="font-size:28px"><code>NickName: <input name="nickname" type="text" /></code></strong></span></span></p>

  <p style="text-align: center;"><strong><span style="color:#3300ff"><span style="font-size:28px"><code>Password: <input name="password" type="text" /></code></strong></span></span></p>

  <p style="text-align: center;"><strong><span style="color:#3300ff"><span style="font-size:28px"><code>Confirm password: <input name="confirm password" type="text" /></code></strong></span></span></p>
</form>

<div style="text-align: center">
  <a href="<c:url value='/mashine/list' />" class="button1">LETS PLAY!</a>
</div>

<div style="text-align: center">
  <a href="<c:url value='/' />" class="button1">Back to Casino</a>
</div>

<div style="text-align: center">
  <a href="<c:url value='/login' />", methods="GET" class="button1">Already Registered</a>
</div>



</body>
</html>