package repo;

import model.AreaModel;
import model.CustomerModel;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerRepository extends BaseRepository<CustomerModel> {

    public CustomerRepository() throws Exception {
    }

    @Override
    public String getInsertStatement(CustomerModel model){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        return  "INSERT INTO customer (id,name,address,contact,areaId, startDate,endDate,isActive) VALUES ("
                + model.id + ",'"
                + model.name +"','"
                + model.address + "','"
                + model.contact + "','"
                + model.areaId + "','"
                + format.format(model.startDate) + "','"
                + format.format(model.endDate) + "',"
                + model.isActive + ")";
    }

    @Override
    public String getUpdateStatement(CustomerModel model){
        return  "UPDATE customer SET name = '" + model.name + "',"+
                "address='"+ model.address +"',\"+\n" +
                "contact='"+ model.contact +"',\"+\n" +
                "areaId='"+ model.areaId +"',\"+\n" +
                "endDate='"+ model.endDate +"',\"+\n" +
                "startDate='"+ model.startDate +"'" +
                "isActive='"+ model.isActive +"','\"+\n" +" WHERE id = "+ model.id + "";
    }

    @Override
    public String getSelectStatement() {
        return "SELECT id,name,address,contact,startDate,endDate,isActive,areaId from customer";
    }

    @Override
    public String getSingleSelectStatement(int id) {
        return "SELECT name,address,contact,startDate,endDate,isActive,areaId from customer WHERE id="+ id;
    }

    @Override
    public String getDeleteStatement(int id) {
        return "DELETE from customer WHERE id="+ id;
    }

    private AreaModel getArea(int id) throws Exception {
        var repo = new AreaModelRepository();
         return repo.getSingle(id);
    }

    @Override
    public CustomerModel MapData(ResultSet rs) throws Exception{
        var customer = new CustomerModel();
        customer.setId(rs.getInt("id"));
        customer.setName(rs.getString("name"));
        customer.setAddress(rs.getString("address"));
        customer.setContact(rs.getString("contact"));
        customer.setStartDate(rs.getDate("startDate"));
        customer.setEndDate(rs.getDate("endDate"));
        customer.setActive(rs.getBoolean("isActive"));
        customer.setAreaId(rs.getInt("areaId"));
        /*
        if(customer.getAreaId() > 0)
            customer.setArea(getArea(customer.getAreaId()));

         */
        return customer;
    }


}

