package com.test.mutant.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class MutantServiceTest {

	ArrayList<String> data;

	@Test
	void invalidLettersTest() {
		MutantService mutantService = new MutantService();
		String message = mutantService.validationContent(fillDataInvalidLetter());
		assertEquals("Datos de ADN Inconsistentes, la cadena: " + "TGAAAAX" + " no contiene los caracteres permitidos",
				message);
	}

	@Test
	void invalidTamChainTest() {
		MutantService mutantService = new MutantService();
		String message = mutantService.validationContent(fillDataInvalidTamChain());
		assertEquals(
				"Datos de ADN Inconsistentes, la cadena: " + "TGAGTGGG" + " no contiene el mismo tam de las demas",
				message);

	}

	@Test
	void invalidTamMatrixTest() {
		MutantService mutantService = new MutantService();
		String message = mutantService.validationContent(fillDataInvalidTamMatrix());
		assertEquals("Datos de ADN Inconsistentes, la lista  no contiene el mismo tam del contenido de las cadenas",
				message);

	}

	@Test
	void validMatrixTest() {
		MutantService mutantService = new MutantService();
		String message = mutantService.validationContent(fillValidMatrix());
		assertEquals("", message);

	}

	@Test
	void validMatrix() {
		MutantService mutantService = new MutantService();
		String message = mutantService.validationContent(fillValidMatrix());
		assertEquals("", message);

	}

	public ArrayList<String> fillDataInvalidLetter() {

		ArrayList<String> data = new ArrayList<>();

		String cadena1 = "TGAAAAX";
		String cadena2 = "CAGTGCG";
		String cadena3 = "CTCTGTT";
		String cadena4 = "CGCTAGT";
		String cadena5 = "CCTCAGC";
		String cadena6 = "CCTCAAA";
		String cadena7 = "TGAGTGG";

		data.add(cadena1);
		data.add(cadena2);
		data.add(cadena3);
		data.add(cadena4);
		data.add(cadena5);
		data.add(cadena6);
		data.add(cadena7);

		return data;
	}

	public ArrayList<String> fillDataInvalidTamChain() {

		ArrayList<String> data = new ArrayList<>();

		String cadena1 = "TGAAAAX";
		String cadena2 = "CAGTGCG";
		String cadena3 = "CTCTGTT";
		String cadena4 = "CGCTAGT";
		String cadena5 = "CCTCAGC";
		String cadena6 = "CCTCAAA";
		String cadena7 = "TGAGTGGG";

		data.add(cadena1);
		data.add(cadena2);
		data.add(cadena3);
		data.add(cadena4);
		data.add(cadena5);
		data.add(cadena6);
		data.add(cadena7);

		return data;
	}

	public ArrayList<String> fillDataInvalidTamMatrix() {

		ArrayList<String> data = new ArrayList<>();

		String cadena1 = "TGAAAAX";
		String cadena2 = "CAGTGCG";
		String cadena3 = "CTCTGTT";
		String cadena4 = "CGCTAGT";
		String cadena5 = "CCTCAGC";
		String cadena6 = "CCTCAAA";
		String cadena7 = "TGAGTGG";
		String cadena8 = "TGAGTGG";

		data.add(cadena1);
		data.add(cadena2);
		data.add(cadena3);
		data.add(cadena4);
		data.add(cadena5);
		data.add(cadena6);
		data.add(cadena7);
		data.add(cadena8);

		return data;
	}

	public ArrayList<String> fillValidMatrix() {

		ArrayList<String> data = new ArrayList<>();

		String cadena1 = "TGAAAAA";
		String cadena2 = "CAGTGCG";
		String cadena3 = "CTCTGTT";
		String cadena4 = "CGCTAGT";
		String cadena5 = "CCTCAGC";
		String cadena6 = "CCTCAAA";
		String cadena7 = "TGAGTGG";

		data.add(cadena1);
		data.add(cadena2);
		data.add(cadena3);
		data.add(cadena4);
		data.add(cadena5);
		data.add(cadena6);
		data.add(cadena7);

		return data;
	}
}
