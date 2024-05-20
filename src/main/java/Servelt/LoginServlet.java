/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servelt;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("contraseña");

        // Aquí deberías tener algún mecanismo para autenticar al usuario.
        // Por ejemplo, puedes comparar el usuario y la contraseña con una base de datos.
        // Por simplicidad, este ejemplo solo verifica que ambos campos no estén vacíos.

        if(usuario != null && !usuario.isEmpty() && contraseña != null && !contraseña.isEmpty()) {
            // Autenticación exitosa
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            response.sendRedirect("bienvenido.jsp");
        } else {
            // Autenticación fallida
            response.sendRedirect("error.jsp");
        }
        
    }
        
     
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
