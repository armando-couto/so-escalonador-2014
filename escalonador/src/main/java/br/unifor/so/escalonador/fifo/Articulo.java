package br.unifor.so.escalonador.fifo;

import java.text.DecimalFormat;

public class Articulo {
	
	private String nombre;
	private double precio;
	private int    cantidad;
	private double descuento;
	
	public Articulo(String nombre, double precio, int cantidad) {
		
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.descuento =0;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setDescuento(double descuento) {
		if(descuento > 0) {
			this.descuento = descuento;
		}
	}
	
	public double getDescuento() {
		return this.descuento;
	}
	
	public double getDescuentoMonetario() {
		if(descuento > 0) {
			double total = this.precio * this.cantidad;
			double descuento = total * this.descuento;
			return descuento;
		}
		return 0;
	}
	
	public double getTotalAjustado() {
		return (this.precio * this.cantidad) - getDescuentoMonetario();
	}
	
	public String getTotalString() {
		DecimalFormat df = new DecimalFormat("###,###,###");		
		return "$" + df.format(getTotalAjustado());
	}
	
}
