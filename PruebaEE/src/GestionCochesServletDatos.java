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

public class GestionCochesServletDatos extends HttpServlet {

	private static final long serialVersionUID = 1L; // Sirve para definir un id que será usado por la virtual machine cuando serializa y deserializa

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ejecutar(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ejecutar(request, response);
	}

	private void ejecutar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String user = request.getParameter("user"); // Devuelve el valor de un parámetro de solicitud como una cadena o nulo si el parámetro no existe
		String password = request.getParameter("password"); // Devuelve el valor de un parámetro de solicitud como una cadena o nulo si el parámetro no existe
		PrintWriter out = response.getWriter(); // response.getWriter() Devuelve un objeto PrintWriter que puede enviar texto de caracteres al cliente
		
		if (user.equals("administrador") && password.equals("f888999h")) { // Si se cumple esta condición
			response.setContentType("text/html"); // Mostrar por web (no por console)
			PrintWriter out1 = response.getWriter(); // Mostrar por web (no por console)
			out1.println("Bienvenido/a " + "<br/>" + "<br/>"); // Mostrar texto
		}
		
		else {
			response.sendRedirect("ErrorUsuario.html");
		}
		
		try {
			String isbn = request.getParameter("isbn");
			String marca = request.getParameter("marca");
			String modelo = request.getParameter("modelo");
			String acabado = request.getParameter("acabado");
			String n_de_puertas = request.getParameter("n_de_puertas");
			String tipo_de_carroceria = request.getParameter("tipo_de_carroceria");
			String cambio = request.getParameter("cambio");
			String combustible = request.getParameter("combustible");
			String potencia_cv = request.getParameter("potencia_cv");
			String consumo_medio_l = request.getParameter("consumo_medio_l");
			String longitud_mm = request.getParameter("longitud_mm");
			String anchura_mm = request.getParameter("anchura_mm");
			String altura_mm = request.getParameter("altura_mm");
			String maletero_l = request.getParameter("maletero_l");
			String garantia_a = request.getParameter("garantia_a");
			String precio_euros = request.getParameter("precio_euros");
			
			Class.forName("com.mysql.jdbc.Driver"); // Carga
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/japancarmm", "root", ""); // Para crear una conexión a la base de datos
			Statement st = conexion.createStatement(); // Se utiliza para crear un objeto que modela a una sentencia SQL. Es un objeto del tipo de una clase que implementa la interfaz Statement, y proveer la infraestructura para ejecutar sentencias SQL sobre una conexión con una base de datos
			String sql = "INSERT INTO japancarmm.coches (isbn, marca, modelo, acabado, n_de_puertas, tipo_de_carroceria, cambio, combustible, potencia_cv, consumo_medio_l, longitud_mm, anchura_mm, altura_mm, maletero_l, garantia_a, precio_euros) values (" + isbn + ",'" + marca + "','" + modelo + "','" + acabado + "'," + n_de_puertas + ",'" + tipo_de_carroceria + "','" + cambio + "','" + combustible + "','" + potencia_cv + "','" + consumo_medio_l + "','" + longitud_mm + "','" + anchura_mm + "','" + altura_mm + "','" + maletero_l + "','" + garantia_a + "','" + precio_euros + "');"; // insertar datos
			System.out.println("sql->" + sql);
			st.executeUpdate(sql); // Ejecuta la instrucción SQL determinada, que puede ser una instrucción INSERT, UPDATE o DELETE; o una instrucción SQL que no devuelve nada, como una instrucción DDL de SQL
			
			RequestDispatcher rd2 = getServletContext().getRequestDispatcher("/GestionCoches.jsp");
			rd2.forward(request, response);

		} catch (Exception e) {
			// Error en algún momento
			response.setContentType("text/html"); // Mostrar por web (no por console)
			PrintWriter out5 = response.getWriter();
			out5.println("Excepción " + e);
			e.printStackTrace();
		}
		
		System.out.println("insert");
		
		}
		

}
