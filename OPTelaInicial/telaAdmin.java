package OPTelaInicial;
import Model.Endereco;
import Model.CEO;
import Model.Empresa;
import ConnectionDB.DB;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class telaAdmin {
    Empresa empresaLogada;

    CEO ceoLogado;
    private int idCEO;

    private int op;

    public telaAdmin(int idEmpresa, int idCEO) throws SQLException {
        DB banco = new DB();

        ResultSet resultSetEmpresa = banco.selectEmpresaByID(idEmpresa); // criando as variaveis para criar o objeto da empresa

        int idEndereco = 0;
        String nome = "";
        String cnpj = "";

        while(resultSetEmpresa.next()){
            nome = resultSetEmpresa.getString("nome");
            cnpj = resultSetEmpresa.getString("cnpj");
            idEndereco = resultSetEmpresa.getInt("id_endereco");

        }
        resultSetEmpresa = banco.selectEnderecoByID(idEndereco);
        Endereco enderecoEmpresa = null;

        while(resultSetEmpresa.next()){
            String rua = resultSetEmpresa.getString(2);
            int numero = resultSetEmpresa.getInt(3);
            String cidade = resultSetEmpresa.getString(4);
            String estado = resultSetEmpresa.getString(5);
            String cep = resultSetEmpresa.getString(6);
            enderecoEmpresa =  new Endereco(rua,numero,cidade,estado,cep);
        }

        resultSetEmpresa = banco.selectCEOByID(idCEO);
        while(resultSetEmpresa.next()){
            String nomeCEO = resultSetEmpresa.getString(2);
            int idadeCEO = resultSetEmpresa.getInt(3);
            String cpfCEO = resultSetEmpresa.getString(4);
            ceoLogado = new CEO(nomeCEO,idadeCEO,cpfCEO);
        }
        empresaLogada = new Empresa(nome,enderecoEmpresa,cnpj,idEmpresa);
        ceoLogado.logar();


    }

    public void execute() {
        while(ceoLogado.isLogado()){
            showOperations();
            controlOperation();
            operationSwitch();
            }
        }
    public void showOperations() {

        System.out.println("1. Registrar funcionário");
        System.out.println("2. Gerar planilha");
        System.out.println("3. Cadastrar Clientes");
        System.out.println("4. Visualizar Clientes");
        System.out.println("5. Visualizar dados da Empresa");
        System.out.println("6. Deslogar");


    }

    public void controlOperation() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("Digite o número da operação: ");
            try {
                op = scanner.nextInt();
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("Esse input não é valido, tente novamente");
                scanner = new Scanner(System.in);
            }
        }
    }

    public void operationSwitch(){
        switch(op) {
            case 1:
                cadastroFuncionario cadastroFuncionario = new cadastroFuncionario();
                cadastroFuncionario.execute(empresaLogada);

            case 2:
                Planilha planilha = new Planilha();
                planilha.gerarPlanilha(empresaLogada);
                execute();
            case 3:
                cadastroCliente cadastroCliente = new cadastroCliente();
                cadastroCliente.execute(empresaLogada);

            case 4:
                empresaLogada.mostrarClientes();
                execute();
            case 5:
                empresaLogada.showDados();
                execute();


            case 6:
                ceoLogado.sair();
                break;

        }

}

}
