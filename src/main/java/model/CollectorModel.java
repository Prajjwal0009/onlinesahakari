package model;
public class CollectorModel {
    public int id;
    public String name;
    public String address;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String contact;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "{" +
                "\"id\":\"" + id + "\"" +
                ", \"name\":" + name + "\"" +
                ", \"address\":\"" + address + "\"" +
                ", \"contact\":\"" + contact + "\"" +
                "}";
    }
}
