package pl.gatomek.mapstruct.model;

public class Producer {
    private String name;
    private Address address;

    public Producer() {
    }

    public Producer(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public static Producer of(String name, Address address) {
        return new Producer(name, address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
