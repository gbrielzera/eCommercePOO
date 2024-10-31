package comercio;

import java.util.Date;

public class Cliente {
    // Declaração das variáveis
    private int clienteID; // Primary Key do Cliente
    private String nome;
    private String email;
    private String telefone; // Número de telefone no padrão X XXXX-XXXX
    private Date dataCadastro; // Mudando para Date para melhor manipulação

    // Construtor padrão
    public Cliente() {
    }

    // Construtor com parâmetros
    public Cliente(int clienteID, String nome, String email, String telefone, Date dataCadastro) {
        this.clienteID = clienteID;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
    }

    // Getters
    public int getClienteID() {
        return clienteID;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    // Setters
    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    // toString
    @Override
    public String toString() {
        return "Cliente{" +
                "clienteID=" + clienteID +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
