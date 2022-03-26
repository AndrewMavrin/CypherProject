import java.io.*;
import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

public class Brute {
    static int key;
    static SortedMap<Integer,Integer> bruteMap = new TreeMap<>();
    private static int count;

    public static void fileBrute(int key) throws IOException {
        //Метод осуществляет расшифровку файла по ключу, без перезаписи файла. Отличие от метода расшифровки в отсутствии перезаписи файла и имеющемся параметре.
        try(BufferedReader reader  = new BufferedReader(new FileReader(FileProcessing.getFileCode()));
            BufferedWriter writer = new BufferedWriter( new FileWriter("src/Text2.txt"))){
            while (reader.ready()){
                String str = reader.readLine();
                char[] buff = str.toCharArray();
                writer.write( Decypher.dencryption(buff, key));
                writer.newLine();}
        }
    }
    public static void bruteMethod() throws IOException {
        //Метод выполняет вызов метода FileBrute в соответствии с количеством возможных ключей и проверяет правильность пунктуации после каждой расшифровки
        // фиксирует в счетчике, какое количество раз пунктуация была правильно использованна и добавяет показания счетчика в bruteMap, где ключом является КЛЮЧ который тестировался,
        //а значением, показания счетчика.
        for(int i = 0;i<38;i++){
            fileBrute(i);
        try(BufferedReader reader  = new BufferedReader(new FileReader("src/Text2.txt"))) {
            while (reader.ready()){
                String str = reader.readLine();
                char[] buff = str.toCharArray();
                for(int a =0;a<buff.length;a++){
                    if(a!=buff.length-1){
                        if(buff[a]==','&& buff[a+1]==' '){
                            count++;}
                        else if('.' == buff[a] && buff[a+1] == ' '){
                            count++;}
                    }
                }
            }
            bruteMap.put(i,count);
            count=0;}
        }

        Integer[] countArrays = new Integer[38];
        for(int i = 0;i<38;i++){
            countArrays[i] = Brute.bruteMap.get(i);}
        Arrays.sort(countArrays);
        for(int i = 0;i<38;i++){
            int countBuff = Brute.bruteMap.get(i);
            if(countBuff==countArrays[countArrays.length-1]){
                key = i;}
        }
    }
}






