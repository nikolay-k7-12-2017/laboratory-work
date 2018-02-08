<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>

<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 28.01.2018
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
<p> id klients: ${client1} </p>


<table border="1" >
    <tr>
        <td>
            <form method="post" action="/mainForm">

                <p><b> Enter the planned business: </b></p>
                <p>
                    <textarea name="tasks" cols="50" rows="10"></textarea>

                </p>
                <p>

                    Birthday: <input type="date"   name="birthday" min="rtt"  required />
                    <script>
                        var i = document.createElement("input");
                        i.setAttribute("min","rtt");
                        document.getElementById('rtt').valueAsDate= new Date();
                    </script>

                    <input type="submit" value="read"/>
                </p>
            </form>

        </td>


        <td>
            <div style="overflow: scroll;height: 300px;width: 450px;">
            <p align="center">Plannned cases:</p>
            <p style=”text-align:left;line-height:1;">
                <c:forEach items="${requestScope.massive}" var="contract" >
                <p>
                Дата выполнения: <c:out value="${contract.data_plane}">
                 </p>

                </c:out> Описание: <c:out value="${contract.my_affairs}"> </c:out>


            </c:forEach>
            </p>
            </div>
        </td>

    </tr>
</table>


</body>
</html>
