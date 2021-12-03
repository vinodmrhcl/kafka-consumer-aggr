package demo.toll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import demo.toll.domain.Lane;
import demo.toll.domain.TollPlaza;
import demo.toll.repo.LaneRepository;
import demo.toll.repo.TollPlazaRepository;

@SpringBootApplication
public class TollApp {

	public static void main(String[] args) {
		SpringApplication.run(TollApp.class, args);
	}

	@Autowired
	private TollPlazaRepository plazaRepository;
	
	@Autowired
	private LaneRepository laneRepository;

	@Bean
	public CommandLineRunner runner() {
		return args -> {
			TollPlaza plaza = new TollPlaza();
			plaza.setTollPlazaId(1L);
			plaza.setTollPlazaName("Plaza 1");
			plaza = plazaRepository.save(plaza);
			
			Lane lane1 = new Lane();
			lane1.setLaneNo("Lane 1");
			lane1.setTollPlazaId(plaza.getTollPlazaId());
			laneRepository.save(lane1);
			
			Lane lane2 = new Lane();
			lane2.setLaneNo("Lane 2");
			lane2.setTollPlazaId(plaza.getTollPlazaId());
			laneRepository.save(lane2);			
		};
	}

}
