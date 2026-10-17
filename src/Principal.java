import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Cadastro novoCadastro = new Cadastro();

        Cliente cliente1 = new Cliente("Mateus", "753.856.856.21", "mateus@gmail.com", "12/11/2004", 1);
        Cliente cliente2 = new Cliente("Anne", "322.563.826.14", "anne@gmail.com", "14/07/2000", 2);
        Cliente cliente3 = new Cliente("Elaine", "333.436.343.31", "elaine@gmail.com", "04/09/1933", 3);

        novoCadastro.cadastrar(cliente1);
        novoCadastro.cadastrar(cliente2);
        novoCadastro.cadastrar(cliente3);

        System.out.println("--- Lista inicial ---");
        novoCadastro.listarClientes();

        System.out.println("--- Consultar id 2 ---");
        Cliente achado = novoCadastro.consultar(2);
        if (achado == null) {
            System.out.println("Cliente não encontrado");
        } else {
            System.out.println(achado);
        }

        System.out.println("--- Alterar id 2 ---");
        Cliente alterado = novoCadastro.alterar(2, "Anne Souza", "322.563.826.14", "anne.souza@gmail.com", "14/07/2000");
        if (alterado == null) {
            System.out.println("Cliente não encontrado");
        } else {
            System.out.println(alterado);
        }

        System.out.println("--- Excluir id 3 ---");
        if (novoCadastro.excluir(3)) {
            System.out.println("Cliente excluído");
        } else {
            System.out.println("Cliente não encontrado");
        }

        System.out.println("--- Lista final ---");
        novoCadastro.listarClientes();
    }
}