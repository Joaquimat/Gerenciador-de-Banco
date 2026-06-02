package banco.service;

import banco.DAO.ContaDAO;
import banco.connection.ConnectionFactory;
import banco.model.Conta;

import java.sql.Connection;
import java.sql.SQLException;

public class ContaService {

    ConnectionFactory connectionFactory = new ConnectionFactory();

    public void salvar(Conta conta) {

        Connection conn = connectionFactory.recuperarConexao();

        try {

            ContaDAO contaDAO = new ContaDAO(conn);

            Integer statusNum = conta.getNumero();
            String statusCpf = conta.getCpf();

            if (contaDAO.lerNum().contains(statusNum) || contaDAO.lerCpf().contains(statusCpf)) {
                System.out.println("ATENÇÃO: ESSA CONTA JÁ EXISTE");
                return;
            }
            contaDAO.salvar(conta);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

