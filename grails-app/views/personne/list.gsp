<%--
  Created by IntelliJ IDEA.
  User: franck
  Date: 08/11/14
  Time: 18:41
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>Personne list</title>
</head>

<body>
<h1>Personne list</h1>
<table>
    <g:each in="${personnes}" var="personne">
        <tr><td>${personne.firstName}</td><td>${personne.lastName}</td></tr>
    </g:each>
</table>
<g:link action="create">Create new personne</g:link>
</body>
</html>