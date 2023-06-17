package Model;

public class CEO extends Funcionario {



    private boolean logado;
    public CEO(String nome, int idade, Endereco endereco, String cargo,String cpf){
        super(nome, idade, endereco, cargo,cpf);
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
