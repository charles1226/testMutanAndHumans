package com.test.mutant.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Adn {

	private int count_mutant_dna;
	private int count_human_dna;
	private Double ratio;

}
