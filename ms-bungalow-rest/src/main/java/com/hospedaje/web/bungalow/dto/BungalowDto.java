package com.hospedaje.web.bungalow.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class BungalowDto {

	private Integer idBungalow;
	private String categoria;
	private Double precioDia;
	private boolean estado;
	

	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Double getPrecioDia() {
		return precioDia;
	}
	public void setPrecioDia(Double precioDia) {
		this.precioDia = precioDia;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Integer getIdBungalow() {
		return idBungalow;
	}
	public void setIdBungalow(Integer idBungalow) {
		this.idBungalow = idBungalow;
	}
	
}
