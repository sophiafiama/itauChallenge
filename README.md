
# Coding Challenge - Bootcamp Itaú{devs}

## 💻 Sobre o projeto

- Desafio de código proposto pela LetsCode para avaliação de candidatos para ingressar no Bootcamp Itaú{devs};
- No Coding Challenge (Desafio Técnico), irá avaliar o desempenho do aluno no projeto de acordo com os requisitos técnicos e não-técnicos solicitados. 
  
  ## 👾 Requisitos realizados
 - Criação de api para cadastro do usuário;
 - Perfis de usuário :  LEITOR(0, "ROLE_READER"),BÁSICO(1, "ROLE_BASIC"),  AVANÇADO(2, "ROLE_ADVANCED"), MODERADOR(3, "ROLE_ADMIN");
 - LEITOR: Após o cadastro, esse usuário poderá logar e buscar por um filme. Ele poderá ver as informações de um filme, comentários e dar uma nota para o filme. A cada filme que o usuário avaliar, ele ganha 1 ponto em seu perfil.
 - BÁSICO: O usuário leitor poderá se tornar BÁSICO quando adquirir 20 pontos. Nesse perfil será possível postar comentários, notas e responder comentários. Cada resposta que o usuário enviar, ele ganha 1 ponto.
 - AVANÇADO: O usuário básico poderá se tornar AVANÇADO quando adquirir 100 pontos. Esse perfil tem as capacidades do BÁSICO, e mais citar outros comentários (comentários feitos por outros usuários) e marcar comentários como “gostei” ou "não gostei”.
 - MODERADOR pontuação de 1000 pontos. 
- Login e autenticação com JWT
- Um usuário não poderá logar sem ter feito um cadastro;
- Um usuário não poderá ver filmes e comentários e notas sem estar logado;
- Um usuário de um determinado perfil não poderá realizar ações que não fazem parte de seu perfil;
- Todas as funcionalidade de seu sistema devem receber um token de autenticação, gerados pela sua API de autorização;
- Um usuário não autenticado(que não possui o token) não poderá realizar ações no sistema;
- Um usuário com token invalido não poderá realizar ações no sistema.

## 🛠 Tecnologias utilizadas
- [JAVA]
- [MySQL]
- [SWAGGER] : url http://localhost:8080/swagger-ui.html#/
- [SPRING]
- [JWT]
- [INTELIJ IDEA]
- [MAVEN]
- Base url : http://localhost:8080/


### 🎮 Como rodar o projeto
- Realize o clone do repositório 
- Altere a senha do banco de dados no arquivo 
spring.datasource.username={seuUsuarioMySQL}
spring.datasource.password={suaSenha}
- Verifique se as dependências foram baixadas, "Reload All Maven Projectss"
- Execute o projeto [JAVA], Run ItauApplication 
- Utilize a coleção de requisições [POSTMAN]
- Crie um usuário 
- Crie um filme
- Utilizando os IDs de User e Movie  você poderá realizar as demais requisições 
- Realize o login do usuário, utilizando email e senha
- Adicione o token gerado no login do usuário no Header de todas as demais requisições. KEY : Authorization, VALUE : Token gerado no Access-Control-Allow-Headers após loging
- Atribua uma nota ao Filme
- Atribua um comentário ao Filme
- A cada interação com a aplicação (Requisições POST) o usuário somará pontos ao atributo actions, além disso será verificado a quantidade de pontos acumulados nesse atributo para que seja adicionada permições ao usuário. 
- Todos os modelos de requisição estão adicionados a coleção



### 💾 Database

![image](https://user-images.githubusercontent.com/85448082/176965107-0fd87fea-e1e3-45a5-a5f2-62a6cff1f0da.png)

  ## 👾 Requisitos propostos NÃO realizados e possiveis melhorias a serem implementadas: 
  - A busca pelo filme na sua api deve ser feita consultando uma api pública chamada OMDb API (https://www.omdbapi.com/) e os comentários e notas devem ser salvos no seu sistema;
  - Todas as tentativas falhas de login devem ser salvas em um cache;
  - Caso um usuário tente 3 vezes logar e erre, na 4 vez deverá ser retornado uma mensagem de “limite de tentativas excedido “;
  - Um usúário só poderá interagir com a aplicação com seu ID;
  - Validação dos dados inviados, objetos nulos e etc;
  - O moderador tem as capacidades do AVANÇADO, e mais excluir um comentário ou marcar como repetida.
  - MODERADOR: Um usuário poderá se tornar MODERADOR de 2 formas: um moderador torna outro usuário moderador ou por pontuação, para se tornar MODERADOR o usuário deverá ter 1000 pontos. O moderador tem as capacidades do AVANÇADO, e mais excluir um comentário ou marcar como repetida.


## Contato 
[WHATSAPP] : (11) 96486-4690
EMAIL: fiama.sophia.sf@gmail.com


[JAVA]: https://www.java.com/pt-BR/
[MySQL]: https://www.mysql.com/
[SWAGGER]: https://swagger.io/tools/swagger-ui/
[SPRING]: https://spring.io/projects/spring-boot
[JWT]: https://jwt.io/
[MAVEN]: https://maven.apache.org/download.cgi
[POSTMAN]: https://www.postman.com/
[WHATSAPP]: https://www.whatsapp.com/?lang=pt_br
[INTELIJ IDEA]: https://www.jetbrains.com/pt-br/idea/

