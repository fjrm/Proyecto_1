<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.Arrays" %>
<%@page import="java.util.ArrayList" %>

<%@ page language="java" %>
<%@ page import = "java.sql.Connection"%>
<%@ page import = "java.sql.DriverManager"%> 
<%@ page import = "java.sql.ResultSet"%> 
<%@ page import = "java.sql.Statement"%> 

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h2>Base de datos</h2>
<%
	try
	{
   	// conexión con bd
   		Class.forName("com.mysql.jdbc.Driver");
   		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/japancarmm", "root", "");
   		if (!conexion.isClosed()){
      		// la consulta
      		Statement st = conexion.createStatement();
      		ResultSet rs = st.executeQuery("select * from japancarmm.coches" );

      		// poner los resultados en un table de html
      		out.println("<table border=\"1\"><tr><td>Isbn</td><td>Marca</td><td>Modelo</td><td>Acabado</td><td>Número de puertas</td><td>Tipo de carrocería</td><td>Cambio</td><td>Combustible</td><td>Potencia (CV)</td><td>Consumo medio (l)</td><td>Longitud (mm)</td><td>Anchura (mm)</td><td>Altura (mm)</td><td>Maletero (l)</td><td>Años de garantía</td><td>Precio (euros)</td><td>Editar</td><td>Eliminar</td></tr>");
      		while (rs.next()){
        		out.println("<tr>");
         		out.println("	<td>"+rs.getObject("isbn")+"</td>");
         		out.println("	<td>"+rs.getObject("marca")+"</td>");
        		out.println("	<td>"+rs.getObject("modelo")+"</td>");
        		out.println("	<td>"+rs.getObject("acabado")+"</td>");
        		out.println("	<td>"+rs.getObject("n_de_puertas")+"</td>");
        		out.println("	<td>"+rs.getObject("tipo_de_carroceria")+"</td>");
          		out.println("	<td>"+rs.getObject("cambio")+"</td>");
         		out.println("	<td>"+rs.getObject("combustible")+"</td>");
        		out.println("	<td>"+rs.getObject("potencia_cv")+"</td>");
        		out.println("	<td>"+rs.getObject("consumo_medio_l")+"</td>");
        		out.println("	<td>"+rs.getObject("longitud_mm")+"</td>");
        		out.println("	<td>"+rs.getObject("anchura_mm")+"</td>");
          		out.println("	<td>"+rs.getObject("altura_mm")+"</td>");
         		out.println("	<td>"+rs.getObject("maletero_l")+"</td>");
        		out.println("	<td>"+rs.getObject("garantia_a")+"</td>");
        		out.println("	<td>"+rs.getObject("precio_euros")+"</td>");
        		out.println("	<td><a href='./vercocheservlet?isbn=" + rs.getObject("isbn") + "'/> E </a></td>"); 
        		out.println("	<td><a href='./gestioncochesservletdelete?isbn=" + rs.getObject("isbn") + "'/> X </a></td>");    		    		
          	
        		out.println("</tr>");
         	}
      			out.println("</table>");
      			
      			// cierre de la conexión
     		    conexion.close();
   		}
   			else
      			// error en la conexión
      			out.println("Error");
	}
	catch (Exception e)
		{
   		// error en algún momento
   		out.println("Excepción "+e);
  		e.printStackTrace();
	}
%>	
	<br>
	<a href='./Introducir.html'>Volver a la página anterior</a>
	
</body>
</html>