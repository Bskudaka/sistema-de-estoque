public class Produto {

    private String nome;
    private int quantidade;
    private double preco;

    public Produto() {
    }

    public Produto(String nome, int quantidade, double preco) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");} else {
        }

        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser menos que zero");
        }

        if (preco <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero");
        }
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public double calcularValorEstoque() {
        return preco * quantidade;
    }

    public boolean adicionarEstoque(int quantidade) {
        if (quantidade <= 0) {
            return false;
        }
        this.quantidade += quantidade;
        return true;
    }

    public boolean removerEstoque(int quantidade) {
        if (quantidade <= 0 || this.quantidade < quantidade) {
            return false;
        }
        this.quantidade -= quantidade;
        return true;
    }


    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }
}
