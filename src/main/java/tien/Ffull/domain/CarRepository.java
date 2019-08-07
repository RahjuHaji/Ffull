/**
 * @author Cobetuoiteen <tienhuynhq5@gmail.com>
 * @dateCreate Aug 2, 2019
 */
package tien.Ffull.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @TODO
 */
public interface CarRepository extends PagingAndSortingRepository<Car, Long> {
	
	//get car by brand using sql
	@Query("select c from Car c where c.brand = ?1")
	
	// get by brand
	List<Car> getByBrand(String brand);
	
	// get by brand and sort by year
	List<Car> getByBrandOrderByYearAsc(String brand);
	
	// get by color
	List<Car> getByColor(String color);
	
	// get by year
	List<Car> getByYear(int year);
	
	// get by brand and model
	List<Car> getByBrandAndModel(String brand, String model);
	
	// get by brand and color
	List<Car> getByBrandAndColor(String brand, String color);
	
}
