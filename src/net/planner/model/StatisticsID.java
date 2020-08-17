package net.planner.model;

public class StatisticsID {
	private int cantidadIdAlto;
	private int cantidadIdMedio;
	private int cantidadIdBajo;
	public StatisticsID(int cantidadIdAlto, int cantidadIdMedio, int cantidadIdBajo) {
		super();
		this.cantidadIdAlto = cantidadIdAlto;
		this.cantidadIdMedio = cantidadIdMedio;
		this.cantidadIdBajo = cantidadIdBajo;
	}
	
	public int getCantidadIdAlto() {
		return cantidadIdAlto;
	}
	public void setCantidadIdAlto(int cantidadIdAlto) {
		this.cantidadIdAlto = cantidadIdAlto;
	}
	public int getCantidadIdMedio() {
		return cantidadIdMedio;
	}
	public void setCantidadIdMedio(int cantidadIdMedio) {
		this.cantidadIdMedio = cantidadIdMedio;
	}
	public int getCantidadIdBajo() {
		return cantidadIdBajo;
	}
	public void setCantidadIdBajo(int cantidadIdBajo) {
		this.cantidadIdBajo = cantidadIdBajo;
	}

}
