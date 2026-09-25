<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Login - Projeto 5 Telas</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">
    <div class="card form-card">
        <h1>Bem-vindo</h1>
        <p>Entre no sistema para continuar.</p>

        <% if ("1".equals(request.getParameter("erro"))) { %>
            <div class="alert">E-mail ou senha inválidos.</div>
        <% } %>

        <% if ("ok".equals(request.getParameter("cadastro"))) { %>
            <div class="success">Cadastro realizado! Agora faça login.</div>
        <% } %>

        <form action="login" method="post">
            <label>E-mail</label>
            <input type="email" name="email" required>

            <label>Senha</label>
            <input type="password" name="senha" required>

            <button class="btn" type="submit">Entrar</button>
        </form>

        <p>Não possui conta?</p>
        <a class="btn" href="cadastro.jsp">Criar cadastro</a>
    </div>
</div>

<footer>Projeto acadêmico - Java Web</footer>
</body>
</html>
