package comercio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteADO {
    private Connection connection;

    public ClienteADO(Connection connection) {
        this.connection = connection;
    }

    // Create
    public void addCliente(Cliente cliente) {
        String sql = "INSERT INTO Clientes (Nome, Email, Telefone, Data_Cadastro) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.setDate(4, new java.sql.Date(cliente.getDataCadastro().getTime()));
            stmt.executeUpdate();
            System.out.println("Cliente adicionado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar cliente: " + e.getMessage());
        }
    }

    // Read
    public Cliente getCliente(int clienteID) {
        String sql = "SELECT * FROM Clientes WHERE Cliente_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, clienteID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cliente(
                        rs.getInt("Cliente_ID"),
                        rs.getString("Nome"),
                        rs.getString("Email"),
                        rs.getString("Telefone"),
                        rs.getDate("Data_Cadastro")
                );
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar cliente: " + e.getMessage());
        }
        return null;
    }

    // Update
    public void updateCliente(Cliente cliente) {
        String sql = "UPDATE Clientes SET Nome = ?, Email = ?, Telefone = ?, Data_Cadastro = ? WHERE Cliente_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.setDate(4, new java.sql.Date(cliente.getDataCadastro().getTime()));
            stmt.setInt(5, cliente.getClienteID());
            stmt.executeUpdate();
            System.out.println("Cliente atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    // Delete
    public void deleteCliente(int clienteID) {
        String sql = "DELETE FROM Clientes WHERE Cliente_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, clienteID);
            stmt.executeUpdate();
            System.out.println("Cliente deletado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar cliente: " + e.getMessage());
        }
    }

    // Listar todos os clientes
    public List<Cliente> getAllClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Clientes";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("Cliente_ID"),
                        rs.getString("Nome"),
                        rs.getString("Email"),
                        rs.getString("Telefone"),
                        rs.getDate("Data_Cadastro")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar clientes: " + e.getMessage());
        }
        return clientes;
    }
}
