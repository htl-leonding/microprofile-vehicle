package at.htl.vehicle.model;

public class Vehicle {

    private Long id;
    private String brand;
    private String model;
    private BodyStyle bodyStyle;

    public Vehicle(String brand, String model, BodyStyle bodyStyle) {
        this.setBrand(brand);
        this.setModel(model);
        this.setBodyStyle(bodyStyle);
    }

    public Vehicle() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", bodyStyle=" + bodyStyle +
                '}';
    }
}
