package Model;

public class Estagiario extends Funcionario {
    public Estagiario(String nome,int idade,String cpf,String cargo,double salario,double bonus){
        super(nome,idade,cpf,cargo,salario,bonus);}
    public double calcSalario(){
        return salario + bonus;
    }
}
