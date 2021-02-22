import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyFile {

    public static void main(String[] args) {

        File directory = new File("D:\\MYDEV\\SKILLFACTORY\\TEST\\");
        File file1 = new File(directory, "file1.txt");
        File file2 = new File(directory, "file2.txt");

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

        copyFile("d:\\MYDEV\\SKILLFACTORY\\TEST\\akira6.jpg", "D:\\MYDEV\\SKILLFACTORY\\TEST\\temp.tmp");
        copyFile(file1, file2);

        appendFileString(file1);
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
