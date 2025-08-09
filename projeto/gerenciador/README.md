# Sistema de Controle Financeiro

## Setup

Para executar o projeto é necessário ter configurado o Java, Maven e plugins do Spring Boot.

## Uso

Abra a pasta `gerenciador` no VSCode.

Para facilitar a interação, pode-se utilizar a extensão `Spring Boot Tools`.

Abra o arquivo `src/main/java/br/ufba/tomorrow/gerenciador/GerenciadorApplication.java` e execute o projeto.

Via terminal pode-se utilizar o `mvnw`, estando na pasta inicial do projeto `gerenciador`, execute:

```bash
./mvnw spring-boot:run
```

**obs**: 

1. Deve-se observar se a porta 8080 está em uso;
2. Apesar de usarmos banco de dados H2, os dados são persistidos em `~/gerenciador`;
3. Para acessar o banco de dados pode-se utilizar o `http://localhost:8080/h2-console/`, colocando o dado `jdbc:h2:file:~/gerenciador` no campo `JDBC URL`. Utilize `sa` para o usuário e senha.

## Manipulando dados

A aplicação foi testada utilizando o Swagger UI (`http://localhost:8080/swagger-ui/index.html`), mas deve funcionar com outras ferramentas que permitam realizar requisições HTTP.

O ponto inicial é a criação da empresa, que pode ser criada enviando POST para o endpoint `/api/v1/empresa/register`, respeitando as validações:

1. O nome fantasia é obrigatório e deve ter no máximo 100 caracteres;
2. A razão social é obrigatória e deve ter no máximo 100 caracteres;
3. O CNPJ é obrigatório e deve conter 14 dígitos numéricos;
4. Email é obrigatório;
5. Senha é obrigatória e deve ter no mínimo 6 caracteres;

Após isso, pode-se interagir com outros endpoints com este usuário logado.
