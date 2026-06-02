package banco.DAO;

import banco.connection.ConnectionFactory;
import banco.model.Conta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContaDAO {

    private Connection conn;

    public ContaDAO(Connection connection) {
        this.conn = connection;

    }

    public void salvar(Conta conta) {
        try {


            PreparedStatement ps = conn.prepareStatement("INSERT INTO conta(numero, cliente, saldo, cpf, email) VALUES (?, ?, ?, ?, ?)");

            ps.setInt(1, conta.getNumero());
            ps.setString(2, conta.getCliente());
            ps.setLong(3, conta.getSaldo());
            ps.setString(4, conta.getCpf());
            ps.setString(5, conta.getEmail());

            ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Set<Conta> listar() {

        Set<Conta> contas = new HashSet<>();

        try {


            PreparedStatement ps = conn.prepareStatement("SELECT * FROM conta");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Conta cnt = new Conta();

                int numero = rs.getInt(1);
                String cliente = rs.getString(2);
                Long saldo = rs.getLong(3);
                String cpf = rs.getString(4);
                String email = rs.getString(5);

                cnt.setNumero(numero);
                cnt.setCliente(cliente);
                cnt.setSaldo(saldo);
                cnt.setCpf(cpf);
                cnt.setEmail(email);

                contas.add(cnt);

            }
            ps.close();
            rs.close();
            conn.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contas;

    }

    public void deletar(Conta conta) {

        try {

            PreparedStatement ps = conn.prepareStatement("DELETE FROM conta WHERE numero = ?");

            ps.setInt(1, conta.getNumero());

            ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void atualizar(Conta conta) {

        try {

            PreparedStatement ps = conn.prepareStatement("UPDATE conta SET email = ? WHERE numero = ?");

            ps.setString(1, conta.getEmail());
            ps.setInt(2, conta.getNumero());

            ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void depositar(Conta conta) {

        try {

            PreparedStatement ps = conn.prepareStatement("UPDATE conta SET saldo = saldo + ? WHERE numero = ?");

            ps.setLong(1, conta.getSaldo());
            ps.setInt(2, conta.getNumero());

            ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void sacar(Conta conta) {

        try {

            PreparedStatement ps = conn.prepareStatement("UPDATE conta SET saldo = saldo - ? WHERE numero = ?");

            ps.setLong(1, conta.getSaldo());
            ps.setInt(2, conta.getNumero());

            ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Conta buscarPorNumero(Conta conta) {

        try {

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM conta WHERE numero = ?");

            ps.setInt(1, conta.getNumero());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int numero = rs.getInt(1);
                String cliente = rs.getString(2);
                Long saldo = rs.getLong(3);
                String cpf = rs.getString(4);
                String email = rs.getString(5);

                conta.setNumero(numero);
                conta.setCliente(cliente);
                conta.setSaldo(saldo);
                conta.setCpf(cpf);
                conta.setEmail(email);
            }

            ps.close();
            rs.close();
            conn.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conta;

    }

}
