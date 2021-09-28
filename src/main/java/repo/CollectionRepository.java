package repo;

import model.CollectionModel;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class CollectionRepository extends BaseRepository<CollectionModel> {

    public CollectionRepository() throws Exception {
    }
    @Override
    public String getInsertStatement(CollectionModel model){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return  "INSERT INTO collection(id,collectorId,customerId,collectionDate,amount,receivedBy) VALUES ("
                + model.id + ",'"
                + model.collectorId +"','"
                + model.customerId + "','"
                + format.format(model.collectionDate) + "','"
                + model.amount + "','"
                + model.receivedBy + "')";
    }
    @Override
    public String getUpdateStatement(CollectionModel model){
        return  "UPDATE collection SET collectorId = '" + model.collectorId + ",'"+
                "customerId='"+ model.customerId +"','\"+\n" +
                "collectionDate='"+ model.collectionDate +"','\"+\n" +
                "amount='"+ model.amount +"','\"+\n" +
                "receivedBy='"+ model.receivedBy +"','\"+\n" + " WHERE id = "+ model.id + "";
    }

    @Override
    public String getSelectStatement() {
        return "SELECT id,collectorId,customerId,collectionDate,amount,receivedBy from collection";
    }

    @Override
    public String getSingleSelectStatement(int id) {
        return "SELECT collectorId,customerId,collectionDate,amount,receivedBy from collection WHERE id="+ id;
    }

    @Override
    public String getDeleteStatement(int id) {
        return "DELETE from collection WHERE id="+ id;
    }

    @Override
    public CollectionModel MapData(ResultSet rs) throws Exception{
        var collection = new CollectionModel();
        collection.setId(rs.getInt("id"));
        collection.setCollectorId(rs.getInt("collectorId"));
        collection.setCustomerId(rs.getInt("customerId"));
        collection.setCollectionDate(rs.getDate("collectionDate"));
        collection.setAmount(rs.getDouble("amount"));
        collection.setReceivedBy(rs.getString("receivedBy"));
        return collection;
    }


}

