package com.appXXX.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.appXXX.model.Fruta;
import com.appXXX.model.Produto;
import com.appXXX.model.Verdura;

public class Atendente {

	private Scanner input;

	public Atendente() {
		input = new Scanner(System.in);
	}

	public int menuPrincipal() {
		while (true) {
			try {
				System.out.println();
				System.out.println("=====================================================================");
				System.out.println("||                    🌿 Bem-vindo à Frutaria 2.0! 🍎               ||");
				System.out.println("=====================================================================");
				System.out.println("||                                                                  ||");
				System.out.println("||   1 - 📝 Cadastrar Produtos                                      ||");
				System.out.println("||   2 - 🍉 Listar Produtos                                         ||");
				System.out.println("||   3 - ❌ Remover Produtos                                        ||");
				System.out.println("||   4 - 🔍 Pesquisar Produtos                                      ||");
				System.out.println("||   0 - 🚪 Sair                                                    ||");
				System.out.println("=====================================================================");
				System.out.print("➡️  Sua escolha: ");

				int escolha = input.nextInt();
				input.nextLine();
				System.out.println();
				return escolha;

			} catch (InputMismatchException e) {
				System.out.println("\n❗ Entrada inválida! Apenas números são permitidos.");
				input.nextLine();
			}
		}
	}

	public Produto escolhaCadastrar(Produto produto) {
		System.out.println();
		System.out.println("========= 🍓 Cadastro de Fruta =========");
		System.out.print("Nome da fruta: 🍓 ");
		String nome = input.nextLine();

		double preco = lerDouble("Preço da fruta: 💲 ");
		int quantidade = lerInt("Quantidade disponível: 📦 ");
		double peso = lerDouble("Peso da fruta (kg): ⚖️ ");

		produto = new Fruta(nome, preco, quantidade, peso);

		System.out.println("✅ Fruta cadastrada com sucesso!");
		System.out.println("=====================================\n");

		return produto;
	}

	public Produto cadastrarVerdura(Produto produto) {
		System.out.println();
		System.out.println("======= 🥦 Cadastro de Verdura =======");
		System.out.print("Nome da verdura: ");
		String nome = input.nextLine();

		double preco = lerDouble("Preço: 💲 ");
		int quantidade = lerInt("Quantidade: 📦 ");
		System.out.print("Tipo da verdura: 🌿 ");
		String tipo = input.nextLine();

		produto = new Verdura(nome, preco, quantidade, tipo);

		System.out.println("✅ Verdura cadastrada com sucesso!\n");

		return produto;
	}

	public void menuExcluir() {
		System.out.println();
		System.out.println("=====================================================================");
		System.out.println("||        ❌ Qual a Categoria do item que deseja remover?           ||");
		System.out.println("=====================================================================");
	}

	public int escolhaItemCadastro() {
		return lerIntMenu("O que deseja cadastrar?\n1️⃣ - Fruta\n2️⃣ - Verdura\n➡️  Sua escolha: ");
	}

	public int escolhaListar() {
		return lerIntMenu("➤ Em qual categoria deseja listar?\n1️⃣ - Produto\n2️⃣ - Fruta\n3️⃣ - Verdura\n➡️  Sua escolha: ");
	}

	public int escolhaCategoriaExcluir() {
		return lerIntMenu("➤ Em qual categoria deseja remover?\n1️⃣ - Fruta\n2️⃣ - Verdura\n➡️  Sua escolha: ");
	}

	public String pesquisarProduto() {
		System.out.print("🔍 Insira o nome do produto:\n➡️  ");
		return input.nextLine();
	}

	public String escolhaExcluirFruta() {
		System.out.print("➡️  Insira o Nome da Fruta: ");
		return input.nextLine();
	}

	public String escolhaExcluirVerdura() {
		System.out.print("➡️  Insira o Nome da Verdura: ");
		return input.nextLine();
	}

	public void msgCadastrado() {
		System.out.print("\n====== ITENS CADASTRADOS ======\n");
	}

	public void listarProduto(Produto p, int cont) {
		System.out.println(cont + ": " + p.getNome());
		System.out.println("=================================");
	}

	public void listarProduto(Produto p) {
		System.out.println(p);
		System.out.println("=================================");
	}

	public void estoqueVazio() {
		System.out.println("=============================");
		System.out.println("       Estoque Vazio!!!       ");
		System.out.println("=============================");
	}

	public void produtoNaoEncontrado() {
		System.out.println("================================================");
		System.out.println("||       ❌ Produto não encontrado            ||");
		System.out.println("================================================");
	}

	public void opcaoInvalida() {
		System.out.println("===============================================");
		System.out.println("||     ❌ Opção Inválida, Tente novamente     ||");
		System.out.println("===============================================");
	}

	private int lerInt(String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem);
				int valor = input.nextInt();
				input.nextLine();
				return valor;
			} catch (InputMismatchException e) {
				System.out.println("❗ Entrada inválida! Digite um número inteiro.");
				input.nextLine();
			}
		}
	}

	private double lerDouble(String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem);
				double valor = input.nextDouble();
				input.nextLine();
				return valor;
			} catch (InputMismatchException e) {
				System.out.println("❗ Entrada inválida! Digite um número com ponto (ex: 4.99).");
				input.nextLine();
			}
		}
	}

	private int lerIntMenu(String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem);
				int valor = input.nextInt();
				input.nextLine();
				return valor;
			} catch (InputMismatchException e) {
				System.out.println("❗ Opção inválida! Digite um número correspondente ao menu.");
				input.nextLine();
			}
		}
	}

}
