/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package entidades.DAO;

import apoio.ConexaoBD;
import entidades.Funcionario;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mateus
 */
/**
 * Cria tabela cliente em @BeforeClass 2) No @Before, limpa o conteúdo da tabela
 * antes de cada teste 3) Executa os testes 4) Em @AfterClass, dropa a tabela e
 * fecha a conexão
 */
public class FuncionarioDAOTest {

    private static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS funcionario ( "
            + "  idfuncionario SERIAL PRIMARY KEY, "
            + "  nome VARCHAR(255) NOT NULL, "
            + "  cargo VARCHAR(255) NOT NULL "
            + ");";

 

    private FuncionarioDAO dao;

    public FuncionarioDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        try {
            System.setProperty("db.config", "db-test.properties");
            ConexaoBD.executeUpdate(SQL_CREATE_TABLE);
        } catch (SQLException e) {
            throw new RuntimeException("Erro em @BeforeClass: falha ao criar tabela 'funcionario'.\n" + e.getMessage(), e);
        }
    }
private static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS funcionario CASCADE;";

@AfterClass
public static void tearDownClass() {
    try {
        ConexaoBD.executeUpdate(SQL_DROP_TABLE);
    } catch (SQLException e) {
        throw new RuntimeException("Erro em @AfterClass: falha ao dropar tabela 'funcionario'.\n" + e.getMessage(), e);
    }
}


    @Before
    public void setUp() {
        ConexaoBD.getInstance().shutdown();
        dao = new FuncionarioDAO();
        try {
            ConexaoBD.executeUpdate("TRUNCATE TABLE funcionario CASCADE;");
            ConexaoBD.executeUpdate("ALTER SEQUENCE funcionario_idfuncionario_seq RESTART WITH 1;");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao truncar tabela 'funcionario'.\n" + e.getMessage(), e);
        }
    }

    @After
    public void tearDown() {
        ConexaoBD.getInstance().shutdown();
    }

    @Test
    public void testInserirERetornarFuncionario() throws SQLException {
        Funcionario f = new Funcionario();
        f.setNome("Ana Costa");
        f.setCargo("Gerente");
        dao.salvar(f);

        ArrayList<Funcionario> lista = dao.recuperarTodos();
        assertNotNull(lista);
        assertEquals(1, lista.size());

        Funcionario recuperado = dao.recuperar(1);
        assertNotNull(recuperado);
        assertEquals(f.getNome(), recuperado.getNome());
        assertEquals(f.getCargo(), recuperado.getCargo());
    }

    @Test
    public void testEditarFuncionario() throws SQLException {
        Funcionario f = new Funcionario();
        f.setNome("Carlos Oliveira");
        f.setCargo("Analista");
        dao.salvar(f);

        Funcionario modificado = new Funcionario();
        modificado.setIdfuncionario(1);
        modificado.setNome("Carlos O. Lima");
        modificado.setCargo("Coordenador");
        dao.editar(modificado);

        Funcionario recuperado = dao.recuperar(1);
        assertNotNull(recuperado);

        assertEquals("Carlos O. Lima", recuperado.getNome());
        assertEquals("Coordenador", recuperado.getCargo());
    }

    @Test
    public void testExcluirFuncionario() throws SQLException {
        Funcionario f = new Funcionario();
        f.setNome("Luciana Prado");
        f.setCargo("Assistente");
        dao.salvar(f);

        Funcionario antes = dao.recuperar(1);
        assertNotNull(antes);

        dao.excluir(1);

        Funcionario depois = dao.recuperar(1);
        assertNull(depois);

        ArrayList<Funcionario> todos = dao.recuperarTodos();
        assertNotNull(todos);
        assertTrue(todos.isEmpty());
    }
}
