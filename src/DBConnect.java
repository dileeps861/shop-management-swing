import java.sql.*;
public class DBConnect {
    
    public Connection conn;
    public DBConnect() throws Exception
    {
       Class.forName("com.mysql.cj.jdbc.Driver");
        // loading driver
     conn = DriverManager.getConnection(
       "jdbc:mysql://localhost:3306/shopmanagement",
             "root","rootroot");
        // Connection
        conn.setAutoCommit(false);
    }
    public void queryExecuter(String sql)
            throws Exception
    {
        Statement stat = conn.createStatement();
        stat.execute(sql);
        stat.close();
    }
    public void commit(){
        try {
            if(conn != null && !conn.isClosed()){
                conn.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void closeConnection(){
        try {

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Statement queryExecuterWithoutAutoCommit()
            throws Exception
    {
        Statement stat = conn.createStatement();
       return  stat;
    }

    public PreparedStatement queryExecuterPreparedStmt(String sql)
            throws Exception
    {
        PreparedStatement statement = conn.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);
        return  statement;
    }


    public ResultSet queryReturner(String sql)
            throws Exception
    {
       Statement stat = conn.createStatement();
       ResultSet rs = stat.executeQuery(sql);
       return rs;
    }
}
