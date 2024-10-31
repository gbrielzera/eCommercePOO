package comercio;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Criando a conexão com o banco de dados
        Conexao dbConnection = new Conexao();
        Connection conn = dbConnection.getConnection();

        // Instanciando o ClienteDAO
        ClienteADO clienteDAO = new ClienteADO(conn);
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Deletar Cliente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1: // Adicionar Cliente
                    Cliente novoCliente = new Cliente();
                    System.out.print("Digite o Nome: ");
                    novoCliente.setNome(scanner.nextLine());
                    System.out.print("Digite o Email: ");
                    novoCliente.setEmail(scanner.nextLine());
                    System.out.print("Digite o Telefone: ");
                    novoCliente.setTelefone(scanner.nextLine());
                    novoCliente.setDataCadastro(new Date());
                    clienteDAO.addCliente(novoCliente);
                    break;

                case 2: // Listar Clientes
                    List<Cliente> clientes = clienteDAO.getAllClientes();
                    System.out.println("Lista de Clientes:");
                    for (Cliente c : clientes) {
                        System.out.println(c);
                    }
                    break;

                case 3: // Atualizar Cliente
                    System.out.print("Digite o ID do Cliente a ser atualizado: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    Cliente clienteAtualizar = clienteDAO.getCliente(idAtualizar);
                    if (clienteAtualizar != null) {
                        System.out.print("Digite o Novo Nome: ");
                        clienteAtualizar.setNome(scanner.nextLine());
                        System.out.print("Digite o Novo Email: ");
                        clienteAtualizar.setEmail(scanner.nextLine());
                        System.out.print("Digite o Novo Telefone: ");
                        clienteAtualizar.setTelefone(scanner.nextLine());
                        clienteDAO.updateCliente(clienteAtualizar);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 4: // Deletar Cliente
                    System.out.print("Digite o ID do Cliente a ser deletado: ");
                    int idDeletar = scanner.nextInt();
                    clienteDAO.deleteCliente(idDeletar);
                    break;

                case 5: // Sair
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        // Fechando a conexão
        dbConnection.closeConnection();
        scanner.close();
    }
}
