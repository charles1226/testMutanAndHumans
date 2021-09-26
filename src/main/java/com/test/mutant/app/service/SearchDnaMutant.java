package com.test.mutant.app.service;

public class SearchDnaMutant {

	private String[][] dnaMatriz;
	private int numRows;
	private int numColumns;

	public SearchDnaMutant(String[][] dnaMatriz, int numRows, int numColumns) {
		this.dnaMatriz = dnaMatriz;
		this.numRows = numRows;
		this.numColumns = numColumns;
	}

	/**
	 * Funcion que valida que dentro de la matriz hay almenos un adn mutante
	 * 
	 * @return
	 */
	public String validateMutantDna() {

		int numSecuences = 0;
		String messageMutantAndHuman = "";

		for (int i = 0; i < dnaMatriz.length; i++) {
			for (int j = 0; j < dnaMatriz.length; j++) {

				if (validateLetterRown(dnaMatriz[i][j], i, j))
					numSecuences++;
				if (validateLetterColumns(dnaMatriz[i][j], i, j))
					numSecuences++;
				if (validateLetterUbliquo(dnaMatriz[i][j], i, j))
					numSecuences++;
			}
		}

		if (numSecuences > 1) {
			messageMutantAndHuman = "Se encontro almenos un Mutante";
		}

		return messageMutantAndHuman;
	}

	public boolean validateLetter(int posI, int posJ, String letter) {
		return dnaMatriz[posI][posJ].equals(letter);
	}

	/**
	 * Funcion para validar que una letra tiene 4 letras continuas en su fila a
	 * partir de su posicion
	 * 
	 * @param letter
	 * @param postionI
	 * @param postionJ
	 * @return
	 */
	public boolean validateLetterRown(String letter, int postionI, int postionJ) {

		int secuence = 0;
		if (postionI >= numRows || postionJ >= numColumns) {
			return false;
		}

		do {

			if (validateLetter(postionI, postionJ, letter)) {
				secuence++;
			} else {
				break;
			}
			postionI++;

		} while (postionI < numRows);

		return secuence >= 4 ? true : false;

	}

	/**
	 * Funcion para validar que una letra tiene cuatro letras seguidas a partir de
	 * su posicion
	 * 
	 * @param letter
	 * @param positionI
	 * @param positionJ
	 * @return
	 */
	public boolean validateLetterColumns(String letter, int positionI, int positionJ) {

		int secuence = 0;
		if (positionI >= numRows || positionJ >= numColumns) {
			return false;
		}
		do {

			if (validateLetter(positionI, positionJ, letter)) {
				secuence++;
			} else {
				break;
			}
			positionJ++;

		} while (positionJ < numColumns);

		return secuence >= 4 ? true : false;

	}

	/**
	 * Funcion para validar que una letra tiene una secuencia de 4 letras de forma
	 * ublicua
	 * 
	 * @param letter
	 * @param posI
	 * @param posJ
	 * @return
	 */
	public boolean validateLetterUbliquo(String letter, int posI, int posJ) {

		if (posI == numRows || posJ == numColumns) {
			return false;
		}
		int secuence = 0;
		do {

			if (validateLetter(posI, posJ, letter)) {
				secuence++;
			} else {
				break;
			}
			posJ++;
			posI++;
		} while (posJ < numColumns && posI < numRows);

		return secuence >= 4 ? true : false;

	}

//Codigo para validar la matriz de forma olbicua
//	public boolean validateObliqueAll(int numRows, String letter, int numColumns) {
//		boolean isOblique = false;
//
//		int numCall = 1;
//		int numCallProces=1;
//		for (int i = numRows-1; i >= 0; i--) {
//			
//			if(numCall<=numColumns) {
//				if (validateLetterOlbique(i, letter, numColumns, numCallProces)) {
//					isOblique = true;
//				}
//				numCallProces++;
//			}else {
//				numCallProces--;
//				if (validateLetterOlbique(i, letter, numColumns, numCallProces)) {
//					isOblique = true;
//				}
//				
//			}
//			numCall++;
//			
//		}
//
//		return isOblique;
//	}
//
//	public boolean validateLetterOlbique(int numRows, String letter, int numColumns, int numLlamadas) {
//
//		int cantTimes = 0;
//		int i = numRows;
//
//		do {
//		for (int x = 0; x < numLlamadas; x++) {
//			if (dnaMatriz[i][x].equals(letter)) {
//				cantTimes++;
//			}
//			i++;
//		}
//		}while(i<numRows && numLlamadas<numColumns);
//
//		return cantTimes >= 4 ? true : false;
//	}

}
