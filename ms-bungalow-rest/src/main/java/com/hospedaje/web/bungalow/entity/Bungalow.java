package com.hospedaje.web.bungalow.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Document(collection="bungalow")
@AllArgsConstructor
@Builder
public class Bungalow {

	@Id
	private Integer idBungalow;
	
	@Field("creation_date")
	private Date creationDate;
	
	@Field("update_date")
	private Date updateDate;
	
	@Field("enabled")
	private boolean enabled;
	
	@Field("bungalow_category")
	private BungalowCategory bungalowCategory;

	public Integer getIdBungalow() {
		return idBungalow;
	}

	public void setIdBungalow(Integer idBungalow) {
		this.idBungalow = idBungalow;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public BungalowCategory getBungalowCategory() {
		return bungalowCategory;
	}

	public void setBungalowCategory(BungalowCategory bungalowCategory) {
		this.bungalowCategory = bungalowCategory;
	}
	
}
