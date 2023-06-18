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
    public void closeConn() throws SQLException{
        connection.close();
    }
    public ResultSet selectEmpresaByID(int idEmpresa) {
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM TB_Empresa WHERE id=" + idEmpresa;
            System.out.println(query);
            Statement statement = connection.createStatement();

            resultSet = statement.executeQuery(query);


        } catch (Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }
    public ResultSet selectEnderecoByID(int idEndereco) {
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM TB_Enderecos WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idEndereco);
            resultSet = statement.executeQuery();


        } catch (Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }
    public ResultSet selectCEOByID(int idCEO) {
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM TB_CEO WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idCEO);
            resultSet = statement.executeQuery();


        } catch (Exception e) {
            System.out.println(e);
        }
        return resultSet;
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
    public void insertFuncionario(String nome,int idade,String cpf, int tipoFuncionario,int id_empresa, String cargo, double salario, double bonus){
        try {

            String query = "INSERT INTO TB_Funcionario(nome,idade,id_empresa,cpf,id_empresa,tipoFuncionario,cargo,salario,bonus) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nome);
            statement.setInt(2, idade);
            statement.setInt(3, id_empresa);
            statement.setString(4,cpf);
            statement.setInt(5,id_empresa);
            statement.setInt(6,tipoFuncionario);
            statement.setString(7,cargo);
            statement.setDouble(8,salario);
            statement.setDouble(9,bonus);


            int result = statement.executeUpdate();
            if(result == 1){
                System.out.println("Dados inseridos com sucesso!");
            }


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
