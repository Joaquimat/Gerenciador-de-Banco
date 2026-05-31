package banco;

import banco.DAO.ContaDAO;
import banco.connection.ConnectionFactory;
import banco.model.Conta;

import java.sql.Connection;

public class AppBanco {
    public static void main(String[] args) {

        Conta conta = new Conta(2,"noemia lode","09823456714","noemialode@gmail.com",(100000000L));
        ConnectionFactory connectionFactory = new ConnectionFactory();
        ContaDAO contaDAO = new ContaDAO(connectionFactory.recuperarConexao());

        contaDAO.salvar(conta);





    }
}
