package Model;

public class CEO extends Funcionario {



    private boolean logado;
    public CEO(String nome, int idade, String cpf){
        super(nome, idade, cpf);
        this.logado = false;
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
