package Model;

public class Fornecedor extends Pessoa {
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
