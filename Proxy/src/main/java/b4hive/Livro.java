package b4hive;

import java.util.Arrays;
import java.util.List;

public class Livro implements ILivro {
    private final String isbn;
    private final String titulo;
    private final String autor;
    private final String conteudo;

    public Livro(String isbn, String titulo, String autor, String conteudo) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.conteudo = conteudo;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public List<String> obterDadosPublicos() {
        return Arrays.asList(titulo, autor);
    }

    @Override
    public String obterConteudo(Funcionario funcionario) {
        return conteudo;
    }
}
