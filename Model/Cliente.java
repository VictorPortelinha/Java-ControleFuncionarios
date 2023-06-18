package Model;

public class Cliente extends Pessoa {
    private String email;

    public Cliente(String nome, int idade, String email,String cpf) {
        super(nome, idade,cpf);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    public String toString(){
        return "Nome: " + nome + " || Email: " + email;
    }




}
