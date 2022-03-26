
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileProcessing {
    public static String getFileCode() {
        return fileCode;
    }

    public static int getKeyCode() {
        return keyCode;
    }

    private static String fileCode;
    private static int keyCode;

    static Scanner scanner = new Scanner(System.in);

    public static void keySet() {
        try{keyCode = scanner.nextInt();
        if(keyCode <0 || keyCode>37){
            System.out.println("Вы ввели число не входящее в диапазон от 1 до 37.");
            System.out.println("Попробуйте еще раз.");
            keySet();}
        }
        catch (InputMismatchException e ){
            System.out.println("Необходимо ввести число. Попробуйте еще раз.");}
    }
    public static void keySet(int key) {
        if(key>0 && key<38){
        keyCode = key;}
    }
    public static void fileCodeMethod(){
    try{fileCode = scanner.nextLine();
    if(Files.isRegularFile(Path.of(fileCode)) && Files.size(Path.of(fileCode))!=0){
        Thread.sleep(500);
        System.out.println("Введите ключ шифровки от 1 до 37(включительно)");
        keySet();
    }
    else if(Files.size(Path.of(fileCode))==0){
        System.out.println("Вы указали путь к пустому файлу, попробуйте еще раз.");
    fileCodeMethod();}
    else{
        while(!Files.isRegularFile(Path.of(fileCode))){
        System.out.println("Вы ввели неверный путь к файлу, попробуйте еще раз");
        fileCode=scanner.nextLine();}
    }
    }
    catch (FileNotFoundException e){
        System.out.println("Файла по указаному пути не существует, попробуйте еще раз.");
        fileCodeMethod();}
        catch (NoSuchFileException e){
        System.out.println("Вы ввели неверный путь к файлу, попробуйте еще раз.");
        fileCodeMethod();}
        catch (Exception e) {
        System.out.println("Вы ввели неверный путь к файлу, попробуйте еще раз.");
        fileCodeMethod();}

}

    public static void fileCodeMethodBrute() {
        try{fileCode = scanner.nextLine();
        if(Files.isRegularFile(Path.of(fileCode)) && Files.size(Path.of(fileCode))!=0){
            Thread.sleep(500);
        }
        else if(Files.size(Path.of(fileCode))==0){
            System.out.println("Вы указали путь к пустому файлу, попробуйте еще раз.");
            fileCodeMethodBrute();
        }
        else{
            while(!Files.isRegularFile(Path.of(fileCode))){
                System.out.println("Вы ввели неверный путь к файлу, попробуйте еще раз");
                fileCode=scanner.nextLine();}
        }
        }

        catch (FileNotFoundException e){
            System.out.println("Файла по указаному пути не существует, попробуйте еще раз.");
            fileCodeMethodBrute();}
        catch (NoSuchFileException e){
            System.out.println("Вы ввели неверный путь к файлу, попробуйте еще раз.");
            fileCodeMethodBrute();}
        catch (Exception e) {
            System.out.println("Вы ввели неверный путь к файлу, попробуйте еще раз.");
            fileCodeMethodBrute();}
    }



}
