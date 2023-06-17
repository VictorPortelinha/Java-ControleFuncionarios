package OPTelaInicial;
import Model.Endereco;
import Model.Empresa;
import ConnectionDB.DB;
import com.mysql.cj.protocol.Resultset;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class cadastroEmpresa {
    private String nome;
    private String senha;
    private int idade;
    private String cargo;
    private Double salario;
    private String cpf;

    private String nomeEmpresa;
    private String cnpj;
    
    private String rua; 
    private int numero; 
    private String cidade; 
    private String estado; 
    private String cep;
    
   
    
    public cadastroEmpresa(){
        cargo = "CEO";
    }
    
    public void execute () {
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.println("-----Cadastro de empresa-----");
                System.out.println("Informe o seu nome: ");
                nome = scanner.nextLine();
                System.out.println("Informe sua senha: ");
                senha = scanner.nextLine();
                System.out.println("Informe sua idade: ");
                idade = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Informe o seu salario: ");
                salario = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Informe o seu CPF: ");
                cpf = scanner.nextLine();
                System.out.println("Informe a rua da empresa: ");
                rua = scanner.nextLine();
                System.out.println("Informe o numero da empresa: ");
                numero = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Informe a cidade da empresa: ");
                cidade = scanner.nextLine();
                System.out.println("Informe o estado da empresa: ");
                estado = scanner.nextLine();
                System.out.println("Informe o CEP da empresa: ");
                cep = scanner.nextLine();
                System.out.println("Informe o nome da empresa: ");
                nomeEmpresa = scanner.nextLine();
                System.out.println("Informe o CNPJ da empresa: ");
                cnpj = scanner.nextLine();
                finalizar_cadastro();
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("Esse input não é valido, tente novamente");
                scanner = new Scanner(System.in);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        
    }
    private void finalizar_cadastro () throws SQLException {
        DB banco = new DB();
        banco.insertEndereco(rua,numero,cidade,estado,cep);
        int idEndereco = banco.selectMaxIdValue("SELECT MAX(id) AS max_id FROM tb_Enderecos");
        banco.insertEmpresa(nomeEmpresa,cnpj,idEndereco);
        int idEmpresa = banco.selectMaxIdValue("SELECT MAX(id) AS max_id FROM tb_Empresa");
        banco.insertCEO(nome,idade,cpf,senha,idEmpresa);
        
        
    }
}
