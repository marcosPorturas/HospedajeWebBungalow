package com.hospedaje.web.bungalow.dto.response;

import java.util.List;

import com.hospedaje.web.bungalow.dto.BungalowDto;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class ListBungalowResponse {

	private List<BungalowDto> listBungalow;
	private AuditResponse auditResponse;
	
	public List<BungalowDto> getListBungalow() {
		return listBungalow;
	}
	public void setListBungalow(List<BungalowDto> listBungalow) {
		this.listBungalow = listBungalow;
	}
	public AuditResponse getAuditResponse() {
		return auditResponse;
	}
	public void setAuditResponse(AuditResponse auditResponse) {
		this.auditResponse = auditResponse;
	}
	
}
