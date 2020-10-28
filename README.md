# Desktop-App 
Uma aplicação Desktop básica para cadastramento de dados em um universo Hotel Fazenda. 
Feito na linguagem Java e usando a API Swing do próprio JDK.

## Instruções para a configuração do ambiente

1. Instale o banco de dados **postgres** com o gerenciador de pacotes do próprio sistema Linux em seu terminal.
 
```sh
$ apt-get install postgresql postgresql-contrib
```

Ou utilize o site do postgres e faça o download de acordo com o seu sistema operacional.

2. Entre no banco de dados pelo terminal utilizando o usuário padrão

```sh
$ sudo su postgres -c psql postgres
```

3. Crie um banco de dados com o nome **"hotel_fazenda"** ou **"hf"** e acesse-o

- Criação..

```sh
postgres=# create database hotel_fazenda;
```
Ou
```sh 
postgres=# create database hf;
```

- Acesso..

```sh
postgres=# \c hotel_fazenda
```
Ou
```sh 
postgres=# \c hf
```

4. Ao acessa-lo, rode o script **hotel_fazenda.sql** (tenha certeza de que o caminho ao diretório da pasta esteja correto).

```sh
postgres=# \i scriptbancorh.sql
```

5. Altere no código fonte, mais específicamente no pacote *persistencia*, a String ```user``` e a ```senha``` de acordo com as suas configurações do postgres.
Caso não esteja utilizando a porta de conexão padrão localhost:5432, altere-a em conjunto.

```java
public static Connection getConnection() {
		String driver = "org.postgresql.Driver";
		String user = "postgres";/* Coloque o usuário criado para acesso ao banco */
		String senha = "SuaSenha";/* Coloque a senha para acesso ao banco */
    String url = "jdbc:postgresql://localhost:5432/hf";/* Coloque o servidor onde está instalado o banco */
    /* [....] */
}
```

6. Com o banco de dados configurado, abra um terminal posteriormente para acessar a pasta principal que contém o arquivo **hf.jar**.
 Esse arquivo contém a aplicação Desktop e para rodá-lo utilize o seguinte comando:
 
 ```sh
 $ java -jar hf.jar
 ```
 
 - Fim....
 
 ## Considerações ##

A estrutura ou padrão de arquitetura utilizado na produção foi o MVC (Model-View-Controller) o qual divide suas responsabilidades em setores, ou seja, pratica algumas boas práticas da programação como o polimorfismo, encapsulamento e a herança na implementação e torna o código bastante legível e compreensível ao longo do processo de criação. 

Por ser uma aplicação básica, sem considerar o front-end, qualquer sugestão ou crítica construtiva será bem-vinda para minha evolução pessoal.
