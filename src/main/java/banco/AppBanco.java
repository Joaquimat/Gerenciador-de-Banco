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


        conta.setNumero(6);
        conta.setCliente("joaquim");
        conta.setCpf("12345698743");
        conta.setEmail("bucetinhagmail");


        contaService.salvar(conta);


        //System.out.println(lista);




    }
}
