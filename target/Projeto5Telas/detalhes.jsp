<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="br.com.projeto.dao.ProdutoDAO" %>
<%@ page import="br.com.projeto.model.Produto" %>
<%
    if (session.getAttribute("usuario") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    int id = Integer.parseInt(request.getParameter("id"));
    Produto produto = new ProdutoDAO().buscarPorId(id);

    if (produto == null) {
        response.sendRedirect("produtos.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Detalhes - Projeto 5 Telas</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<nav class="navbar">
    <div class="logo">TechStore</div>
    <div>
        <a href="home.jsp">Home</a>
        <a href="produtos.jsp">Produtos</a>
    </div>
</nav>

<div class="container">
    <div class="card">
        <h1><%= produto.getNome() %></h1>
        <p><%= produto.getDescricao() %></p>

        <h2 class="price">R$ <%= String.format("%.2f", produto.getPreco()) %></h2>

        <p><strong>ID:</strong> <%= produto.getId() %></p>

        <a class="btn" href="produtos.jsp">Voltar para produtos</a>
        <a class="btn" href="home.jsp">Ir para Home</a>
    </div>
</div>

<footer>TechStore - Projeto acadêmico</footer>
</body>
</html>
