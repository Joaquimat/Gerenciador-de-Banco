package banco.DAO;

import banco.connection.ConnectionFactory;
import banco.model.Conta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContaDAO {

    private Connection conn;

    public ContaDAO(Connection connection){
        this.conn = connection;

    }

    public void salvar (Conta conta){
        try {


            PreparedStatement ps = conn.prepareStatement("INSERT INTO conta(numero, cliente, saldo, cpf, email) VALUES (?, ?, ?, ?, ?)");

            ps.setInt(1, conta.getNumero());
            ps.setString(2,conta.getCliente());
            ps.setLong(3,conta.getSaldo());
            ps.setString(4,conta.getCpf());
            ps.setString(5,conta.getEmail());

            ps.executeUpdate();
            ps.close();
            conn.close();

        }catch (SQLException e){
           throw new RuntimeException(e);
        }

    }
}
