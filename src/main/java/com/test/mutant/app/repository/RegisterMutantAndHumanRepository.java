package com.test.mutant.app.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.mutant.app.entity.Adn;
import com.test.mutant.app.entity.RegisterMutantAndHuman;

@Repository
public class RegisterMutantAndHumanRepository {

	@Autowired
	private IRegisterMutantAndHumanRepository repository;

	public void save(RegisterMutantAndHuman entity) {
		repository.save(entity);
	}

	public Adn getMutantsAndHumans() {

		Long countMutants = repository.getMutantsAndHumans(false);
		Long countHumans = repository.getMutantsAndHumans(true);

		Adn adn = new Adn();
		adn.setCount_human_dna(countHumans.intValue());
		adn.setCount_mutant_dna(countMutants.intValue());

		if (adn.getCount_human_dna() > 0) {
			adn.setRatio(Double.valueOf(adn.getCount_mutant_dna() / adn.getCount_human_dna()));
		}

		return adn;
	}
}
