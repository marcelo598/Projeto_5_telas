package br.com.projeto.servlet;

import br.com.projeto.dao.UsuarioDAO;
import br.com.projeto.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UsuarioDAO dao = new UsuarioDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario usuario = dao.login(email, senha);

        if (usuario != null) {
            request.getSession().setAttribute("usuario", usuario);
            response.sendRedirect(request.getContextPath() + "/home.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp?erro=1");
        }
    }
}
