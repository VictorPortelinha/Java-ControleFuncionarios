package Model;

import java.util.ArrayList;

public class Empresa {
    private int id;
    private String nome;
    private Endereco endereco;
    private String cnpj;
    private final ArrayList<Funcionario> funcionarios;
    private final ArrayList<Cliente> clientes;
    
    public Empresa(String nome, Endereco endereco, String cnpj,int id) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.funcionarios = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

   public void mostrarClientes(){
        for (Cliente cliente : clientes){
            System.out.println(cliente);
        }
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

    public int getId() {
        return id;
    }

    public void printDados(){
        System.out.println("Funcionarios: ");
        for (Funcionario f: funcionarios
             ) {
            System.out.println("Nome: " + f.getNome() + "Salário: " + f.salario);
        }
        System.out.println("Clientes: ");
        for (Cliente c: clientes
             ) {
            System.out.println(c);
        }
    }

    public void showDados(){
        System.out.println("Nome : " + nome + " || CNPJ: " + cnpj + endereco.toString());
        printDados();
    }
   
    
    
}
