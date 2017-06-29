package br.deolino.model;

import java.util.Date;
import java.util.List;

public class Rota {

	private Integer rotaId;
	private String name;
	private Date routeDate;
	private Integer vehicleId;
	private List<Parada> stops;
	private List<Coordenadas> path;

	public Integer getRotaId() {
		return rotaId;
	}

	public void setRotaId(Integer rotaId) {
		this.rotaId = rotaId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRouteDate() {
		return routeDate;
	}

	public void setRouteDate(Date routeDate) {
		this.routeDate = routeDate;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public List<Parada> getStops() {
		return stops;
	}

	public void setStops(List<Parada> stops) {
		this.stops = stops;
	}

	public List<Coordenadas> getPath() {
		return path;
	}

	public void setPath(List<Coordenadas> path) {
		this.path = path;
	}
}
