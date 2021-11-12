#!/bin/bash

read -p "Nome do titulo: " TITLE
read -p "Noticia: " DESCRIPTION

# Enseri uma noticia
curl -g http://localhost:8080/noticias -X POST -v -H "Content-type: application/json" -d '{
"titulo": "'$TITLE'","descricao": "'$DESCRIPTION'","autorModel": {   "id":10,   "nome":"Julio"   }}'
