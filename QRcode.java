package selenium.advanced;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter; 
import com.google.zxing.common.BitMatrix;
import java.nio.file.FileSystems; 
import java.nio.file.Path;
public class QRcode {

    public static void main(String[] args) {
        generateQRCodeImage("https://www.saucedemo.com/", 200, "qrcode.png");
        displayQRCodeInConsole("https://www.saucedemo.com/", 35);
    }

    public static void generateQRCodeImage(String data, int size, String fileName) {
        try {
            BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, size, size);
            Path path = FileSystems.getDefault().getPath(fileName);
            MatrixToImageWriter.writeToPath(matrix, "PNG", path);
            System.out.println("QR Code image saved at: " + path.toAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayQRCodeInConsole(String data, int size) {
        try {
            BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, size, size);
            for (int y = 0; y < size; y++) {
                for (int x = 0; x < size; x++) {
                    System.out.print(matrix.get(x, y) ? "  " : "  ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}