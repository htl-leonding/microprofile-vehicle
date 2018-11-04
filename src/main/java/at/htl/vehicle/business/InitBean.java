package at.htl.vehicle.business;

import at.htl.vehicle.model.BodyStyle;
import at.htl.vehicle.model.Vehicle;
import at.htl.vehicle.persistence.VehicleRepository;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class InitBean {

    @Inject
    VehicleRepository vehicleRepository;

    public InitBean() {
    }

    @PostConstruct
    private void init() {
        Vehicle kapitaen = new Vehicle("Opel", "Kapitän", BodyStyle.SEDAN);
        System.out.println(vehicleRepository.save(kapitaen));
    }
}
