package com.appXXX.main;

import com.appXXX.model.Produto;
import com.appXXX.model.Verdura;
import com.appXXX.view.Atendente;
import com.appXXX.service.Estoque;
import com.appXXX.model.Fruta;

public class Main {

	public static void main(String[] args) {
		
		Estoque estoque = new Estoque();
		Atendente atendente = new Atendente();
		Fruta fruta = new Fruta();
		Verdura verdura = new Verdura();
		Produto produto = new Produto();
		
		while (true) {
			
			int opcao = atendente.menuPrincipal();
			
			estoque.gerenciarEstoque(opcao, atendente, fruta, verdura, produto);

		}
		
		
		
		
		
		

	}

}
