package com.hospedaje.web.bungalow.service;

import org.springframework.http.HttpHeaders;

import com.hospedaje.web.bungalow.dto.request.BungalowRequest;
import com.hospedaje.web.bungalow.dto.response.GetBungalowResponse;
import com.hospedaje.web.bungalow.dto.response.ListBungalowResponse;

import reactor.core.publisher.Mono;

public interface BungalowService {
	
	Mono<ListBungalowResponse> listarBungalow(HttpHeaders headers);
	Mono<GetBungalowResponse> agregarBungalow(HttpHeaders header,BungalowRequest bungalowRequest);
	

}
