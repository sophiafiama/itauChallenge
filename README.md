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
 - MODERADOR: Um usuário poderá se tornar MODERADOR de 2 formas: um moderador torna outro usuário moderador ou por pontuação, para se tornar MODERADOR o usuário deverá ter 1000 pontos. O moderador tem as capacidades do AVANÇADO, e mais excluir um comentário ou marcar como repetida.

- Login e autenticação com JWT
- Um usuário não poderá logar sem ter feito um cadastro;
- Um usuário não poderá ver filmes e comentários e notas sem estar logado;
- Um usuário de um determinado perfil não poderá realizar ações que não fazem parte de seu perfil;
- Todas as funcionalidade de seu sistema devem receber um token de autenticação, gerados pela sua API de autorização;
- Um usuário não autenticado(que não possui o token) não poderá realizar ações no sistema;
- Um usuário com token invalido não poderá realizar ações no sistema.

## 🛠 Tecnologias utilizadas
[JAVA]: https://www.java.com/pt-BR/
[MySQL]: https://www.mysql.com/
[SWAGGER]: https://swagger.io/tools/swagger-ui/
[SPRING]: https://spring.io/projects/spring-boot
[JWT]: https://jwt.io/


### 🎮 Como rodar o projeto
