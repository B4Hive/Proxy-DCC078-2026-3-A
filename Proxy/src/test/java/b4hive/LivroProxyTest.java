package b4hive;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LivroProxyTest {
    private CatalogoLivros catalogo;

    @BeforeEach
    void setUp() {
        catalogo = new CatalogoLivros();
        catalogo.adicionarLivro(new Livro(
                "978-1",
                "O Hobbit",
                "J. R. R. Tolkien",
                "Conteúdo integral do livro"));
    }

    @Test
    void deveRetornarDadosPublicosDoLivro() {
        ILivro livro = new LivroProxy("978-1", catalogo);

        assertEquals(Arrays.asList("O Hobbit", "J. R. R. Tolkien"), livro.obterDadosPublicos());
    }

    @Test
    void bibliotecarioPodeObterConteudoDoLivro() {
        ILivro livro = new LivroProxy("978-1", catalogo);
        Funcionario bibliotecario = new Funcionario("Ana", true);

        assertEquals("Conteúdo integral do livro", livro.obterConteudo(bibliotecario));
    }

    @Test
    void usuarioNaoAutorizadoNaoPodeObterConteudoDoLivro() {
        ILivro livro = new LivroProxy("978-1", catalogo);
        Funcionario visitante = new Funcionario("João", false);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> livro.obterConteudo(visitante));

        assertEquals("Funcionário não autorizado", exception.getMessage());
    }

    @Test
    void deveIndicarQuandoLivroNaoExisteNoCatalogo() {
        ILivro livro = new LivroProxy("isbn-ausente", catalogo);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                livro::obterDadosPublicos);

        assertEquals("Livro não encontrado", exception.getMessage());
    }
}
