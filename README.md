# 🐾 CRUD Cadastro Pets

Este é um projeto refatorado de um outro projeto mais simples feito anteriormente para praticar e aplicar conceitos essenciais do **Spring Boot**, evoluindo de um desafio simples para um sistema completo de cadastro de pets para adoção.  
Aqui são utilizados recursos como conexão com banco de dados, JPA, Spring Validation para validações, Specifications para filtros, testes unitários e Docker para gerenciar o ambiente de desenvolvimento.

📎 Projeto na versão anterior (mais simples): https://github.com/asafeorneles/desafio-cadastro

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3** (Web, JPA/Hibernate)
- **JPA Specifications** (busca com filtros)
- **MySQL 8**
- **Docker & Docker Compose**
- **JUnit 5**
- **Mockito**
- **Maven**

---

## 📌 Objetivo do Projeto

O objetivo deste projeto é:

- Praticar a estruturação de aplicações com **Spring Boot**
- Criar um **CRUD completo** seguindo boas práticas e divisão de camadas
- Realizar conexão da aplicação com **MySQL via Docker**
- Aplicar **Specifications** para buscas avançadas com filtros
- Criar **testes unitários** utilizando Mockito e JUnit
- Evoluir um desafio inicial de cadastro para um sistema robusto e organizado

---

## 🗂️ Estrutura do Projeto

```
src/
 └── main/
     ├── java/
     │    ├── controllers/ → Rotas da API
     │    ├── services/ → Regras de negócio
     |    ├── entities/ → Entidade
     │    ├── repository/ → Acesso ao banco (JPA)
     │    ├── dto/ → DTOs
     │    ├── specifications/ → Specifications
     │    ├── queryFilters/ → Criação de filtro por Specification
     │    └── exceptions/ → Tratamento de erros
     └── resources/
         ├── application.properties
         └ ── ...
```

---

## 🐳 Docker

Um arquivo **docker-compose.yml** foi usado para subir o container do MySQL:

* Banco exposto em: `localhost:3306`
* Usuário: `root`
* Senha: `root`

Para rodar:

```bash
docker-compose up -d
```

---

## 📮 Endpoints Principais (CRUD)

### Cadastrar um novo pet

```
POST /pets
```

### Lista todos os pets

```
GET /pets
```

### Busca um pet pelo ID

```
GET /pets/{id}
```

### Atualiza os dados do pet

```
PUT /pets/{id}
```

### Deleta o pet

```
DELETE /pets/{id}
```

---

## 🧠 Aprendizados

Durante este projeto, pude aprender sobre:

* Estruturação de um projeto real com camadas bem definidas
* Como o Spring Data JPA facilita o acesso ao banco
* Validações e uso de DTOs
* Criação de Specifications para filtros dinâmicos
* Como escrever testes unitários para Services e Repositories
* Como subir um banco MySQL com Docker de forma simples
* Como organizar melhor o código para escalabilidade

---

## 📦 Como Rodar o Projeto

1. Suba o MySQL com Docker:

```bash
docker-compose up -d
```

2. Execute o projeto pelo IntelliJ/NetBeans ou via terminal:

```bash
mvn spring-boot:run
```

3. Acesse os endpoints na porta padrão `8080`.

---


## Sobre o Projeto

Este sistema foi criado como uma evolução do meu antigo desafio de cadastro, agora com uma estrutura muito mais completa, com filtros, organização por camadas e testes.
Foi um passo importante na minha jornada com Java + Spring Boot, aplicando habilidades reais de back-end.
