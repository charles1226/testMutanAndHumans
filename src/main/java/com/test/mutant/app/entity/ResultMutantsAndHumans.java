package com.test.mutant.app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
public class ResultMutantsAndHumans {

	private int total;
	private boolean human;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public boolean isHuman() {
		return human;
	}
	public void setHuman(boolean human) {
		this.human = human;
	}
	
	
}
