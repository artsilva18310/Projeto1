/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package entidades;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;



public class ProdutoTest {

    private Produto produto;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        produto = new Produto();
    }

    @After
    public void tearDown() {
        produto = null;
    }

    @Test
    public void testGettersAndSetters() {
        int idEsperado = 42;
        String nomeEsperado = "Chocolate";
        String tipoEsperado = "doce";
        double pesoEsperado = 1.000;
        String ingredienteEsperado = "sal,cacau";
        int qtdestoqueEsperado = 25;

        produto.setId(idEsperado);
        produto.setNome(nomeEsperado);
        produto.setTipo(tipoEsperado);
        produto.setPeso(pesoEsperado);
        produto.setIngrediente(ingredienteEsperado);
        produto.setQtdestoque(qtdestoqueEsperado);

        assertEquals(idEsperado, produto.getId());
        assertEquals(nomeEsperado, produto.getNome());
        assertEquals(tipoEsperado, produto.getTipo());
        assertEquals(pesoEsperado, produto.getPeso(), 0.0001); // corrigido aqui
        assertEquals(ingredienteEsperado, produto.getIngrediente());
        assertEquals(qtdestoqueEsperado, produto.getQtdestoque());
    }

    @Test
    public void testToString() {
        produto.setId(5);
        produto.setNome("Massa");
        produto.setTipo("Amarga");
        produto.setPeso(1.0);
        produto.setIngrediente("cacau");
        produto.setQtdestoque(10);

     String esperado = "5;Massa;Amarga;1.0;cacau;10";
    assertEquals(esperado, produto.toString());
    }
}

