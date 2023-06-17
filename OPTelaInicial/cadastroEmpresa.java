package OPTelaInicial;
import Model.Endereco;
import Model.Empresa;

import java.util.InputMismatchException;
import java.util.Scanner;

public class cadastroEmpresa {
    private String nome;
    private int idade;
    private Endereco endereco;
    private String cargo;
    private Double salario;
    
    private String rua; 
    private int numero; 
    private String cidade; 
    private String estado; 
    private String cep;
    
    public cadastroEmpresa(){
        cargo = "CEO";
    }
    
    private boolean isEmpty(String input){
        return String.valueOf(input).length() == 0;
    }
    
    public void execute () {
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.println("Informe o seu nome: ");
                nome = scanner.next();
                System.out.println("Informe sua idade: ");
                idade = scanner.nextInt();
                System.out.println("Informe o seu salário: ");
                salario = scanner.nextDouble();
                System.out.println("Informe a sua rua: ");
                rua = scanner.next();
                System.out.println("Informe o número: ");
                numero = scanner.nextInt();
                System.out.println("Informe a cidade: ");
                cidade = scanner.next();
                System.out.println("Informe o estado: ");
                estado = scanner.next();
                System.out.println("Informe o CEP: ");
                cep = scanner.next();
                endereco = new Endereco(rua,numero,cidade,estado,cep);
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("Esse input não é valido, tente novamente");
                scanner = new Scanner(System.in);
            }
        }
         
       
            
    }
}
