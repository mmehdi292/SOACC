<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/style.css" rel="stylesheet"/>
<title>Login | Garde System</title>
</head>
<body>

<div class="login-page">
  <div class="form">
    <form class="login-form" action="LoginServlet" method="POST">
      <input type="text" placeholder="username" name="username"/>
      <input type="password" placeholder="password" name="password"/>
      <button>login</button>
      <c:if test = "${not empty error}">
         <c:out value="${error}"></c:out>
      </c:if>
    </form>
  </div>
</div>



</body>
</html>