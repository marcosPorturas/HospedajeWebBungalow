package com.hospedaje.web.bungalow.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.hospedaje.web.bungalow.dto.request.BungalowRequest;
import com.hospedaje.web.bungalow.dto.response.BungalowResponse;
import com.hospedaje.web.bungalow.entity.Bungalow;
import com.hospedaje.web.bungalow.entity.BungalowCategory;
import com.hospedaje.web.bungalow.entity.BungalowStatus;
import com.hospedaje.web.bungalow.repository.BungalowCategoryRepository;
import com.hospedaje.web.bungalow.repository.BungalowRepository;
import com.hospedaje.web.bungalow.repository.BungalowStatusRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BungalowServiceImplement implements BungalowService{

	private static final Logger LOG = LoggerFactory.getLogger(BungalowServiceImplement.class);
	
	Gson gson = new Gson();
	
	@Autowired
	BungalowRepository bungalowRepository;
	
	@Autowired
	BungalowCategoryRepository bungalowCategoryRepository;
	
	@Autowired
	BungalowStatusRepository bungalowStatusRepository;
	
	@Override
	public Flux<BungalowResponse> listarBungalow(HttpHeaders headers) {
		return bungalowRepository.findAll()
				.map(this::bungalowConvertToDto);
				
	}
	
	@Override
	public Mono<BungalowResponse> agregarBungalow(HttpHeaders header,BungalowRequest bungalowRequest) {
		
		Mono<BungalowCategory> singleBungalowCategory = bungalowCategoryRepository
									.findById(bungalowRequest.getIdBungalowCategory());
			
		Mono<BungalowStatus> singleBungalowStatus = bungalowStatusRepository.findById(0);
		
		return Mono.zip(singleBungalowCategory,singleBungalowStatus)
					.map(tupla->Bungalow.builder()
							.idBungalow(bungalowRequest.getIdBungalow())
							.creationDate(new Date())
							.enabled(true)
							.bungalowCategory(
									BungalowCategory.builder()
										.id(tupla.getT1().getId())
										.descripcion(tupla.getT1().getDescripcion())
										.nombre(tupla.getT1().getNombre())
										.precioDia(tupla.getT1().getPrecioDia())
										.build()
							).bungalowStatus(BungalowStatus.builder()
									.id(tupla.getT2().getId())
									.description(tupla.getT2().getDescription())
									.build())
							.build())
					.flatMap(bungalowRepository::save)
					.map(this::bungalowConvertToDto);
						
	}
	
	private BungalowResponse bungalowConvertToDto(Bungalow bungalow) {
		return BungalowResponse.builder()
				.idBungalow(bungalow.getIdBungalow())
				.categoria(bungalow.getBungalowCategory().getNombre())
				.precioDia(bungalow.getBungalowCategory().getPrecioDia())
				.habilitado(bungalow.isEnabled())
				.estado(bungalow.getBungalowStatus().getDescription())
				.build();
	}

	@Override
	public Mono<BungalowResponse> obtenerBungalow(Integer idBungalow) {

		return bungalowRepository.findById(idBungalow)
				.map(this::bungalowConvertToDto);
	}
	


}
