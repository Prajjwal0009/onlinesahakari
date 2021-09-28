package repo;

import model.BaseModelList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class BaseRepository<T> {
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost/test";

    //  Database credentials
    final String USER = "root";
    final String PASS = "";

    Connection conn = null;
    Statement stmt = null;

    public abstract String getInsertStatement(T model);
    public abstract String getUpdateStatement(T model);
    public abstract String getSelectStatement();
    public abstract String getSingleSelectStatement(int id);
    public abstract String getDeleteStatement(int id);

    public BaseRepository() throws Exception{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        }
        catch (Exception ex){
            throw ex;
        }
    }

    private int executeStatement(String statement) throws Exception{
        stmt = conn.createStatement();
        return stmt.executeUpdate(statement);
    }

    private ResultSet executeQuery(String statement) throws Exception{
        stmt = conn.createStatement();
        return stmt.executeQuery(statement);
    }

    public int Add(T model) throws Exception{
        String stmt= getInsertStatement(model);
        return executeStatement(stmt);
    }

    public int Update(T model) throws Exception{
        return executeStatement(getUpdateStatement(model));
    }

    public abstract T MapData(ResultSet rs) throws  Exception;

    public BaseModelList<T> GetAll() throws Exception{
        String stmt = getSelectStatement();
        ResultSet rs = executeQuery(stmt);

        BaseModelList<T> modelList = new BaseModelList<T>();
        //STEP 5: Extract data from result set
        while(rs.next()) {
            modelList.add(MapData(rs));
        }
        return modelList;
    }

    public T GetSingle(int id) throws Exception{
        ResultSet rs = executeQuery(getSingleSelectStatement(id));

        BaseModelList<T> modelList = new BaseModelList<T>();
        while(rs.next()) {
            modelList.add(MapData(rs));
        }

        if (modelList.size() > 0)
            return modelList.get(0);

        return null;
    }

    public int Delete(int id) throws Exception{
        return executeStatement(getDeleteStatement(id));
    }
}
