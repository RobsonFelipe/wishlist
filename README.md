# Wishlist API

Um parágrafo da descrição do projeto vai aqui

## 🚀 Começando

Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de desenvolvimento e teste.

Consulte **[Implantação](#-implanta%C3%A7%C3%A3o)** para saber como implantar o projeto.

### 📋 Pré-requisitos

Para rodar a aplicação local e necessário ter as seguintes ferramentas.

```
- Java 17
- Uma IDE para rodar o projeto.
- Docker ou Mongodb
- PostMan
```

### 🔧 Instalação

Para rodar a API e necessário importar o projeto em uma IDE de sua preferencia. 
Selecionar o Java 17 para rodar o projeto.

Realizar o download do Docker Desktop, após instalar deve executar o arquivo
docker-compose.yml que se encontra na pasta :

```
/local/docker 
```

Dentro na pasta abrir o terminal e executar o comando:

```
docker-compose up --build -d
```

Após subir o docker, subir a aplicação Java 17 na IDE  a aplicação esta disponível para ser utilizada.

Para ter acesso aos endpoint da aplicação e necessário ter algum programa para realizar as requisições HTTP. Eu utilizei o Postman para realizar as chamadas e testes.


## ⚙️ Executando os testes

Para executar os testes o projeto possui dois arquivos o primeiro dele e o User case localizado na pasta:
```
Tests/USER_CASE_BDD.txt
```
Localizado na pasta do projeto.

O arquivo localizado na pasta acima ira explicar quais sao os cases de uma forma nao tecnica para utilizar a API.

O segundo arquivo e uma collection que foi exportada do Postman localizado:

```
/local/collection/Wishlist_Collection.postman_collection
```

Após importar essa collection voce terá acesso ao endpoint da API.

Algumas orientações sobre o projeto:

```
- Cada wishlist e identificada pelo wishlistId
- Cada produto possui dois campos productId e name
- A aplicação visa apenas controlar a tabela de wishlist.
- A wishlist pode ser criada com e sem produto
- A wishlist possui um limite de 20 produtos
```
## 🛠️ Construído com

Mencione as ferramentas que você usou para criar seu projeto

* [SpringBoot](https://spring.io/projects/spring-boot) - O framework web usado
* [Maven](https://maven.apache.org/) - Gerente de Dependência
* [Java 17](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html) -Linguagem de programação


## 📌 Versão

0.5

###  Futuras Melhorias:
- Criação de uma documentação no Swagger
- Tratamento mais minucioso em algumas exceções
