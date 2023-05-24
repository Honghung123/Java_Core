package com.honghung.JAVA_7;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class PathClass {
    public static void main(String[] args) throws URISyntaxException, IOException {
        Path path = Paths.get("Test/file.txt");
        System.out.println(path);
        System.out.println(path.toString());
        System.out.println(path.toAbsolutePath());
        System.out.println(path.toUri());
        Path path2 = Path.of("D:\\Document\\Workspace_Backend\\JAVA_core\\JavaTest26_3\\Test\\file.txt");
        System.out.println(path2);
        System.out.println(path2.getNameCount());
        System.out.println(path2.getFileName());
        System.out.println(path2.getName(3));
        System.out.println(path2.getRoot());
        Path path3 = Path.of("D:/Document/Workspace_Backend/JAVA_core/JavaTest26_3")
                .resolve("Test/file.txt");
        System.out.println(path3);
        Path path4 = Path.of("D:", "Document", "Workspace_Backend", "JAVA_core", "JavaTest26_3")
                .resolve("Test/file.txt");
        System.out.println(path4);
        Path path5 = Path.of(new URI("file:///D:/Document/Workspace_Backend/JAVA_core/JavaTest26_3/Test/file.txt"));
        System.out.println(path5);
        System.out.println("Does the path exist: " + Files.exists(path));
        long mismatchIndex = Files.mismatch(path5, path2);
        System.out.println("Mismatch Index: " + mismatchIndex);
        // System.out.println(Files.getOwner(path5));

        // Temporary directories / files
        Path tempDirectory = Files.createTempDirectory("tempDirectory");
        System.out.println(tempDirectory);
        System.out.println("Is the temporary directory exist: " + Files.exists(tempDirectory));
        Files.deleteIfExists(tempDirectory);
        System.out.println("Is temporary directory exist: " + Files.exists(tempDirectory));
        Path tempFile = Files.createTempFile("tempFile",".txt");
        System.out.println(tempFile);
        System.out.println("Is the temporary file exist: " + Files.exists(tempFile));
        Files.deleteIfExists(tempFile);
        System.out.println("Is the temporary file exist: " + Files.exists(tempFile)); 
        Path tempFile2 = Files.createTempFile(path2.getParent().getParent(),"tempFile",".txt");
        System.out.println(tempFile2);
        Files.deleteIfExists(tempFile2);
        System.out.println("Is the temporary file exist: " + Files.exists(tempFile2));

        // Create a actual file, throw FileAlreadyExistsException if it exists
        Path createTemp = path2.getParent().getParent().resolve("fileTemp.txt");
        Path moveTo = path2.getParent().getParent().getParent().resolve("moveTo.txt");
        if (Files.notExists(createTemp)) {
            System.out.println(Files.createFile(createTemp));
        }
        if (Files.notExists(moveTo)) {
            System.out.println(Files.createFile(moveTo));
        }
        // Write date to file
        Files.write(moveTo, "Hoang cute, dang yeu\n".getBytes());
        Files.writeString(moveTo, "Hoang de thuong, xinh dep\n", StandardOpenOption.APPEND);
        // Read file 
        System.out.println(Files.readString(moveTo));
        System.out.println(new String(Files.readAllBytes(moveTo)));
        
        
        OutputStream out = Files.newOutputStream(moveTo, StandardOpenOption.APPEND);
        out.write("Hoang dep nhu thien than".getBytes());
        out.close();
        // Move file 
        //Files.move(moveTo, createTemp);
        InputStream in = Files.newInputStream(createTemp);
        int index = 0;
        while ((index = in.read()) != -1) {
            System.out.print((char) index);
        }
        in.close();

        // Show all items in the same directory - Stream<Path>
        try (var files = Files.list(createTemp.getParent())) {
            files.forEach(System.out::println);
        }
        System.out.println();

        // Show the tree hirachy of folder - Stream<Path>
        try (var files = Files.walk(createTemp )) {
            files.forEach(System.out::println);
        }

        Path path7 = Path.of("./src/main/java/../resources/some.properties");
        System.out.println("p.isAbsolute() = " + path7.isAbsolute());
        // Convert to Absolute path 
        Path absolutePath = path7.normalize().toAbsolutePath();
        System.out.println(absolutePath.toString());
        // Conver to Relative path
        Path relativePath = absolutePath.relativize(absolutePath);
        System.out.println(relativePath.toString());
        //Files.deleteIfExists(createTemp);
 
        // Path subPath = path2.getRoot().resolve(path2.subpath(0, path2.getNameCount() - 2));
        // System.out.println(subPath.resolve("NewFile.txt").toString());
        // Path createFile = Files.createFile(subPath.resolve("NewFile.txt"));
        // System.out.println(createFile.toString());
        // Files.deleteIfExists(createFile);
    }
}
