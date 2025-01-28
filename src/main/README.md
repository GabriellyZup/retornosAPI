 # Retornos API


### API para gerenciamento de produtos, permitindo operações CRUD (Criar, Ler, Atualizar, Deletar) com validações.

### Tecnologias Utilizadas
- **Java 17**
- **Spring Boot**
- **JPA**
- **H2 Database** (para testes)
- **Thunder Client** (para testes manuais)

---

## Como Executar o Projeto
1. Clone o repositório:

    ```bash
   git clone https://github.com/GabriellyZup/retornosAPI.git

2. Acesse o diretório do projeto e execute a aplicação: 
    ```bash
    mvn spring-boot:run

## Testando a API

### Acessar o Banco H2
- **URL**: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- **Credenciais**:
    - **JDBC URL**: `jdbc:h2:mem:testdb`
    - **Username**: `sa`
    - **Password**: (deixe em branco)

---

## Testando a API com Thunder Client
1. Instale a extensão **Thunder Client** no seu editor de código (como o VS Code).
2. Configure as requisições para os endpoints da API:
    - **Base URL**: `http://localhost:8080/api/products`
    - Exemplos de requisições:
        - **POST**: Criar um produto (com o corpo da requisição em JSON).
        - **GET**: Buscar todos os produtos ou um produto específico por ID.
        - **PUT**: Atualizar um produto (com o corpo da requisição em JSON).
        - **DELETE**: Deletar um produto por ID.
3. Execute as requisições e verifique as respostas diretamente no Thunder Client.

---

## Endpoints CRUD

### 1. Criar um Produto
- **Método**: `POST`
- **Endpoint**: `/api/products`
- **Exemplo de Corpo da Requisição**:
  ```json
  {
    "name": "Produto1",
    "description": "Descrição do produto",
    "price": 10.5,
    "stockQuantity": 5,
    "category": "CATEGORY1"
  }

---

### 2. Buscar um Produto por ID
- **Método**: `GET`
- **Endpoint**: `/api/products/{id}`

---

### 3. Listar Todos os Produtos
- **Método**: `GET`
- **Endpoint**: `/api/products`

---

### 4. Atualizar um Produto
- **Método**: `PUT`
- **Endpoint**: `/api/products/{id}`
- **Exemplo de Corpo da Requisição**:
    ```json
    {
      "name": "Produto1 Atualizado",
      "description": "Nova descrição",
      "price": 15.0,
      "stockQuantity": 10,
      "category": "CATEGORY2"
    }

---

### 5. Deletar um Produto
- **Método**: `DELETE`
- **Endpoint**: `/api/products/{{id}}`
- **Resposta de Sucesso**: `204 No Content`

---

## Estrutura do Código
- **`controllers/`**: Define os endpoints da API.
- **`services/`**: Contém a lógica de negócios.
- **`models/`**: Estruturas de dados e entidades.
- **`repositories/`**: Comunicação com o banco de dados.
- **`DTOs/`**: Objetos de transferência de dados.

---

## Considerações
- Os testes foram realizados manualmente utilizando **Thunder Client** e **H2 Console**.
- Todos os endpoints seguem as regras de negócio definidas.