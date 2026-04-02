# 💰 MinhaGrana

Sistema de controle financeiro pessoal desenvolvido em **Java Swing** com integração ao banco de dados **MySQL**.

Projeto desenvolvido como trabalho acadêmico em 4 etapas, evoluindo desde a modelagem orientada a objetos até a persistência de dados em banco relacional.

---

## 📋 Funcionalidades

- **Dashboard** — visão geral com saldo atual, total de receitas, total de despesas e últimos lançamentos
- **Cadastro de Receitas** — registre entradas com descrição, valor, data e origem
- **Cadastro de Despesas** — registre saídas com descrição, valor, data e categoria
- **Categorias** — gerencie as categorias de despesas (adicionar e excluir)
- **Relatórios** — visualize todos os lançamentos com resumo financeiro geral

---

## 🛠️ Tecnologias

| Tecnologia | Uso |
|---|---|
| Java 21 | Linguagem principal |
| Java Swing | Interface gráfica desktop |
| MySQL 8 | Banco de dados relacional |
| JDBC | Conexão Java ↔ MySQL |
| NetBeans 25 | IDE de desenvolvimento |

---

## 🗂️ Estrutura do Projeto

```
MinhaGrana/
├── src/
│   ├── minhagrana/        # Classes de domínio (Lancamento, Receita, Despesa, Categoria)
│   ├── telas/             # Interfaces gráficas (TelaPrincipal, DialogReceita, DialogDespesa)
│   ├── DAO/               # Acesso ao banco de dados (CategoriaDAO, ReceitasDAO, DespesasDAO)
│   ├── banco/             # Conexão com MySQL (conexaoBD)
│   └── dados/             # Dados simulados para testes sem banco
```

---

## 🗄️ Banco de Dados

O sistema utiliza um banco MySQL chamado `minhagrana` com 3 tabelas:

```sql
CREATE TABLE categoria (
    id   INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE receitas (
    id        INT PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(100) NOT NULL,
    valor     DOUBLE NOT NULL,
    data      DATE NOT NULL,
    origem    VARCHAR(50)
);

CREATE TABLE despesa (
    id           INT PRIMARY KEY AUTO_INCREMENT,
    descricao    VARCHAR(100) NOT NULL,
    valor        DOUBLE NOT NULL,
    data         DATE NOT NULL,
    categoria_id INT NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);
```

## ⚙️ Como executar

### Pré-requisitos

- Java 21 ou superior
- MySQL 8 instalado e rodando
- NetBeans IDE (recomendado) ou qualquer IDE Java
- MySQL Connector/J (já incluído nas Libraries do projeto)

### Passos

1. **Clone o repositório**
```bash
git clone https://github.com/seu-usuario/MinhaGrana.git
```

2. **Configure o banco de dados**
   - Abra o MySQL Workbench
   - Execute o script SQL acima para criar as tabelas e inserir os dados iniciais

3. **Configure a conexão**
   - Abra o arquivo `src/banco/conexaoBD.java`
   - Ajuste as credenciais se necessário:
```java
public String url      = "jdbc:mysql://localhost:3306/minhagrana";
public String user     = "root";
public String password = "root";
```

4. **Abra no NetBeans**
   - File → Open Project → selecione a pasta `MinhaGrana`
   - Clique em Run (F6)

---

## 📐 Arquitetura

O projeto segue o padrão **DAO (Data Access Object)**, separando a lógica de acesso ao banco das regras de negócio:

```
Tela (Swing)
    ↓
DAO (CategoriaDAO / ReceitasDAO / DespesasDAO)
    ↓
conexaoBD (JDBC)
    ↓
MySQL
```

---

## 📚 Etapas do desenvolvimento

| Etapa | Descrição |
|---|---|
| Etapa 1 | Modelagem orientada a objetos — classes Lancamento, Receita, Despesa, Categoria, Relatorio |
| Etapa 2 | Projeto de UX/UI — wireframes, paleta de cores e acessibilidade |
| Etapa 3 | Implementação das telas em Java Swing com dados simulados |
| Etapa 4 | Integração com banco de dados MySQL via JDBC e padrão DAO |

---

## 👨‍💻 Autor

Desenvolvido por **Arthur** como projeto integrador acadêmico.
