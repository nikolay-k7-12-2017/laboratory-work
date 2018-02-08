<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 28.01.2018
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserLogin</title>
</head>
<body>

${currentUser.login}
${currentUser.password}

<form method="post" action="/userLogin">
    <input type="text" name="nameInput"/>
    <input type="password" name="ageInput"/>
    <input type="submit" value="ok"/>
</form>

<p> ${client}</p>

<p>
$END$
</p>
</body>
</html>
