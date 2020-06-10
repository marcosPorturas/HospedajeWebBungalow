package com.hospedaje.web.bungalow.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Document(collection="bungalow_category")
@AllArgsConstructor
@Builder
public class BungalowCategory implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	@Field
	private String nombre;
	@Field
	private String descripcion;
	@Field(value="precio_dia")
	private Double precioDia;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecioDia() {
		return precioDia;
	}
	public void setPrecioDia(Double precioDia) {
		this.precioDia = precioDia;
	}
	
}
