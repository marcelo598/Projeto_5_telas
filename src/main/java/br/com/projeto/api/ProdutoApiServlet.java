package br.com.projeto.api;

import br.com.projeto.dao.ProdutoDAO;
import br.com.projeto.model.Produto;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/api/produtos")
public class ProdutoApiServlet extends HttpServlet {

    private final ProdutoDAO dao = new ProdutoDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String idParam = request.getParameter("id");

        if (idParam != null) {
            try {
                int id = Integer.parseInt(idParam);
                Produto p = dao.buscarPorId(id);

                if (p == null) {
                    response.setStatus(404);
                    response.getWriter().write("{\"erro\":\"Produto não encontrado\"}");
                    return;
                }

                response.getWriter().write(produtoJson(p));
                return;

            } catch (NumberFormatException e) {
                response.setStatus(400);
                response.getWriter().write("{\"erro\":\"ID inválido\"}");
                return;
            }
        }

        List<Produto> produtos = dao.listar();
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < produtos.size(); i++) {
            if (i > 0) json.append(",");
            json.append(produtoJson(produtos.get(i)));
        }
        json.append("]");

        response.getWriter().write(json.toString());
    }

    private String produtoJson(Produto p) {
        return String.format(
                "{\"id\":%d,\"nome\":\"%s\",\"descricao\":\"%s\",\"preco\":%.2f}",
                p.getId(),
                escape(p.getNome()),
                escape(p.getDescricao()),
                p.getPreco()
        );
    }

    private String escape(String valor) {
        return valor.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
