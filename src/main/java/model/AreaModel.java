package model;

public class AreaModel implements BaseModel {
    public int areaId;
    public String name;
    public String description;


    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + areaId + "\"" +
                ", \"name\":" + name + "\"" +
                ", \"description\":\"" + description + "\"" +
                "}";
    }
}
