<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.Arrays" %>
<%@page import="java.util.ArrayList" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	Editar coche 
	<br/>
	<br/>
	<form name="formulario" action= "/PruebaEE/actualizarcochesservlet" method="post">	
	<input type="text" name="isbn" value ="<%=request.getParameter("isbn")%>" readonly="readonly"/>  
	Isbn<br/>
	<input type="text" name="marca"/>
    Marca<br/>
    <input type="text" name="modelo"/>
	Modelo<br/>  
	<input type="text" name="acabado"/> 
	Acabado<br/>
	<input type="text" name="n_de_puertas"/>
    Número de puertas<br/>
    <input type="text" name="tipo_de_carroceria"/>
	Tipo de carrocería<br/>
	<input type="text" name="cambio"/>
    Cambio<br/>
    <input type="text" name="combustible"/>
	Combustible<br/>  
	<input type="text" name="potencia_cv"/> 
	Potencia (CV)<br/>
	<input type="text" name="consumo_medio_l"/>
    Consumo medio (l)<br/>
    <input type="text" name="longitud_mm"/>
	Longitud (mm)<br/>
	<input type="text" name="anchura_mm"/>
    Anchura (mm)<br/>
    <input type="text" name="altura_mm"/>
	Altura (mm)<br/>  
	<input type="text" name="maletero_l"/> 
	Maletero (l)<br/>
	<input type="text" name="garantia_a"/>
    Años de garantía<br/>
    <input type="text" name="precio_euros"/>
	Precio (euros)<br/>
	<br/>	
	<br/>	
	<input type="submit" name="aceptar" value="Aceptar"/>
	<br/>
	<br/>
    <a href='./GestionCoches.jsp'> Cancelar </a> 
	</form> 
	
</body>
</html>