package comercio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao { // Nome da classe alterado para Conexao

    private static final String HOST = "localhost"; // Host do banco de dados
    private static final int PORT = 3307; // Porta do banco de dados
    private static final String DB_NAME = "comercio"; // Nome do banco de dados
    private static final String USER = "root"; // Usuário
    private static final String PASSWORD = "catolica"; // Senha

    private Connection connection;

    // Construtor da classe
    public Conexao() {
        try {
            // Montando a URL de conexão
            String url = String.format("jdbc:mysql://%s:%d/%s", HOST, PORT, DB_NAME);

            // Estabelecendo a conexão
            connection = DriverManager.getConnection(url, USER, PASSWORD);
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao estabelecer a conexão: " + e.getMessage());
            e.printStackTrace(); // Para mais detalhes sobre o erro
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexão fechada.");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
