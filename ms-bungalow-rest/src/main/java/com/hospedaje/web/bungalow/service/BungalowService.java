package com.hospedaje.web.bungalow.service;

import org.springframework.http.HttpHeaders;

import com.hospedaje.web.bungalow.dto.request.BungalowRequest;
import com.hospedaje.web.bungalow.dto.response.BungalowResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BungalowService {
	
	Flux<BungalowResponse> listarBungalow(HttpHeaders headers);
	Mono<BungalowResponse> agregarBungalow(HttpHeaders header,BungalowRequest bungalowRequest);
	

}
