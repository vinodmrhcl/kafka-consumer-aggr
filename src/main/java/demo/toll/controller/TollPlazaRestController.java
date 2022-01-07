package demo.toll.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.toll.domain.Lane;
import demo.toll.domain.TollPlaza;
import demo.toll.service.LaneService;
import demo.toll.service.TollPlazaService;

@RestController
@RequestMapping("/plazas")
public class TollPlazaRestController {

	@Autowired
	private TollPlazaService plazaService;

	@Autowired
	private LaneService laneService;

	@GetMapping
	public Collection<TollPlaza> getAll() {
		return this.plazaService.getAll();
	}

	@GetMapping("/lanes")
	public Collection<Lane> getAllLanes() {
		return this.laneService.getAll();
	}

	@GetMapping("/{id}/lanes")
	public Collection<Lane> getLanesbByTollPlazaId(@PathVariable(value = "id") Long id) {
		return this.laneService.getAllByTollPlazaId(id);
	}

	@PostMapping
	public void create(@RequestBody TollPlaza plaza) {
		this.plazaService.create(plaza);
	}

	@GetMapping("/{id}")
	public TollPlaza getById(@PathVariable(value = "id") Long id) {
		return this.plazaService.getById(id).get();
	}

	@PutMapping
	public void update(@RequestBody TollPlaza plaza) {
		this.plazaService.update(plaza);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		this.plazaService.deleteById(id);
	}

}
