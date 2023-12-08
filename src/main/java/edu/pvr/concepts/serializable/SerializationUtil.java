package edu.pvr.concepts.serializable;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializationUtil<T> {

    protected static <T> void serializeToFile(T object, String directoryPath, String filename) {
        Path filePath = Paths.get(directoryPath, filename);

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath.toFile());
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            // Write the object to the ObjectOutputStream
            objectOutputStream.writeObject(object);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static <T extends Serializable> T deserializeFromFile(Class<T> type, String directoryPath, String filename) {
        T object = null;
        Path filePath = Paths.get(directoryPath, filename);

        try (FileInputStream fileInputStream = new FileInputStream(filePath.toFile());
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            // Read the object from the ObjectInputStream
            object = type.cast(objectInputStream.readObject());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return object;
    }
}
