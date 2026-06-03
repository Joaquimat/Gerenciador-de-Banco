# 💳 Sistema Bancário com JDBC e MySQL

## 📌 Sobre o Projeto

Este é um **sistema bancário simples** desenvolvido em **Java**, utilizando **JDBC** para comunicação com o banco de dados **MySQL**.

O projeto foi criado com foco em **aprendizado prático**, consolidando conceitos fundamentais de backend e persistência de dados.

---

## 🎯 Objetivos do Projeto

* Praticar integração entre Java e banco de dados
* Aplicar operações CRUD na prática
* Entender o funcionamento do JDBC
* Trabalhar com arquitetura em camadas
* Desenvolver lógica de negócio do zero

---

## 🧩 Funcionalidades

O sistema permite:

* ✅ Criar contas bancárias
* ✅ Listar contas cadastradas
* ✅ Buscar conta por número
* ✅ Realizar depósitos
* ✅ Realizar saques
* ✅ Atualizar saldo
* ✅ Excluir contas

---

## 🗄️ Banco de Dados

* Banco: **MySQL**
* Tabela principal: `conta`

### Estrutura:

| Campo   | Tipo          |
| ------- | ------------- |
| numero  | BIGINT (PK)   |
| cliente | VARCHAR       |
| saldo   | DECIMAL(15,2) |
| cpf     | VARCHAR       |
| email   | VARCHAR       |

🔑 **Chave primária:** `numero`

---

## 💰 Modelagem de Valores Monetários

O projeto evoluiu para utilizar:

* Banco de dados: `DECIMAL(15,2)`
* Java: `BigDecimal`

✔ Isso garante precisão em operações financeiras.

---

## 🏗️ Arquitetura do Projeto

```id="estruturasys"
AppBanco (Main)
│
├── connection
│   └── ConnectionFactory
│
├── dao
│   └── ContaDAO
│
├── service
│   └── ContaService
│
└── model
    └── Conta
```

---

## 🔄 Fluxo da Aplicação

```id="fluxofinal"
Main
 ↓
Service (regras de negócio)
 ↓
DAO (acesso ao banco)
 ↓
MySQL
```

---

## 🔌 Tecnologias Utilizadas

* Java
* JDBC
* MySQL
* IntelliJ IDEA

---

## 🛠️ Conceitos Aplicados

* Connection / DriverManager
* PreparedStatement
* ResultSet
* Execução de queries (`executeQuery`, `executeUpdate`)
* Tratamento de exceções SQL
* Uso de coleções (`Set`, `HashSet`)
* Separação em camadas (DAO, Service, Model)

---

## 🧠 Regras de Negócio Implementadas

* Validação de conta existente
* Verificação de saldo antes de saque
* Tratamento de operações inválidas
* Controle de dados consistentes no banco

---

## ▶️ Como Executar

1. Configurar o MySQL e criar o banco de dados
2. Criar a tabela `conta`
3. Atualizar as credenciais no `ConnectionFactory`
4. Executar a classe `AppBanco`

---

## 📈 Resultado

O projeto atingiu seu objetivo principal:

✔ Integração completa com banco de dados
✔ CRUD totalmente funcional
✔ Lógica de negócio implementada
✔ Estrutura organizada e escalável

---

## 🧠 Considerações Finais

Este projeto representa a consolidação de conhecimentos essenciais para desenvolvimento backend com Java, servindo como base para aplicações mais complexas utilizando frameworks como Spring Boot.

---

🚀 Projeto finalizado com foco em aprendizado sólido e boas práticas.
