<%--
  Created by IntelliJ IDEA.
  User: luyfe
  Date: 25/01/2025
  Time: 10:59
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Lista de Usuários</title>
</head>
<body>
<h1>Lista de Usuários</h1>

<table border="1">
  <thead>
  <tr>
    <th>Nome</th>
    <th>Email</th>
    <th>Senha</th>
    <th>Banco de Dados</th>  <!-- Coluna para o banco de dados -->
  </tr>
  </thead>
  <tbody>
  <g:each in="${usuarios}" var="usuarioInfo">
    <tr>
      <td>${usuarioInfo.user.nome}</td>
      <td>${usuarioInfo.user.email}</td>
      <td>${usuarioInfo.user.senha}</td>
      <td>${usuarioInfo.datasource}</td>  <!-- Exibe o banco de dados -->
    </tr>
  </g:each>
  </tbody>
</table>
</body>
</html>
