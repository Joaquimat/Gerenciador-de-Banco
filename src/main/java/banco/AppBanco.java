package banco;

import banco.DAO.ContaDAO;
import banco.connection.ConnectionFactory;
import banco.model.Conta;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.Set;

public class AppBanco {
    public static void main(String[] args) {


        ConnectionFactory connectionFactory = new ConnectionFactory();
        ContaDAO contaDAO = new ContaDAO(connectionFactory.recuperarConexao());
        Conta conta = new Conta();

        //Set<Conta> lista = contaDAO.listar();

        conta.setSaldo(200L);
        conta.setNumero(2);

        //System.out.println(lista);

        contaDAO.sacar(conta);


    }
}
