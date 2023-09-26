<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>

<%
    String user = null;
    String sessionUser = String.valueOf(session.getAttribute("username"));
    if (sessionUser == null) {
        response.sendRedirect("login.html");
    } else {
        user = sessionUser;
    }

    String cookieUser = null;
    String sessionId = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie: cookies) {
            if ("username".equalsIgnoreCase(cookie.getName())){
                cookieUser = cookie.getValue();
            } else if ("jsessionid".equalsIgnoreCase(cookie.getName())) {
                sessionId = cookie.getValue();
            }
        }
    } else {
        sessionId = session.getId();
    }

%>

<h3>
    Hello, <%=user%>! Login successful
    <br>
    Session ID = <%=sessionId%>
    <br>
    Cookie username = <%=cookieUser%>
    <br>
</h3>

</body>
</html>