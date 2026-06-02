package banco.service;

import banco.DAO.ContaDAO;
import banco.connection.ConnectionFactory;
import banco.model.Conta;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

public class ContaService {

    ConnectionFactory connectionFactory = new ConnectionFactory();

    public void salvarService(Conta conta) {

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
            System.out.println("CONTA SALVA");

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

    public void deletarService(Conta conta) {

        Connection conn = connectionFactory.recuperarConexao();

        try {

            ContaDAO contaDAO = new ContaDAO(conn);

            Integer statusNum = conta.getNumero();

            if (contaDAO.lerNum().contains(statusNum)) {
                contaDAO.deletar(conta);
                System.out.println("CONTA DELETADA");
            } else {
                System.out.println("ATENÇÃO:ESSA CONTA NÃO EXISTE");
            }

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

    public Set<Conta> listarService() {

        Connection conn = null;
        ContaDAO contaDAO = null;
        try {
            conn = connectionFactory.recuperarConexao();

            contaDAO = new ContaDAO(conn);
            return contaDAO.listar();

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

