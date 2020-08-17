package net.planner.model;

public class StatisticsFav {
	private int cantidadFLibro;
	private int cantidadFPelicula;
	private int cantidadFLugar;
	private int cantidadFRestaurante;
	private int cantidadFSerie;
	private int cantidadFRopa;
	public StatisticsFav(int cantidadFLibro, int cantidadFPelicula, int cantidadFLugar, int cantidadFRestaurante,
			int cantidadFSerie, int cantidadFRopa) {
		super();
		this.cantidadFLibro = cantidadFLibro;
		this.cantidadFPelicula = cantidadFPelicula;
		this.cantidadFLugar = cantidadFLugar;
		this.cantidadFRestaurante = cantidadFRestaurante;
		this.cantidadFSerie = cantidadFSerie;
		this.cantidadFRopa = cantidadFRopa;
	}
	
	public int getCantidadFLibro() {
		return cantidadFLibro;
	}
	public void setCantidadFLibro(int cantidadFLibro) {
		this.cantidadFLibro = cantidadFLibro;
	}
	public int getCantidadFPelicula() {
		return cantidadFPelicula;
	}
	public void setCantidadFPelicula(int cantidadFPelicula) {
		this.cantidadFPelicula = cantidadFPelicula;
	}
	public int getCantidadFLugar() {
		return cantidadFLugar;
	}
	public void setCantidadFLugar(int cantidadFLugar) {
		this.cantidadFLugar = cantidadFLugar;
	}
	public int getCantidadFRestaurante() {
		return cantidadFRestaurante;
	}
	public void setCantidadFRestaurante(int cantidadFRestaurante) {
		this.cantidadFRestaurante = cantidadFRestaurante;
	}
	public int getCantidadFSerie() {
		return cantidadFSerie;
	}
	public void setCantidadFSerie(int cantidadFSerie) {
		this.cantidadFSerie = cantidadFSerie;
	}
	public int getCantidadFRopa() {
		return cantidadFRopa;
	}
	public void setCantidadFRopa(int cantidadFRopa) {
		this.cantidadFRopa = cantidadFRopa;
	}
	
}
