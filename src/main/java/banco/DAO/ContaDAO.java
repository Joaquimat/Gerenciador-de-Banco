package banco.DAO;

import banco.connection.ConnectionFactory;

import java.sql.Connection;

public class ContaDAO {

    private Connection conn;

    public ContaDAO(Connection connection){
        this.conn = connection;

    }
}
