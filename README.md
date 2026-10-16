# Projeto Cine System 

![cine_img](https://github.com/JG-endOS/ProjetoSistemaCinema/blob/main/Captura%20de%20tela%202026-10-15%20220316.png)

---

### 🧑‍💻 Devs
JG-endOS - responsável pela maior parte da escrita do código, principalmente funções e classes<br>
RJulyane - responsável pela implementação do menu e do Gson<br>
glutmother - responsável pela escrita das funções e da organização do GitHub<br>
laisecamarao - responsável pela implementação dos testes automatizados pelo JUnit<br>

---

### 📖 Problema
Um cinema local precisa de um sistema para rastrear e registrar suas vendas, seus clientes e os filmes de maneira eficiente

---

### 🦾 Funcionalidades
• Cadastrar<br>
• Listar / Ordenar<br>
• Consultar<br>
• Remover<br>
• Editar<br>
• Calcular indicadores / Gerar relatórios<br>
• Pesquisar<br>
• Associar Objetos<br>

---

### 🗄️ Classes principais
• Cinema.java<br>
• Venda.java<br> 
• Filme.java<br>
• Sala.java<br>
• Cliente.java<br>
• Produto.java<br>

---

### 📊 Regras de negócio
• O cinema não resgistra vendas de ingressos para pessoas sem a idade apropriada<br>
• O cinema oferece desconto para estudantes e idosos<br>
• 10% do faturamento total é dos funcionários<br>
• Vendas são negadas quando a sala está lotada<br>
• Aos finais de semana o preço base fica 10R$ mais caro<br>

---

### 💻 Tecnologias usadas
• Gerenciamento de dependências: Maven<br>
• Tecnologia externa 1: Google Gson (importação e exportação de dados em JSON)<br>
• Tecnologia externa 2: JUnit (testes automatizados das regras criadas)<br>

---

### ⚙️ Instruções para configuração
1) Baixar o arquivo ProjetoCinema.zip
2) Extrair o arquivo
3) Abrir o VS Code
4) Abrir a pasta do programa dentro do VS Code

---


### ▶️ Instruções para execução
Antes de rodar o programa, é essencial baixar a extensão do Maven para Java no Marketplace do VS Code, para garantir que o código funcione como esperado

---

### 📇 Exemplos de uso
Sistema de um cinema local de pequeno porte

---

### 🤖 Utilização de IA
<table>
  <tr>
    <td>Ferramenta</td>
    <td>Objetivo</td>
    <td>Resumo do uso</td>
    <td>Revisão pelo dev</td>
  </tr>
  <tr>
    <td>ChatGPT</td>
    <td>Código para exportação com JSON, correção de erros</td>
    <td>Foi usado para organização do código utilizado para a função de exportação com JSON, correção de erros no JUnit para testes automatizados e verificação dos resultados dos testes e para passar raiva</td>
    <td>Testes manuais e validação das funções, organização do código</td>
  </tr>
  <tr>
    <td>Claude</td>
    <td>Código para exportação com JSON</td>
    <td>Foi usado para organização do código utilizado para a função de exportação com JSON e funções iniciais do menu</td>
    <td>Testes manuais e validação das funções, organização do código</td>
  </tr>
  <tr>
    <td>Gemini</td>
    <td>Raciocínio e README</td>
    <td>Foi usado para as definições iniciais do código e do README, auxiliou na definição e idealização das funções principais do programa</td>
    <td>Construção do esqueleto inicial do programa e validação das funções</td>
  </tr>
</table>
