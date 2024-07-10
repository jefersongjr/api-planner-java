# API de Planejamento de Viagens ✈️ 🌎

## Descrição 📘

Esta API de planejamento de viagens foi desenvolvida durante o evento NLW Journey da Rocketseat. Utilizando Java e SpringBoot,
a API oferece funcionalidades essenciais para a criação e gestão de viagens, incluindo cadastro de participantes, planejamento de atividades e mais.

## Funcionalidades

- **Criação e Gestão de Viagens**
  - Crie novas viagens com informações detalhadas.
  - Edite e atualize detalhes das viagens existentes.
  - Confirme viagens para torná-las oficiais.

- **Cadastro e Confirmação de Participantes**
  - Registre participantes em viagens.
  - Envie convites e confirme a participação dos usuários.

- **Planejamento de Atividades**
  - Adicione e gerencie atividades relacionadas às viagens.
  - Crie novas atividades com detalhes específicos.
  - Recupere e visualize todas as atividades planejadas.
 
- **Links de eventos e hospedagens**
  - Disponibilização de links

## Tecnologias Utilizadas 🛠️

- **Java**
- **SpringBoot**
- **Spring Data JPA**
- **H2 Database** (para testes)
- **Maven**

## Instalação 🔧

1. Clone o repositório:
   ```bash
   git clone git@github.com:jefersongjr/api-planner-java.git

2. Navegue até o diretório do projeto:

   ```bash
     cd api-planner-java.git

3. Compile o projeto utilizando Maven:

   ```bash
   mvn clean install

5. Execute a aplicação:
      ```bash
      mvn spring-boot:run

## Endpoints : ➡️ 🛩️

### Viagens

- **Criar Viagem**
  - `POST /trips`
  - Payload:
    ```json
    {
      "destination": "Destino da viagem",
      "starts_at": "2024-07-10T10:00:00",
      "ends_at": "2024-07-15T18:00:00",
      "emails_to_invite": ["email1@example.com", "email2@example.com"]
    }
    ```
  - Resposta:
    ```json
    {
      "id": "UUID-da-viagem"
    }
    ```

- **Obter Detalhes da Viagem**
  - `GET /trips/{id}`
  - Parâmetros:
    - `id` (UUID): ID da viagem.
  - Resposta:
    ```json
    {
      "id": "UUID-da-viagem",
      "destination": "Destino da viagem",
      "starts_at": "2024-07-10T10:00:00",
      "ends_at": "2024-07-15T18:00:00",
      "is_confirmed": false,
      "participants": []
    }
    ```

- **Atualizar Viagem**
  - `PUT /trips/{id}`
  - Parâmetros:
    - `id` (UUID): ID da viagem.
  - Payload:
    ```json
    {
      "destination": "Novo destino",
      "starts_at": "2024-07-12T10:00:00",
      "ends_at": "2024-07-18T18:00:00"
    }
    ```
  - Resposta:
    ```json
    {
      "id": "UUID-da-viagem",
      "destination": "Novo destino",
      "starts_at": "2024-07-12T10:00:00",
      "ends_at": "2024-07-18T18:00:00",
      "is_confirmed": false,
      "participants": []
    }
    ```

- **Confirmar Viagem**
  - `GET /trips/{id}/confirm`
  - Parâmetros:
    - `id` (UUID): ID da viagem.
  - Resposta:
    ```json
    {
      "id": "UUID-da-viagem",
      "destination": "Destino da viagem",
      "starts_at": "2024-07-10T10:00:00",
      "ends_at": "2024-07-15T18:00:00",
      "is_confirmed": true,
      "participants": []
    }
    ```

### Participantes

- **Convidar Participante**
  - `POST /trips/{id}/invite`
  - Parâmetros:
    - `id` (UUID): ID da viagem.
  - Payload:
    ```json
    {
      "email": "participant@example.com"
    }
    ```
  - Resposta:
    ```json
    {
      "id": "UUID-do-participante",
      "email": "participant@example.com",
      "status": "Invited"
    }
    ```

- **Obter Todos os Participantes**
  - `GET /trips/{id}/participants`
  - Parâmetros:
    - `id` (UUID): ID da viagem.
  - Resposta:
    ```json
    [
      {
        "id": "UUID-do-participante",
        "email": "participant@example.com",
        "status": "Confirmed"
      }
    ]
    ```

### Atividades

- **Cadastrar Atividade**
  - `POST /trips/{id}/activities`
  - Parâmetros:
    - `id` (UUID): ID da viagem.
  - Payload:
    ```json
    {
      "name": "Atividade",
      "description": "Descrição da atividade",
      "starts_at": "2024-07-13T10:00:00",
      "ends_at": "2024-07-13T12:00:00"
    }
    ```
  - Resposta:
    ```json
    {
      "id": "UUID-da-atividade",
      "name": "Atividade",
      "description": "Descrição da atividade",
      "starts_at": "2024-07-13T10:00:00",
      "ends_at": "2024-07-13T12:00:00"
    }
    ```

- **Recuperar Atividades**
  - `GET /trips/{id}/activities`
  - Parâmetros:
    - `id` (UUID): ID da viagem.
  - Resposta:
    ```json
    [
      {
        "id": "UUID-da-atividade",
        "name": "Atividade",
        "description": "Descrição da atividade",
        "starts_at": "2024-07-13T10:00:00",
        "ends_at": "2024-07-13T12:00:00"
      }
    ]
    ```

### Links

- **Criar Link**
  - `POST /trips/{id}/links`
  - Parâmetros:
    - `id` (UUID): ID da viagem.
  - Payload:
    ```json
    {
      "url": "http://example.com",
      "description": "Descrição do link"
    }
    ```
  - Resposta:
    ```json
    {
      "id": "UUID-do-link",
      "url": "http://example.com",
      "description": "Descrição do link"
    }
    ```

- **Recuperar Links**
  - `GET /trips/{id}/links`
  - Parâmetros:
    - `id` (UUID): ID da viagem.
  - Resposta:
    ```json
    [
      {
        "id": "UUID-do-link",
        "url": "http://example.com",
        "description": "Descrição do link"
      }
    ]
    ```


## Contribuição 🧑‍🤝‍🧑
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

## Licença 🔐
Este projeto está licenciado sob a licença MIT. Veja o arquivo LICENSE para mais detalhes
