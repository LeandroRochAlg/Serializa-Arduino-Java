# Serializa-o
[PT] Serialização de mensagens. Envio de um vetor de inteiros quebrados em 2 bytes.
# Projeto Arduino-Java Comunicação Serial

Este projeto consiste em uma comunicação serial entre um computador (Java) e um Arduino. A ideia é enviar um vetor de inteiros desmontados de 2 em 2 bytes para o Arduino, que monta a mensagem e verifica se a soma dos números está correta. Abaixo estão os detalhes de como executar o projeto e os arquivos de código necessários.

## Conteúdo do Repositório

- `envio/src/Main.java`: Arquivo Java responsável por criar o vetor de inteiros, serializá-lo e enviá-lo para o Arduino via comunicação serial.
- `recebimento/arduino.ino`: Código Arduino que recebe os dados serializados, monta o vetor de inteiros e verifica se a soma está correta.

## Requisitos

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk15-downloads.html) instalado no computador.
- [Arduino IDE](https://www.arduino.cc/en/Main/Software) instalada no computador.

## Como Executar o Projeto

1. **Configurar o Hardware:**
   - Conecte o Arduino ao computador via cabo USB.
   - Certifique-se de que o Arduino está configurado corretamente e a porta COM está selecionada na Arduino IDE.

2. **Compilar e Enviar o Código Arduino:**
   - Abra o arquivo `arduino.ino` na Arduino IDE.
   - Compile e envie o código para o Arduino.

3. **Executar o Código Java:**
   - Abra o arquivo `Main.java` em um ambiente de desenvolvimento Java, como o Eclipse ou o IntelliJ IDEA.
   - Certifique-se de que a biblioteca `jssc` está configurada no seu projeto (pode ser baixada [aqui](https://github.com/java-native/jssc)).
   - Execute o código Java. Ele criará o vetor de inteiros, serializará os dados e enviará para o Arduino.

4. **Observar a Saída no Monitor Serial:**
   - Abra o Monitor Serial na Arduino IDE para ver as mensagens enviadas pelo Arduino.
   - O Arduino verificará se a soma dos números recebidos está correta e exibirá uma mensagem indicando se a soma é correta ou não.

Certifique-se de ajustar as portas COM no código Java e Arduino, conforme necessário, para corresponder à porta à qual o Arduino está conectado ao computador.

## Colaboradores
<a href="https://github.com/CacauRowe">
    <img src="https://avatars.githubusercontent.com/u/62967461?v=4" alt="Ana Clara Braz" style="width: 100px; border-radius: 50%">
    <br>
    Ana Clara Braz
</a>

<br>

<a href="https://github.com/LeandroRochAlg">
    <img src="https://avatars.githubusercontent.com/u/87719561?v=4" alt="Leandro Rocha" style="width: 100px; border-radius: 50%">
    <br>
    Leandro Rocha
</a>

<hr>

Divirta-se experimentando e explorando mais sobre comunicação serial Arduino-Java!