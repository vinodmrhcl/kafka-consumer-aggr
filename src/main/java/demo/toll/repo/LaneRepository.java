package demo.toll.repo;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.toll.domain.Lane;

public interface LaneRepository extends JpaRepository<Lane, Long> {

	Collection<Lane> findAllByTollPlazaId(Long tollPlazaId);
}