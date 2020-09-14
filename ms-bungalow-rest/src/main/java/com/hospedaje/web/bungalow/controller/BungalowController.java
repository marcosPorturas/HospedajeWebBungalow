package com.hospedaje.web.bungalow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospedaje.web.bungalow.dto.request.BungalowRequest;
import com.hospedaje.web.bungalow.dto.response.BungalowResponse;
import com.hospedaje.web.bungalow.service.BungalowService;

import reactor.core.publisher.Mono;

@RestController
@Validated
@RequestMapping("/bungalow")
public class BungalowController {

	
	@Autowired
	BungalowService bungalowService;
	
	@PostMapping("/agregar")
	public Mono<BungalowResponse> agregarBungalow(@RequestHeader HttpHeaders headers ,
			@RequestBody BungalowRequest bungalowRequest){
		return bungalowService.agregarBungalow(headers, bungalowRequest);
	}
	
	@PutMapping("/actualizar")
	public Mono<BungalowResponse> actualizarBungalow(@RequestHeader HttpHeaders headers ,
			@RequestBody BungalowRequest bungalowRequest){
		return bungalowService.agregarBungalow(headers, bungalowRequest);
	}
	
	@GetMapping("/{idBungalow}")
	public Mono<BungalowResponse> obtenerBungaloe(@PathVariable("idBungalow")Integer idBungalow){
		return bungalowService.obtenerBungalow(idBungalow);
	}
	
}
