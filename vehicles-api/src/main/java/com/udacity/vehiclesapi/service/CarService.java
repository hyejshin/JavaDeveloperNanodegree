package com.udacity.vehiclesapi.service;

import com.udacity.vehiclesapi.VehiclesApiApplication;
import com.udacity.vehiclesapi.client.maps.MapsClient;
import com.udacity.vehiclesapi.client.prices.PriceClient;
import com.udacity.vehiclesapi.domain.Location;
import com.udacity.vehiclesapi.domain.car.Car;
import com.udacity.vehiclesapi.domain.car.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

/**
 * Implements the car service create, read, update or delete
 * information about vehicles, as well as gather related
 * location and price data when desired.
 */
@Service
public class CarService {

    @Autowired
    private Environment env;

    private final CarRepository repository;
    private VehiclesApiApplication vehiclesApiApplication;
    private PriceClient priceClient;
    private MapsClient mapsClient;

    public CarService(CarRepository repository) {
        /**
         * TODO: Add the Maps and Pricing Web Clients you create
         *   in `VehiclesApiApplication` as arguments and set them here.
         */
        vehiclesApiApplication = new VehiclesApiApplication();
        this.repository = repository;
    }

    /**
     * Gathers a list of all vehicles
     * @return a list of all vehicles in the CarRepository
     */
    public List<Car> list() {
        List<Car> cars = repository.findAll();

        String priceEndpoint = env.getProperty("pricing.endpoint");
        WebClient pricing = vehiclesApiApplication.webClientPricing(priceEndpoint);
        String mapsEndpoint = env.getProperty("maps.endpoint");
        WebClient maps = vehiclesApiApplication.webClientMaps(mapsEndpoint);
        Location location = new Location(20.0, 30.0);

        for(Car car : cars) {
            Long id = car.getId();
            priceClient = new PriceClient(pricing);
            car.setPrice(priceClient.getPrice(id));
            mapsClient = new MapsClient(maps, new ModelMapper());
            car.setLocation(mapsClient.getAddress(location));
        }
        return cars;
    }

    /**
     * Gets car information by ID (or throws exception if non-existent)
     * @param id the ID number of the car to gather information on
     * @return the requested car's information, including location and price
     */
    public Car findById(Long id) {
        /**
         * TODO: Find the car by ID from the `repository` if it exists.
         *   If it does not exist, throw a CarNotFoundException
         *   Remove the below code as part of your implementation.
         */

        Car car;
        Optional<Car> optionalCar = repository.findById(id);
        if(optionalCar.isPresent())
            car = optionalCar.get();
        else
            throw new CarNotFoundException();

        /**
         * TODO: Use the Pricing Web client you create in `VehiclesApiApplication`
         *   to get the price based on the `id` input'
         * TODO: Set the price of the car
         * Note: The car class file uses @transient, meaning you will need to call
         *   the pricing service each time to get the price.
         */
        String priceEndpoint = env.getProperty("pricing.endpoint");
        WebClient pricing = vehiclesApiApplication.webClientPricing(priceEndpoint);
        priceClient = new PriceClient(pricing);
        car.setPrice(priceClient.getPrice(id));

        /**
         * TODO: Use the Maps Web client you create in `VehiclesApiApplication`
         *   to get the address for the vehicle. You should access the location
         *   from the car object and feed it to the Maps service.
         * TODO: Set the location of the vehicle, including the address information
         * Note: The Location class file also uses @transient for the address,
         * meaning the Maps service needs to be called each time for the address.
         */
        String mapsEndpoint = env.getProperty("maps.endpoint");
        WebClient maps = vehiclesApiApplication.webClientMaps(mapsEndpoint);
        mapsClient = new MapsClient(maps, new ModelMapper());
        Location location = new Location(20.0, 30.0);
        car.setLocation(mapsClient.getAddress(location));

        return car;
    }

    /**
     * Either creates or updates a vehicle, based on prior existence of car
     * @param car A car object, which can be either new or existing
     * @return the new/updated car is stored in the repository
     */
    public Car save(Car car) {
        if (car.getId() != null) {
            return repository.findById(car.getId())
                    .map(carToBeUpdated -> {
                        carToBeUpdated.setDetails(car.getDetails());
                        carToBeUpdated.setLocation(car.getLocation());
                        return repository.save(carToBeUpdated);
                    }).orElseThrow(CarNotFoundException::new);
        }

        return repository.save(car);
    }

    /**
     * Deletes a given car by ID
     * @param id the ID number of the car to delete
     */
    public void delete(Long id) {
        /**
         * TODO: Find the car by ID from the `repository` if it exists.
         *   If it does not exist, throw a CarNotFoundException
         */
        Car car;
        Optional<Car> optionalCar = repository.findById(id);
        if(optionalCar.isPresent())
            car = optionalCar.get();
        else
            throw new CarNotFoundException();

        /**
         * TODO: Delete the car from the repository.
         */
        repository.delete(car);
    }

}