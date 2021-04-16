package model;

import java.util.Date;

public class CollectionModel {
    public int id;
    public int collectorId;
    public int customerId;
    public double amount;
    public Date collectionDate;
    public String receivedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(int collectorId) {
        this.collectorId = collectorId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(Date collectionDate) {
        this.collectionDate = collectionDate;
    }

    public String getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(String receivedBy) {
        this.receivedBy = receivedBy;
    }
    public String toString() {
        return "{" +
                "\"id\":\"" + id + "\"" +
                ", \"amount\":" + amount + "\"" +
                ", \"collectionDate\":\"" + collectionDate + "\"" +
                ", \"collectorId\":" + collectorId + "\"" +
                ", \"customer\":" + customerId + "\"" +
                ", \"receivedBy\":" + receivedBy + "\"" +
                "}";
    }

}
