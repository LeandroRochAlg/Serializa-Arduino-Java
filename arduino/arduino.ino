byte msg[16];
int num;

int deserializar(byte vet[], int pos){
  num = msg[pos];
  num = num << 8;
  num = num | msg[pos+1];
  
  return num;
}

void setup() {
  Serial.begin(9600);
  Serial.println("Leandro");
}

void loop() {
  if(Serial.available()){
    Serial.readBytes(msg,16);

    int vet[8];
    int soma = 0, i;

    for(i = 0; i<8; i++){
      vet[i] = deserializar(msg, i*2);

      if(i>2){
        if(vet[i-1]==24) {
				  break;
        }
      }
    }

    for(int j = 1; j<i-1; j++){
      soma += vet[j];
    }

    if(soma == vet[i]){
      Serial.print("1");
    }else{
      Serial.print("0");
    }
  }
}