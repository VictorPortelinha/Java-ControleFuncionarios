public class controleLogin {
    public boolean realizarLogin(String usuario, String senha) {
        if (usuario.equals("") && senha.equals("")) {
            System.out.println("Login realizado com sucesso!");
            return true;
        } else {
            System.out.println("Usuario ou senha invalidos.");
            return false;
        }
    }
}
