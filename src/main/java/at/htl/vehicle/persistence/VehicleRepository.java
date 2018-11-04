package at.htl.vehicle.persistence;

import at.htl.vehicle.model.Vehicle;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class VehicleRepository extends Repository<Vehicle> {

    public VehicleRepository() {
        super(Vehicle.class);
    }

}
