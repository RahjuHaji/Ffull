/**
 * @author Cobetuoiteen <tienhuynhq5@gmail.com>
 * @dateCreate Aug 3, 2019
 */
package tien.Ffull.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tien.Ffull.domain.Car;
import tien.Ffull.domain.CarRepository;

/**
 * @TODO
 */

//The @RestController annotation identifies that this class will be the controller
//for the RESTful web service

@RestController
public class CarController {
	private static final Logger logger = LoggerFactory.getLogger(CarController.class);

//	To be able to return cars from the database, we have to inject our
//	CarRepository into the controller. Then, we can use the findAll() method
//	that the repository provides to fetch all cars. The following source code shows
//	the controller code:
	@Autowired // <--- lan trc thieu cai nay, mat 20 phut ngoi mo console log ==' dm , fucking autowired
	private CarRepository carRepository;
	
//	By default, @RequestMapping handles all the HTTP method (GET, PUT,
//			POST, and more) requests. You can define which method is accepted using
//			the following @RequestMapping("/cars", method=GET) parameter.
//			Now, this method handles only GET requests from the /cars endpoint.
	    	
	@RequestMapping("/cars")
	public Iterable<Car> getCars(){
		logger.info("Hi there, i getCars");
		return carRepository.findAll();
	}
	
//	@RequestMapping("/carsbrand")
//	public List<Car> getCarsByBrand(){
//		logger.info("Hi there, i getCarsByBrand");
//		return carRepository.getByBrand("A");
//	}

}
