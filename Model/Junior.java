package Model;

public class Junior extends Funcionario {
    public Junior(String nome,int idade,String cpf,String cargo,double salario,double bonus){
        super(nome,idade,cpf,cargo,salario,bonus);}
    public double calcSalario(){
        return salario * this.bonus;
    }
}
