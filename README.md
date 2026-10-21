# Crud.java: Sistema de Clientes

Sistema de cadastro de clientes em **Java puro**, com os dados guardados em um banco **MySQL** via JDBC. Projeto de estudo de POO e acesso a banco de dados.

## Funcionalidades

- Cadastrar cliente
- Listar clientes
- Consultar cliente por ID
- Alterar cliente
- Excluir cliente

## Tecnologias

- Java (JDK 25)
- MySQL
- JDBC (MySQL Connector/J)
- IntelliJ IDEA

## Estrutura

| Arquivo | Função |
|---|---|
| `Cliente.java` | Dados do cliente (nome, CPF, e-mail, data de nascimento e ID) |
| `Cadastro.java` | Operações no banco: cadastrar, listar, consultar, alterar e excluir |
| `ConexaoBanco.java` | Abre a conexão com o MySQL (não vai pro repositório, veja abaixo) |
| `Principal.java` | Executa um teste de cada operação |

## Como rodar

### 1. Criar o banco e a tabela

```sql
CREATE DATABASE Cadastros;
USE Cadastros;

CREATE TABLE clientes (
    id INT PRIMARY KEY,
    nome VARCHAR(100),
    cpf VARCHAR(20),
    email VARCHAR(100),
    data_nascimento VARCHAR(10)
);
```

### 2. Adicionar o driver

Baixe o **MySQL Connector/J** (opção *Platform Independent*) e adicione o `.jar` ao projeto em
*File → Project Structure → Libraries*.

### 3. Criar o arquivo de conexão

Por segurança, o arquivo com a senha **não está no repositório**. Crie `src/ConexaoBanco.java` com este conteúdo, usando o seu usuário e a sua senha:

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    public static Connection conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Cadastros";
        String usuario = "SEU_USUARIO";
        String senha = "SUA_SENHA";

        return DriverManager.getConnection(url, usuario, senha);
    }
}
```

### 4. Executar

Rode a classe `Principal`.

## Próximos passos

- Sistema de clientes e pedidos, com relacionamento entre tabelas
- API REST com Spring Boot com Spring Boot