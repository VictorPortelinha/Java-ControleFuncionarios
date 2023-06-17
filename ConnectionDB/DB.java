package ConnectionDB;
import java.sql.*;

public class DB {
        String url = "jdbc:mysql://localhost:3306/controlefuncionarios";
        String username = "root";
        String password = "123456";
        
    
        public void select(String query) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
    
                java.sql.Connection connection = DriverManager.getConnection(url, username, password);
    
                Statement statement = connection.createStatement();
    
    
                ResultSet resultSet = statement.executeQuery(query);
    
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
    
                }
    
                connection.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    
        public void crud(String query) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
    
                java.sql.Connection connection = DriverManager.getConnection(url, username, password);
    
                Statement statement = connection.createStatement();
    
                int result = statement.executeUpdate(query);
                if(result == 1){
                    System.out.println("Dados inseridos com sucesso!");
                }
    
                connection.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
}
