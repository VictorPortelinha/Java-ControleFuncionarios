package ConnectionDB;
import java.sql.*;

public class DB {
        String url = "jdbc:mysql://localhost:3306/controlefuncionarios";
        String username = "root";
        String password = "123456";
        java.sql.Connection connection;
        public DB(){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");

                 connection = DriverManager.getConnection(url, username, password);
            }catch (Exception e) {
                System.out.println(e);
            }
        }
        public ResultSet selectCEO() {
            ResultSet resultSet = null;
            try {
                String query = "SELECT * FROM TB_CEO";
                Statement statement = connection.createStatement();

                resultSet = statement.executeQuery(query);
                
                
            } catch (Exception e) {
                System.out.println(e);
            }
            return resultSet;
        }

    public int selectMaxIdValue(String query) {
        ResultSet resultSet = null;
        int id = -1;
        try {
            Statement statement = connection.createStatement();

            resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                id = resultSet.getInt("max_id");
            }


        } catch (Exception e) {
            System.out.println(e);
        }
        return id;
    }
        
        
        
    
        public void crud(String query) {
            try {
                
                Statement statement = connection.createStatement();
    
                int result = statement.executeUpdate(query);
                if(result == 1){
                    System.out.println("Dados inseridos com sucesso!");
                }
    
                
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    public void insertEndereco(String rua,int numero,String cidade, String estado, String cep) {
        try {
            
            String query = "INSERT INTO TB_ENDERECOS(rua,numero,cidade,estado,cep) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, rua);
            statement.setInt(2, numero);
            statement.setString(3, cidade);
            statement.setString(4, estado);
            statement.setString(5, cep);
            
            int result = statement.executeUpdate(); 
            if(result == 1){
                System.out.println("Dados inseridos com sucesso!");
            }

            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertEmpresa(String nome, String cnpj, int id_endereco) {
        try {

            String query = "INSERT INTO TB_Empresa(nome,cnpj,id_endereco) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nome);
            statement.setString(2, cnpj);
            statement.setInt(3, id_endereco);
           

            int result = statement.executeUpdate();
            if(result == 1){
                System.out.println("Dados inseridos com sucesso!");
            }

            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void insertCEO(String nome,int idade,String cpf, String senha,int id_empresa){
        try {

            String query = "INSERT INTO TB_CEO(nome,idade,cpf,senha,id_empresa) VALUES (?, ?, ?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nome);
            statement.setInt(2, idade);
            statement.setString(3, cpf);
            statement.setString(4,senha);
            statement.setInt(5,id_empresa);


            int result = statement.executeUpdate();
            if(result == 1){
                System.out.println("Dados inseridos com sucesso!");
            }


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
