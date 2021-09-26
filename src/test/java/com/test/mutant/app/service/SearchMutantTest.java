package com.test.mutant.app.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.test.mutant.app.entity.BaseDna;
import com.test.mutant.app.service.SearchDnaMutant;

public class SearchMutantTest {


	String[][] dnaMatrix;
	
	@BeforeEach
	void init() {
		dnaMatrix = new String[6][6];
		
	}
	
	
	@Test
	void mutantValidateTest() {
		SearchDnaMutant searchMutant = new SearchDnaMutant(fillBaseDnaMutantRowAndColumn(), 6,6);
		String message = searchMutant.validateMutantDna();
		assertEquals("Se encontro almenos Mutante", message);
	}
	
	@Test
	void noMutantValidateTest() {
		SearchDnaMutant searchMutant = new SearchDnaMutant(fillBaseDnaCeroMutantRowAndColumn(), 6,6);
		String message = searchMutant.validateMutantDna();
		assertEquals("", message);
	}
	
	
	@Test
	void mutantObliqueTest() {
		SearchDnaMutant searchMutant = new SearchDnaMutant(fillBaseDnaMutantOlbique(), 6,6);
		String message = searchMutant.validateMutantDna();
		assertEquals("Se encontro almenos Mutante", message);
	}
	
	
	public String[][] fillBaseDnaMutantRowAndColumn() {
		BaseDna baseDna = new BaseDna();
		ArrayList<String> data = new ArrayList<>();
		
		String cadena1="TGAAAAA";
		String cadena2="CAGTGCG";
		String cadena3="CTCTGTT";
		String cadena4="CGCTAGT";
		String cadena5="CCTCAGC";
		String cadena6="CCTCAAA";
		String cadena7="TGAGTGG";
		
		data.add(cadena1);
		data.add(cadena2);
		data.add(cadena3);
		data.add(cadena4);
		data.add(cadena5);
		data.add(cadena6);
		data.add(cadena7);
		
		baseDna.fillInBaseDna(data );
		
		return baseDna.getDnaMatriz();
	}
	
	public String[][] fillBaseDnaCeroMutantRowAndColumn() {
		BaseDna baseDna = new BaseDna();
		ArrayList<String> data = new ArrayList<>();
		
		String cadena1="TGAAGAA";
		String cadena2="CAGTGCG";
		String cadena3="CTATGTT";
		String cadena4="CGCTCGT";
		String cadena5="GCTCAAC";
		String cadena6="CCTCAAA";
		String cadena7="TGAGTGG";
		
		data.add(cadena1);
		data.add(cadena2);
		data.add(cadena3);
		data.add(cadena4);
		data.add(cadena5);
		data.add(cadena6);
		data.add(cadena7);
		
		baseDna.fillInBaseDna(data );
		
		return baseDna.getDnaMatriz();
	}
	
	
	public String[][] fillBaseDnaMutantOlbique() {
		BaseDna baseDna = new BaseDna();
		ArrayList<String> data = new ArrayList<>();
		
		String cadena1="TGAAGAA";
		String cadena2="CAGTGCG";
		String cadena3="CTATGTT";
		String cadena4="CGCACGT";
		String cadena5="GCTCAAC";
		String cadena6="CCTCCAA";
		String cadena7="TGAGTCG";
		
		data.add(cadena1);
		data.add(cadena2);
		data.add(cadena3);
		data.add(cadena4);
		data.add(cadena5);
		data.add(cadena6);
		data.add(cadena7);
		
		baseDna.fillInBaseDna(data );
		
		return baseDna.getDnaMatriz();
	}
	
	
}
