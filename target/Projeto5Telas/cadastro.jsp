<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Cadastro - Projeto 5 Telas</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">
    <div class="card form-card">
        <h1>Criar conta</h1>
        <p>Preencha seus dados para acessar o sistema.</p>

        <% if ("1".equals(request.getParameter("erro"))) { %>
            <div class="alert">Não foi possível realizar o cadastro. Verifique se o e-mail já está cadastrado.</div>
        <% } %>

        <form action="cadastro" method="post">
            <label>Nome</label>
            <input type="text" name="nome" required>

            <label>E-mail</label>
            <input type="email" name="email" required>

            <label>Senha</label>
            <input type="password" name="senha" required>

            <button class="btn" type="submit">Cadastrar</button>
        </form>

        <p><a href="login.jsp">Voltar para o login</a></p>
    </div>
</div>

<footer>Projeto acadêmico - Java Web</footer>
</body>
</html>
