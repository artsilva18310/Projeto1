/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package entidades.DAO;

import apoio.ConexaoBD;
import entidades.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testa a classe ProdutoDAO usando os dados de db-test:
 * 1) Cria tabela produto em @BeforeClass
 * 2) No @Before, limpa o conteúdo da tabela antes de cada teste
 * 3) Executa os testes
 * 4) Em @AfterClass, dropa a tabela e fecha a conexão
 */
public class ProdutoDAOTest {
 // SQL para criar e dropar a tabela de teste
    private static final String SQL_CREATE_FUNCIONARIO = "CREATE TABLE IF NOT EXISTS funcionario ("
        + " idfuncionario SERIAL PRIMARY KEY, "
        + " nome VARCHAR(255) NOT NULL, "
        + " cargo VARCHAR(255) NOT NULL);";
    
    
    
    private static final String SQL_CREATE_PRODUTO  = "CREATE TABLE IF NOT EXISTS produto ( "
            + "  idproduto SERIAL PRIMARY KEY, "
            + "  nome VARCHAR(255) NOT NULL, "
            + "  tipo VARCHAR(100) NOT NULL, "
            + "  peso DOUBLE PRECISION NOT NULL, "
            + "  ingrediente VARCHAR(255) NOT NULL, "
            + "  qtdestoque INT NOT NULL "
            + ");";

    private static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS produto;";

    private ProdutoDAO dao;

    public ProdutoDAOTest() {}
    // Construtor default: não precisa inicializar nada aqui
 @BeforeClass
public static void setUpClass() {
    try {
        System.setProperty("db.config", "db-test.properties");
        ConexaoBD.executeUpdate(SQL_CREATE_FUNCIONARIO); // Cria antes, se necessário
        ConexaoBD.executeUpdate(SQL_CREATE_PRODUTO);
    } catch (SQLException e) {
        throw new RuntimeException("Erro em @BeforeClass:\n" + e.getMessage(), e);
    }
}


 @AfterClass
public static void tearDownClass() {
    try {
        ConexaoBD.executeUpdate("DROP TABLE IF EXISTS produto CASCADE;");
        ConexaoBD.executeUpdate("DROP TABLE IF EXISTS funcionario CASCADE;");
    } catch (SQLException e) {
        throw new RuntimeException("Erro ao dropar tabelas.\n" + e.getMessage(), e);
    }
}


 @Before
public void setUp() {
    ConexaoBD.getInstance().shutdown();
    dao = new ProdutoDAO();
    try {
        ConexaoBD.executeUpdate("TRUNCATE TABLE produto RESTART IDENTITY CASCADE;");
        ConexaoBD.executeUpdate("TRUNCATE TABLE funcionario RESTART IDENTITY CASCADE;");
    } catch (SQLException e) {
        throw new RuntimeException("Erro ao truncar tabelas.\n" + e.getMessage(), e);
    }
}


    @After
    public void tearDown() {
        ConexaoBD.getInstance().shutdown();
    }

    @Test
    public void testInserirERetornarProduto() throws SQLException {
        Produto p = new Produto();
        p.setNome("Chocolate");
        p.setTipo("doce");
        p.setPeso(1.000);
        p.setIngrediente("sal,cacau");
        p.setQtdestoque(25);
        dao.salvar(p);

        ArrayList<Produto> lista = dao.recuperarTodos();
        assertNotNull(lista);
        assertEquals(1, lista.size());

        Produto recuperado = dao.recuperar(1);
        assertNotNull(recuperado);
        assertEquals(p.getNome(), recuperado.getNome());
        assertEquals(p.getTipo(), recuperado.getTipo());
        assertEquals(p.getPeso(), recuperado.getPeso(), 0.001);
        assertEquals(p.getIngrediente(), recuperado.getIngrediente());
        assertEquals(p.getQtdestoque(), recuperado.getQtdestoque());
    }

    @Test
    public void testEditarProduto() throws SQLException {
        Produto p = new Produto();
        p.setNome("Massa");
        p.setTipo("branca");
        p.setPeso(0.500);
        p.setIngrediente("trigo,agua");
        p.setQtdestoque(10);
        dao.salvar(p);

        Produto modificado = new Produto();
        modificado.setId(1);
        modificado.setNome("Massa Integral");
        modificado.setTipo("integral");
        modificado.setPeso(0.600);
        modificado.setIngrediente("trigo integral,agua");
        modificado.setQtdestoque(15);
        dao.editar(modificado);

        Produto recuperado = dao.recuperar(1);
        assertNotNull(recuperado);
        assertEquals("Massa Integral", recuperado.getNome());
        assertEquals("integral", recuperado.getTipo());
        assertEquals(0.600, recuperado.getPeso(), 1.001);
        assertEquals("trigo integral,agua", recuperado.getIngrediente());
        assertEquals(15, recuperado.getQtdestoque());
    }

    @Test
    public void testExcluirProduto() throws SQLException {
        Produto p = new Produto();
        p.setNome("Chocolate");
        p.setTipo("Doce");
        p.setPeso(0.300);
        p.setIngrediente("leite,acucar");
        p.setQtdestoque(5);
        dao.salvar(p);

        Produto antes = dao.recuperar(1);
        assertNotNull(antes);

        dao.excluir(1);

        Produto depois = dao.recuperar(1);
        assertNull(depois);

        ArrayList<Produto> todos = dao.recuperarTodos();
        assertNotNull(todos);
        assertTrue(todos.isEmpty());
    }
}
