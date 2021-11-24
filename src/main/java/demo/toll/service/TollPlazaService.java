package demo.toll.service;

import java.util.Collection;
import java.util.Optional;

import demo.toll.domain.TollPlaza;

public interface TollPlazaService {

	void create(TollPlaza plaza);

	Collection<TollPlaza> getAll();

	Optional<TollPlaza> getById(Long id);
	
	void update(TollPlaza plaza);

	void deleteById(Long id);

}
