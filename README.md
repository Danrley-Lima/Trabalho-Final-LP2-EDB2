<h1 align="center">TRABALHO INTERDISCIPLINAR <br><br> LINGUAGEM DE PROGRAMAÇÃO 2 <br> ESTRUTURA DE DADOS 2</h1>

<p align="center">
   <img src="https://miro.medium.com/max/640/0*VML2uj9Frs7f13MK.webp">
</p>
<br>

# 🎲 Introdução
Neste projeto foi criado uma solução para um pseudo problema de redes usando o
paradigma de programação orientada a objetos, onde é preciso conectar todas as casas
(vértices) com o menor custo possível e no máximo d ligações por casa, em outras
palavras é um problema de árvore geradora mínima com restrição de grau.

Utilizamos um algoritmo para gerar as combinações possíveis de arestas a partir
de um grafo completo. Com as combinações, podemos gerar árvores através do algoritmo
de Kruskal que utiliza a estrutura de dados Conjunto Disjunto para evitar ciclos,
verificando o representante de cada conjunto e gerando uma árvore a cada combinação única
de arestas. A primeira árvore válida gerada é armazenada e a cada nova árvore válida
gerada é feita a comparação de qual tem o menor custo e substituindo-a caso a nova
árvore tenha custo total menor do que a anterior.

Para criação de interface foi utilizado a biblioteca <a href="https://graphstream-project.org/">GraphStream</a>.

## Grafo de entrada
<p align="center">
<img src="https://user-images.githubusercontent.com/71523376/205799330-978b8d36-fe14-410c-8fbe-b5a5d9785d71.png" width="400">
</p>

## Grafo de saída
<p align="center">
<img src="https://user-images.githubusercontent.com/71523376/205799362-2f7f1f9d-c275-4b53-aeac-a74e54767e9c.png" width="400">
</p>

# ⚙️ Requisitos


 * ## Ambiente
    - Visual Studio Code
    - Eclipse
 * ## Linguagem de programação
    - Java<br>
    <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" width="140" height="50">

* ## Como rodar no Visual Studio Code
  ### Na pasta vscode contém o arquivo "launch.json" e na sua linha 19 é possível trocar a entrada de arquivo para o programa, tais arquivos estão em formato .txt na pasta data.
  1. - Abra o Visual Studio Code na pasta do projeto.
  2. - Instale a extensão "Extension Pack for Java" no Visual Studio Code.
  3. - Abre o arquivo Main.java.
  4. - Clique setinha ao lado do símbolo de "Play" e escolha "Run Java".<br><img src="https://user-images.githubusercontent.com/71523376/205457448-0e2c8ee4-08be-4a2c-904c-fc046ddc8734.png">
   
* ## Como rodar no Eclipse
   1. - Abra o Eclipse
   2. - Abra o projeto
   3. - Selecione run configurations
   4. - Selecione o arquivo Main do projeto e selecione a aba "Arguments"
   5. - Em Arguments, digite o caminho relativo ao arquivo que deseja passar por parâmetro
   6. - Ex.: "./data/entrada.txt"


# 🤝 Colaboradores
  * [Anchel Vitor](https://github.com/Anchel17)
  * [Danrley Lima](https://github.com/Danrley-Lima)
***
