package Model;

public abstract class Pessoa {
    protected String nome;
    protected int idade;


    protected String cpf;
    
        public Pessoa(String nome, int idade, String cpf) {
            this.nome = nome;
            this.idade = idade;

            this.cpf = cpf;
        }
    public abstract String getNome();

    public abstract void setNome(String nome);

    public abstract int getIdade();

    public abstract void setIdade(int idade);


    @Override
    public abstract String toString();



    

   



}
