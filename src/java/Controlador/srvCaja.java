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
import config.GenerarSerie;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 */
@WebServlet(name = "srvCaja", urlPatterns = {"/srvCaja"})
public class srvCaja extends HttpServlet {

    Cliente c = new Cliente();
    ClienteDAO cdao = new ClienteDAO();

    Producto p = new Producto();
    ProductosDAO pdao = new ProductosDAO();

    VentaDAO vdao = new VentaDAO();

    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalpagar;

    String numeroserie;

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

        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        int idEmpleado = usuario.getId();

        if (accion != null) {
            switch (accion) {
                case "BuscarCliente":
                    int dni = Integer.parseInt(request.getParameter("dnicliente"));
                    c.setDni(dni);
                    c = cdao.buscarDni(dni);
                    request.setAttribute("c", c);

                    break;

                case "BuscarProducto":
                    int id = Integer.parseInt(request.getParameter("codigoproducto"));
                    p = pdao.MostrarProductoEditar(id);
                    request.setAttribute("c", c);
                    request.setAttribute("listaVentas", lista);
                    request.setAttribute("producto", p);
                    request.setAttribute("totalpagar", totalpagar);
                    break;

                case "Agregar":
                    totalpagar = 0.0;
                    item = item + 1;
                    cod = p.getIdProd();
                    descripcion = request.getParameter("nombreproducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cant"));
                    subtotal = precio * cant;
                    v = new Venta();
                    v.setItem(item);
                    v.setIdProducto(cod);
                    v.setDescripcionProd(descripcion);
                    v.setPrecioProd(precio);
                    v.setCantProd(cant);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    for (int i = 0; i < lista.size(); i++) {
                        totalpagar = totalpagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("c", c);
                    request.setAttribute("totalpagar", totalpagar);
                    request.setAttribute("listaVentas", lista);
                    break;
                case "Eliminar":
                    int idItem = Integer.parseInt(request.getParameter("idItem"));
                    if (idItem >= 0 && idItem < lista.size()) {
                        lista.remove(idItem);
                        totalpagar = 0.0;
                        for (Venta venta : lista) {
                            totalpagar += venta.getSubtotal();
                        }
                    }
                    request.setAttribute("c", c);
                    request.setAttribute("totalpagar", totalpagar);
                    request.setAttribute("listaVentas", lista);
                    break;
                case "GenerarVenta":
                    //Actualizar el Stock
                    for (int i = 0; i < lista.size(); i++) {
                        Producto pr = new Producto();
                        int cantidad = lista.get(i).getCantProd();
                        int idproducto = lista.get(i).getIdProducto();
                        ProductosDAO pd = new ProductosDAO();
                        pr = pd.buscar(idproducto);
                        int stockAct = pr.getStock() - cantidad;
                        pd.actualizarStock(idproducto, stockAct);
                    }

                    //guardar venta
                    v.setIdClienteVenta(c.getIdCliente());
                    v.setIdEmpleadoVenta(idEmpleado);
                    v.setNumeroserie(numeroserie);
                    v.setTotalventa(totalpagar);
                    vdao.GuardarVenta(v);

                    //guardar detalle venta
                    int idv = Integer.parseInt(vdao.idVentas());
                    for (int i = 0; i < lista.size(); i++) {
                        v = new Venta();
                        v.setIdVenta(idv);
                        v.setIdProducto(lista.get(i).getIdProducto());
                        v.setDescripcionProd(lista.get(i).getDescripcionProd());
                        v.setCantProd(lista.get(i).getCantProd());
                        v.setPrecioProd(lista.get(i).getPrecioProd());
                        v.setSubtotal(lista.get(i).getSubtotal());
                        vdao.GuardarDetallerVenta(v);
                    }
                    break;

                default:
                    v = new Venta();
                    lista = new ArrayList<>();
                    item = 0;
                    totalpagar = 0.0;

                    numeroserie = vdao.GenerarSerie();
                    if (numeroserie == null) {
                        numeroserie = "00000001";
                        request.setAttribute("nserie", numeroserie);
                    } else {
                        try {
                            int incrementar = Integer.parseInt(numeroserie);
                            GenerarSerie gs = new GenerarSerie();
                            numeroserie = gs.NumeroSerie(incrementar);
                            request.setAttribute("nserie", numeroserie);
                        } catch (NumberFormatException e) {
                            request.setAttribute("error", "Error al generar el número de serie.");
                            request.setAttribute("nserie", numeroserie);
                            numeroserie = "00000001"; // Asignar un valor predeterminado en caso de error
                        }
                    }
                    request.setAttribute("nserie", numeroserie);
                    request.getRequestDispatcher("caja.jsp").forward(request, response);
            }
            numeroserie = vdao.GenerarSerie();
            if (numeroserie == null) {
                numeroserie = "00000001";
                request.setAttribute("nserie", numeroserie);
            } else {
                try {
                    int incrementar = Integer.parseInt(numeroserie);
                    GenerarSerie gs = new GenerarSerie();
                    numeroserie = gs.NumeroSerie(incrementar);
                    request.setAttribute("nserie", numeroserie);
                } catch (NumberFormatException e) {
                    request.setAttribute("error", "Error al generar el número de serie.");
                    request.setAttribute("nserie", numeroserie);
                    numeroserie = "00000001"; // Asignar un valor predeterminado en caso de error
                }
            }
            request.setAttribute("nserie", numeroserie);
            request.getRequestDispatcher("caja.jsp").forward(request, response);
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
