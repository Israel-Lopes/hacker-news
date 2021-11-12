#!/bin/bash

read -p "Escreva o ID: " ID

# Deleta um noticia pelo ID
curl -X  DELETE http://localhost:8080/noticias/$ID