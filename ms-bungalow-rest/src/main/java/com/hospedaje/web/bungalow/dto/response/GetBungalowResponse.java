package com.hospedaje.web.bungalow.dto.response;

import com.hospedaje.web.bungalow.dto.BungalowDto;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class GetBungalowResponse {

	private BungalowDto bungalow;
	private AuditResponse auditResponse;
	
	public BungalowDto getBungalow() {
		return bungalow;
	}
	public void setBungalow(BungalowDto bungalow) {
		this.bungalow = bungalow;
	}
	public AuditResponse getAuditResponse() {
		return auditResponse;
	}
	public void setAuditResponse(AuditResponse auditResponse) {
		this.auditResponse = auditResponse;
	}
	
}
