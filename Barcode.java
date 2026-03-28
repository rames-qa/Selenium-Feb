package selenium.advanced;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix; // 1. Added this import
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Barcode {

    public static void main(String[] args) {
        try {
            String data = "SwagLabs"; 

            BitMatrix matrix = new MultiFormatWriter().encode(
                    data,
                    BarcodeFormat.CODE_128,
                    300,
                    100
            );

            Path path = FileSystems.getDefault().getPath("barcode.png");
            MatrixToImageWriter.writeToPath(matrix, "PNG", path);

            System.out.println("Barcode generated successfully at: " + path.toAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}