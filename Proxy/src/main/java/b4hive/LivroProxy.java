package b4hive;

import java.util.List;
import java.util.Objects;

public class LivroProxy implements ILivro {
    private final String isbn;
    private final CatalogoLivros catalogo;
    private Livro livro;

    public LivroProxy(String isbn, CatalogoLivros catalogo) {
        this.isbn = isbn;
        this.catalogo = Objects.requireNonNull(catalogo, "Catálogo não pode ser nulo");
    }

    @Override
    public List<String> obterDadosPublicos() {
        return obterLivro().obterDadosPublicos();
    }

    @Override
    public String obterConteudo(Funcionario funcionario) {
        if (funcionario == null || !funcionario.isBibliotecario()) {
            throw new IllegalArgumentException("Funcionário não autorizado");
        }
        return obterLivro().obterConteudo(funcionario);
    }

    private Livro obterLivro() {
        if (livro == null) {
            livro = catalogo.obterLivro(isbn);
        }
        return livro;
    }
}
