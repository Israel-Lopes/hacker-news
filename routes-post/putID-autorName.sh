#!/bin/bash

read -p "Escreva o ID: " ID
read -p "Escreva nome para atulizar: " NAME

# Atuliza autor pelo ID
curl -X PUT -H "Content-Type: application/json" -d '{"nome":"'$NAME'"}' http://localhost:8080/autores/$ID