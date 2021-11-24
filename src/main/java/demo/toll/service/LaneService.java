package demo.toll.service;

import java.util.Collection;
import java.util.Optional;

import demo.toll.domain.Lane;

public interface LaneService {

	void create(Lane lane);

	Collection<Lane> getAll();

	Collection<Lane> getAllByTollPlazaId(Long tollPlazaId);

	Optional<Lane> getById(Long id);

	void update(Lane lane);

	void deleteById(Long id);

}
