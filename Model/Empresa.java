package Model;
import ConnectionDB.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Empresa {
    private int id;
    private String nome;
    private Endereco endereco;
    private String cnpj;
    private final ArrayList<Funcionario> funcionarios;
    private final ArrayList<Cliente> clientes;

    
    public Empresa(String nome, Endereco endereco, String cnpj,int id) throws SQLException {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.funcionarios = new ArrayList<>();
        this.clientes = new ArrayList<>();
        fetchFuncionariosFromDB();
        fetchClientesFromDB();
    }

    public void fetchClientesFromDB() throws SQLException {
        try{
            DB banco = new DB();
            ResultSet rs = banco.selectClienteByID(id);
            while (rs.next()){
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String cpf = rs.getString("cpf");
                Cliente cliente = new Cliente(nome,idade,cpf);
                setClientes(cliente);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

   public void fetchFuncionariosFromDB() throws SQLException {
        try {
            DB banco = new DB();
            ResultSet rs = banco.selectFuncionarios(id);
            while (rs.next()) {
                String nomeFuncionario = rs.getString("nome");
                int idadeFuncionario = rs.getInt("idade");
                String cpf = rs.getString("cpf");
                int tipoFuncionario = rs.getInt("tipoFuncionario");
                String cargo = rs.getString("cargo");
                double salario = rs.getDouble("salario");
                double bonus = rs.getDouble("bonus");
                if (tipoFuncionario == 0) {
                    Funcionario funcionario = new Estagiario(nomeFuncionario, idadeFuncionario, cpf, cargo, salario, bonus);
                    setFuncionarios(funcionario);
                } else if (tipoFuncionario == 1) {
                    Funcionario funcionario = new Junior(nomeFuncionario, idadeFuncionario, cpf, cargo, salario, bonus);
                    setFuncionarios(funcionario);
                } else if (tipoFuncionario == 2) {
                    Funcionario funcionario = new Pleno(nomeFuncionario, idadeFuncionario, cpf, cargo, salario, bonus);
                    setFuncionarios(funcionario);
                } else if (tipoFuncionario == 3) {
                    Funcionario funcionario = new Senior(nomeFuncionario, idadeFuncionario, cpf, cargo, salario, bonus);
                    setFuncionarios(funcionario);
                }

            }
        }catch(Exception e){
            System.out.println(e);
        }

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

   public void setClientes(Cliente cliente){
        this.clientes.add(cliente);
   }
    public void printDados(){
        System.out.println("Funcionarios: ");
        for (Funcionario f: funcionarios
             ) {
            System.out.println("Nome: " + f.getNome() + "Salário: " + f.salario);
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("Clientes: ");
        for (Cliente c: clientes
             ) {
            System.out.println(c);
        }
    }

    public void showDados(){
        System.out.println(clientes.size());
        System.out.println("Nome : " + nome + " || CNPJ: " + cnpj + endereco.toString());
        System.out.println("---------------------------------------------------------");
        printDados();
    }
   
    
    
}
