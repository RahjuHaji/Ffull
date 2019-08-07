package tien.Ffull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tien.Ffull.domain.Car;
import tien.Ffull.domain.CarRepository;
import tien.Ffull.domain.Owner;
import tien.Ffull.domain.OwnerRepository;

@SpringBootApplication
public class FfullApplication {
	
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private OwnerRepository ownerRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(FfullApplication.class);
	
	public static void main(String[] args) {
		//Restart ??
		SpringApplication.run(FfullApplication.class, args);
		logger.info("Hi there, i am here");
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			//TODO: code here
			Owner who1 = new Owner("A", "A");
			Owner who2 = new Owner("B", "B");
			Owner who3 = new Owner("C", "C");
			ownerRepository.save(who1);
			ownerRepository.save(who2);
			ownerRepository.save(who3);
			
//			Car car1 = new Car("A", "A", "A", "1", 1, 1, "1A", who1);
//			Car car2 = new Car("B", "B", "B", "2", 2, 2, "2B", who2);
//			Car car3 = new Car("C", "C", "C", "3", 3, 3, "3C", who3);
//			carRepository.save(car1);
//			carRepository.save(car2);
//			carRepository.save(car3);
			
			Car car = new Car("A", "A", "A", "1", 1, 1, "1A", who1);
			carRepository.save(car);
			car = new Car("B", "B", "B", "2", 2, 2, "2B", who2);
			carRepository.save(car);
			car = new Car("C", "C", "C", "3", 3, 3, "3C", who3);
			carRepository.save(car);
		};
	}
}
