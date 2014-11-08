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
    <title>Personne creation</title>
</head>

<body>
<h1>Personne creation</h1>
<g:hasErrors bean="${personne}">
    <div class="errors">
        <g:renderErrors bean="${personne}" />
    </div>
</g:hasErrors>
<g:form method="POST" action="create">
    <table>
        <tr><td>FirstName</td><td> <g:textField name="firstName"/></td></tr>
        <tr><td>LastName</td><td> <g:textField name="lastName"/></td></tr>
        <tr><td>Address</td><td> <g:textField name="address"/></td></tr>
        <tr><td>&nbsp;</td><td> <g:submitButton name="submit"/></td></tr>
    </table>

</g:form>

</body>
</html>