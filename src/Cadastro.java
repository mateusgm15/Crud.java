
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cadastro {
    private ArrayList<Cliente> clientes;

    public Cadastro(){
        clientes = new ArrayList<>();
    }

    public void cadastrar(Cliente cliente) {
        String sql = "INSERT INTO clientes (id, nome, cpf, email, data_nascimento) VALUES (?,?,?,?,?)";

        try (Connection conexao = ConexaoBanco.conectar();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setInt(1, cliente.getId());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getDataNascimento());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }
    }

    public void listarClientes(){
        String sql = "SELECT * FROM clientes";

        try (Connection conexao = ConexaoBanco.conectar();
             PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("data_nascimento"),
                        rs.getInt("id")
                );
                System.out.println(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
    }

    public Cliente consultar(int id) {
        String sql = "SELECT * FROM clientes WHERE id = ?";

        try (Connection conexao = ConexaoBanco.conectar();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getString("email"),
                            rs.getString("data_nascimento"),
                            rs.getInt("id")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar: " + e.getMessage());
        }
        return null;
    }
    public Cliente alterar(int id, String nome, String cpf, String email, String dataNascimento) {
        String sql = "UPDATE clientes SET nome = ?, cpf = ?, email = ?, data_nascimento = ? WHERE id = ?";

        try (Connection conexao = ConexaoBanco.conectar();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setString(1, nome);
            ps.setString(2, cpf);
            ps.setString(3, email);
            ps.setString(4, dataNascimento);
            ps.setInt(5, id);

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas == 0) {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao alterar: " + e.getMessage());
            return null;
        }
        return consultar(id);
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";

        try (Connection conexao = ConexaoBanco.conectar();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
            return false;
        }
    }
}
