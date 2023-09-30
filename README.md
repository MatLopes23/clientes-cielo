# Desafio Final Bootcamp Cielo Dev - AdaTech

Backend desenvolvido em Spring Boot (Gradle) implementando
endpoits de API pedidos.

Frontend desenvolvido em Angular demonstrando a utilização
da API desenvolvida no backend.


## Tecnologias

- Java 17
- Spring Boot
- Gradle
- Node.js 18
- Angular
- Angular Material

## Execução

- Frontend
    - Para iniciar o aplicativo Angular, navegue até o diretório
      `clientes-frontend`, instale as dependências com
        - `npm install`
    - e inicie o aplicativo com
        - `npm start`
- Backend
    - A partir do diretório `clientes-backend` execute
        - `./gradlew bootBuildImage --imageName=api:v1.0`
    - Em seguida suba a imagem docker criada
        - `docker run -p 8080:8080 api:v1.0`

## URLs

- Swagger da API (backend):
    - http://localhost:8080/swagger-ui/index.html
- Frontend:
    - http://localhost:4200/
