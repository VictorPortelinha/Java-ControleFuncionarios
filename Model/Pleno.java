package Model;

public class Pleno extends Funcionario{
    public Pleno(String nome,int idade,String cpf,String cargo,double salario,double bonus){
        super(nome,idade,cpf,cargo,salario,bonus);}
    public double calcSalario(){
        return salario * (this.bonus * 2);
    }
}
