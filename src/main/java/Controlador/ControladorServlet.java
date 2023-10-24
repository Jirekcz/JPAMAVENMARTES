package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassCrudAutoImp;
import model.TblAuto;
import java.util.List;

/**
 * Servlet implementation class ControladorServlet
 */
public class ControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("/GestionAuto.jsp").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recuperamos los valores del formulario que ingresa el usuario final
		String color = request.getParameter("color");
		String modelo = request.getParameter("modelo");
		String motor = request.getParameter("motor");
		double precio = Double.parseDouble(request.getParameter("precio"));
		String marca = request.getParameter("marca");
		String fabri = request.getParameter("fabri");
		// Instanciamos la clase
		TblAuto tblauto = new TblAuto();
		ClassCrudAutoImp crud = new ClassCrudAutoImp();
		// Asignamos los respectivos valores
		tblauto.setColor(color);
		tblauto.setModelo(modelo);
		tblauto.setMotor(motor);
		tblauto.setPrecio(precio);
		tblauto.setMarca(marca);
		tblauto.setFabricacion(fabri);
		// Invocamos al metodo registrar
		crud.RegistrarAuto(tblauto);
		// Recuperamos el listado de autos
		List<TblAuto> listadoauto = crud.ListadoAuto();
		// Enviamos a la vista
		request.setAttribute("listado", listadoauto);
		// Redireccionamos
		request.getRequestDispatcher("/GestionAuto.jsp").forward(request, response);
	}

}
