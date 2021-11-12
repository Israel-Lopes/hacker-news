#!/bin/bash

read -p "Escreva um nome para inserir: " NAME

# Insere um usuario
curl http://localhost:8080/autores -X POST -v -H "Content-type: application/json" -d '{
"nome": "'$NAME'"
}'