import java.io.InputStream;
import java.util.Scanner;

public class Reader {
    public static String fileText(){
        InputStream is = Reader.class.getResourceAsStream("/resources/text.txt");
        if (is == null) {
            return "Ресурс не найден!";
        }
        String text = "";
        Scanner scanner = new Scanner(is);
        while (scanner.hasNextLine()) {
            text += scanner.nextLine();
        }
        scanner.close();
        return text;


    }
}
