package demo.toll.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.toll.domain.TollPlaza;

public interface TollPlazaRepository extends JpaRepository<TollPlaza, Long> {
}
