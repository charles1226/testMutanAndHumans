package com.test.mutant.app.service;

import java.util.ArrayList;

import com.test.mutant.app.entity.Adn;
import com.test.mutant.app.entity.Dna;

public interface IMutantService {

	String validationDna (Dna dna);
	String validationContent(ArrayList<String> dna);
	Adn getMutantsAndHumans();
	
}
