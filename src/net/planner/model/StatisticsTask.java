package net.planner.model;

public class StatisticsTask {
	private int cantidadTAlto;
	private int cantidadTMedio;
	private int cantidadTBajo;
	
	public StatisticsTask(int cantidadTAlto, int cantidadTMedio, int cantidadTBajo) {
		super();
		this.cantidadTAlto = cantidadTAlto;
		this.cantidadTMedio = cantidadTMedio;
		this.cantidadTBajo = cantidadTBajo;
	}

	public int getCantidadTAlto() {
		return cantidadTAlto;
	}

	public void setCantidadTAlto(int cantidadTAlto) {
		this.cantidadTAlto = cantidadTAlto;
	}

	public int getCantidadTMedio() {
		return cantidadTMedio;
	}

	public void setCantidadTMedio(int cantidadTMedio) {
		this.cantidadTMedio = cantidadTMedio;
	}

	public int getCantidadTBajo() {
		return cantidadTBajo;
	}

	public void setCantidadTBajo(int cantidadTBajo) {
		this.cantidadTBajo = cantidadTBajo;
	}
	
}
