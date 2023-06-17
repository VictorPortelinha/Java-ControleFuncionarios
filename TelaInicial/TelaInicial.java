package TelaInicial;
import OPTelaInicial.cadastroEmpresa;
import OPTelaInicial.login;
import java.util.Scanner;
import java.util.InputMismatchException;
public class TelaInicial {
    private int op;
    private boolean sair;

    public TelaInicial(){
        sair = false;
    }
    public void execute() {
        showOperations();
        controlOperation();
        operationSwitch();


    }

    public void showOperations() {
        System.out.println("1. Cadastrar Empresa");
        System.out.println("2. Logar-se no sistema");
        System.out.println("3. Sair");
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
        switch(op){
            case  1:
                cadastroEmpresa cadastro = new cadastroEmpresa();
                cadastro.execute();
              break;
            case 2:
                login login = new login();
                login.execute();
                break;
            case 3:
                setSair(true);
                break;

        }
    }

    public boolean getSair() {
        return sair;
    }

    public void setSair(boolean sair) {
        this.sair = sair;
    }
}
