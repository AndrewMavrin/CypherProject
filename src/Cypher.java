import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;


public class Cypher{

    static char[] ALPHABET = new char[]{'а', 'б', 'в',
            'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»',
            ':', '!', '?', ' '};

    public static char[] encryption(char[] buff, int key) { //метод сдвигает текущую букву из массива на количество шагов равное ключу.
        for (int i = 0; i < buff.length; i++) {
            for (int a = 0; a < ALPHABET.length; a++) {
                if (buff[i] == ALPHABET[a]) {
                    if (a + key < ALPHABET.length) {
                        buff[i] = ALPHABET[a + key];
                        break;
                    } else if (a + key > ALPHABET.length - 1) {
                        int c = a + key - ALPHABET.length;
                        buff[i] = ALPHABET[c];
                        break;
                    }
                }
            }
        }
        return buff;
    }

    public static void fileEncryption() throws IOException {
        //Метод зашифровывает информацию в файле пользователя по методу Цезаря, после чего принудительно закрывает потоки и перезаписывает файл.
        try(BufferedReader reader  = new BufferedReader(new FileReader(FileProcessing.getFileCode()));
            BufferedWriter writer = new BufferedWriter( new FileWriter("src/Text2.txt"))){
            while (reader.ready()){
                String str = reader.readLine().toLowerCase();
                char[] buff = str.toCharArray();
                writer.write( Cypher.encryption(buff, FileProcessing.getKeyCode()));
                writer.newLine();}
            writer.close();
            reader.close();
            Path path = Path.of(FileProcessing.getFileCode());
            Files.copy(Path.of("src/Text2.txt"),path, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}







