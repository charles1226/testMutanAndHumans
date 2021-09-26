package com.test.mutant.app.entity;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseDna {

	private String[][] dnaMatriz;
	private int numRows;
	private int numColumns;
	
	public BaseDna() {

	}

	/**
	 * Metodo para construir la matriz a partir del json de entrada
	 * @param data
	 */
	public void fillInBaseDna(ArrayList<String> data) {

		this.numRows = data.size();
		this.numColumns = data.get(0).length();

		dnaMatriz = new String[numRows][numColumns];
		String chainDna;

		for (int i = 0; i < numRows; i++) {
			chainDna = data.get(i);
			System.out.println("-----------");

			for (int x = 0; x < numColumns; x++) {
				dnaMatriz[i][x] = (chainDna.charAt(x) + "").toUpperCase();
				System.out.print("|" + dnaMatriz[i][x] + "|");
			}

			System.out.println(" ");
		}

		
	}

	
}
