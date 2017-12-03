# Demo payment system microservice edition #
[![Build Status](https://travis-ci.org/AnkBurov/demo-payment-system-microservice.svg?branch=master)](https://travis-ci.org/AnkBurov/demo-payment-system-microservice) [![Coverage Status](https://coveralls.io/repos/github/AnkBurov/demo-payment-system-microservice/badge.svg?branch=master&ts=1)](https://coveralls.io/github/AnkBurov/demo-payment-system-microservice?branch=master)

Example of simple payment system. Supports making payments between accounts, deposit money to account and withdraw money from account:
* POST /payment
* PUT /account-operation/deposit
* GET /account-operation/withdraw

HTTP-port 8080

## Run ##
docker-compose up --build