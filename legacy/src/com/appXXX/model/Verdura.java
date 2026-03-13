package com.appXXX.model;

public class Verdura extends Produto{

    private String tipo;

    public Verdura(String nome, double preco, int quantidade, String tipo) {
        super(nome, preco, quantidade);
        this.tipo = tipo;
    }

    public Verdura() {
        super();
        this.tipo = null;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return  "\n----------------------------------------" +
                "\n🥦 Nome da Verdura   : " + getNome() +
                "\n💲 Preço             : R$ " + String.format("%.2f", getPreco()) +
                "\n📦 Quantidade        : " + getQuantidade() + " unidade(s)" +
                "\n🥬 Tipo             : " + tipo +
                "\n----------------------------------------";
    }



}
