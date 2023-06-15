package Model;

public class CEO extends Funcionario {
    private String departamento;
    private double bonus;

    private boolean logado;
    public CEO(String nome, int idade, String endereco, String cargo, double salario, String departamento, double bonus) {
        super(nome, idade, endereco, cargo, salario);
        this.departamento = departamento;
        this.bonus = bonus;
        logado = false;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
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
