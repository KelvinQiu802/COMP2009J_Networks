import java.io.FileInputStream;
import java.io.IOException;

public class Io {
    public static void main(String[] args) {
//        String hi = "Hello Word";
//        byte[] data = hi.getBytes();
//
//        try {
//            System.out.write(data);
//        } catch (IOException e) {
//            System.out.println(e);
//        } finally {
//            System.out.close();
//        }
//
//        System.out.flush();

//        try {
//            int[] data = new int[10];
//            for (int i = 0; i < data.length; i++) {
//                data[i] = System.in.read();
//            }
//            for (int datum : data) {
//                System.out.write(datum);
//            }
//            System.out.flush();
//        } catch (IOException e) {
//            System.out.println(e);
//        } finally {
//            System.out.close();
//        }

        try {
            FileInputStream in = new FileInputStream("test.txt");
            while (true) {
                int data = in.read();
                if (data == -1) {
                    System.out.println("\nEOF");
                    break;
                } else {
                    System.out.write(data);
                }
            }
            System.out.flush();
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            System.out.close();
        }
    }
}
