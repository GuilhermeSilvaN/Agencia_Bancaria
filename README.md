# 💳 Sistema Bancário em Java

## 📌 Sobre o Projeto
Este projeto é um **sistema bancário simples** desenvolvido em **Java**, com interação via **terminal (console)** e persistência de dados em **MySQL**.  

O objetivo é simular operações básicas de uma agência bancária, como cadastro de clientes e movimentações em contas correntes e poupança.  

O projeto utiliza **JDBC (Java Database Connectivity)** para realizar a comunicação entre o Java e o banco de dados MySQL. Todas as operações de CRUD (Create, Read, Update, Delete) e transações financeiras são feitas através de **PreparedStatements e conexões gerenciadas via JDBC**.

Esse projeto tem fins **educacionais**, servindo como prática de:
- Programação orientada a objetos (POO) em Java
- Integração Java com banco de dados MySQL via JDBC
- Boas práticas de organização de código (camadas Model, DAO, Service e View)

---

## ⚙️ Funcionalidades

✅ Cadastro de clientes com:
- Nome  
- Endereço  
- Data de nascimento  
- CPF  
- Estado civil  
- Conta (Corrente ou Poupança)  

🏦 Operações disponíveis:
- Consultar saldo  
- Depositar  
- Sacar  
- Transferir valores entre contas  
- Exibir extrato  

📋 Gerenciamento:
- Listar clientes  
- Buscar cliente por CPF  
- Excluir cliente  

---

## 🗄️ Estrutura do Banco de Dados

**Tabela Cliente**
```sql
CREATE TABLE Cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(200),
    data_nascimento DATE,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    estado_civil VARCHAR(20)
);
