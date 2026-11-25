package b4hive;

public class Funcionario {
    private final String nome;
    private final boolean bibliotecario;

    public Funcionario(String nome, boolean bibliotecario) {
        this.nome = nome;
        this.bibliotecario = bibliotecario;
    }

    public String getNome() {
        return nome;
    }

    public boolean isBibliotecario() {
        return bibliotecario;
    }
}
