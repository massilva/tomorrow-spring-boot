# Sistema de Controle Financeiro

## Histórias do usuário (User Story)

* **US-01** Como administrador da empresa XPTO, gostaria de manter em contas a pagar a despesa recorrente mensalmente "Salário do Colaborador" para a data limite 01/08/2025;
* **US-02** Como administrador da empresa XPTO, gostaria de manter em contas a pagar a despesa "Comprar café" para a data limite 01/08/2025;
* **US-03** Como administrador da empresa XPTO, gostaria de manter em contas a receber, o ganho "Pagamento do Projeto X" para a data 01/08/2025;
* **US-04** Como administrador da empresa XPTO, gostaria de visualizar o balanço mensal entre contas a pagar e a receber no período determinado;

## Estrutura do projeto

Na pasta `projeto` tem a pasta do código-fonte `gerenciador`.

### Arquitetura

* **config**: arquivos de configuração e segurança da aplicação;
* **controllers**: controladores das requisições;
* **dtos**: objetos de transferência de dados entre o frontend e a API;
* **mappers**: mapeadores de dados entre `dtos => models` e vice-versa;
* **models**: entidades que representam tabelas no banco de dados;
* **repositories**: repositórios JPA de interface entre o modelo e o banco de dados;
* **services**: serviço responsável por aplicar regras de negócio do domínio de aplicação;

## Atividades

| # | Status                | Descrição                                                                                                                | User Story | Relacionado a |
|---|-----------------------|--------------------------------------------------------------------------------------------------------------------------|------------|---------------|
| 1 | :white_check_mark:    | Validar os campos no cadastro de empresa                                                                                 | -          | -             |
| 2 | :white_check_mark:    | Permitir registrar empresa                                                                                               | -          | Atividade 1   |
| 3 | :black_square_button: | Formatar mensagem de erro (validação, notfound e etc) no registro de empresa                                             | -          | Atividade 2   |
| 4 | :black_square_button: | Listar empresas cadastradas                                                                                              | -          | Atividade 3   |
| 5 | :black_square_button: | Editar empresa cadastrada                                                                                                | -          | Atividade 4   |
| 6 | :black_square_button: | Excluir empresa cadastrada                                                                                               | -          | Atividade 5   |
| 7 | :black_square_button: | Alinhar a representação das despesas (contas a pagar) e receitas (contas a receber) com base no que foi feito por Marcus | -          | -             |
