package demo.toll.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.toll.domain.TollPlaza;
import demo.toll.repo.TollPlazaRepository;

@Service
public class TollPlazaServiceImpl implements TollPlazaService {

	@Autowired
	private TollPlazaRepository plazaRepository;

	@Override
	@Transactional(readOnly = true)
	public Collection<TollPlaza> getAll() {
		return this.plazaRepository.findAll();
	}

	@Override
	@Transactional
	public void create(TollPlaza plaza) {
		this.plazaRepository.save(plaza);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<TollPlaza> getById(Long id) {
		return this.plazaRepository.findById(id);
	}

	@Override
	@Transactional
	public void update(TollPlaza plaza) {
		this.plazaRepository.save(plaza);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		this.plazaRepository.deleteById(id);
	}

}
