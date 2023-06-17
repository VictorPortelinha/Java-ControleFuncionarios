package Model;

public abstract class Pessoa {
    protected String nome;
    protected int idade;
    protected Endereco endereco;

    protected String cpf;
    
        public Pessoa(String nome, int idade, Endereco endereco,String cpf) {
            this.nome = nome;
            this.idade = idade;
            this.endereco = endereco;
            this.cpf = cpf;
        }
    public abstract String getNome();

    public abstract void setNome(String nome);

    public abstract int getIdade();

    public abstract void setIdade(int idade);

    public abstract Endereco getEndereco();

    public abstract void setEndereco(Endereco endereco);

    @Override
    public abstract String toString();



    

   



}
