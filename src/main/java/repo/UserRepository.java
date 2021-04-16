package repo;
import model.UserModel;
import java.sql.ResultSet;


public class UserRepository extends BaseRepository<UserModel> {

    public UserRepository() throws Exception {
    }

    @Override
    public String getInsertStatement(UserModel model){
        return  "INSERT INTO user(id,userName,password,displayName) " +
                "VALUES ("+model.id + ",'"+ model.userName +"','"+ model.password + "','"+ model.displayName + "')";
    }

    @Override
    public String getUpdateStatement(UserModel model){
        return  "UPDATE user SET userName = '" + model.userName + ",'"+
                "password='"+ model.password +"','\"+\n" +
                "displayName='"+ model.displayName +"','\"+\n" +
                " WHERE id = "+ model.id + "";
    }

    @Override
    public String getSelectStatement() {
        return "SELECT id,userName,password,displayName from user";
    }

    @Override
    public String getSingleSelectStatement(int id) {
        return "SELECT userName,password,displayName from user WHERE id="+ id;
    }

    @Override
    public String getDeleteStatement(int id) {
        return "DELETE from user WHERE id="+ id;
    }

    @Override
    public UserModel MapData(ResultSet rs) throws Exception{
        var user = new UserModel();
        user.setId(rs.getInt("id"));
        user.setUserName(rs.getString("userName"));
        user.setPassword(rs.getString("password"));
        user.setDisplayName(rs.getString("displayName"));
        return user;
    }


}
