package com.hospedaje.web.bungalow.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.hospedaje.web.bungalow.dto.BungalowDto;
import com.hospedaje.web.bungalow.dto.request.BungalowRequest;
import com.hospedaje.web.bungalow.dto.response.AuditResponse;
import com.hospedaje.web.bungalow.dto.response.GetBungalowResponse;
import com.hospedaje.web.bungalow.dto.response.ListBungalowResponse;
import com.hospedaje.web.bungalow.entity.Bungalow;
import com.hospedaje.web.bungalow.entity.BungalowCategory;
import com.hospedaje.web.bungalow.repository.BungalowCategoryRepository;
import com.hospedaje.web.bungalow.repository.BungalowRepository;


import reactor.core.publisher.Mono;

@Service
public class BungalowServiceImplement implements BungalowService{

	private static final Logger LOG = LoggerFactory.getLogger(BungalowServiceImplement.class);
	
	Gson gson = new Gson();
	
	@Autowired
	BungalowRepository bungalowRepository;
	
	@Autowired
	BungalowCategoryRepository bungalowCategoryRepository;
	
	@Override
	public Mono<ListBungalowResponse> listarBungalow(HttpHeaders headers) {
		return bungalowRepository.findAll()
				.map(this::bungalowConvertToDto)
				.collectList()
				.flatMap(bungalows->Mono.just(listBungalowResponse(bungalows)));
				
	}
	
	@Override
	public Mono<GetBungalowResponse> agregarBungalow(HttpHeaders header,BungalowRequest bungalowRequest) {
		
			return bungalowCategoryRepository.findById(bungalowRequest.getIdBungalowCategory())
					.map(bc->Bungalow.builder()
							.idBungalow(bungalowRequest.getIdBungalow())
							.creationDate(new Date())
							.enabled(true)
							.bungalowCategory(
									BungalowCategory.builder()
										.id(bc.getId())
										.descripcion(bc.getDescripcion())
										.nombre(bc.getNombre())
										.precioDia(bc.getPrecioDia()).build()
							).build())
					.flatMap(bungalowRepository::save)
					.map(this::bungalowConvertToDto)
					.map(this::getBungalowResponse);
						
	}
	
	private BungalowDto bungalowConvertToDto(Bungalow bungalow) {
		return BungalowDto.builder()
				.idBungalow(bungalow.getIdBungalow())
				.categoria(bungalow.getBungalowCategory().getNombre())
				.precioDia(bungalow.getBungalowCategory().getPrecioDia())
				.estado(bungalow.isEnabled()).build();
	}
	
	private ListBungalowResponse listBungalowResponse(List<BungalowDto> listBungalow) {
		return ListBungalowResponse.builder()
				.listBungalow(listBungalow)
				.auditResponse(new AuditResponse()).build();
	}
	
	
	private GetBungalowResponse getBungalowResponse(BungalowDto bungalowDto) {
		return GetBungalowResponse.builder()
				.bungalow(bungalowDto)
				.auditResponse(new AuditResponse()).build();
	}


}
