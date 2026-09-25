<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="br.com.projeto.dao.ProdutoDAO" %>
<%@ page import="br.com.projeto.model.Produto" %>
<%@ page import="java.util.List" %>
<%
    if (session.getAttribute("usuario") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    ProdutoDAO dao = new ProdutoDAO();
    List<Produto> produtos = dao.listar();
%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Produtos - Projeto 5 Telas</title>
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
    <h1>Produtos</h1>
    <p>Lista carregada do PostgreSQL. Os mesmos dados também estão disponíveis na API REST.</p>

    <div class="grid">
        <% for (Produto p : produtos) { %>
            <div class="card product-card">
                <h3><%= p.getNome() %></h3>
                <p><%= p.getDescricao() %></p>
                <div class="price">R$ <%= String.format("%.2f", p.getPreco()) %></div>
                <br>
                <a class="btn" href="detalhes.jsp?id=<%= p.getId() %>">Ver detalhes</a>
            </div>
        <% } %>
    </div>
</div>

<footer>TechStore - Projeto acadêmico</footer>
</body>
</html>
