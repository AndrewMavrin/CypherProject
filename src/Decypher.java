import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Decypher{
    static char[] ALPHABET = new char[]{'а', 'б', 'в',
            'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»',
            ':', '!', '?', ' '};
    static char[] dencryption(char[] buff, int key){ // Метод сдвигает текущую букву из массива на количество шагов равное ключу.
        for(int i = 0; i< buff.length; i++){
            for(int a = 0;a<ALPHABET.length;a++){
                if (buff[i] == ALPHABET[a]) {
                    if(a- key <0){
                        buff[i]= ALPHABET[ALPHABET.length+(a- key)];
                        break;
                    }
                    else if(a- key >=0){
                        buff[i] = ALPHABET[a- key];
                        break;}}}}
        return buff;
    }

    public static void fileDecryption() throws IOException {
        //Метод расшифровывает информацию в файле пользователя по методу Цезаря, после чего принудительно закрывает потоки и перезаписывайт файл.
        try(BufferedReader reader  = new BufferedReader(new FileReader(FileProcessing.getFileCode()));
            BufferedWriter writer = new BufferedWriter( new FileWriter("src/Text2.txt"))){
            while (reader.ready()){
                String str = reader.readLine();
                char[] buff = str.toCharArray();
                writer.write( Decypher.dencryption(buff, FileProcessing.getKeyCode()));
                writer.newLine();}
            writer.close();
            reader.close();
            Path path = Path.of(FileProcessing.getFileCode());
            Files.copy(Path.of("src/Text2.txt"),path, StandardCopyOption.REPLACE_EXISTING);
}}


}
