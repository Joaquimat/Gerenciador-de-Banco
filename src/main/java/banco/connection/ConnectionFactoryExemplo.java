package banco.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryExemplo {

    public void recuperarConexao(){

        try {

            DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/", "root", "sua senha");

            System.out.println("recuperação no banco concluida");

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
