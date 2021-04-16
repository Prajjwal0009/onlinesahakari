package repo;

import model.AreaModel;
import java.sql.ResultSet;

public class AreaModelRepository extends BaseRepository<AreaModel> {

    public AreaModelRepository() throws Exception {
    }
    @Override
    public String getInsertStatement(AreaModel model){
        return  "INSERT INTO area (areaId,name,description)" +
                " VALUES ("+model.areaId+ ",'"+model.name+"','"+model.description+ "')";
    }

    @Override
    public String getUpdateStatement(AreaModel model){
        return  "UPDATE area SET name = '" + model.name + ",'"+
                "description='"+ model.description +"','\"+\n" + " WHERE areaId = "+ model.areaId + "";
    }

    @Override
    public String getSelectStatement() {
        return "SELECT areaId,name,description";
    }

    @Override
    public String getSingleSelectStatement(int id) {
        return "SELECT name,description from area WHERE areaId="+ id;
    }

    @Override
    public String getDeleteStatement(int id) {
        return "DELETE from area WHERE areaId="+ id;
    }

    @Override
    public AreaModel MapData(ResultSet rs) throws Exception{
        var area = new AreaModel();
        area.setAreaId(rs.getInt("areaId"));
        area.setName(rs.getString("name"));
        area.setDescription(rs.getString("description"));
        return area;
    }


    public AreaModel getSingle(int id) {
    return getSingle(id);
    }

}

