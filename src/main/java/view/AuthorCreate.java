package view;

import entity.Author;
import logic.AuthorLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shariar (Shawn) Emami
 */
@WebServlet(name = "AuthorCreate", urlPatterns = {"/AuthorCreate"})
public class AuthorCreate extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AuthorView</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AuthorView at " + request.getContextPath() + "</h1>");
            out.println("<form method=\"POST\"><table>");
            out.println("<tr>");
            out.printf("<td>First Name: <input type=\"text\" name=\"%s\"></td>",AuthorLogic.FN);
            out.println("</tr>");
            out.println("<tr>");
            out.printf("<td>Last Name: <input type=\"text\" name=\"%s\"></td>",AuthorLogic.LN);
            out.println("</tr>");
            out.println("<tr>");
            out.printf("<td><input type=\"submit\" name=\"%s\"></td>","Submit");
            out.println("</tr>");
            out.println("</table></form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        if(request.getParameter("Submit")!=null){
            AuthorLogic logic = new AuthorLogic();
            Author a = logic.createEntity( request.getParameterMap());
            logic.add(a);
        }
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
