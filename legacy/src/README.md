# 🍎 Sistema de Gerenciamento de Frutas

Bem-vindo ao incrível **Gerenciador de Frutas**! Aqui você descobre, adiciona, lista e exclui suas frutas favoritas, enquanto aprende Java na prática com organização de código e boas práticas de programação orientada a objetos.

## 🚀 Por que organizar o código em pacotes é importante?

Imagine uma feira organizada, onde cada fruta está em sua banca, fácil de encontrar! Com o código é igual: usar pacotes (packages) deixa tudo mais limpo e prático:
- **Organização:** Você encontra cada parte do sistema facilmente, como numa estante bem arrumada.
- **Manutenção rápida:** Precisa mudar algo? Vai direto ao pacote certo, sem se perder.
- **Zero confusão:** Nomes de classes iguais podem existir em pacotes diferentes, sem briga!
- **Reaproveitamento:** Quer usar uma parte em outro projeto? Só levar o pacote inteiro!

## 🧩 O que é o princípio da responsabilidade única?

Pense em um super-herói: cada um tem seu poder e missão! O princípio da responsabilidade única (Single Responsibility Principle - SRP) diz que cada classe no seu projeto também tem uma missão única. Isso traz:
- **Código fácil de ler:** Você entende rapidinho o que cada classe faz.
- **Menos bugs:** Mudou algo em um lugar? Não quebra o resto.
- **Testes simples:** Com classes simples, testar fica muito mais fácil.

## 🥝 O que cada classe faz?

- **Fruta (`model/Fruta.java`)**: O coração do sistema! Representa cada fruta, com nome e cor.
- **FrutaService (`service/FrutaService.java`)**: O gerente da feira! Cadastra, lista e exclui frutas.
- **FrutaView (`view/FrutaView.java`)**: O balconista simpático! Fala com o usuário, recebe pedidos e mostra resultados.
- **Main (`main/Main.java`)**: O maestro! Faz tudo funcionar junto, do início ao fim.

## 📦 Estrutura de Pacotes

```
src/
└── br/
    └── com/
        └── frutas/
            ├── model/
            │     └── Fruta.java
            ├── service/
            │     └── FrutaService.java
            ├── view/
            │     └── FrutaView.java
            └── main/
                  └── Main.java
```

- **model**: Guarda o que é uma fruta.
- **service**: Cuida de todas as operações com frutas.
- **view**: Conversa com o usuário.
- **main**: Inicia o sistema.

## 💡 Conceitos Aplicados

### 1. Package

O código é modularizado em pacotes, como setores em um supermercado, facilitando a organização e manutenção.

### 2. Encapsulamento

A classe `Fruta` protege seus dados com atributos privados e libera acesso seguro com getters e setters:

```java
package br.com.frutas.model;

public class Fruta {
    private String nome;
    private String cor;

    public Fruta(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
}
```

### 3. S do SOLID — Responsabilidade Única

Cada classe faz só o que precisa:
- `Fruta`: só cuida dos dados da fruta.
- `FrutaService`: só gerencia as operações.
- `FrutaView`: só fala com o usuário.
- `Main`: só orquestra o show.

Exemplo de classe de serviço:

```java
package br.com.frutas.service;

import java.util.ArrayList;
import java.util.List;
import br.com.frutas.model.Fruta;

public class FrutaService {
    private List<Fruta> frutas = new ArrayList<>();

    public void cadastrar(Fruta fruta) {
        frutas.add(fruta);
    }

    public List<Fruta> listar() {
        return new ArrayList<>(frutas);
    }

    public boolean excluir(String nome) {
        return frutas.removeIf(f -> f.getNome().equalsIgnoreCase(nome));
    }
}
```

Exemplo de classe view (resumido):

```java
package br.com.frutas.view;

import java.util.Scanner;
import br.com.frutas.model.Fruta;

public class FrutaView {
    private Scanner scanner = new Scanner(System.in);

    public Fruta lerFruta() {
        System.out.print("Nome da fruta: ");
        String nome = scanner.nextLine();
        System.out.print("Cor da fruta: ");
        String cor = scanner.nextLine();
        return new Fruta(nome, cor);
    }

    public String lerNomeFrutaParaExcluir() {
        System.out.print("Nome da fruta para excluir: ");
        return scanner.nextLine();
    }

    public void mostrarFrutas(java.util.List<Fruta> frutas) {
        frutas.forEach(f -> System.out.println(f.getNome() + " - " + f.getCor()));
    }
}
```

## ▶️ Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/seurepositorio.git
   ```
2. Compile os arquivos Java:
   ```bash
   javac -d bin src/br/com/frutas/**/*.java
   ```
3. Execute a aplicação:
   ```bash
   java -cp bin br.com.frutas.main.Main
   ```

## ⚙️ Requisitos

- JDK 8 ou superior

## 📜 Licença

MIT

---

Projeto didático para aprender, praticar e se divertir programando em Java! 🍉🍇🍌
