import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class GestionErrorServlet extends HttpServlet {

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
		
		RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/Error.jsp"); // Para intercambiar información entre servlets. Objeto dentro de cada servlet. Sitio dónde redirigir la ejecución de la aplicación		 
		
		try {
			rd1.forward(request, response); // Reenviar la información que hay aquí al otro servlet		
		} 
		
		catch (ServletException e) { // TODO Auto-generated catch block	
			response.setContentType("text/html"); 
			PrintWriter out5 = response.getWriter(); // Mostrar por web (no por console)
			out5.println("¡Acceso denegado!: " + "Introduzca un usuario y/o contraseña correctos" + e.getMessage());
			//System.out.println("¡Acceso denegado!: " + "Introduzca un usuario y/o contraseña correctos" + e.getMessage());  // ÚNICAMENTE OPERATIVO SI EL USUARIO Y LA CONTRASEÑA ESTÁN VISIBLES
			e.printStackTrace();
		} 
		
	}

}
