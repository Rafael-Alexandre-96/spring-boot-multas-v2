# Spring Boot API Rest Gestor Multas
![Status Badge](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)
![Licence Badge](https://img.shields.io/badge/LICENCE-GPL_3.0-blue?style=for-the-badge)
![Spring Badge](https://img.shields.io/badge/Spring_Boot-v3.2.3-green?style=for-the-badge)
![Java Badge](https://img.shields.io/badge/Java-21-blue?style=for-the-badge)
![Maven Badge](https://img.shields.io/badge/Maven-red?style=for-the-badge)
![SQL Badge](https://img.shields.io/badge/MySQL-blue?style=for-the-badge)

:construction: Projeto em construção :construction:

### Objetivo
Criar API Rest para gerir infrações de trânsito de uma empresa de transporte, controlando: boletos pagos, à pagar e à receber, desconto na folha de pagamento do motorista, indicação ou não do condutor na infração, situação da infração, consulta de infração por placa e/ou motorista e estatísticas por periodo.

# Índice 
* [Título e Objetivo](#spring-boot-api-rest-gestor-multas)
* [Índice](#índice)
* [Funcionalidades](#funcionalidades)
* [Acesso ao Projeto](#acesso-ao-projeto)
* [Rodar o projeto](#rodar-o-projeto)
* [Requisitos](#requisitos)
* [Técnicas e Tecnologias Utilizadas](#técnicas-e-tecnologias-utilizadas)

# :hammer: Funcionalidades=
- `REST Api`
- `CRUD`: Veículos, Condutores, Infrações, Enquadramentos e Boletos
- `Gestão Financeira`: Boletos pagos, à pagar e à receber, desconto na folha de pagamento do motorista
- `Gestão Infrações`: Controle de tratativa da infração: Aguardando assinatura do condutor, em recurso, aguardando chegada da penalidade, etc...
- `Consultas`: Infrações por placa e/ou motorista, resumo de infrações por periodo

# 📁 Acesso ao Projeto
- [Repositório GitHub](https://github.com/Rafael-Alexandre-96/spring-boot-multas-v2)

# 🛠️ Rodar o Projeto
- Execute o comando Git em sua pasta de projetos:
```bash
  git clone git@github.com:Rafael-Alexandre-96/spring-boot-multas-v2.git
```
- Execute o comando CMD na pasta deste projeto:
```bash
  \.mvnw spring-boot:run
```
- A API irá escutar na porta 8080:
```bash
  localhost:8080/api/v1
```

# :warning: Requisitos
- Java JDK 21
- MySQL
- Postman

# ✔️ Técnicas e Tecnologias Utilizadas
- ``Spring Boot 3``
- ``Maven``
- ``MySQL``
- ``FlyWay Migrations``
- ``Swagger UI & Open API``
- ``Jakarta & Hibernate``
- ``Java 21``
- ``VS Code``
- ``Postman``
