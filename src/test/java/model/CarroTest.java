package model;

import exception.AceleracaoNegativaException;
import org.junit.*;
import org.junit.rules.ExpectedException;

public class CarroTest {
    @Test
    public void deveIniciarDesligado() {
        System.out.println("deveIniciarDesligado");
        // Given (Dado)
        Carro carro = new Carro();
        // When (Quando)// Then (Então)
        Assert.assertFalse(carro.getLigado());
    }

    @Test
    public void deveLigarCorretamente() throws Exception {
        System.out.println("deveLigarCorretamente");
        // Teste #3 - Deve ligar corretamente
        // Given (Dado)
        Carro carro = new Carro();

        // When (Quando)
        carro.ligar();

        // Then (Então)
        Assert.assertTrue(carro.getLigado());
    }

    @Test
    public void deveIniciarComVelocidadeZero() {
        System.out.println("deveIniciarComVelocidadeZero");
        // Teste #2 - Deve iniciar com velocidade Zero
        // Given (Dado)
        Carro carro = new Carro();
        // When (Quando)
        // Then (Então)
        Assert.assertEquals((Integer) 1, carro.getVelocidadeAtual());
    }

    @Test
    public void deveAcelerarCorretamente() throws Exception {
        System.out.println("deveAcelerarCorretamente");
        // Teste #5 - Deve acelerar corretamente um carro ligado
        // Given (Dado)
        Carro carro = new Carro();

        // When (Quando)
        carro.ligar();
        carro.acelerar(10);

        // Then (Então)
        Assert.assertEquals((Integer) 10, carro.getVelocidadeAtual());
    }

    @Test
    public void naoDeveUltrapassarAVelocidadeMaxima() throws Exception {
        System.out.println("naoDeveUltrapassarAVelocidadeMaxima");
        // Teste #6 - Não pode ultrapassar a velocidade maxima
        // Given
        Carro carro = new Carro(200);

        // When
        carro.ligar();
        carro.acelerar(100);
        carro.acelerar(100);
        carro.acelerar(100);

        // Then
        Assert.assertEquals((Integer) 200, carro.getVelocidadeAtual());
    }

    @Test
    public void naoDeveTerVelocidadeInferiorAZero() throws Exception {
        System.out.println("naoDeveTerVelocidadeInferiorAZero");
        // Given
        Carro carro = new Carro();
        carro.getLigado();
        carro.acelerar(100);

        // When
        carro.frear(50);
        carro.frear(51);

        // Then
        Assert.assertEquals((Integer) 0, carro.getVelocidadeAtual());
    }

    @Test(expected = AceleracaoNegativaException.class)
    public void deveLancarExceptionEmCasoDeAceleracaoNegativa_01() throws Exception {
        Carro carro = new Carro();
        carro.ligar();
        carro.acelerar(-10);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void deveLancarExceptionEmCasoDeAceleracaoNegativa_02() throws Exception {
        Carro carro = new Carro();
        carro.ligar();

        expectedException.expect(Exception.class);
        expectedException.expectMessage("A aceleracao não pode ser menor que zero!");

        carro.acelerar(-10);
    }

    @Test
    public void deveLancarExceptionEmCasoDeAceleracaoNegativa_03() {
        Carro carro = new Carro();
        carro.ligar();

        try {
            carro.acelerar(-10);
            Assert.fail();
        } catch (Exception e) {
            Assert.assertEquals("A aceleracao não pode ser menor que zero!", e.getMessage());
        }
    }

    @Test
    public void deveLancarExceptionEmCasoDeAceleracaoNegativa_04() {
        // 4.13

        Carro carro = new Carro();
        carro.ligar();

        Throwable throwable =
                Assert.assertThrows(Exception.class, () -> carro.acelerar(-10));

        Assert.assertEquals("A aceleracao não pode ser menor que zero!", throwable.getMessage());
    }

        // Testando Exceptions
}
