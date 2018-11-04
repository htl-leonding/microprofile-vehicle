package at.htl.vehicle.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "VEH_VEHICLE")
public class Vehicle {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "V_ID")
    private Long id;

    @Column(name = "V_BRAND")
    @Size(min = 2, max = 50, message = "Brand must be between 2 and 50 Characters")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Brand may contain only letters and numbers")
    private String brand;

    @Column(name = "V_MODEL")
    private String model;

    @Column(name = "V_BODY_STYLE")
    @Enumerated(EnumType.STRING)
    private BodyStyle bodyStyle;

    //region Constructors
    public Vehicle(String brand, String model, BodyStyle bodyStyle) {
        this.setBrand(brand);
        this.setModel(model);
        this.setBodyStyle(bodyStyle);
    }

    public Vehicle() {
    }
    //endregion


    //region Getter and Setter
    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BodyStyle getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(BodyStyle bodyStyle) {
        this.bodyStyle = bodyStyle;
    }
    //endregion

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", bodyStyle=" + bodyStyle +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id);
    }

}
