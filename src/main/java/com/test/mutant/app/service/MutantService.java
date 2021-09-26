package com.test.mutant.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mutant.app.entity.Adn;
import com.test.mutant.app.entity.BaseDna;
import com.test.mutant.app.entity.Dna;
import com.test.mutant.app.entity.RegisterMutantAndHuman;
import com.test.mutant.app.params.Params;
import com.test.mutant.app.repository.RegisterMutantAndHumanRepository;


@Service
public class MutantService implements IMutantService {

	
	@Autowired
    private RegisterMutantAndHumanRepository registerMutantAndHumanRepository;
	
	/**
	 * Funcion para realiza que la cadena de json recibida es valida para procesarla
	 */
	@Override
	public String validationContent(ArrayList<String> listDna) {

		boolean validate = true;
		int initSize = listDna.get(0).length();
		String messageValidation = "";

		if (initSize != listDna.size()) {
			messageValidation = new StringBuilder("Datos de ADN Inconsistentes, la lista ")
					.append(" no contiene el mismo tam del contenido de las cadenas").toString();
		} else {

			for (String chainDna : listDna) {

				if (inconsistencySize(initSize, chainDna.length())) {
					validate = true;
					chainDna = chainDna.toUpperCase();
					for (int i = 0; i < chainDna.length(); i++) {
						contentLetter(chainDna.charAt(i));
						if (!contentLetter(chainDna.charAt(i))) {
							validate = false;
						}
					}

					if (!validate) {
						messageValidation = new StringBuilder("Datos de ADN Inconsistentes, la cadena: ")
								.append(chainDna).append(" no contiene los caracteres permitidos").toString();

					}
				} else {
					messageValidation = new StringBuilder("Datos de ADN Inconsistentes, la cadena: ").append(chainDna)
							.append(" no contiene el mismo tam de las demas").toString();

				}

			}
		}

		return messageValidation;
	}

	
	/**
	 * Funcion para realizar el proceso de validar un adn mutante
	 */
	@Override
	public String validationDna(Dna dna) {
		String messageValidation = "";
		messageValidation = validationContent(dna.getDna());

		
		
		if (messageValidation.isEmpty()) {

			BaseDna baseDna = new BaseDna();
			baseDna.fillInBaseDna(dna.getDna());
			RegisterMutantAndHuman register = new RegisterMutantAndHuman();
			register.setChainDna(dna.getDna().toString());
			
			SearchDnaMutant searchMutant = new SearchDnaMutant(baseDna.getDnaMatriz(), baseDna.getNumRows(),
					baseDna.getNumColumns());

			messageValidation = searchMutant.validateMutantDna();
			
			if(!messageValidation.isEmpty()) {
				register.setHuman(false);
			}else {
				register.setHuman(true);
			}
			
			saveRegister(register);
			
			return messageValidation;

		} else {
			return messageValidation;
		}
	}

	/**
	 * Funcion para validar que la cadena tiene las letras permitidas
	 * @param c
	 * @return
	 */
	public boolean contentLetter(char c) {
		return Params.CONTENT_LETTERS.contains(c + "") ? true : false;
	}

	/**
	 * Funcion para validar que alguna cadena no tiene el mismo numero de letras
	 * @param initSize
	 * @param verifySize
	 * @return
	 */
	public boolean inconsistencySize(int initSize, int verifySize) {
		return initSize == verifySize ? true : false;
	}
	
	public void saveRegister(RegisterMutantAndHuman register) {
		registerMutantAndHumanRepository.save(register);
	}
	
	public Adn getMutantsAndHumans() {
		return registerMutantAndHumanRepository.getMutantsAndHumans();
	}
}
