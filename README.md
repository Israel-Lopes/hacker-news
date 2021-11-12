# ![banner-logo](banner-news.jpg)
# API SpringBoot de Noticias

Dependencias:
 - curl
 - jq
 - docker
 - docker-compose

Configuração do Docker. Configuração e feita em cima do arquivo ***docker-compose.yml***.

``sudo docker-compose up``

Para subir container Docker do mySQL

``sudo docker start mysql``

Para executar aplicação springboot

``sudo ./mvnw spring-boot:run``

Para verificar basta acessar em http://localhost:8080/autores

Dentro do diretorio ***routes-post***, estao exemplos de post feito com curl.

Para executar basta iniciar com ./nome-do-arquivo.sh

## GET
curl
./getAll-autores.sh
 - retorna todos os autores.

./getId-autores.sh
 - retorna autor pelo ID.

## POST

./post-autores.sh
 - Inseri um autor.

### PUT

./putID-autorName.sh
 - Autualiza nome de uma autor pelo ID.

### DELETE

./deleteId-autores.sh
 - delete um autor pelo ID.