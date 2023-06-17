package Model;

public class CEO extends Funcionario {

    private double bonus;

    private boolean logado;
    public CEO(String nome, int idade, Endereco endereco, String cargo, double salario,double bonus,String cpf){
        super(nome, idade, endereco, cargo, salario,cpf);
        this.logado = false;
        this.bonus = bonus;
    }

    public boolean isLogado(){
        return logado;
    }
    public void logar(){
        this.logado = true;
    }
    
    public void sair(){
        this.logado = false;
    }
    
}
