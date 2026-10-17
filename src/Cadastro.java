
import java.util.ArrayList;

public class Cadastro {
    private ArrayList<Cliente> clientes;

    public Cadastro(){
        clientes = new ArrayList<>();
    }

    public void cadastrar(Cliente cliente) {
        clientes.add(cliente);
    }

    public void listarClientes(){
        for (Cliente listarClientes : clientes){
            System.out.println(listarClientes);
        }
    }

    public Cliente consultar(int id){
        for (Cliente consultar : clientes){
            if (id == consultar.getId()) {
                return consultar;
            }
        }
        return null;
    }
    public Cliente alterar(int id, String nome, String cpf, String email, String dataNascimento){
        Cliente atualizarCadastro = consultar(id);
        if (atualizarCadastro == null){
            return null;
        }else{
            atualizarCadastro.setNome(nome);
            atualizarCadastro.setCpf(cpf);
            atualizarCadastro.setEmail(email);
            atualizarCadastro.setDataNascimento(dataNascimento);
        }
        return atualizarCadastro;
    }

    public boolean excluir(int id) {
        Cliente cliente = consultar(id);
        if (cliente == null) {
            return false;
        }
        clientes.remove(cliente);
        return true;
    }
}

