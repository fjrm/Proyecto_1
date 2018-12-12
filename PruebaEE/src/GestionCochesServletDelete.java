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

public class GestionCochesServletDelete extends HttpServlet {

	private static final long serialVersionUID = 1L; // Sirve para definir un id que será usado por la virtual machine cuando serializa y deserializa

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ejecutar(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ejecutar(request, response);
	}

	private void ejecutar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.sendRedirect("Eliminar.html");
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver"); // Carga
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/japancarmm", "root", ""); // Para crear una conexión a la base de datos
			Statement st = conexion.createStatement(); // Se utiliza para crear un objeto que modela a una sentencia SQL. Es un objeto del tipo de una clase que implementa la interfaz Statement, y proveer la infraestructura para ejecutar sentencias SQL sobre una conexión con una base de datos
  			String sql = "DELETE FROM coches WHERE isbn='" + (request.getParameter("isbn") + "'"); // Eliminar objeto
			System.out.println("sql->" + sql);
			st.executeUpdate(sql); // Ejecuta la instrucción SQL determinada, que puede ser una instrucción INSERT, UPDATE o DELETE; o una instrucción SQL que no devuelve nada, como una instrucción DDL de SQL
			
			RequestDispatcher rd2 = getServletContext().getRequestDispatcher("/GestionCoches.jsp");
			rd2.forward(request, response);

		} catch (Exception e) {
			// Error en algún momento
			response.setContentType("text/html"); 
			PrintWriter out5 = response.getWriter();
			out5.println("Excepción " + e);
			e.printStackTrace();
		}
		
		System.out.println("delete");
		
		}
		

}
