import Model.*;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Shaw", 20, "Rua a, 123");
        Funcionario funcionario = new Funcionario("Jao", 20, "Rua b, 123", "The mith", 3000);
        CEO ceo = new CEO("Portelinha", 20, "Rua c, 123", "Model.CEO", 10000, "a", 3000);
        Cliente cliente = new Cliente("Victor", 20, "Rua d, 123", "vitao@gmail.com");
        Fornecedor fornecedor = new Fornecedor("BOB Marley", 420, "Rua e, 123", "123456");

        System.out.println("Nome da pessoa: " + pessoa.getNome());
        pessoa.setNome("Shaw");
        System.out.println("Novo nome da pessoa: " + pessoa.getNome());

        System.out.println("Cargo do funcionário: " + funcionario.getCargo());
        funcionario.setCargo("The mith master");
        System.out.println("Novo cargo do funcionário: " + funcionario.getCargo());

        System.out.println("Bônus do Model.CEO: " + ceo.getBonus());
        ceo.setBonus(6000);
        System.out.println("Novo bônus do Model.CEO: " + ceo.getBonus());

        System.out.println("Email do cliente: " + cliente.getEmail());
        cliente.setEmail("vitao@gmail.com");
        System.out.println("Novo email do cliente: " + cliente.getEmail());

        System.out.println("CNPJ do fornecedor: " + fornecedor.getCnpj());
        fornecedor.setCnpj("123456789");
        System.out.println("Novo CNPJ do fornecedor: " + fornecedor.getCnpj());
    }
}