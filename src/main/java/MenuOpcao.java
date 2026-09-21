import java.util.Scanner;

public class MenuOpcao {

    Estoque estoque = new Estoque();
    Scanner sc = new Scanner(System.in);

    public void exibirMenu() {

        Scanner sc = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar produto");
            System.out.println("4 - Adicionar estoque");
            System.out.println("5 - Remover estoque");
            System.out.println("6 - Produto mais caro");
            System.out.println("7 - Valor total do estoque");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    adicionar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    adicionarEstoque();
                    break;
                case 5:
                    removerEstoque();
                    break;
                case 6:
                    encontrarProdutoMaisCaro();
                    break;
                case 7:
                    calcularValorTotalEstoque();
                    break;
                default:
                    System.out.println("Não existe a opção informada");
            }

        } while (opcao != 0);

    }

    public Produto cadastrarProduto() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Informar o nome do produto: ");
        String nome = sc.next();
        System.out.print("Informar a quantidade: ");
        int quantidade = sc.nextInt();
        System.out.print("Informar o preço R$: ");
        double preco = sc.nextDouble();
        return new Produto(nome, quantidade, preco);
    }

    public String buscarPorNome() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Favor informar o nome do produto: ");
        return sc.next();
    }

    public void adicionar() {
        try {
            estoque.adicionarProduto(cadastrarProduto());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void listar() {
        System.out.println(estoque.listarProdutos());
    }

    public void buscar() {
        Produto produto = estoque.buscarProdutoPorNome(buscarPorNome());
        if (produto == null){
            System.out.println("Produto não localizado");
        }else {
            System.out.println(produto);
        }
    }

    public void adicionarEstoque() {
        Produto produtoLocalizado = estoque.buscarProdutoPorNome(buscarPorNome());
        if (produtoLocalizado == null) {
            System.out.println("Produto não localizado");
        } else {
            System.out.print("Favor informar a quantidade para adicionar no estoque: ");
            int quantidade = sc.nextInt();
            produtoLocalizado.adicionarEstoque(quantidade);
            System.out.println("Quantidade atualizada");
        }
    }

    public void removerEstoque() {
        Produto produto = estoque.buscarProdutoPorNome(buscarPorNome());
        if (produto == null) {
            System.out.println("Produto não localizado");
        } else {
            System.out.print("Favor informar a quantidade para remover no estoque: ");
            int quantidadeRemove = sc.nextInt();
            boolean removeu = produto.removerEstoque(quantidadeRemove);
            if (removeu){
                System.out.println("Quantidade atualizada");
            }else {
                System.out.println("Quantidade inválida ou estoque insuficiente");
            }
        }
    }

    public void encontrarProdutoMaisCaro(){
        System.out.println("Produto mais caro da lista: " + estoque.encontrarProdutoMaisCaro());
    }

    public void calcularValorTotalEstoque(){
        System.out.println("Valor total do estoque R$: " + estoque.calcularValorTotalEstoque());
    }

}
