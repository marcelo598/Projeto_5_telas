<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="br.com.projeto.model.Usuario" %>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Home - Projeto 5 Telas</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<nav class="navbar">
    <div class="logo">TechStore</div>
    <div>
        <a href="home.jsp">Home</a>
        <a href="produtos.jsp">Produtos</a>
        <a href="login.jsp">Sair</a>
    </div>
</nav>

<div class="container">
    <section class="hero">
        <h1>Olá, <%= usuario.getNome() %>!</h1>
        <p>Bem-vindo ao sistema acadêmico desenvolvido em Java Web.</p>
        <p>Esta tela está conectada ao login e ao banco de dados.</p>
        <a class="btn btn-light" href="produtos.jsp">Ver produtos</a>
    </section>

    <br><br>

    <div class="grid">
        <div class="card">
            <h2>Java</h2>
            <p>Aplicação desenvolvida com Java 17 e Servlets.</p>
        </div>
        <div class="card">
            <h2>REST</h2>
            <p>Os produtos são disponibilizados por uma API REST.</p>
        </div>
        <div class="card">
            <h2>PostgreSQL</h2>
            <p>Usuários e produtos são armazenados no banco.</p>
        </div>
    </div>
</div>

<footer>TechStore - Projeto acadêmico</footer>
</body>
</html>
