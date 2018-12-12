import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MiSessionListener implements HttpSessionListener {
	Calendar c = null;
	Calendar c2 = null;

	SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
	String fecha_hoy1 = null;
	String fecha_hoy2 = null;

	// double MINUTOS_HORA = 60d;
	// double SEGUNDOS_MINUTO= 60d;
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		c = Calendar.getInstance(); // Obtiene una instancia de un calendario
		String fecha_hoy1 = formateador.format(c.getTime()); // Devuelve una fecha
		System.out.println("MiSessionListener : Fecha de inicio: " + fecha_hoy1);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		
		c2 = Calendar.getInstance();
		String fecha_hoy2 = formateador.format(c2.getTime());
		System.out.println("MiSessionListener : Fecha de cierre : " + fecha_hoy2);
		double diferencia1 = (c2.getTimeInMillis() - c.getTimeInMillis()) / 1000d / 60d / 60d / 24d; // Calcula la diferencia de tiempo entre fechas. 1000ms=1s, 60s=1minuto, 60minutos=1h y 1*24h=1 día.
		double diferencia2 = diferencia1;
		double diferencia3 = (c2.getTimeInMillis() - c.getTimeInMillis()) / 1000d / 60d / 60d; // Calcula la diferencia de tiempo entre fechas. 1000ms=1s, 60s=1minuto y 60minutos=1h.
		double diferencia4 = diferencia3;
		double diferencia5 = (c2.getTimeInMillis() - c.getTimeInMillis()) / 1000d / 60d; // Calcula la diferencia de tiempo entre fechas. 1000ms=1s y 60s=1minuto.
		double diferencia6 = diferencia5;
		double diferencia7 = (c2.getTimeInMillis() - c.getTimeInMillis()) / 1000d; // Calcula la diferencia de tiempo entre fechas. 1000ms=1s.
		double diferencia8 = diferencia7;
		System.out.println("MiSessionListener : ");
		System.out.println("MiSessionListener : La diferencia de tiempo es: " + diferencia2 + " días");
		System.out.println("MiSessionListener : La diferencia de tiempo es: " + diferencia4 + " horas");
		System.out.println("MiSessionListener : La diferencia de tiempo es: " + diferencia6 + " minutos");
		System.out.println("MiSessionListener : La diferencia de tiempo es: " + diferencia8 + " segundos");

		try {
			File ficheroSession = new File("E:/ZZ_J2EE_SQL/J2EE/10_Ap/ficheroSession.txt"); 
			ficheroSession.createNewFile();
			FileWriter z = new FileWriter(ficheroSession, true);
			BufferedWriter bz = new BufferedWriter(z);
			PrintWriter zr = new PrintWriter(bz);
			zr.write(" Fecha exacta de inicio: " + fecha_hoy1 + " / Fecha en formato simple de inicio: " + fecha_hoy1
					+ " / Fecha exacta de cierre: " + " ?? " + " / Fecha en formato simple de cierre: " + fecha_hoy2
					+ " / " + " días: " + diferencia2 + ", horas: " + diferencia4 + ", minutos: " + diferencia6
					+ " y segundos: " + diferencia8 + "\n"); // Escribir en el archivo
			zr.close(); // Ahora cerrar los flujos de canales de datos, al cerrarlos el archivo
			bz.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Fin de sesión");
	}
}
