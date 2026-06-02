package banco;

import banco.DAO.ContaDAO;
import banco.connection.ConnectionFactory;
import banco.model.Conta;
import banco.service.ContaService;

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
        ContaService contaService = new ContaService();

        //Set<Conta> lista = contaDAO.listar();



        conta.setNumero(2);
        conta.setSaldo(100L);
        contaService.sacarService(conta);
      //contaService.depositarService(conta);
        System.out.println(contaService.buscarPNumeroService(conta));




        //System.out.println(lista);




    }
}
