public class Cliente extends Pessoa {
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
