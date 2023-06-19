package Model;

public class Cliente extends Pessoa {


    public Cliente(String nome, int idade, String cpf) {
        super(nome, idade,cpf);

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
        return "Nome: " + nome;
    }




}
