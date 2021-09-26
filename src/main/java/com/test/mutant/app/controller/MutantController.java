package com.test.mutant.app.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.mutant.app.entity.Adn;
import com.test.mutant.app.entity.Dna;
import com.test.mutant.app.service.IMutantService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor // defect constructor
public class MutantController {

	private final IMutantService mutantService;
	HttpServletResponse response;

	@PostMapping(value = "/mutant")
	public ResponseEntity<String> validationMutant(@Validated @RequestBody() Dna dna) {

		String message = mutantService.validationDna(dna);

		if (message.isEmpty()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No se encontro ningun adn mutante");
		} else {
			return new ResponseEntity<>(message, HttpStatus.OK);
		}

	}

	@GetMapping(value = "/stats")
	public ResponseEntity<Adn> validationMutant() {

		Adn adn = mutantService.getMutantsAndHumans();
		return new ResponseEntity<>(adn, HttpStatus.OK);

	}
}
