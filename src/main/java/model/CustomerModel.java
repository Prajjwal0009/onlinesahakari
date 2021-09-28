package model;

import java.util.Date;

public class CustomerModel implements BaseModel {
    public int id;
    public String name;
    public String address;
    public String contact;
    public Date startDate;
    public Date endDate;
    public int areaId;
    public AreaModel area;
    public boolean isActive;

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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public AreaModel getArea() {
        return area;
    }

    public void setArea(AreaModel area) {
        this.area = area;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id + "\"" +
                ", \"name\":\"" + name + "\"" +
                ", \"address\":\"" + address + "\"" +
                ", \"contact\":\"" + contact + "\"" +
                ", \"areaId\":\"" + areaId + "\"" +
                ", \"startDate\":\"" + startDate + "\"" +
                ", \"endDate\":\"" + endDate + "\"" +
                ", \"isActive\":\"" + isActive + "\"" +
                "}";
    }
}
