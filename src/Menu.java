import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    static int selections;
    public static void startMenu() throws InterruptedException, IOException {
        System.out.println("Что вы хотите сделать?");
        Thread.sleep(500);
        System.out.println("Если вы хотите зашифровать файл, введите цифру 1");
        Thread.sleep(500);
        System.out.println("Если вы хотите расшифровать файл по ключу введите цифру 2");
        Thread.sleep(500);
        System.out.println("Если вы хотите взломать шифр без ключа введите цифру 3");

        try{selections = scanner.nextInt();
        if (selections == 1) {
            Thread.sleep(500);
            System.out.println("Укажите путь к файлу который вы хотите зашифровать");
            FileProcessing.fileCodeMethod();
            Cypher.fileEncryption();
            System.out.println("Файл зашифрован по ключу:"+FileProcessing.getKeyCode());}
        else if(selections == 2){
            Thread.sleep(500);
            System.out.println("Укажите путь к файлу который вы хотите расшифровать");
            FileProcessing.fileCodeMethod();
            Decypher.fileDecryption();
            System.out.println("Файл расшифрован по ключу:"+FileProcessing.getKeyCode());}
        else if(selections==3){
            System.out.println("Укажите путь к файлу который вы хотите взломать");
            FileProcessing.fileCodeMethodBrute();
            Brute.bruteMethod();
            FileProcessing.keySet(Brute.key);
            Decypher.fileDecryption();
            System.out.println("Шифр файла взломан.Ключ шифра был:"+FileProcessing.getKeyCode());
            FileProcessing.keySet(0);}
        else{
            System.out.println("Вы ввели неверное число, попробуйте еще раз.");
            Thread.sleep(500);
            startMenu();}
        }
        catch (InputMismatchException e){
            System.out.println("Необходимо ввести число.Попробуйте еще раз.");}
        }
    }


