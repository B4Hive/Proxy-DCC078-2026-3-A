package b4hive;

import java.util.HashMap;
import java.util.Map;

public class CatalogoLivros {
    private final Map<String, Livro> livros = new HashMap<>();

    public void adicionarLivro(Livro livro) {
        livros.put(livro.getIsbn(), livro);
    }

    public Livro obterLivro(String isbn) {
        Livro livro = livros.get(isbn);
        if (livro == null) {
            throw new IllegalArgumentException("Livro não encontrado");
        }
        return livro;
    }
}
