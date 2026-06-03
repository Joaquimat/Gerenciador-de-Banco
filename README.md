# 💳 Sistema Bancário com JDBC e MySQL

## 📌 Sobre o Projeto

Este projeto é um **sistema bancário simples** desenvolvido em **Java** utilizando **JDBC** e **MySQL**.

O foco principal **não é criar um sistema completo**, mas sim **aprender na prática** conceitos importantes de desenvolvimento backend e banco de dados, entendendo cada etapa da implementação.

---

## 🎯 Objetivos de Aprendizado

* JDBC
* Conexão com banco de dados
* CRUD (Create, Read, Update, Delete)
* PreparedStatement
* ResultSet
* Arquitetura em camadas
* Manipulação de coleções
* Tratamento de exceções SQL

---

## 🧩 Funcionalidades

### Conta Bancária

A entidade principal do sistema é a **Conta**, que possui:

* Número da conta
* Nome do cliente
* Saldo
* CPF
* E-mail

### Funcionalidades implementadas / planejadas:

* Criar conta
* Listar contas
* Buscar conta
* Depositar
* Sacar
* Excluir conta (futuro)

---

## 🗄️ Banco de Dados

* Banco: **MySQL**
* Tabela principal: `conta`

### Estrutura da tabela:

| Campo   | Tipo        |
| ------- | ----------- |
| numero  | BIGINT (PK) |
| cliente | VARCHAR     |
| saldo   | BIGINT      |
| cpf     | VARCHAR     |
| email   | VARCHAR     |

🔑 **Chave primária:** `numero`

---

## 💰 Observação sobre o saldo

Inicialmente foi utilizado:

* `BIGINT` no banco
* `Long` no Java

📌 Porém, o ideal para valores monetários é:

* Banco: `DECIMAL(15,2)`
* Java: `BigDecimal`

Isso evita problemas de precisão com centavos.

---

## 🏗️ Estrutura do Projeto

```
AppBanco (Main)
│
├── connection
│   └── ConnectionFactory
│
├── dao
│   └── ContaDAO
│
└── model
    └── Conta
```

---

## 🔌 Conexão com o Banco

### ConnectionFactory

Responsável por:

* Abrir conexão com o MySQL
* Retornar um objeto `Connection`

Método principal:

```java
Connection recuperarConexao()
```

---

## 📦 Entidade Conta

Classe responsável por representar uma conta bancária.

Possui:

* Atributos privados
* Getters e setters
* Construtores

---

## 🛠️ Camada DAO

### ContaDAO

Responsável por executar operações SQL.

Recebe a conexão no construtor:

```java
public ContaDAO(Connection connection)
```

---

### ✔️ Método `salvar()`

* Insere uma conta no banco
* Utiliza `PreparedStatement`
* Executa `INSERT`

---

### ✔️ Método `listar()`

* Busca todas as contas
* Utiliza `SELECT`
* Retorna:

```java
Set<Conta>
```

---

## 🔍 Conceitos JDBC Utilizados

### Connection

Representa a conexão com o banco.

### DriverManager

Responsável por abrir a conexão:

```java
DriverManager.getConnection(...)
```

### PreparedStatement

Usado para:

* INSERT
* SELECT

Vantagens:

* Evita SQL Injection
* Permite uso de parâmetros (`?`)

### executeUpdate()

Usado para:

* INSERT
* UPDATE
* DELETE

### executeQuery()

Usado para:

* SELECT

Retorna um `ResultSet`

### ResultSet

Permite percorrer os dados:

```java
while(rs.next())
```

---

## 🔄 Fluxo da Aplicação

```
Main
 ↓
ConnectionFactory
 ↓
Connection
 ↓
ContaDAO
 ↓
MySQL
```

---

## 🚀 Próximos Passos

* Finalizar método `listar()`
* Implementar busca por número
* Implementar depósito
* Implementar saque
* Atualizar saldo
* Criar `ContaService`
* Criar menu com `Scanner`
* Validar regras de negócio
* Implementar exclusão de contas
* Melhorar mensagens e logs

---

## 📈 Progresso Atual

✔ Conexão com MySQL
✔ Criação da entidade Conta
✔ ConnectionFactory implementada
✔ Estrutura do DAO criada
✔ Método `salvar()` iniciado
✔ Método `listar()` quase finalizado

---

## 🧠 Observação Final

Este projeto foi desenvolvido com foco em **aprendizado prático**, evitando copiar soluções prontas e priorizando o entendimento da lógica por trás de cada implementação.

---

✍️ Projeto em evolução.
