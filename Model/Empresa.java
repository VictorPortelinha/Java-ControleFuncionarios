package Model;

import java.util.ArrayList;

public class Empresa {
    private String nome;
    private Endereco endereco;
    private String cnpj;
    private final ArrayList<Funcionario> funcionarios;
    
    public Empresa(String nome, Endereco endereco, String cnpj, ArrayList<Funcionario> funcionarios) {
        this.nome = nome;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.funcionarios = new ArrayList<>();
    }

   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

   
    
    
}
