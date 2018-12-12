import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerCocheServlet extends HttpServlet {

	private static final long serialVersionUID = 1L; // Sirve para definir un id que ser� usado por la virtual machine cuando serializa y deserializa

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ejecutar(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ejecutar(request, response);
	}

	private void ejecutar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		RequestDispatcher rd3 = getServletContext().getRequestDispatcher("/ModificarCoche.jsp"); 
		
		try {
			
			String isbn = request.getParameter("isbn");
			Class.forName("com.mysql.jdbc.Driver"); //carga
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/japancarmm", "root", ""); // Para crear una conexi�n a la base de datos
			Statement st = conexion.createStatement(); // Se utiliza para crear un objeto que modela a una sentencia SQL. Es un objeto del tipo de una clase que implementa la interfaz Statement, y proveer la infraestructura para ejecutar sentencias SQL sobre una conexi�n con una base de datos
			String sql = "select * from japancarmm.coches where isbn=" + isbn; // Ver el isbn del coche seleccionado 
			System.out.println("sql->" + sql);
  			st.executeQuery(sql); // Ejecuta la instrucci�n SQL determinada, que puede ser una instrucci�n INSERT, UPDATE o DELETE; o una instrucci�n SQL que no devuelve nada, como una instrucci�n DDL de SQL
		
  			rd3.forward(request, response); // Reenviar la informaci�n que hay aqu�

		} catch (Exception e) {
			// Error en alg�n momento
			response.setContentType("text/html"); 
			PrintWriter out5 = response.getWriter();
			out5.println("Excepci�n " + e);
			e.printStackTrace();
		}
		
		System.out.println("ver coche");
	
		}
		

}

