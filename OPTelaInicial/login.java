// Package not sdetected, please report project structure on CodeTogether's GitHub Issues
package OPTelaInicial;
import ConnectionDB.DB;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.sql.*;


public class login {
    private String cpf;
    private String senha;

    public login(){}

    public void execute () {
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.println("Informe o CPF:");
                cpf = scanner.nextLine();
                System.out.println("Informe a Senha");
                senha = scanner.nextLine();
                finalizar_login();
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
    private boolean finalizar_login () throws SQLException {
        DB banco = new DB();
        ResultSet resultSet = banco.selectCEO();
        while(resultSet.next()){
            String nome = resultSet.getString("nome");
            String senha = resultSet.getString("senha");
            int idade = resultSet.getInt("idade");
            String cpf = resultSet.getString("cpf");
            int idEmpresa = resultSet.getInt("id_empresa");
            if (this.cpf.equals(cpf) && this.senha.equals(senha)){

            }
        }

    }
}
