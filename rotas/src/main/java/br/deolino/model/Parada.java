package br.deolino.model;

public class Parada {

	private Integer paradaId;
	private String name;
	private Coordenadas position;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Coordenadas getPosition() {
		return position;
	}

	public void setPosition(Coordenadas position) {
		this.position = position;
	}

	public Integer getParadaId() {
		return paradaId;
	}

	public void setParadaId(Integer paradaId) {
		this.paradaId = paradaId;
	}
}
