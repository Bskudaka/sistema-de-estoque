import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque {

    private List<Produto> produtos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    public void adicionarProduto(Produto produto) {
        for (Produto p : produtos) {
            if (produto.getNome().equalsIgnoreCase(p.getNome())) {
                throw new IllegalArgumentException("Produto já cadastrado");
            }
        }
        produtos.add(produto);
    }

    public Produto buscarProdutoPorNome(String nome) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
                return produtos.get(i);
            }
        }
        return null;
    }

    public boolean removerProduto(String nome) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
                produtos.remove(i);
                return true;
            }
        }
        return false;
    }

    public Produto encontrarProdutoMaisCaro() {
        Produto produtoMaisCaro = produtos.getFirst();
        for (int i = 1; i < produtos.size(); i++) {
            if (produtos.get(i).getPreco() > produtoMaisCaro.getPreco()) {
                produtoMaisCaro = produtos.get(i);
            }
        }
        return produtoMaisCaro;
    }

    public double calcularValorTotalEstoque() {
        double totalEstoque = 0;
        for (Produto p : produtos) {
            totalEstoque += p.calcularValorEstoque();
        }
        return totalEstoque;
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

}
