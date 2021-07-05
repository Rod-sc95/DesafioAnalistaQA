1° desafio 
	Foi desenvolvido uma solução através do selenium por meio de DSL, onde o intuito foi deixar a solução com um melhor legibilidade e 
	reuso em outros testes. Não foi aplicado a técnica de BDD, pois não possuo conhecimento suficiente para aplica-lá no desenvolvimento.

	¹Primeiro teste - Básicamente, acessamos o elemento "Guia Médica" e realizamos um busca avançada por uma especialidade e região terminada.
	Realizamos a validação dos resultados apresentados através do retorno de um array de WebElement contendo o valor chave da busca de especificação e região
	²Segundo teste - Realizamos o mesmo procedimento que o teste anterior, porém a validação de resultados agora é feita pelo Não apresentação de resultados com a 
	cidade de São Paulo nas páginas 1,2 e 3, onde foi devolvido um método auxiliar para realizar a interação com a páginação dos resultados.


2° desafio
	¹Primeiro teste - Utilizamos o framework RestAssured para realizar a automação. Passamos como parametro as variaveis globais no trecho de pré condição (given)
	e realizamos uma assertiva com o valor de retorno nos campos "Title", "Year" e "Languagem".
	²Segundos teste - Basicamente validamos o retorno da API para uma request de filme inexistente, passando um ID_DO_FILME não existente e obtendo o resultado 	esperado.
