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

/**
 *
 * @author mateus
 */
public class FuncionarioTest {

    public FuncionarioTest() {
    }

    private Funcionario funcionario;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // Roda antes de cada teste: cria novo Funcionario
        funcionario = new Funcionario();
    }

    @After
    public void tearDown() {
        // Roda depois de cada teste: limpa a instância
        funcionario = null;
    }

    @Test
    public void testGettersAndSetters() {
        // Arrange
        int idEsperado = 10;
        String nomeEsperado = "Joana Lima";
        String cargoEsperado = "Gerente";

        // Act: aplica os setters
        funcionario.setIdfuncionario(idEsperado);
        funcionario.setNome(nomeEsperado);
        funcionario.setCargo(cargoEsperado);

        // Assert: valida os getters
        assertEquals(idEsperado, funcionario.getIdfuncionario());
        assertEquals(nomeEsperado, funcionario.getNome());
        assertEquals(cargoEsperado, funcionario.getCargo());
    }

    @Test
    public void testToString() {
        // Arrange
        funcionario.setIdfuncionario(3);
        funcionario.setNome("Pedro Santos");
        funcionario.setCargo("Analista");

        // Act
        String esperado = "3;Pedro Santos;Analista";
        String obtido = funcionario.toString();

        // Assert
        assertEquals(esperado, obtido);
    }
}