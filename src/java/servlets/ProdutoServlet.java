package servlets;

import dao.ProdutoDAO;
import dao.ProdutoDAOImpl;
import entidades.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "ProdutoServlet", urlPatterns = {"/produto"})
public class ProdutoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Produto p = new Produto();
        ProdutoDAO dao = new ProdutoDAOImpl();
        
        if(request.getParameter("produto") != null){
            int id = Integer.parseInt(request.getParameter("id"));
            double qtde = Double.parseDouble(request.getParameter("quantidade"));
            double valor = Double.parseDouble(request.getParameter("valor"));
            p.setId(id);
            p.setProduto(request.getParameter("produto"));
            p.setQuantidade(qtde);
            p.setValor(valor);
            p.setMarca(request.getParameter("marca"));
            dao.save(p);
        }else if(request.getParameter("excluir") != null){
            
            int id = Integer.parseInt(request.getParameter("excluir"));
            dao.delete(dao.find(id));
        }else if(request.getParameter("editar") != null){
            int id = Integer.parseInt(request.getParameter("editar"));
            p = dao.find(id);
            System.out.println("editando "+ p.getProduto());
            request.setAttribute("produto",p);
        }
            
        request.setAttribute("lista",dao.list());
        
        RequestDispatcher view = request.getRequestDispatcher("produto.jsp");
        view.forward(request, response);

        List<Produto> lista = (List<Produto>) request
                .getSession()
                .getAttribute("lista");

        if (lista == null) {
            lista = new ArrayList<Produto>();
        }
        
        lista.add(p);
        request.getSession().setAttribute("lista", lista);
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
