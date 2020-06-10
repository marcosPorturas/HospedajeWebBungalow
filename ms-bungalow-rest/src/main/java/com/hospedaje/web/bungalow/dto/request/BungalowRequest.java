package com.hospedaje.web.bungalow.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class BungalowRequest {

	
	private Integer idBungalow;
	private Integer idBungalowCategory;
	
	public Integer getIdBungalow() {
		return idBungalow;
	}
	public void setIdBungalow(Integer idBungalow) {
		this.idBungalow = idBungalow;
	}
	public Integer getIdBungalowCategory() {
		return idBungalowCategory;
	}
	public void setIdBungalowCategory(Integer idBungalowCategory) {
		this.idBungalowCategory = idBungalowCategory;
	}
	
	
}
