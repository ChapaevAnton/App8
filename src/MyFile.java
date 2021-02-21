import java.io.File;
import java.io.IOException;
import java.util.Arrays;

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
