package banco.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryExemplo {

    public Connection recuperarConexao(){

        try {

            Connection connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/nomedobanco", "root", "sua senha");

            System.out.println("recuperação no banco concluida");
            return connection;


        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
