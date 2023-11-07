byte msg[16]; // Vetor de bytes que armazena a mensagem recebida
int num;      // Variável que armazena o número montado
int fim = 24; // Número que indica o fim da mensagem

// Função que recebe um vetor de bytes e uma posição e retorna um inteiro montado por 2 bytes
int deserializar(byte vet[], int pos){
  num = msg[pos];
  num = num << 8;
  num = num | msg[pos+1];
  
  return num;
}

// Configuração inicial do Arduino
void setup() {
  Serial.begin(9600);
}

// Função principal do Arduino
void loop() {
  if(Serial.available()){ // Se houver dados disponíveis na porta serial
    Serial.readBytes(msg,16); // Lê os dados disponíveis e armazena no vetor msg

    int vet[8];       // Vetor que armazena os números da mensagem
    int soma = 0, i;  // Variáveis auxiliares

    for(i = 0; i<8; i++){ // Percorre o vetor de bytes e monta o vetor de inteiros
      vet[i] = deserializar(msg, i*2);

      if(vet[i] == fim){ // Se encontrar o fim da mensagem, monta a soma e sai do loop
        vet[i+1] = deserializar(msg, i*2+2);
        break;
      }
    }

    for(int j = 1; j<i-1; j++){ // Percorre o vetor de inteiros e calcula a soma
      soma += vet[j];
    }

    if(soma == vet[i]){ // Verifica se a soma está correta
      Serial.print("Soma correta!!!");
    }else{
      Serial.print("Soma incorreta :(");
    }
  }
}