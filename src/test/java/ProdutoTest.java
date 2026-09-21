import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    @Test
    void deveCalcularValorTotalDoProduto() {

        // Arrange
        Produto produto = new Produto("Mouse", 10, 100.0);

        // Act
        double resultado = produto.calcularValorEstoque();

        // Assert
        assertEquals(1000.0, resultado);
    }

    @Test
    void deveAdicionarEstoque() {
        Produto produto = new Produto("Mouse", 10, 100.0);

        produto.adicionarEstoque(5);

        assertEquals(15, produto.getQuantidade());
    }

    @Test
    void deveRemoverEstoqueQuandoQuantidadeForSuficiente() {
        Produto produto = new Produto("Mouse", 10, 100.0);

        boolean resultado = produto.removerEstoque(4);

        assertTrue(resultado);

        assertEquals(6, produto.getQuantidade());

    }

    @Test
    void naoDeveRemoverEstoqueQuandoQuantidadeForInsuficiente() {
        Produto produto = new Produto("Mouse", 10, 100.0);

        boolean resultado = produto.removerEstoque(15);

        assertFalse(resultado);
        assertEquals(10, produto.getQuantidade());
    }

    @Test
    void deveLancarExceptionQuandoNomeForVazio() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Produto("", 10, 100.0)
        );
    }

    @Test
    void deveLancarExceptionQuandoPrecoForInvalido() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Produto("Mouse", 10, 0)
        );

        assertEquals(
                "Preço deve ser maior que zero",
                exception.getMessage()
        );
    }

}