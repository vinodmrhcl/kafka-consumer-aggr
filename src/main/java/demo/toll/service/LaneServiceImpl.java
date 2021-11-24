package demo.toll.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.toll.domain.Lane;
import demo.toll.repo.LaneRepository;

@Service
public class LaneServiceImpl implements LaneService {

	@Autowired
	private LaneRepository laneRepository;

	@Override
	@Transactional(readOnly = true)
	public Collection<Lane> getAll() {
		return this.laneRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Lane> getAllByTollPlazaId(Long tollPlazaId) {
		return this.laneRepository.findAllByTollPlazaId(tollPlazaId);
	}

	@Override
	@Transactional
	public void create(Lane lane) {
		this.laneRepository.save(lane);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Lane> getById(Long id) {
		return this.laneRepository.findById(id);
	}

	@Override
	@Transactional
	public void update(Lane lane) {
		this.laneRepository.save(lane);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		this.laneRepository.deleteById(id);
	}

}
