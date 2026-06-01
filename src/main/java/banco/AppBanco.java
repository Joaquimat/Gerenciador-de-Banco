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

        Set<Conta> lista  = contaDAO.listar();


        System.out.println(lista);


    }
}
