package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.*;
import Modelo.Cliente;
import java.util.List;

@WebServlet(name = "srvCliente", urlPatterns = {"/srvCliente"})
public class srvCliente extends HttpServlet {

    int idCliente;
    ClienteDAO clientedao = new ClienteDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente();
        
        if (accion != null) {
            switch (accion) {
                case "Listar":
                    List lista = clientedao.obtenerTodosLosClientes();
                    request.setAttribute("listaClientes", lista);
                    request.getRequestDispatcher("clientes.jsp").forward(request, response);
                    break;
                    
                case "agregar":
                    int dni = Integer.parseInt(request.getParameter("dni"));
                    String nombre = request.getParameter("nombre");
                    String apellido = request.getParameter("apellido");
                    int telefono = Integer.parseInt(request.getParameter("telefono"));
                    String correo = request.getParameter("correo");
                    cliente.setIdCliente(dni);
                    cliente.setNombre(nombre);
                    cliente.setApellido(apellido);
                    cliente.setTelefono(telefono);
                    cliente.setCorreo(correo);
                    clienteDAO.agregarCliente(cliente);
                    request.getRequestDispatcher("srvCliente?accion=Listar").forward(request, response);
                    break;
                    
                case "editar":
                    idCliente = Integer.parseInt(request.getParameter("id"));
                    Cliente clienteid = clienteDAO.obtenerCliente(idCliente);
                    request.setAttribute("clienteSeleccionado", clienteid);
                    request.getRequestDispatcher("srvCliente?accion=Listar").forward(request, response);
                    break;
                
                case "actualizar":
                    int dniUpdate = Integer.parseInt(request.getParameter("dni"));
                    String nombreUpdate = request.getParameter("nombre");
                    String apellidoUpdate = request.getParameter("apellido");
                    int telefonoUpdate = Integer.parseInt(request.getParameter("telefono"));
                    String correoUpdate = request.getParameter("correo");
                    cliente.setDni(dniUpdate);
                    cliente.setNombre(nombreUpdate);
                    cliente.setApellido(apellidoUpdate);
                    cliente.setTelefono(telefonoUpdate);
                    cliente.setCorreo(correoUpdate);
                    cliente.setIdCliente(idCliente);
                    clienteDAO.actualizarCliente(cliente);
                    request.getRequestDispatcher("srvCliente?accion=Listar").forward(request, response);
                    break;
                
                case "eliminar":
                    idCliente = Integer.parseInt(request.getParameter("id"));
                    clienteDAO.eliminarCliente(idCliente);
                    request.getRequestDispatcher("srvCliente?accion=Listar").forward(request, response);
                    break;

                default:
                    request.getRequestDispatcher("srvCliente?accion=Listar").forward(request, response);
            }
            
        } else {
            response.sendRedirect("clientes.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}


