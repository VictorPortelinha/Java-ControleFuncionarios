package OPTelaInicial;
import Model.*;
import ConnectionDB.DB;
import com.mysql.cj.protocol.Resultset;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class cadastroCliente {
    private String nome;
    private int idade;
    private String cpf;



    public void execute(Empresa empresa){
        while(true){
            Scanner scanner = new Scanner(System.in);
            try{
                System.out.println("Informe o nome do cliente: ");
                nome = scanner.nextLine();
                System.out.println("Informe a idade do cliente: ");
                idade = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Informe o CPF do cliente:");
                cpf = scanner.nextLine();
                finalizarCadastro(empresa);
                break;

            }catch(InputMismatchException e){
                System.out.println("Um erro ocorreu, tente novamente");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void finalizarCadastro (Empresa empresa) throws SQLException{
        DB banco = new DB();

        try{
            banco.insertCliente(nome,idade,cpf,empresa.getId());

            System.out.println("O novo cliente foi cadastrado com sucesso");
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
