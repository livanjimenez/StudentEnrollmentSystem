public class Address {
    private String street;
    private String city;
    private String zip_code;
    private String state;

    public Address(String street, String city, String zip_code, String state) {
        this.street = street;
        this.city = city;
        this.zip_code = zip_code;
        this.state = state;
    }

    public Address() {
        street = "355 NW 107 AVE";
        state = "FL";
        city = "Miami";
        zip_code = "33177";
    }

    public String getStreet () {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode(){
        return zip_code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    } 

    public void setZipCode(String zip_code) {
        this.zip_code = zip_code;
    }

    public String toString() {
        return "Address: " + street + "\n\t " + city + ", " + state + "\n\t " + zip_code;
    }
}