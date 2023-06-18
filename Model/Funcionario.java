package Model;

import java.util.ArrayList;

public class Funcionario extends Pessoa {
    protected String cargo;
    protected double salario;
    protected double bonus;

    public Funcionario(String nome, int idade, String cpf) {
        super(nome, idade, cpf);
    }

    public Funcionario(String nome, int idade, String cpf, String cargo, double salario,double bonus) {
        super(nome, idade, cpf);
        this.cargo = cargo;
        this.salario = salario;
        this.bonus = bonus;
    }

    public double calcSalario(){
        return salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int getIdade() {
        return idade;
    }

    @Override
    public void setIdade(int idade) {
        this.idade = idade;
    }


    @Override
    public String toString() {
        return null;
    }
}
