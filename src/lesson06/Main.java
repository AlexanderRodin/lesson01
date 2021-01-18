package lesson06;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class Main extends Object{

    public static StringBuilder text;

    public static void main(String[] args){


        text = new StringBuilder();
        String word = "Google";
        String wordTwo = "worried";

        try {

        FileInputStream starFile = new FileInputStream("star.txt");
        FileInputStream googleFile = new FileInputStream("google.txt");
        File fileCatalog = new File("C:\\JAVA\\lesson01\\src\\lesson06");
        File[] files = fileCatalog.listFiles();
        StringBuilder listText = fileManager(wordTwo, files);

        System.out.println(gluingLines(starFile, googleFile));
        System.out.println();

        if(wordSearch(word, text)) System.out.println("Слово есть " + word + " в тексте!");
        else System.out.println("Слова " + word + " нет в текте!");
        System.out.println();

        if(listText.length() != 0) System.out.println("Слово " + wordTwo + " содержиться в следующих файлах: " + listText);
        else System.out.println("Слово " + wordTwo + " отсутствует в каталоге!");

        starFile.close();
        googleFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private static StringBuilder gluingLines (FileInputStream oneText, FileInputStream twoText){
        int outbox;
        try {
            while ((outbox = oneText.read()) != -1) {
                text.append((char) outbox);
            }
            while ((outbox = twoText.read()) != -1) {
                text.append((char) outbox);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    private static boolean wordSearch(String name, StringBuilder searchText) {

        int indexWord = searchText.indexOf(name);
        return indexWord != -1? true:false;

    }

    private static StringBuilder fileManager(String name, File[] fileList) {

        int outbox;
        StringBuilder listOfFiles = new StringBuilder();
        try {

            for (int i = 0; i < fileList.length; i++) {
                StringBuilder textFromFile = new StringBuilder();
                FileInputStream testInput = new FileInputStream(fileList[i]);
                while ((outbox = testInput.read()) != -1) {
                    textFromFile.append((char) outbox);
                }
                if (fileList[i].getName().endsWith("txt")) {
                    int indexWord = textFromFile.indexOf(name);
                    if (indexWord != -1) listOfFiles.append(fileList[i].getName() + " ");
                }
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return listOfFiles;
    }
}
