package repo;
import model.CollectorModel;
import java.sql.ResultSet;


public class CollectorRepository extends BaseRepository<CollectorModel> {

    public CollectorRepository() throws Exception {
    }

    @Override
    public String getInsertStatement(CollectorModel model){
        return  "INSERT INTO collector(id,name,address)" +
                "VALUES ("+model.id + ",'"+ model.name +"','"+ model.address + "')";
    }

    @Override
    public String getUpdateStatement(CollectorModel model){
        return  "UPDATE collector SET name = '" + model.name + "',"+
                "address='"+ model.address +"'" +
                " WHERE id = "+ model.id + "";
    }

    @Override
    public String getSelectStatement() {
        return "SELECT id,name,address from collector";
    }

    @Override
    public String getSingleSelectStatement(int id) {
        return "SELECT id, name,address from collector WHERE id="+ id;
    }

    @Override
    public String getDeleteStatement(int id) {
        return "DELETE from collector WHERE id="+ id;
    }

    @Override
    public CollectorModel MapData(ResultSet rs) throws Exception{
        var collector = new CollectorModel();
        collector.setId(rs.getInt("id"));
        collector.setName(rs.getString("name"));
        collector.setAddress(rs.getString("address"));
        return collector;
    }


}
