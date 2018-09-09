<jsp:useBean id="user" scope="request" type="com.sunxu.domain.User"/>
<%--
  User: 孙许
  Date: 2018/09/09
  Time: 0:17
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    ${user.realName}<br/>
    ${user.userId}<br/>
    ${user.userName}<br/>
    ${user.birthday}<br/>
    ${user.salary}
</body>
</html>
