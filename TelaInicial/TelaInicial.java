package TelaInicial;
import Cadastro.cadastro;
import java.util.Scanner;
import java.util.InputMismatchException;
public class TelaInicial {
    private int op;

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
                cadastro cadastro = new cadastro();
                cadastro.execute();
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}
