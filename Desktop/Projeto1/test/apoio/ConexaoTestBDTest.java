package apoio;

import org.junit.Test;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

public class ConexaoTestBDTest {

    public ConexaoTestBDTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void testDatabaseTestConnection() throws SQLException {
        // Define configuração para usar database de teste
        System.setProperty("db.config", "db-test.properties");

        // Obtém a Connection a partir do singleton ConexaoBD
        Connection conn = ConexaoBD.getInstance().getConnection();

        // Verifica se não é null
        assertNotNull("A conexão não deve ser nula", conn);

        // Verifica se está aberta
        assertFalse("A conexão não deve estar fechada", conn.isClosed());
        
        conn.close();
        ConexaoBD.getInstance().shutdown();
    }
}
