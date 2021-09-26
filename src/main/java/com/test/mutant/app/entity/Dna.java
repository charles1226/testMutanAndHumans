package com.test.mutant.app.entity;

import java.util.ArrayList;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dna {
	
	@NotEmpty(message = "No ingreso cadena ADN")
	private  ArrayList<String> dna;
	
}
