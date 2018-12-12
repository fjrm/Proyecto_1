import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ServletCerrarSession extends HttpServlet {

	private static final long serialVersionUID = 1L; // Sirve para definir un id que será usado por la virtual machine cuando serializa y deserializa

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtener un objeto Print Writer para enviar respuesta

		ejecutar(request, response);
		// super.doPost(request, response);

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtener un objeto Print Writer para enviar respuesta
		
		ejecutar(request, response);
		// super.doGet(request, response);

	}

	private void ejecutar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//RequestDispatcher rd12 = getServletContext().getRequestDispatcher("/ZStop.jsp");	
		HttpSession sesion = request.getSession();
		sesion.invalidate(); // Desconecta la sesión y borra todas las variables del usuario
		
		Cookie[] cookies = request.getCookies(); // Borrar las cookies
		if(cookies!=null)
		for (int i = 0; i < cookies.length; i++) {
			cookies[i].setMaxAge(0); // Establecer setMaxAge en 0 eliminará la cookie. Establecer en -1 lo conservará hasta que se cierre el navegador
		}
			
		//System.out.println("inicio: antes de ---invalidate");
		response.sendRedirect("PaginaFin.html"); // No se puede enviar a la vez el sendRedirect y el RequestDispatcher
		
		}

}
