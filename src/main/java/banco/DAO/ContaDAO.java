package banco.DAO;

import banco.model.Conta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ContaDAO {

    private Connection conn;

    public ContaDAO(Connection connection) {
        this.conn = connection;
    }

    public void salvar(Conta conta) {

        PreparedStatement ps = null;

        try {

            ps = conn.prepareStatement("INSERT INTO conta(numero, cliente, saldo, cpf, email) VALUES (?, ?, ?, ?, ?)");

            ps.setInt(1, conta.getNumero());
            ps.setString(2, conta.getCliente());
            ps.setLong(3, 0L);
            ps.setString(4, conta.getCpf());
            ps.setString(5, conta.getEmail());

            ps.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Set<Conta> listar() {

        Set<Conta> contas = new HashSet<>();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = conn.prepareStatement("SELECT * FROM conta");

            rs = ps.executeQuery();

            while (rs.next()) {
                Conta cnt = new Conta();
                cnt.setNumero(rs.getInt(1));
                cnt.setCliente(rs.getString(2));
                cnt.setSaldo(rs.getLong(3));
                cnt.setCpf(rs.getString(4));
                cnt.setEmail(rs.getString(5));
                contas.add(cnt);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return contas;
    }

    public void deletar(Conta conta) {

        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("DELETE FROM conta WHERE numero = ?");

            ps.setInt(1, conta.getNumero());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void atualizar(Conta conta) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE conta SET email = ? WHERE numero = ?");

            ps.setString(1, conta.getEmail());
            ps.setInt(2, conta.getNumero());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void depositar(Conta conta) {

        PreparedStatement ps = null;
        try {

            ps = conn.prepareStatement("UPDATE conta SET saldo = saldo + ? WHERE numero = ?");

            ps.setLong(1, conta.getSaldo());
            ps.setInt(2, conta.getNumero());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void sacar(Conta conta) {

        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("UPDATE conta SET saldo = saldo - ? WHERE numero = ?");

            ps.setLong(1, conta.getSaldo());
            ps.setInt(2, conta.getNumero());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Conta buscarPorNumero(Conta conta) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM conta WHERE numero = ?");

            ps.setInt(1, conta.getNumero());

            rs = ps.executeQuery();

            if (rs.next()) {

                conta.setNumero(rs.getInt(1));
                conta.setCliente(rs.getString(2));
                conta.setSaldo(rs.getLong(3));
                conta.setCpf(rs.getString(4));
                conta.setEmail(rs.getString(5));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return conta;
    }

    public Set<Integer> lerNum() {

        Set<Integer> contas = new HashSet<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("SELECT numero FROM conta");

            rs = ps.executeQuery();

            while (rs.next()) {
                contas.add(rs.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return contas;
    }

    public Set<String> lerCpf() {

        Set<String> contas = new HashSet<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("SELECT cpf FROM conta");

            rs = ps.executeQuery();

            while (rs.next()) {
                contas.add(rs.getString(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return contas;
    }
    public Long lerSaldo(Conta conta) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("SELECT saldo FROM conta WHERE numero = ?");
            ps.setInt(1, conta.getNumero());

            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getLong("saldo");
            }

            return 0L; // se não encontrar

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

