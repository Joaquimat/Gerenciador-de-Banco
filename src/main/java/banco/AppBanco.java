package banco;

import banco.connection.ConnectionFactory;

public class AppBanco {
    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.recuperarConexao();

    }
}
