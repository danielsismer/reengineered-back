<div align="center">

```
██████╗ ███████╗███████╗███╗   ██╗ ██████╗ ██╗███╗   ██╗███████╗███████╗██████╗ ███████╗██████╗
██╔══██╗██╔════╝██╔════╝████╗  ██║██╔════╝ ██║████╗  ██║██╔════╝██╔════╝██╔══██╗██╔════╝██╔══██╗
██████╔╝█████╗  █████╗  ██╔██╗ ██║██║  ███╗██║██╔██╗ ██║█████╗  █████╗  ██████╔╝█████╗  ██║  ██║
██╔══██╗██╔══╝  ██╔══╝  ██║╚██╗██║██║   ██║██║██║╚██╗██║██╔══╝  ██╔══╝  ██╔══██╗██╔══╝  ██║  ██║
██║  ██║███████╗███████╗██║ ╚████║╚██████╔╝██║██║ ╚████║███████╗███████╗██║  ██║███████╗██████╔╝
╚═╝  ╚═╝╚══════╝╚══════╝╚═╝  ╚═══╝ ╚═════╝ ╚═╝╚═╝  ╚═══╝╚══════╝╚══════╝╚═╝  ╚═╝╚══════╝╚═════╝
```

### 🍎 A fruit store API — reimagined from the ground up.
### Clean Architecture · Hexagonal Design · SOLID Principles · Async-First CRUD

<br/>

[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg?style=for-the-badge)](LICENSE)
[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Clean Architecture](https://img.shields.io/badge/Clean-Architecture-orange?style=for-the-badge)](#arquitetura)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen?style=for-the-badge)](CONTRIBUTING.md)

</div>

---

## 📖 Sobre o Projeto

> *"Não basta funcionar. O código precisa ser estruturado para durar."*

O **reengineered-back** nasceu de uma pergunta simples: *e se reescrevêssemos uma aplicação de loja de frutas do zero, desta vez do jeito certo?*

O resultado é uma API backend construída com **lógica de negócio robusta**, **operações CRUD performáticas** e uma arquitetura que separa responsabilidades com precisão cirúrgica — combinando **Clean Architecture**, **Arquitetura Hexagonal (Ports & Adapters)** e os princípios **SOLID** em uma base que escala, que testa bem e que você vai querer mostrar para os outros.

---

## 🏛️ Arquitetura

A alma do projeto. Não uma, mas **três camadas de boas práticas** funcionando em harmonia.

### Clean Architecture + Hexagonal: O Casamento Perfeito

```
┌─────────────────────────────────────────────────────────────┐
│                      MUNDO EXTERNO                          │
│   HTTP Clients · Databases · Message Queues · File System   │
└──────────────────────────┬──────────────────────────────────┘
                           │
┌──────────────────────────▼──────────────────────────────────┐
│                    ADAPTERS (Driving)                        │
│         Controllers · Routes · DTOs · Serializers           │
│                   [ HTTP In → Domain ]                       │
└──────────────────────────┬──────────────────────────────────┘
                           │
┌──────────────────────────▼──────────────────────────────────┐
│                  APPLICATION LAYER                           │
│          Use Cases · Command Handlers · Queries              │
│         Orquestra o domínio sem conhecer infraestrutura     │
└──────────────────────────┬──────────────────────────────────┘
                           │
┌──────────────────────────▼──────────────────────────────────┐
│                    DOMAIN LAYER  🏆                          │
│        Entities · Value Objects · Domain Services           │
│         Aggregates · Domain Events · Interfaces (Ports)     │
│              ← Nenhuma dependência externa →                │
└──────────────────────────┬──────────────────────────────────┘
                           │
┌──────────────────────────▼──────────────────────────────────┐
│                  ADAPTERS (Driven)                           │
│      Repositories · External APIs · Mailers · Cache         │
│                  [ Domain → Infrastructure ]                 │
└─────────────────────────────────────────────────────────────┘
```

O **domínio nunca sabe quem está batendo na porta**. Ele define *o que precisa* (Ports), e os Adapters entregam. Quer trocar o banco de dados? Trocar o framework HTTP? Nenhum Use Case sabe disso. Nenhum precisa saber.

---

### 🔵 Clean Architecture em Detalhe

A Arquitetura Limpa de Uncle Bob garante que as **regras de negócio sejam independentes** de frameworks, bancos de dados e interfaces externas. A regra de ouro: **as dependências só apontam para dentro**.

```
         ┌───────────────────────────┐
         │      Frameworks &         │
         │   Drivers (Spring, JPA)   │  ← Camada mais externa
         │  ┌─────────────────────┐  │
         │  │   Interface Adapters│  │  ← Controllers, Gateways
         │  │  ┌───────────────┐  │  │
         │  │  │  Application  │  │  │  ← Use Cases
         │  │  │  ┌─────────┐  │  │  │
         │  │  │  │ Domain  │  │  │  │  ← Entities, Rules (centro)
         │  │  │  └─────────┘  │  │  │
         │  │  └───────────────┘  │  │
         │  └─────────────────────┘  │
         └───────────────────────────┘
                   ↑ dependências fluem para dentro
```

**No contexto desta aplicação:**

| Camada            | O que vive aqui                              |
|-------------------|----------------------------------------------|
| `domain/`         | `Product`, `Stock`, regras de negócio puras|
| `application/`    | `SaveProductUseCase`, `FindStockUseCase`... |
| `presentation/`    | Controllers REST, DTOs de entrada         |
| `infrastructure/` | Spring Boot, JPA, Hibernate, Docker |

---

### 🔷 Arquitetura Hexagonal (Ports & Adapters)

Criada por Alistair Cockburn, a arquitetura hexagonal trata a aplicação como um **hexágono** rodeado de adaptadores. O interior é puro; o mundo externo se adapta a ele — nunca ao contrário.

```
                        ┌─────────────────┐
        HTTP Request ──►│   HTTP Adapter  │
                        └────────┬────────┘
                                 │ usa
                        ┌────────▼────────┐
        CLI Command ───►│  CLI  Adapter   │
                        └────────┬────────┘
                                 │ usa
                        ┌────────▼──────────────────────────────┐
                        │                                        │
                        │         APPLICATION CORE               │
                        │                                        │
                        │  ┌─────────────────────────────────┐  │
                        │  │         USE CASES               │  │
                        │  │  createFruit · updateFruit      │  │
                        │  │  listFruits  · deleteFruit      │  │
                        │  └────────────┬────────────────────┘  │
                        │               │ depends on             │
                        │  ┌────────────▼────────────────────┐  │
                        │  │    DOMAIN (Entities + Ports)    │  │
                        │  │  IFruitRepository (interface)   │  │
                        │  └─────────────────────────────────┘  │
                        │                                        │
                        └───────────────┬────────────────────────┘
                                        │ implementado por
                        ┌───────────────▼────────────────┐
                        │     PostgreSQL Adapter          │
                        │  (FruitRepositoryPostgres)      │
                        └────────────────────────────────┘
                        ┌───────────────────────────────────┐
                        │       In-Memory Adapter            │
                        │  (FruitRepositoryInMemory) 🧪     │
                        └───────────────────────────────────┘
```

**Ports** são interfaces definidas no domínio. **Adapters** são as implementações concretas. Isso significa:

- ✅ Testar use cases **sem banco de dados** (In-Memory Adapter)
- ✅ Trocar PostgreSQL por MongoDB **sem alterar uma linha de negócio**
- ✅ Expor via HTTP, CLI ou gRPC **com o mesmo core**

---

### 🟡 SOLID na Prática

Não como teoria de livro. Cada princípio aplicado com exemplos reais comparando o código legado (`legacy`) com a nova arquitetura (`reengineered`):

#### **S — Single Responsibility Principle (Princípio da Responsabilidade Única)**
> *Uma classe deve ter um, e apenas um, motivo para mudar.*

*   **❌ Errado (`legacy`):** A classe `Estoque` gerenciava a lista de produtos, processava a lógica de menus, lidava com entrada/saída de dados e chamava métodos da View.
*   **✅ Correto (`reengineered`):** Responsabilidades divididas. O `SaveStockUseCase` apenas salva o estoque, enquanto o `StockController` cuida da entrada HTTP e o `StockPort` da abstração de persistência.

```java
// ❌ Errado: Estoque faz tudo (Lógica + UI + Coleção)
public class Estoque {
    public void gerenciarEstoque(int opcao, Atendente atendente, ...) {
        switch (opcao) {
            case 1 -> { 
                produto = atendente.escolhaCadastrar(produto);
                estoqueProdutos.add(produto); 
            }
        }
    }
}

// ✅ Correto: Caso de uso com responsabilidade única
@Component
public class SaveStockUseCase {
    private final StockPort repository;

    public Stock execute(Stock stock) { 
        return repository.save(stock); 
    }
}
```

---

#### **O — Open/Closed Principle (Princípio Aberto/Fechado)**
> *Objetos ou entidades devem estar abertos para extensão, mas fechados para modificação.*

*   **❌ Errado (`legacy`):** Para adicionar uma nova funcionalidade (ex: um novo tipo de listagem), era necessário modificar o `switch/case` central na classe `Estoque`.
*   **✅ Correto (`reengineered`):** Novas funcionalidades são adicionadas criando novos Use Cases ou implementando novas interfaces, sem alterar o código core existente.

---

#### **L — Liskov Substitution Principle (Princípio da Substituição de Liskov)**
> *Uma classe derivada deve ser substituível por sua classe base.*

*   **❌ Errado (`legacy`):** Uso massivo de `instanceof` para verificar se um `Produto` era `Fruta` ou `Verdura`, quebrando a polimorfia e o princípio de substituição.
*   **✅ Correto (`reengineered`):** Uso de composição e tipos genéricos. A entidade `Product` possui uma `Category`, permitindo que qualquer produto seja tratado de forma uniforme pelo domínio.

```java
// ❌ Errado: Verificação manual de tipos (instanceof)
for (Produto p : estoqueProdutos) {
    if (p instanceof Fruta f) {
        atendente.listarProduto(f, cont);
    }
}

// ✅ Correto: Domínio uniforme e polimórfico
public class Product {
    private Category category; // Composição em vez de herança forçada
    // Métodos agem sobre o Produto independente do tipo
}
```

---

#### **I — Interface Segregation Principle (Princípio da Segregação de Interface)**
> *Uma classe não deve ser forçada a depender de métodos que não utiliza.*

*   **❌ Errado (`legacy`):** A classe `Atendente` (View) funcionava como uma "Interface Gorda", misturando cadastros de diferentes tipos, exclusões e menus em um único lugar.
*   **✅ Correto (`reengineered`):** Interfaces (Ports) específicas para cada domínio (`StockPort`, `ProductPort`, `UserPort`), garantindo que cada adaptador implemente apenas o necessário.

---

#### **D — Dependency Inversion Principle (Princípio da Inversão de Dependência)**
> *Dependa de abstrações e não de implementações.*

*   **❌ Errado (`legacy`):** Acoplamento direto com implementações concretas (ex: `ArrayList` direto no campo, dependência direta da classe `Atendente`).
*   **✅ Correto (`reengineered`):** O Use Case depende da interface `StockPort`. Não importa se a persistência é em JPA, MongoDB ou em memória, o core não muda.

```java
// ✅ Correto: Dependendo da abstração (Port)
public class SaveStockUseCase {
    private final StockPort repository; // Interface, não implementação concreta (JPA)

    public SaveStockUseCase(StockPort repository) {
        this.repository = repository;
    }
}
```

---

---

## 📁 Estrutura de Pastas

```
reenginered/
│
├── src/main/java/com/weg/reenginered/
│   ├── domain/                        # 🏆 Núcleo — Regras de negócio puras
│   │   ├── entity/                    # Entidades (Product, Stock, Category)
│   │   ├── port/                      # Interfaces (Ports) para persistência
│   │   └── exception/                 # Exceções de domínio
│   │
│   ├── application/                   # 🎯 Casos de Uso — Orquestração
│   │   ├── usecase/                   # Lógica específica (SaveProduct, FindStock)
│   │   ├── facade/                    # Fachadas para simplificar chamadas
│   │   └── mapper/                    # Conversão DTO/Entity/JPA
│   │
│   ├── presentation/                  # 🔌 Entrada (Driving Adapters)
│   │   └── controller/                # Endpoints REST
│   │
│   └── infrastructure/                # ⚙️ Implementação (Driven Adapters)
│       ├── persistence/               # Implementação JPA e Adapters de Repositório
│       └── config/                    # Configurações do Spring
│
├── pom.xml                            # Dependências do Maven
└── docker-compose.yml                 # Infraestrutura (DB)
```

---


## 🔌 Endpoints da API

| Método   | Rota               | Descrição                     |
|----------|--------------------|-------------------------------|
| `GET`    | `/product`         | Lista todos os produtos       |
| `GET`    | `/product/:id`     | Busca um produto por ID       |
| `POST`   | `/product`         | Cria um novo produto          |
| `PUT`    | `/product/:id`     | Atualiza um produto existente |
| `DELETE` | `/product/:id`     | Remove um produto             |

### Exemplo de Request/Response

```bash
POST /product
Content-Type: application/json

{
  "name": "Manga Palmer",
  "price": 4.99,
  "quantity": 150,
  "description": "Manga Palmer madura e suculenta",
  "urlImage": "http://link-da-imagem.com",
  "category": { "id": 1 }
}
```

```json
HTTP/1.1 201 Created
{
  "id": "a3f1c2d4-...",
  "name": "Manga Palmer",
  "price": 4.99,
  "stock": 150,
  "createdAt": "2024-01-15T10:30:00.000Z"
}
```

---

## 🚀 Como Rodar

### Pré-requisitos

- Java 17+
- Maven
- Docker & Docker Compose

### 1. Clone o repositório

```bash
git clone https://github.com/danielsismer/reengineered-back.git
cd reengineered-back
```

### 2. Configure as variáveis de ambiente

```bash
cp .env.example .env
# Edite o .env com suas configurações
```

### 3. Suba a infra com Docker

```bash
docker-compose up -d
```

### 4. Instale as dependências e rode

```bash
# 4. Rode a aplicação com Maven
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:3000` 🎉

---

## 🧪 Testes

A separação de camadas torna os testes **simples, rápidos e confiáveis**.

```bash
# Testes unitários (sem banco de dados — usa InMemoryRepository)
```bash
# Executar todos os testes
./mvnw test
```

**Por que os testes são confiáveis aqui?** Porque a arquitetura permite testar Use Cases isoladamente de IO, garantindo rapidez e precisão na validação das regras de negócio.

---

## 🧠 Por que Re-engenharia?

A versão original da aplicação tinha problemas clássicos de código que cresce sem planejamento:

| Problema Original                    | Solução Aplicada                          |
|--------------------------------------|-------------------------------------------|
| Lógica de negócio nos controllers    | Use Cases isolados na camada Application  |
| Dependência direta do ORM no domínio | Ports & Adapters (IFruitRepository)       |
| Callbacks aninhados (callback hell)  | Java Stream API e clean code            |
| Classes com múltiplas responsabilidades | SRP: cada classe faz uma coisa           |
| Dificuldade para testar              | InMemoryRepository para testes rápidos   |
| Framework acoplado ao negócio        | Domain completamente framework-agnostic  |

---

## 🤝 Contribuindo

Contribuições são bem-vindas! Por favor, leia o [CONTRIBUTING.md](CONTRIBUTING.md) para detalhes sobre o processo de Pull Request.

```bash
# Fork → Clone → Branch → Commit → PR
git checkout -b feature/nova-funcionalidade
git commit -m "feat: adiciona funcionalidade X"
git push origin feature/nova-funcionalidade
```

---

## 📚 Referências e Leituras

- 📗 [Clean Architecture — Robert C. Martin (Uncle Bob)](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
- 📘 [Hexagonal Architecture — Alistair Cockburn](https://alistair.cockburn.us/hexagonal-architecture/)
- 📙 [SOLID Principles — Wikipedia](https://en.wikipedia.org/wiki/SOLID)
- 📕 [Domain-Driven Design — Eric Evans](https://martinfowler.com/bliki/DomainDrivenDesign.html)

---

## 📄 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

---

<div align="center">

**Feito com 🍊 e boas práticas por [danielsismer](https://github.com/danielsismer) e [hugodeleon](https://github.com/HugoDeleonP)**

*"Código limpo não é sobre ser perfeito. É sobre ser honesto com o próximo dev — que provavelmente será você mesmo."*

</div>
