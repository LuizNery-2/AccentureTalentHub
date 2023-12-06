<h1>AccentureTalentHub</h1>

<sub>Este documento contém descrições dos passos necessários para implantar a solução em um novo ambiente. </sub>

<h4>Desenvolvedores: Isabela Silva, Jonathas Mendonca, Karolyna Rolim, Keylane Cardoso, Luisa Ferreira Luiz Nery, Levi Gila 🧑‍💻</h4>

<h3> Descrição: </h3>
      A plataforma Accenture TalentHub é uma solução de treinamento e desenvolvimento desenvolvida para melhorar a comunicação eficaz entre líderes e liderados, visa sanar lacunas no desenvolvimento profissional,
  alinhar os funcionários com as metas da empresa e evitar a perda de talentos valiosos.


<h3> Funcionalidades: </h3>
+ Cadastramento de cursos
+  criação de salas de aulas personalizadas (O líder responsável pela criação da sala pode inserir o curso de sua escolha e os participantes que deseja convidar.)

<h3> Como funciona: </h3>

<h4> O Accenture TalentHub funciona da seguinte forma: </h4>
+ Um chamado é aberto para o suporte da empresa com as informações do usuário como: 
nome, e-mail, usuário, cargo, link da foto para perfil, e se esse usuário terá perfil de lider ou de liderado.

+ o suporte faz o cadastro com a senha padrão: "Mudar@123". Quando o usuário é criado, automaticamente uma sala de aula pessoal para ele é criada.

+ Quando ele entra na plataforma com a senha padrão ,um e-mail com um código aleatório é enviado para ele e ele pode trocar sua senha.
com a senha trocada, ele escolhe as tecnologias que se interessa.

<h3> Benefícios: </h3>

<h4> A Accenture TalentHub oferece os seguintes benefícios: </h4>

+ Sanar lacunas no desenvolvimento profissional: A plataforma ajuda os funcionários a identificar e desenvolver as competências necessárias para o sucesso na empresa. Isso ajuda a evitar que os
 funcionários fiquem para trás no desenvolvimento de suas carreiras.
+ Alinha os funcionários com as metas da empresa: A plataforma ajuda os funcionários a entender as metas da empresa e como podem contribuir para o seu sucesso. Isso ajuda a garantir que os funcionários
  estejam motivados e alinhados com os objetivos da empresa.
+ Evita a perda de talentos valiosos: A plataforma ajuda a identificar e desenvolver os talentos da empresa. Isso ajuda a evitar que a empresa perca talentos valiosos para a concorrência.

<h3> Atualizações futuras: </h3> 
+ Mapeamento de competências: A plataforma permite que os líderes e liderados mapeiem as competências necessárias para o sucesso na empresa, bem como as competências atuais dos funcionários. Isso ajuda a
  identificar as lacunas de desenvolvimento e a criar planos de desenvolvimento personalizados.
+ Recomendações de treinamento: A plataforma fornece recomendações de treinamento com base no mapeamento de competências. Isso ajuda os funcionários a encontrar os cursos e treinamentos mais relevantes
  para suas necessidades.
+ Acompanhamento do progresso: A plataforma permite acompanhar o progresso dos funcionários no desenvolvimento de suas competências. Isso ajuda a garantir que os funcionários estejam no caminho certo
  para alcançar seus objetivos.
+ A plataforma identifica as lacunas de desenvolvimento.
+ A plataforma fornece recomendações de treinamento.
<h3> Conclusão: </h3>

   A plataforma Accenture TalentHub é uma solução poderosa que pode ajudar as empresas a melhorar seus programas de treinamento e desenvolvimento. A plataforma oferece uma série de benefícios, incluindo a 
melhoria da comunicação eficaz entre líderes e liderados, o saneamento de lacunas no desenvolvimento profissional, o alinhamento dos funcionários com as metas da empresa e a prevenção da perda de talentos valiosos.

<h2> Como implementar a solução:</h2>
<h3> Requisitos </h3>

<h4> Para implantar a solução, você precisará dos seguintes requisitos:</h4>

Um servidor web com suporte a Java e PostgreSQL.
Um banco de dados PostgreSQL.
Uma ferramenta de gerenciamento de código-fonte, como o GitHub.
Um editor de código, como o Visual Studio Code.


<h3> Passos: </h3>
1- Crie um projeto Spring Boot.
Para criar um projeto Spring Boot, você pode usar a ferramenta Spring Initializr. Acesse o site da Spring Initializr e selecione as seguintes dependências:

      * Web
      * PostgreSQL
_<h4> Clique em "Gerar projeto" e salve o arquivo do projeto em seu computador.</h4>
_

<h4> 2.Configurar o banco de dados PostgreSQL. </h4>
Para configurar o banco de dados PostgreSQL, você precisará criar um banco de dados e uma tabela para a solução.

_Para criar um banco de dados, execute o seguinte comando:_ 

      psql -U postgres

Digite a senha do usuário postgres quando solicitado.
<sub> o suporte faz o cadastro com a senha padrão: "Mudar@123". Quando o usuário é criado, automaticamente uma sala de aula pessoal para ele é criada. </sub>

Em seguida, execute o seguinte comando para criar o banco de dados:

      CREATE DATABASE AccentureTalentHub; 
Para criar uma tabela, execute o seguinte comando:

      USE AccentureTalentHub;
Em seguida, execute o seguinte comando para criar a tabela:
      
               CREATE TABLE sua-tabela (
        id INT NOT NULL AUTO_INCREMENT,
        nome VARCHAR(255) NOT NULL,
        email VARCHAR(255) NOT NULL,
        PRIMARY KEY (id)
      );

<h4> 3.Configurar a conexão com o banco de dados.</h4>
Abra o arquivo `application.properties` do projeto Spring Boot e configure as seguintes propriedades:

- `spring.datasource.url:` A URL do banco de dados.
- `spring.datasource.username:` O nome de usuário do banco de dados.
- `spring.datasource.password:` A senha do banco de dados.

<h4> 4.Crie os arquivos de front-end. </h4>
Os arquivos de front-end da solução são escritos em JavaScript, HTML e CSS. Você pode criar esses arquivos usando um editor de código, como o Visual Studio Code.

Para criar uma página simples, você pode usar o seguinte código:

       HTML
      <!DOCTYPE html>
      <html lang="pt-br">
      <head>
        <title>AccentureTalentHub</title>
      </head>
      <body>
        <h1>Olá, mundo!</h1>
      </body>
      </html>
<h4> 5.Construa o aplicativo Spring Boot.</h4>
Para construir o aplicativo Spring Boot, execute o seguinte comando:

      ./mvnw clean install
<h4> 6.Copie os arquivos para o servidor web. </h4> 
Copie os arquivos do projeto Spring Boot, incluindo os arquivos de front-end, para o diretório do servidor web.

Para copiar os arquivos para o servidor web local, você pode usar o seguinte comando:

      scp -r ./AccentureTalentHub /var/www/

<h4> 7.Configure o servidor web. </h4>
Você precisará configurar o servidor web para apontar para o diretório da solução.

Para configurar o Apache, edite o arquivo` httpd.conf` e adicione a seguinte diretiva:

      Alias /AccentureTalentHub/var/www/

<h4> 8. Em seguida, reinicie o servidor web.</h4>

Inicie o servidor web.
Para iniciar o servidor web, execute o seguinte comando:

      sudo systemctl start apache2

<h4> Avaliação </h4>
Para avaliar a solução, você pode executar os seguintes testes:

Abra o navegador e navegue até o endereço da solução.
Verifique se a solução é exibida corretamente.
Tente inserir dados na solução.
Verifique se os dados são inseridos corretamente.
Se a solução passar nos testes




      





