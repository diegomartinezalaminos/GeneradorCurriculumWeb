/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package generadorcurriculum;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GeneradorCurriculum {

	public static void main(String[] args) {

    //Lectura
		String datosdelcurriculum = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("datoscurriculum.txt"));
			
			String linea = " ";
			
			while(linea != null) {
				linea = br.readLine();
				datosdelcurriculum += linea + "\n";
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Error no se ha encontrado el archivo datoscurriculum.txt");
			
		} catch (IOException e) {
		      System.out.println("Error de lectura. No se puede leer el archivo datoscurriculum.txt");
	  }
		
    //Variables
		//Introducimos los datos del curriculum en variables
    //Dividimos la varible datosdelcurriculum en subcadenas los delimitadores de dichas cadenas son >>>* 
		String[] nombre = datosdelcurriculum.substring(datosdelcurriculum.indexOf(">>>nombre") + 10, datosdelcurriculum.indexOf(">>>telefono")).split("\n");
		String[] telefono = datosdelcurriculum.substring(datosdelcurriculum.indexOf(">>>telefono") + 12, datosdelcurriculum.indexOf(">>>correo")).split("\n");
		String[] correo = datosdelcurriculum.substring(datosdelcurriculum.indexOf(">>>correo") + 10, datosdelcurriculum.indexOf(">>>habilidades")).split("\n");
    String[] habilidades = datosdelcurriculum.substring(datosdelcurriculum.indexOf(">>>habilidades") + 15, datosdelcurriculum.indexOf(">>>formacion")).split("\n");
		String[] formacion = datosdelcurriculum.substring(datosdelcurriculum.indexOf(">>>formacion") + 13, datosdelcurriculum.indexOf(">>>experiencia laboral")).split("\n");
		String[] experiencia = datosdelcurriculum.substring(datosdelcurriculum.indexOf(">>>experiencia laboral") + 22, datosdelcurriculum.indexOf(">>>fin")).split("\n");
				
    //Programa
		try {
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("curriculum.html"));
			
      
			bw.write("<!DOCTYPE html>\n" + 
					"<html>\n" + 
					"<head>\n" + 
          "<link rel=\"stylesheet\" type=\"text/css\" href=\"estilos.css\">\n" +
					"<title>Curriculum</title>\n" + 
					"<meta charset=\"utf-8\" />\n" + 
					"</head>\n" +
					"<body>\n" + 
          "<div>\n" + 
					"<h1>Curriculum</h1>\n" + 
					"<h3>Datos personales</h3>\n" + 
					"<p>" + nombre[0] + "</p>\n" + 
					"<p>" + telefono[0] + "</p>\n" + 
					"<p>" + correo[0] + "</p>\n" +
					"<h3>Habilidades:</h3>\n");

      for (String habilidad : habilidades) {
        bw.write("<p>" + habilidad + "</p>\n");
      }

      bw.write("<h3>Formación Laboral:</h3>\n");
      
			for (String educacion : formacion) {
				bw.write("<p>" + educacion + "</p>\n");
			}
			
			bw.write("<h3>Experiencia Laboral</h3>\n");
			
			for (String experienciatrabajo : experiencia) {
				bw.write("<p>" + experienciatrabajo + "</p>\n");
			}
      
      bw.write("</div>\n");
      bw.write("</body>\n");
			
			bw.close();
			
		} catch(Exception e) {
			System.out.println("Error al escribir");
		}
	}

}