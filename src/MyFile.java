import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyFile {

    public static void main(String[] args) {

        File directory = new File("D:\\MYDEV\\SKILLFACTORY\\TEST\\");
        File file1 = new File(directory, "file1.txt");
        File file2 = new File(directory, "file2.txt");
        File badFile = new File("bad", "bad");

        System.out.println(directory.mkdir());

        try {
            System.out.println(file1.createNewFile());
            System.out.println(file2.createNewFile());
        } catch (IOException err) {
            err.printStackTrace();
        }

        System.out.println(file1.getAbsolutePath());
        System.out.println(file2.getAbsolutePath());

        String[] list = directory.list();
        System.out.println(Arrays.toString(list));

        System.out.println("directory:" + directory.isDirectory());
        System.out.println("file:" + file1.isFile());
        System.out.println("not directory:" + file2.isDirectory());


        File myFileJava = new File("src/MyFile.java");

        boolean isExists = myFileJava.exists();
        System.out.println(isExists);
        System.out.println(myFileJava.getAbsolutePath());
        System.out.println(myFileJava.getParentFile());
        System.out.println(myFileJava.getPath());

        File newFileJava = new File("src/MyTest.java");
        try {
            newFileJava.createNewFile();
        } catch (IOException err) {
            err.printStackTrace();
        }
        System.out.println(newFileJava.getPath());

        System.out.println((getSizeDirectory(directory) / 1024) / 1024);

        readFile(file1);

        getCountNumberFile(file1);

        //copyFile("d:\\MYDEV\\SKILLFACTORY\\TEST\\akira6.jpg", "D:\\MYDEV\\SKILLFACTORY\\TEST\\temp.tmp");
        //copyFile(file1, file2);

        //appendFileString(file1);

        System.out.println(copyTextFile(file1, badFile));

        //readFileToList(file1);
    }

    //TODO 10.1

    public static void readFileToList(File file) {
        Scanner input = new Scanner(System.in);
        try {
            List<String> list = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            System.out.println("Input number 1-" + list.size());
            int index = input.nextInt();
            System.out.println("Output:" + list.get(index - 1));
        } catch (IndexOutOfBoundsException | IOException err) {
            System.out.println(err.getMessage());
        }

    }


    //TODO 9.4
    // TODO: 27.02.2021 10.3
    public static boolean copyTextFile(File readFile, File writeFile) {
        System.out.println("Copy start...");
        int bytes;
        char[] buffer = new char[1024];
        Charset utf8 = StandardCharsets.UTF_8;

        Charset utf8Chars = Charset.forName("UTF-8");
        Charset win1251 = Charset.forName("WINDOWS-1251");


        //TODO v1 Java v>=11
        //Reader readStream = new FileReader(readFile, utf8);
        //Writer writeStream = new FileWriter(writeFile, win1251);
        //TODO v2 Java v<11

        // TODO: 27.02.2021 try-with-resources uses if Java v>7
        try (Reader readStream = new InputStreamReader(new FileInputStream(readFile), utf8);
             Writer writeStream = new OutputStreamWriter(new FileOutputStream(writeFile), win1251)) {

            while ((bytes = readStream.read(buffer)) != -1) {

                writeStream.write(buffer, 0, bytes);
            }

        } catch (FileNotFoundException read) {
            System.out.println("Ошбика чтения/записи файла");
            System.out.println(read.getMessage());
            return false;
        } catch (NullPointerException nullError) {
            System.out.println(nullError.getMessage());
            System.out.println("В метод copyTextFile передан null в качестве параметра readFile/writeFile");
            return false;
        } catch (IOException closeError) {
            System.out.println(closeError.getMessage());
            System.out.println("Ошибка процесса копирования/закрытия файла");
            return false;
        }

        System.out.println("Copy complete...");
        return true;
    }

    //TODO 9.3

    public static void copyFile(String readFile, String writeFile) {

        System.out.println("Copy start...");
        int bytes;
        byte[] buffer = new byte[1024];
        try {
            InputStream readStream = new FileInputStream(readFile);
            OutputStream writeStream = new FileOutputStream(writeFile);


            while ((bytes = readStream.read(buffer)) != -1) {

                writeStream.write(buffer, 0, bytes);

            }
            readStream.close();
            writeStream.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
        System.out.println("Copy complete...");
    }

    public static void copyFile(File readFile, File writeFile) {
        copyFile(readFile.getAbsolutePath(), writeFile.getAbsolutePath());
    }

    //TODO 9.3.1
    public static void appendFileString(File file) {
        String str = "GIVE ME THE CODE, PLEASE\r\n";
        byte[] buffer = str.getBytes();
        try {
            FileOutputStream writeStream = new FileOutputStream(file, true);
            writeStream.write(buffer, 0, buffer.length);
            writeStream.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
        System.out.println("Append complete");
    }

    //TODO 9.2.1
    public static void readFile(File file) {
        int i = 0;

        try {
            FileInputStream inputStream = new FileInputStream(file);
            while ((i = inputStream.read()) != -1) {
                System.out.print((char) i);
            }
            inputStream.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
        System.out.println(); //чисто для красоты
    }


    //TODO 9.2.3
    public static void getCountNumberFile(File file) {
        int i = 0;
        int count = 0;
        //Pattern pattern = Pattern.compile("\\d");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            while ((i = fileInputStream.read()) != -1) {

                //Matcher matcher = pattern.matcher(Character.toString((char) i));
                //if (matcher.matches()) {
                if (Pattern.matches("\\d", Character.toString((char) i))) {
                    count++;
                    System.out.print((char) i);
                }
            }
            System.out.println(); //чисто для красоты
            System.out.println("count:" + count);
        } catch (IOException err) {
            err.printStackTrace();
        }

    }

    public static long getSizeDirectory(File directory) {

        long size = 0;

        File[] fileList = directory.listFiles();

        for (File file : fileList) {

            if (file.isFile()) {
                size += file.length();
            } else {
                size += getSizeDirectory(file);
            }
        }

        return size;
    }


}
