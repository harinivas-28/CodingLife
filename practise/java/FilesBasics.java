package practise.java;


import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class FilesBasics {
    public static void main(String[] args) throws IOException {
        // CREATING A FILE
        final Path path = Paths.get("practise/java/example.txt");
        try {
            Files.createFile(path);
            System.out.println("FILE CREATED!");
        } catch (FileAlreadyExistsException e){
            System.out.println("FILE ALREADY EXISTS");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // WRITING INTO FILE
        try {
            List<String> lines = Arrays.asList("Line 1", "Line 2");
            Files.write(path, lines);
            System.out.println("WRITTEN TO FILE!");
        } catch (IOException e) {e.printStackTrace();}
        // READING FROM FILE
        System.out.println("LINES IN FILE: ");
        List<String> lines = Files.readAllLines(path);
        lines.forEach(System.out::println);
        final Path tempPath = Paths.get("example.txt");
        // DIRECTORY OPERATIONS
        System.out.println("USEFUL FILE OPERATIONS: ");
        System.out.println("FILES IN ./practise/DB/");
        Files.list(Paths.get("./practise/DB/")).forEach(System.out::println);
        System.out.println("IS DIRECTORY? -> "+Files.isDirectory(path));
        // OTHER USEFUL FILE OPERATIONS
        System.out.println("FILE EXISTS? -> "+Files.exists(tempPath));
        System.out.println("FILE SIZE: "+Files.size(path));
        Files.copy(path, tempPath, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("FILE COPIED!");
        final var tempPath2 = Paths.get("practise/java/temp.txt");
        Files.move(tempPath, tempPath2);
        System.out.println("FILE MOVED!");
        // DELETING A FILE
        boolean res = Files.deleteIfExists(tempPath);
        System.out.println(res?"FILE DELETED":"FILE NOT EXIST");
        res = Files.deleteIfExists(tempPath2);
        System.out.println(res?"FILE DELETED":"FILE NOT EXIST");
        // READING FROM CSV
        Path csvPath = Paths.get("./practise/java/file.csv");
        List<String> csvLines = Files.readAllLines(csvPath);
        System.out.println("CONTENT IN CSV: ");
        csvLines.stream().map(l->l.replace(","," ")).forEach(System.out::println);
        // COMPARE FILES
        long mismatch = Files.mismatch(path, csvPath);
        System.out.println("mismatch position: "+mismatch);
    }
}
