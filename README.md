# Tarefa 1

Para avaliarmos o impacto do uso de assistentes de IA nas atividades de desenvolvimento, seguiremos com a programação com e sem apoio de assistente de IA para a tarefa aqui proposta..

## Conceitos

### Vetorização

Uma das técnicas utilizadas por IA é a vetorização, a transformação de informação não estruturada em um vetor de valores numéricos. 

Em processamento de linguagem natural por IA, a vetorização é utilizada para transformar texto em um array de números.

### Determinação de Similaridade

A comparação de textos de forma a identificar o quão próximos estão, ou  seja, o quanto um texto está relacionado com outro, é uma tarefa recorrente no processamento de linguagem natural em algoritmos de IA.

A similaridade pode ser expressa em um intervalo de -1 a 1, onde 1 seria o máximo de similaridade, que é o caso quando comparamos a similaridade de um texto com ele mesmo, e -1 indicaria um outro extremo, ou seja dois textos que não tem nenhuma relação entre si. 

Exemplo:

Frase 1:
"Hello AI Challenging World!"

Frase 2
"The world is being challenged by AI!"


Similaridade(Frase1, Frase1): 1
Similaridade(Frase1, Frase2): 0.1889822365046136 


Esta é a idéia. Os valores podem ser mais ou menos assertivos a depender da técnica utilizada para vetorização e da técnica para determinar a distância entre os vetores (o grau de similaridade).


### Distância de Cosseno

Uma vez que os textos foram transformados em vetores, uma das técnicas de determinação de similaridade é a da Distância de Cosseno.

Considerando o ângulo entre dois vetores como Theta, a Distância de Cosseno é simplesmente o Cosseno de Theta.


A Distância de Cossenos pode ser estendida para vetores de n dimensões:


## Snipped

Exemplo de código Java para vetorização de uma String:

public static Map<String, Integer> vectorizeString(String inputString) throws IOException
    {
        Map<String, Integer> wordCount = new HashMap<>();
        ClassicTokenizer tokenizer = new ClassicTokenizer();
        tokenizer.setReader(new StringReader(inputString));
        tokenizer.reset();


        while (tokenizer.incrementToken())
        {
            String token = tokenizer.getAttribute(CharTermAttribute.class).toString();
            wordCount.put(token, wordCount.getOrDefault(token, 0) + 1);
        }


        tokenizer.end();
        tokenizer.close();


        return wordCount;
    }




## Tarefa de Desenvolvimento


Desenvolva uma aplicação Web que apresenta um formulário com:

1. Dois campos texto para entrada e frases pelo usuário
2. Um botão (Similaridade) para solicitar o valor da similaridade entre as frases
3. Um botão (Histórico) para apresentar na tela o histórico de consultas feitas.
4. Um link (Home) para voltar à tela inicial.

Premissas da implementação:

0. FrontEnd com React e NFF, Backend em Java
1. Solução hospedada em cloud Azure
3. DeterminarSimilaridade como microsserviço com deploy em AKS, e exportado via REST API.
4. Resultados da execução de DeterminarSimilaridade deve ser persistido em base gerenciada na Azure.
4. ListarHistorico como microsserviço com deploy em  AKS, e exportado via REST API.
5. O código deve estar documentado com comentários
6. Deve incluir testes unitários JUnit
 
## Avaliação

### Inspeção
### Tempo de desenvolvimento
### Dev Survey

