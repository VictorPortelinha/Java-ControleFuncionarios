import java.util.ArrayList;
import java.util.List;

public class ControleCadastro {
    private List<Pessoa> pessoas;

    public ControleCadastro() {
        pessoas = new ArrayList<>();
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
        System.out.println("Pessoa cadastrada com sucesso!");
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }
}


public class ControleLogin {
    private List<Usuario> usuarios;

    public ControleLogin() {
        usuarios = new ArrayList<>();
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public boolean realizarLogin(String username, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                System.out.println("Login bem-sucedido!");
                return true;
            }
        }
        System.out.println("Usuário ou senha incorretos. Tente novamente.");
        return false;
    }

    public void realizarLogout() {
        System.out.println("Logout realizado com sucesso!");
    }
}

public class Main {
    public static void main(String[] args) {
        ControleLogin controleLogin = new ControleLogin();

        Usuario usuario = new Usuario("Shaw", "123456");

        controleLogin.cadastrarUsuario(usuario);

        controleLogin.realizarLogin("Shaw", "123456");
        
        controleLogin.realizarLogout();
    }
}

private class Pessoa {
    private String nome;
    private int idade;
    private String endereco;

    public Pessoa(String nome, int idade, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}

private class Funcionario extends Pessoa {
    private String cargo;
    private double salario;

    public Funcionario(String nome, int idade, String endereco, String cargo, double salario) {
        super(nome, idade, endereco);
        this.cargo = cargo;
        this.salario = salario;
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
}

private class CEO extends Funcionario {
    private String departamento;
    private double bonus;

    public CEO(String nome, int idade, String endereco, String cargo, double salario, String departamento, double bonus) {
        super(nome, idade, endereco, cargo, salario);
        this.departamento = departamento;
        this.bonus = bonus;
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
}

public class GeradorPlanilha {
    public void gerarPlanilha(String nomeArquivo) {
        // Lógica para gerar a planilha com o nome especificado [portelinha]
    }
}

private class Cliente extends Pessoa {
    private String email;

    public Cliente(String nome, int idade, String endereco, String email) {
        super(nome, idade, endereco);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


private class Fornecedor extends Pessoa {
    private String cnpj;

    public Fornecedor(String nome, int idade, String endereco, String cnpj) {
        super(nome, idade, endereco);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}


private class Projeto {
    private String nome;
    private String descricao;
    private String status;

    public Projeto(String nome, String descricao, String status) {
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

private class Departamento {
    private String nome;
    private String descricao;
    private String chefe;

    public Departamento(String nome, String descricao, String chefe) {
        this.nome = nome;
        this.descricao = descricao;
        this.chefe = chefe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getChefe() {
        return chefe;
    }

    public void setChefe(String chefe) {
        this.chefe = chefe;
    }
}

private class Endereco {
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco(String rua, String numero, String cidade, String estado, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
