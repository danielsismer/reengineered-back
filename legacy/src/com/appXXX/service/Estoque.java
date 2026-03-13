package com.appXXX.service;

import java.util.List;
import java.util.ArrayList;
import com.appXXX.model.Fruta;
import com.appXXX.model.Produto;
import com.appXXX.model.Verdura;
import com.appXXX.view.Atendente;

public class Estoque {


	private List<Produto> estoqueProdutos;

	public Estoque() {
		estoqueProdutos = new ArrayList<>();
	}

	public void gerenciarEstoque(int opcao, Atendente atendente, Fruta fruta, Verdura verdura, Produto produto) {

		switch (opcao) {

			case 1 -> {

				while (true){

					int escolhaCadastrar = atendente.escolhaItemCadastro();

					if (escolhaCadastrar == 1) { produto = atendente.escolhaCadastrar(produto); estoqueProdutos.add(produto); break;}

					else if (escolhaCadastrar == 2) { produto = atendente.cadastrarVerdura(produto); estoqueProdutos.add(produto); break;}

					else { atendente.opcaoInvalida(); }
				}

			}

			case 2 -> {

				while (true){

					int cont = 1;
					opcao = atendente.escolhaListar();
					System.out.println();

					if (estoqueProdutos.isEmpty()){ atendente.estoqueVazio(); break; }

					else if  (opcao == 1) { atendente.msgCadastrado(); for (Produto p : estoqueProdutos) { atendente.listarProduto(p, cont); cont++; } break; }

					else if (opcao == 2) {
						boolean semFruta = estoqueProdutos.stream().noneMatch(product -> product instanceof Fruta);

						if (semFruta) {
							atendente.estoqueVazio();
							break;
						}

						atendente.msgCadastrado();
						cont = 1;

						for (Produto p : estoqueProdutos) {
							if (p instanceof Fruta f) {
								atendente.listarProduto(f, cont);
								cont++;
							}
						}
						break;
					}

					else if (opcao == 3) {
						boolean semVerdura = estoqueProdutos.stream().noneMatch(product -> product instanceof Verdura);

						if (semVerdura) {
							atendente.estoqueVazio();
							break;
						}

						atendente.msgCadastrado();
						cont = 1;

						for (Produto p : estoqueProdutos) {
							if (p instanceof Verdura v) {
								atendente.listarProduto(v, cont);
								cont++;
							}
						}
						break;
					}

					else { atendente.opcaoInvalida(); }

				}

			}

			case 3 -> {

				while (true){

					int cont = 1;
					atendente.menuExcluir();
					opcao = atendente.escolhaCategoriaExcluir();

					if (opcao == 1) {
						boolean semFruta = estoqueProdutos.stream().noneMatch(product -> product instanceof Fruta);

						if (semFruta) {
							atendente.estoqueVazio();
							break;
						} else {
							for (Produto p : estoqueProdutos) {
								if (p instanceof Fruta f) {
									System.out.println();
									atendente.listarProduto(f, cont);
									cont++;
								}
							}
						}

						String nomeFruta = atendente.escolhaExcluirFruta();

						for (cont = estoqueProdutos.size() - 1; cont >= 0; cont--) {
							Produto p = estoqueProdutos.get(cont);
							if (nomeFruta.equals(p.getNome())) {
								estoqueProdutos.remove(cont);
								break;
							} else {
								atendente.produtoNaoEncontrado();
							}
						}

						break;
					}

					else if (opcao == 2) {
						boolean semVerdura = estoqueProdutos.stream().noneMatch(product -> product instanceof Verdura);

						if (semVerdura) {
							atendente.estoqueVazio();
							break;
						} else {
							for (Produto p : estoqueProdutos) {
								if (p instanceof Verdura v) {
									System.out.println();
									atendente.listarProduto(v, cont++);
								}
							}
						}

						String nomeVerdura = atendente.escolhaExcluirVerdura();

						for ( cont = estoqueProdutos.size() - 1; cont >= 0; cont--) {
							Produto p = estoqueProdutos.get(cont);
							if (nomeVerdura.equals(p.getNome())) {
								estoqueProdutos.remove(cont);
							} else {
								atendente.produtoNaoEncontrado();
							}
						}

						break;
					}

					else {
						atendente.opcaoInvalida();
					}

				}


			}

			case 4 -> {
				String itemPesquisar = atendente.pesquisarProduto();
				boolean encontrado = false;

				for (Produto p : estoqueProdutos) {
					if (itemPesquisar.equalsIgnoreCase(p.getNome())) {
						atendente.listarProduto(p);
						encontrado = true;
						break;
					}
				}

				if (!encontrado) {
					atendente.produtoNaoEncontrado();
				}
			}


			case 0 -> {
				System.exit(0);
			}

			default -> {
				System.out.println("Opção inválida.");
			}
		}

	}
}
