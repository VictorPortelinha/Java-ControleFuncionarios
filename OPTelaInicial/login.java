
package OPTelaInicial;
import ConnectionDB.DB;
import Model.Empresa;

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
        ResultSet resultSetCEO = banco.selectCEO();
        
        if(resultSetCEO.next()){
            while(resultSetCEO.next()){
                int idCEO = resultSetCEO.getInt("id");
                String senha = resultSetCEO.getString("senha");
                String cpfCEO = resultSetCEO.getString("cpf");
                int idEmpresa = resultSetCEO.getInt("id_empresa");

                if (this.cpf.equals(cpfCEO)){
                    if(this.senha.equals(senha)){
                        telaAdmin telaAdmin = new telaAdmin(idEmpresa, idCEO);
                        telaAdmin.execute();
                    }else{
                        System.out.println("Senha incorreta, tente novamente");
                    }
                }else{
                    System.out.println("Usuário  " + cpfCEO + " não está cadastrado no sistema");
                }
            }
        }else{
            System.out.println("Não há usuarios cadastrados");
        }


        return false;
    }
}
