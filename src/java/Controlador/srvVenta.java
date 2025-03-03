package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.*;
import Modelo.*;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "srvVenta", urlPatterns = {"/srvVenta"})
public class srvVenta extends HttpServlet {
    
    VentaDAO ventadao = new VentaDAO();
    VentaDAO vdao = new VentaDAO();
    int idVenta;
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
        
        String accion = request.getParameter("accion");
        
        if(accion!=null){
            switch (accion) {
                case "Listar":
                    List listaVentas = ventadao.RecuperarRegistrosVentas();
                    request.setAttribute("listaVentas", listaVentas);
                    request.getRequestDispatcher("ventas.jsp").forward(request, response);
                    break;
                case "eliminar":
                    idVenta = Integer.parseInt(request.getParameter("id"));
                    vdao.EliminarRegistroVenta(idVenta);
                    request.getRequestDispatcher("srvVenta?accion=Listar").forward(request, response);
                    break;
                default:
                    request.getRequestDispatcher("srvVenta?accion=Listar").forward(request, response);
            }
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
