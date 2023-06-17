import TelaInicial.TelaInicial;

public class Main {
    public static void main(String[] args) {
        TelaInicial telaInicial = new TelaInicial();
        while ( !telaInicial.getSair()){
            telaInicial.execute();
        }

    }
}