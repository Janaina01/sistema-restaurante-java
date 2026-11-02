# Sistema de Restaurante 🍔

Projeto desenvolvido em **Java** para simular o atendimento de um restaurante, desde a montagem de lanches e o registro de pedidos até o fechamento do dia. O sistema funciona pelo **console** e foi construído em três níveis, com evolução gradual das funcionalidades.

## Funcionalidades

- **Cardápio:** X-Burger (R$ 16,00), X-Salada (R$ 18,00) e X-Bacon (R$ 22,00).
- **Pedidos:** cadastro com numeração automática, identificação do cliente, inclusão e remoção de itens e listagem dos pedidos.
- **Personalização:** retirada de queijo, alface, tomate ou cebola sem alteração do preço do lanche.
- **Adicionais:** cheddar (+ R$ 4,00) e bacon extra (+ R$ 6,00), inclusive combinados.
- **Cancelamento:** pedidos cancelados não entram no faturamento do dia.
- **Fechamento:** cálculo do faturamento e apresentação da quantidade e das descrições das combinações únicas vendidas.
- **Validações:** tratamento de nomes inválidos, valores negativos e entradas numéricas incorretas.

## Tecnologias e conceitos

- Java 27 (conforme configuração do `pom.xml`)
- Maven
- JUnit 5
- Programação orientada a objetos e encapsulamento
- Interfaces e polimorfismo
- Coleções `ArrayList`, `HashMap` e `HashSet`
- Tratamento de exceções

### Padrões de projeto

- **Factory (`LancheFactory`):** centraliza a criação de novos lanches do cardápio.
- **Decorator (`ComCheddar` e `ComBaconExtra`):** adiciona ingredientes pagos à descrição e ao preço sem modificar a classe base.
- **Facade (`RestauranteFacade`):** concentra o acesso às operações do sistema, simplificando a comunicação com o menu.

## Organização do projeto

```text
src/
├── main/java/org/example/
│   ├── app/         # Main, MenuConsole e RestauranteFacade
│   ├── cardapio/    # Lanche, interface, Factory e adicionais
│   └── pedido/      # Pedido e GerenciadorPedidos
└── test/java/org/example/pedido/
    ├── ComBaconExtraTest.java
    ├── GerenciadorPedidosTest.java
    ├── LancheTest.java
    └── PedidoTest.java
```

## Como executar

1. Clone o repositório:

   ```bash
   git clone https://github.com/Janaina01/sistema-restaurante-java.git
   ```

2. Abra a pasta do projeto no **IntelliJ IDEA** como um projeto Maven.
3. Configure um **JDK 27**, compatível com o `pom.xml`.
4. Aguarde o Maven carregar as dependências.
5. Execute o método `main` da classe `org.example.app.Main`.
6. Siga as opções exibidas no console para registrar, consultar, alterar e cancelar pedidos ou fechar o restaurante.

## Testes

O projeto inclui testes automatizados com **JUnit 5** para validações e regras de negócio. Na última execução registrada durante o desenvolvimento, **16 testes passaram**.

Para executar os testes no IntelliJ, clique com o botão direito na pasta `src/test/java` e selecione **Run Tests**. Também é possível usar o ciclo **test** do Maven.

## Demonstração em vídeo

**Link do vídeo:** _adicionar aqui após a gravação_.

Na demonstração, serão apresentados o fluxo de um pedido, a organização dos pacotes, um padrão de projeto e a execução dos testes.

## Escopo

O projeto contempla os **níveis 1, 2 e 3** da atividade proposta. As funcionalidades de bônus não fazem parte desta versão.
