package repo;
import model.CollectorModel;
import java.sql.ResultSet;


public class CollectorRepository extends BaseRepository<CollectorModel> {

    public CollectorRepository() throws Exception {
    }

    @Override
    public String getInsertStatement(CollectorModel model){
        String query = "INSERT INTO collector (id, name,address,contact) VALUES ("+ model.id +",'"+ model.name +"','"+ model.address + "','"+ model.contact + "')";
        return  query;
    }

    @Override
    public String getUpdateStatement(CollectorModel model){
        return  "UPDATE collector SET name = '" + model.name + "',"+
                "address='"+ model.address +"'" +
                "contact='"+ model.contact +"'" +
                " WHERE id = "+ model.id + "";
    }

    @Override
    public String getSelectStatement() {
        return "SELECT id,name,address,contact from collector";
    }

    @Override
    public String getSingleSelectStatement(int id) {
        return "SELECT id, name,address,contact from collector WHERE id="+ id;
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
        collector.setContact(rs.getString("contact"));
        return collector;
    }


}
