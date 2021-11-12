#!/bin/bash

read -p "Escreva o ID: " ID

# Busca um usuario pelo ID
curl http://localhost:8080/autores/$ID