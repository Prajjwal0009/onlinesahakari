package repo;

import model.CollectorAreaMapping;

import java.sql.ResultSet;

public class CollectorAreaMappingRepository extends BaseRepository<CollectorAreaMapping> {

    public CollectorAreaMappingRepository() throws Exception {
    }
    @Override
    public String getInsertStatement(CollectorAreaMapping model){
        return  "INSERT INTO areamapping (id,areaId,collectorId)" +
                "VALUES ("+model.id + ","+ model.areaId +","+ model.collectorId + ")";
    }

    @Override
    public String getUpdateStatement(CollectorAreaMapping model){
        return  "UPDATE areamapping SET name = '" + model.areaId + ",'"+
                "description='"+ model.collectorId +"','+\n" + " WHERE id = "+ model.id + "";
    }

    @Override
    public String getSelectStatement() {
        return "SELECT id,areaId,collectorId";
    }

    @Override
    public String getSingleSelectStatement(int id) {
        return "SELECT areaId,collectorId from areamapping WHERE id="+ id;
    }

    @Override
    public String getDeleteStatement(int id) {
        return "DELETE from areamapping WHERE id="+ id;
    }

    @Override
    public CollectorAreaMapping MapData(ResultSet rs) throws Exception{
        var areaMapping = new CollectorAreaMapping();
        areaMapping.setId(rs.getInt("id"));
        areaMapping.setAreaId(rs.getInt("areaId"));
        areaMapping.setCollectorId(rs.getInt("collectorId"));
        return areaMapping;
    }


}


