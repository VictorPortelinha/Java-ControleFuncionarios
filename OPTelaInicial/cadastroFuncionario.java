package OPTelaInicial;
import Model.*;
import ConnectionDB.DB;
import com.mysql.cj.protocol.Resultset;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class cadastroFuncionario {

    private String nome;
    private int idade;
    private String cpf;
    private String cargo;
    private double salario;
    private double bonus;


    private int tipoFuncionario;


    public void execute(Empresa empresa){
        while(true){
            Scanner scanner = new Scanner(System.in);
            try{
                System.out.println("Informe o nome do funcionário: ");
                nome = scanner.nextLine();
                System.out.println("Informe a idade do funcionário: ");
                idade = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Informe o CPF do funcionário:");
                cpf = scanner.nextLine();
                System.out.println("Informe o cargo do funcionário:");
                cargo = scanner.nextLine();
                System.out.println("Informe o salário do funcionário:");
                salario = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Informe o tipo de funcionário: ");
                System.out.println("0. Estagiário");
                System.out.println("1. Junior");
                System.out.println("2. Pleno");
                System.out.println("3. Senior");
                tipoFuncionario = scanner.nextInt();
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
            banco.insertFuncionario(nome,idade,cpf,tipoFuncionario,empresa.getId(),cargo,salario,bonus);
            if(tipoFuncionario == 0){
                Funcionario funcionario = new Estagiario(nome,idade,cpf,cargo,salario,bonus);
                empresa.setFuncionarios(funcionario);
            }else if(tipoFuncionario==1){
                Funcionario funcionario = new Junior(nome,idade,cpf,cargo,salario,bonus);
                empresa.setFuncionarios(funcionario);
            }else if(tipoFuncionario==2){
                Funcionario funcionario = new Pleno(nome,idade,cpf,cargo,salario,bonus);
                empresa.setFuncionarios(funcionario);
            }else if(tipoFuncionario==3){
                Funcionario funcionario = new Senior(nome,idade,cpf,cargo,salario,bonus);
                empresa.setFuncionarios(funcionario);
            }
            System.out.println("O novo funcionario foi cadastrado com sucesso");
        }catch(Exception e){
            System.out.println(e);
        }

    }

}
