<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error page</title>
</head>
<body>
<%
    String msg = request.getParameter("msg");
    out.println(msg);
%>
</body>
</html>
