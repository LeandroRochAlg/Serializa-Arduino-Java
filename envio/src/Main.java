import jssc.SerialPort;
import jssc.SerialPortException;

public class Main {
    public static void main(String[] args) {

        byte vet[] = new byte[16];
        int[] nums = {42, 1, 2, 3, 4, 5, 24, 15};

        for(int i = 0; i<8; i++) {
            serializar(vet, nums[i], i*2);

            if(i>2) {
                if(nums[i-1]==24) {
                    break;
                }
            }
        }

        SerialPort porta = new SerialPort("COM6");

        try {
            porta.openPort();
            porta.setParams(9600, 0, 1, 0, false, false);
            porta.writeBytes(vet);
            porta.closePort();
        } catch (SerialPortException e) {

            e.printStackTrace();
        }
    }

    public static void serializar(byte vet[], int num, int pos) {
        byte b1, b2;

        b2 = (byte)(num & 0xFF);
        b1 = (byte)( (num >> 8) & 0xFF );

        vet[pos] = b1;
        vet[pos+1] = b2;
    }
}