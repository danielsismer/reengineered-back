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
[![Node.js](https://img.shields.io/badge/Node.js-339933?style=for-the-badge&logo=nodedotjs&logoColor=white)](https://nodejs.org)
[![TypeScript](https://img.shields.io/badge/TypeScript-3178C6?style=for-the-badge&logo=typescript&logoColor=white)](https://www.typescriptlang.org)
[![Clean Architecture](https://img.shields.io/badge/Clean-Architecture-orange?style=for-the-badge)](#arquitetura)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen?style=for-the-badge)](CONTRIBUTING.md)

</div>

---

## 📖 Sobre o Projeto

> *"Não basta funcionar. O código precisa ser estruturado para durar."*

O **reengineered-back** nasceu de uma pergunta simples: *e se reescrevêssemos uma aplicação de loja de frutas do zero, desta vez do jeito certo?*

O resultado é uma API backend construída com **lógica assíncrona otimizada**, **operações CRUD robustas** e uma arquitetura que separa responsabilidades com precisão cirúrgica — combinando **Clean Architecture**, **Arquitetura Hexagonal (Ports & Adapters)** e os princípios **SOLID** em uma base que escala, que testa bem e que você vai querer mostrar para os outros.

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
         │   Drivers (Express, ORM)  │  ← Camada mais externa
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
| `domain/`         | `Fruit`, `FruitId`, regras de negócio puras  |
| `application/`    | `CreateFruitUseCase`, `GetFruitsUseCase`...  |
| `adapters/`       | Controllers HTTP, Repository Implementations |
| `infrastructure/` | ORM, DB config, Express setup, DI Container  |

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

Não como teoria de livro. Cada princípio aplicado com exemplo concreto desta codebase:

#### **S — Single Responsibility Principle**
> *Cada classe tem uma única razão para mudar.*

```typescript
// ❌ Errado: Controller fazendo tudo
class FruitController {
  async create(req, res) {
    const fruit = new Fruit(req.body); // regra de negócio
    await db.query('INSERT ...');       // persistência
    res.json(fruit);                    // apresentação
  }
}

// ✅ Correto: Cada classe com sua responsabilidade
class CreateFruitController {
  constructor(private readonly useCase: CreateFruitUseCase) {}

  async handle(req: Request, res: Response): Promise<void> {
    const output = await this.useCase.execute(req.body);
    res.status(201).json(output);
  }
}
```

---

#### **O — Open/Closed Principle**
> *Aberto para extensão, fechado para modificação.*

```typescript
// A interface (Port) é estável. Novos adaptadores não mudam o Use Case.
interface IFruitRepository {
  findAll(): Promise<Fruit[]>;
  findById(id: FruitId): Promise<Fruit | null>;
  save(fruit: Fruit): Promise<void>;
  delete(id: FruitId): Promise<void>;
}

// Posso adicionar um RedisRepository sem tocar em CreateFruitUseCase
class FruitRepositoryRedis implements IFruitRepository { ... }
class FruitRepositoryPostgres implements IFruitRepository { ... }
class FruitRepositoryInMemory implements IFruitRepository { ... }
```

---

#### **L — Liskov Substitution Principle**
> *Subtipos devem ser substituíveis por seus tipos base.*

```typescript
// Qualquer implementação de IFruitRepository pode ser injetada
// no Use Case sem quebrar o comportamento esperado
const useCase = new CreateFruitUseCase(new FruitRepositoryInMemory());
const useCase = new CreateFruitUseCase(new FruitRepositoryPostgres(db));
// Ambos funcionam identicamente do ponto de vista do Use Case
```

---

#### **I — Interface Segregation Principle**
> *Clientes não devem depender de interfaces que não usam.*

```typescript
// ❌ Interface gorda
interface IRepository {
  findAll(): Promise<Fruit[]>;
  findById(id: string): Promise<Fruit | null>;
  save(fruit: Fruit): Promise<void>;
  delete(id: string): Promise<void>;
  aggregate(): Promise<Stats>;      // Nem todo adapter precisa disso
  exportToCsv(): Promise<string>;   // Nem todo adapter precisa disso
}

// ✅ Interfaces segregadas
interface IFruitReader { findAll(): Promise<Fruit[]>; findById(id: FruitId): Promise<Fruit | null>; }
interface IFruitWriter { save(fruit: Fruit): Promise<void>; }
interface IFruitDeleter { delete(id: FruitId): Promise<void>; }
interface IFruitRepository extends IFruitReader, IFruitWriter, IFruitDeleter {}
```

---

#### **D — Dependency Inversion Principle**
> *Dependa de abstrações, não de implementações concretas.*

```typescript
// ✅ Use Case depende da abstração (Port), não da implementação concreta
class CreateFruitUseCase {
  constructor(
    private readonly fruitRepository: IFruitRepository, // ← interface
  ) {}

  async execute(dto: CreateFruitDTO): Promise<CreateFruitOutput> {
    const fruit = Fruit.create(dto.name, dto.price, dto.stock);
    await this.fruitRepository.save(fruit);
    return FruitMapper.toOutput(fruit);
  }
}
```

O container de DI (Injeção de Dependência) cuida de conectar as abstrações às implementações concretas em tempo de execução.

---

## 📁 Estrutura de Pastas

```
reengineered-back/
│
├── src/
│   ├── domain/                        # 🏆 Núcleo — zero dependências externas
│   │   ├── entities/
│   │   │   └── Fruit.ts               # Entidade rica com regras de negócio
│   │   ├── value-objects/
│   │   │   ├── FruitId.ts             # ID tipado, imutável
│   │   │   ├── FruitName.ts           # Valida e encapsula o nome
│   │   │   └── FruitPrice.ts          # Garante preço > 0
│   │   └── repositories/
│   │       └── IFruitRepository.ts    # Port: contrato de persistência
│   │
│   ├── application/                   # 🎯 Casos de Uso — orquestra o domínio
│   │   ├── use-cases/
│   │   │   ├── CreateFruitUseCase.ts
│   │   │   ├── GetFruitsUseCase.ts
│   │   │   ├── UpdateFruitUseCase.ts
│   │   │   └── DeleteFruitUseCase.ts
│   │   └── dtos/
│   │       ├── CreateFruitDTO.ts
│   │       └── UpdateFruitDTO.ts
│   │
│   ├── adapters/                      # 🔌 Adapters — conectam o mundo ao domínio
│   │   ├── http/
│   │   │   ├── controllers/
│   │   │   │   └── FruitController.ts
│   │   │   └── routes/
│   │   │       └── fruit.routes.ts
│   │   └── repositories/
│   │       ├── FruitRepositoryPostgres.ts    # Driven Adapter (DB real)
│   │       └── FruitRepositoryInMemory.ts    # Driven Adapter (testes)
│   │
│   └── infrastructure/                # ⚙️ Config, DI, Framework bootstrap
│       ├── database/
│       │   └── connection.ts
│       ├── container/
│       │   └── index.ts               # Injeção de Dependência
│       └── server.ts
│
├── tests/
│   ├── unit/                          # Testam entidades e use cases isolados
│   └── integration/                   # Testam adapters com DB real
│
├── .env.example
├── docker-compose.yml
├── package.json
└── tsconfig.json
```

---

## ⚡ Async-First: CRUD Robusto

Todas as operações são **100% assíncronas**, evitando blocking I/O e garantindo throughput máximo.

```typescript
// Exemplo: GetFruitsUseCase com paginação assíncrona
export class GetFruitsUseCase {
  constructor(private readonly repo: IFruitRepository) {}

  async execute(query: GetFruitsQuery): Promise<PaginatedOutput<FruitOutput>> {
    const [fruits, total] = await Promise.all([
      this.repo.findAll({ page: query.page, limit: query.limit }),
      this.repo.count(),
    ]);

    return {
      data: fruits.map(FruitMapper.toOutput),
      total,
      page: query.page,
      totalPages: Math.ceil(total / query.limit),
    };
  }
}
```

Uso de `Promise.all` onde operações são independentes, evitando waterfalls desnecessários.

---

## 🔌 Endpoints da API

| Método   | Rota               | Descrição                     |
|----------|--------------------|-------------------------------|
| `GET`    | `/fruits`          | Lista todas as frutas (paginado) |
| `GET`    | `/fruits/:id`      | Busca uma fruta por ID        |
| `POST`   | `/fruits`          | Cria uma nova fruta           |
| `PUT`    | `/fruits/:id`      | Atualiza uma fruta existente  |
| `DELETE` | `/fruits/:id`      | Remove uma fruta              |

### Exemplo de Request/Response

```bash
POST /fruits
Content-Type: application/json

{
  "name": "Manga Palmer",
  "price": 4.99,
  "stock": 150
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

- Node.js 18+
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
npm install
npm run dev
```

A API estará disponível em `http://localhost:3000` 🎉

---

## 🧪 Testes

A separação de camadas torna os testes **simples, rápidos e confiáveis**.

```bash
# Testes unitários (sem banco de dados — usa InMemoryRepository)
npm run test:unit

# Testes de integração (com banco de dados real via Docker)
npm run test:integration

# Coverage completo
npm run test:coverage
```

**Por que os testes são rápidos aqui?** Porque os Use Cases são testados com o `FruitRepositoryInMemory`. Nenhuma chamada de banco. Nenhum I/O. Puro TypeScript.

```typescript
// Teste de Use Case — sem banco, sem mock framework, sem magia negra
describe('CreateFruitUseCase', () => {
  it('should create a fruit successfully', async () => {
    const repo = new FruitRepositoryInMemory();
    const useCase = new CreateFruitUseCase(repo);

    const output = await useCase.execute({
      name: 'Banana Prata',
      price: 2.50,
      stock: 200,
    });

    expect(output.name).toBe('Banana Prata');
    expect(output.price).toBe(2.50);
  });
});
```

---

## 🧠 Por que Re-engenharia?

A versão original da aplicação tinha problemas clássicos de código que cresce sem planejamento:

| Problema Original                    | Solução Aplicada                          |
|--------------------------------------|-------------------------------------------|
| Lógica de negócio nos controllers    | Use Cases isolados na camada Application  |
| Dependência direta do ORM no domínio | Ports & Adapters (IFruitRepository)       |
| Callbacks aninhados (callback hell)  | Async/Await consistente em toda a base    |
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

**Feito com 🍊 e boas práticas por [danielsismer](https://github.com/danielsismer)**

*"Código limpo não é sobre ser perfeito. É sobre ser honesto com o próximo dev — que provavelmente será você mesmo."*

</div>
