package com.carlosb.chuletillas;

/**
 * @author Carlos Belmonte Ceniza
 * Chuletillas App for Android
 */

import java.io.Serializable;

public class Chuleta implements Serializable {
	
	private String path;
	private String nombreFcihero;
	private String titulo;
	private String contenido;
	
	public Chuleta(String path, String nombreFcihero, String titulo,
			String contenido) {
		this.path = path;
		this.nombreFcihero = nombreFcihero;
		this.titulo = titulo;
		this.contenido = contenido;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getNombreFcihero() {
		return nombreFcihero;
	}
	public void setNombreFcihero(String nombreFcihero) {
		this.nombreFcihero = nombreFcihero;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	@Override
	public String toString() {
		return "Chuleta [path=" + path + ", nombreFcihero=" + nombreFcihero
				+ ", titulo=" + titulo + ", contenido=" + contenido + "]";
	}
	
	

}
