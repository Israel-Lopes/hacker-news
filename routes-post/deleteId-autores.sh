#!/bin/bash

read -p "Escreva o ID: " ID

# Deleta um usuario pelo ID
curl -X  DELETE http://localhost:8080/autores/$ID