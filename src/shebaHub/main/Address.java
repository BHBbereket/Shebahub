package shebaHub.main;

public class Address {

    private String city;
    private String zipCode;

    public Address(){}

    public Address(String city, String zipCode) {
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
