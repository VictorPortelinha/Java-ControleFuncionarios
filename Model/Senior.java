package Model;

public class Senior extends Funcionario {
    public Senior(String nome,int idade,String cpf,String cargo,double salario,double bonus){
        super(nome,idade,cpf,cargo,salario,bonus);}
    public double calcSalario(){
        return salario * (this.bonus * 3);
    }
}
