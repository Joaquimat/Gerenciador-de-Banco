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

            if (contaDAO.lerNum().contains(conta.getNumero()) || contaDAO.lerCpf().contains(conta.getCpf())) {
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

            if (contaDAO.lerNum().contains(conta.getNumero())) {
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

    public void atualizarService(Conta conta) {

        Connection conn = connectionFactory.recuperarConexao();

        try {
            ContaDAO contaDAO = new ContaDAO(conn);

            if (contaDAO.lerNum().contains(conta.getNumero())) {
                contaDAO.atualizar(conta);
                System.out.println("CONTA ATUALIZADA");
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

    public void depositarService(Conta conta) {

        Connection conn = connectionFactory.recuperarConexao();

        try {

            ContaDAO contaDAO = new ContaDAO(conn);

            if (contaDAO.lerNum().contains(conta.getNumero())) {
                contaDAO.depositar(conta);
                System.out.println("DEPOSITO REALIZADO");
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

    public void sacarService(Conta conta) {

        Connection conn = connectionFactory.recuperarConexao();

        try {

            ContaDAO contaDAO = new ContaDAO(conn);

            if (contaDAO.lerNum().contains(conta.getNumero()) && contaDAO.lerSaldo().contains(conta.getSaldo() > 0L)) {
                contaDAO.sacar(conta);
                System.out.println("SAQUE REALIZADO");
            } else {
                System.out.println("ATENÇÃO:ESSA CONTA NÃO EXISTE OU NAO POSSUI SALDO");
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

    public Conta buscarPNumeroService(Conta conta) {

        Connection conn = null;
        ContaDAO contaDAO = null;
        try {
            conn = connectionFactory.recuperarConexao();

            contaDAO = new ContaDAO(conn);
            return contaDAO.buscarPorNumero(conta);

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

