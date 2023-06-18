package OPTelaInicial;
import Model.Endereco;
import Model.Empresa;
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
    private String email;


    public void execute(){
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
                System.out.println("Informe o email do cliente:");
                email = scanner.nextLine();
                break;
            }catch(InputMismatchException e){
                System.out.println("Um erro ocorreu, tente novamente");
            }
        }
    }
}
