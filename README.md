# Prova

### Contexto

Você foi contratado pela loja de chocolates "Doce Sonho" para desenvolver uma aplicação para controle e comércio online
dos diversos produtos do estabelecimento. A loja vende Chocolates e Bombons por unidade, e possui um sistema de avaliação que permite aos consumidores darem notas
aos itens do catálogo.

### Escopo Técnico

A aplicação é uma API RESTful que retorna dados em formato JSON. É baseada em Java e utiliza o framework Spring.
Para deixar este exercício mais simples e independente, um banco de dados relacional em memória é utilizado (H2). O
projeto é gerenciado pelo Gradle.

A sua tarefa será realizar os desafios que envolvem alteração de escopo e esquema listados abaixo. Os desafios deverão
ser concluídos na ordem em que estão listados. Os desafios são dissertativos - em outras palavras, existem várias
maneiras que eles podem ser resolvidos. A menos que seja especificado no desafio, você possui toda a liberdade para
escolher os nomes para classes e _endpoints_. O código dos desafios resolvidos serão avaliados em diversos aspectos,
tais como coerência, coesão, e domínio da linguagem/API.

#### Compilando

Após clonar este repositório, basta navegar até o diretório raiz do projeto e inserir o comando:

```gradlew bootRun```

A aplicação estará disponível na porta 8080. O console do H2 estará disponível no caminho ```/h2-console```, com os
seguintes parâmetros: 

```
URL         : jdbc:h2:mem:desafio-db
User Name   : desafio
Password    : desafio
```

### Desafios

#### Desafio 1

Ao analisar o histórico de vendas e perguntas realizadas com frequência nos canais de comunicação com os consumidores,
o proprietário decidiu lançar uma nova categoria de produtos: Kits prontos para presente, contendo uma quantidade
pré-definida dos itens do catálogo.

Sua tarefa será criar os serviços e endpoints para obtenção e listagem (de todos ou de apenas um, se fornecido um
identificador), criação, alteração e exclusão destes kits. O modelo de dados já está criado e é definido pelas classes
```Presente``` e ```ItemPresente```. Os repositórios também já estão criados, e você deverá criar quaisquer métodos
necessários para as consultas, caso julgue necessário.

##### Desafio 2

Ao analisar as lojas concorrentes, o proprietário da "Doce Sonho" constatou que chocolates a granel geralmente são
vendidos por peso, e não por unidade.

Sua tarefa será alterar o modelo de dados da classe ```Chocolate```, removendo o parâmetro ```preco```, e incluindo os
parâmetros ```peso``` e ```precoPorQuilograma```.

Dica: Como o parâmetro ```peso``` se encontra na classe ```Produto```, e não ```Chocolate```, você não poderá alterar
diretamente a classe ```Produto```. Do contrário, os Kits para presente passariam a ser vendidos por peso, o que está
fora do escopo desta alteração.

#### Desafio 3

O proprietário deseja saber quais itens do catálogo possuem as melhores avaliações.

Sua tarefa será construir um relatório que exiba os 10 itens com melhores avaliações do catálogo. Ele deverá possuir os
seguintes campos:

```
nome: texto
mediaNotas: fração
```

Você deverá construir este relatório, criando seu modelo de dados (um DTO, não é necessário persisti-lo no banco de
dados), o serviço para compilação dos dados e o _endpoint_ para chamada pela API.

#### Desafio 4

Para aprimorar a clareza das informações disponíveis para exibição, e também para calcular a tabela de informações 
nutricionais, a aplicação precisa exibir a informação dos ingredientes de cada chocolate.

Sua tarefa será criar o relacionamento da classe ```Chocolate``` com a classe ```Ingrediente``` (já criada). Este
relacionamento possui duas regras:
* Um chocolate possui vários ingredientes
* Um ingrediente não pode estar duas vezes (ou mais) em um chocolate

Você pode escolher a estrutura de dados que melhor se encaixa para esta tarefa. Você só precisa criar o relacionamento
no modelo de dados (Não é necessário criar novas classes).