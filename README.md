Rastreamento de usuários

Uma das maneiras de identificarmos potenciais clientes é verificando onde os visitantes do nosso site acessam e buscam informações. Dado que um dos clientes do RD Station possua um software no modelo SaaS e a atração de seus clientes é principalmente feita pelo seu site, um visitante que acessa a página de informações do produto, depois a página de preços e por fim a página de contato, está mais propenso a se tornar um cliente do que um visitante que acessou apenas a página inicial.

Sendo assim, o desafio proposto é:

Desenvolver uma aplicação web em Ruby que contenha uma lista de contatos. Deve obrigatoriamente conter o campo email. Sugestão de framework: Sinatra ou Rails
Desenvolver uma biblioteca em JavaScript que quando incluída no site do cliente envie as seguintes informações para a sua aplicação:
Identificador único do visitante (Usar cookies ou local storage) 
URL acessada
Data/hora do acesso
Criar um site de exemplo desacoplado da aplicação principal contendo pelo menos 3 páginas utilizando a biblioteca JS desenvolvida
O site de exemplo deve conter uma página de contato com um formulário que envie o contato para sua aplicação. Esse formulário deve ter um campo "email" que servirá como identificador do contato.

Espera-se que funcione da seguinte forma:

 O visitante "A" acessa a página "Home" da sua página de exemplo.
 O visitante "A" acessa a página de "Preço" da sua página de exemplo.
 O visitante "B" acessa a página "Home" da sua página de exemplo.
 O visitante "B" acessa a página "Contato" da sua página de exemplo.
 O visitante "B" preenche o formulário e confirma.
 É criado um contato em sua aplicação para o Visitante "B".
 Ao acessar a página do Visitante "B" na aplicação é possível ver as seguintes páginas:
Home
Contato
O visitante "A" acessa a página "Contato" da sua página de exemplo.
O visitante "A" preenche o formulário e confirma.
É criado um contato em sua aplicação para o Visitante "A".
Ao acessar a página do Visitante "A" na aplicação é possível ver as seguintes páginas:
Home
Preço
Contato
O visitante "B" acessa a página "Sobre" da página de exemplo.
Ao acessar a página do visitante "B" na aplicação é possível ver as seguintes páginas:
Home
Contato
Sobre

Note que após o visitante preencher o formulário de contato, toda página que ele acessar deve ser rastreada em tempo real dispensando a necessidade dele se cadastrar novamente.
Fique atento a problemas de performance e concorrência em uma grande quantidade de requisições. Caso julgue necessário o desenvolvimento de outras bibliotecas ou serviços, pode utilizar a tecnologia que quiser.

Sobre a aplicação e o código fonte, esperamos o seguinte:

O código deve estar no Github
Deve existir um Readme em inglês que explique como rodar localmente a aplicação
Devem existir testes automatizados. Quanto mais bem testada a aplicação, melhor.
A aplicação deve estar deployada no Heroku

	Como queremos avaliar o seu estilo, pedimos que não utilize geradores de código.
	Por fim, como você é um RDoer em potencial, tenha sempre em mente o nosso Culture Code .	
No final você deve nos entregar um documento contendo uma breve apresentação da aplicação, além dos links para o código fonte no Github e para a aplicação no Heroku. Você também pode documentar as decisões e suposições em que se baseou caso ache necessário. Esperamos que você entregue o máximo que conseguir fazer em 4 dias. Te desejamos muita boa sorte. ;) Keep Hacking.
