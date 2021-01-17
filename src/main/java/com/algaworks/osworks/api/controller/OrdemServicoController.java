package com.algaworks.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.OrdemServico;
import com.algaworks.osworks.domain.repository.OrdemServicoRepository;
import com.algaworks.osworks.domain.service.GestaoOrdemServicoService;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {
	
	@Autowired
	private GestaoOrdemServicoService ordemServicoService;
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServico criar(@Valid @RequestBody OrdemServico ordemServico) throws Exception {
		return ordemServicoService.criar(ordemServico);
	}
	
	@GetMapping
	public List<OrdemServico> listar() {
		return ordemServicoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrdemServico> buscar(@PathVariable Long id) {
		Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(id);
		
		if (ordemServico.isPresent()) {
			return ResponseEntity.ok(ordemServico.get());
		}
		
		return ResponseEntity.notFound().build();
	}

}
