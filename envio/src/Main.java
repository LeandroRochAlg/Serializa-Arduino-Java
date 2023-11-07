import jssc.SerialPort;
import jssc.SerialPortException;

public class Main {
    public static void main(String[] args) {

        byte vet[] = new byte[16];                      // Vetor de bytes que será enviado
        int fim = 24;                                   // Número que indica o fim da sequência
        int inicio = 42;                                // Número que indica o início da sequência
        int[] nums = {inicio, 1, 2, 3, 4, 5, fim, 15};  // Números que serão montados e enviados

        for(int i = 0; i<8; i++) {
            serializar(vet, nums[i], i*2);

            if(nums[i] == fim){
                serializar(vet, nums[i+1], i*2+2);
            }
        }

        SerialPort porta = new SerialPort("COM6");    // Porta serial que será utilizada

        try {   // Tenta abrir a porta serial
            porta.openPort();
            porta.setParams(9600, 8, 1, 0, false, false);
            porta.writeBytes(vet);  // Envia o vetor de bytes
            porta.closePort();
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }

    // Método que serializa um inteiro em um vetor de bytes
    public static void serializar(byte[] vet, int num, int pos) {
        byte b1, b2;    // Bytes que serão utilizados para serializar o inteiro

        b2 = (byte)(num & 0xFF);        // Pega os 8 primeiros bits do inteiro
        b1 = (byte)((num >> 8) & 0xFF); // Pega os 8 últimos bits do inteiro

        // Coloca os bytes no vetor de bytes
        vet[pos] = b1;
        vet[pos+1] = b2;
    }
}