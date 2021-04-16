package model;

public class CollectorAreaMapping {
    public int id;

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

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public int collectorId;
    public int areaId;

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id + "\"" +
                ", \"collectorId\":" + collectorId + "\"" +
                ", \"areaId\":" + areaId + "\"" +
                "}";
    }
}
