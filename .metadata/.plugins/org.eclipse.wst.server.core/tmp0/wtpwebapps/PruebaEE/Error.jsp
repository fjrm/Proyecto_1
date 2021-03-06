<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="description" content="Japancar MM, distribuidor oficial de Mazda y Mitsubishi en Barcelona">
	<meta name="keywords" content="Japancar MM, Mazda, Mitsubishi, Barcelona">
	<title>Japancar MM | Error</title>
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<style>
		main{
			color: #DCDCDC;
			font-size: 1.5em;
			text-align: center;
			padding-top: 320px;
      		padding-right: 0px;
      		padding-bottom: 320px;
      		padding-left: 0px;
		}
		
		main>a{
			color: #000000;
		}
		
		main>a:hover{
			color: #191970;
		}
		
		body{
      		/*background-image: url(img/01.jpg);
      		background-repeat: no-repeat;
      		background-position: bottom; 
      		background-size: 125% 100%;*/
      		background-color: #696969; 
      	}
	</style>
</head>
<body>
	<div id="wrapper">
		<header>
			<div class="logo">
				<h1><span>Japancar</span> MM</h1>
				<p>Concesionario Oficial Mazda y Mitsubishi</p>
			</div>
			<nav>
				<ul>
					<li><a href="index.html">Inicio<hr></a></li>
					<li><a href="SobreNosostros.html">Sobre Nosotros<hr></a></li>
					<li><a href="Concesionarios.html">Concesionarios<hr></a></li>
					<li><a href="Contacto.html">Contacto<hr></a></li>
				</ul>
			</nav>
		</header>
		<main>
			ERROR: <%= request.getParameter("user") %> y <%= request.getParameter("password") %> �INCORRECTOS!
		</main>
		<footer>
			<section>
				<div class="menu_footer1">
					<a href="Privacidad.html">Pol�tica de Privacidad</a> &nbsp|&nbsp <a href="Cookies.html">Cookies</a> &nbsp|&nbsp <a href="MapaDelSitio.html">Mapa del sitio</a>
				</div>
				<div class="menu_footer2">
					<a href="https://www.mazda.es/">Web Oficial Mazda</a> &nbsp|&nbsp <a href="https://www.mitsubishi-motors.es">Web Oficial Mitsubishi Motors</a>
				</div>
			</section>
			<div class="linea">
				<p class="copyright">&copy; 2018 Japancar MM, S.L. Todos los derechos reservados</p>
				<div class="redes">
					<p>S�guenos en</p>
					<ul>
						<li>
							<a href="https://es-es.facebook.com/"><img src="img/Facebook.jpg" alt="Facebook"></a>
						</li>
						<li>
							<a href="https://www.instagram.com/?hl=es"><img src="img/Instagram.jpg" alt="Instagram"></a>
						</li>
						<li>
							<a href="https://twitter.com/?lang=es"><img src="img/Twitter.jpg" alt="Twitter"></a>
						</li>
						<li>
							<a href="https://www.youtube.com/?gl=ES&hl=es"><img src="img/Youtube.jpg" alt="Youtube"></a>
						</li>					
					</ul>
				</div>
			</div>
		</footer>
	</div>	
</body>
</html>