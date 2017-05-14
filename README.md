# web-android-spring-backend
Aplicação de backend para os projetos [android-fontend](https://github.com/alephlm/android-fontend) e [web-angular-frontend](https://github.com/alephlm/web-angular-frontend)

## Modo de Inicialização
Depois de clonar este repositório vá ate o arquivo de configuração application.properties e altere as configurações referentes ao banco de dados. O projeto utiliza postgreSQL.
```shell
$ git clone https://github.com/alephlm/web-angular-frontend.git
$ cd /src/main/resources/
```
```sql
--application.properties
spring.datasource.url=jdbc:postgresql://localhost/filmes_app -- nome do banco de dados(criar um com o mesmo nome 'filme_app' ou escolher outro)
spring.datasource.username=postgres                          -- nome de usuario do banco de dados
spring.datasource.password=password                          -- senha do usuario
```
Depois basta iniciar a aplicação usando o maven.
```shell
$ mvn spring-boot:run
```

## Tecnologias utilizadas no projeto.
* Maven - para controle de pacotes
* SpringBoot - para a inicialização do servidor
* SpringData - para a comunicacao java/banco de dados
* SpringSecurity - para o login do usuario e controle de autenticação
