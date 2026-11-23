package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CounterController {

    private static final Path FILE_PATH = Path.of("src/counter.bin");

    public CounterController() {}

    public static int getMethod() {
        if (!Files.exists(FILE_PATH)) {
            setMethod(1);
            return 1;
        }
        try (DataInputStream in = new DataInputStream(Files.newInputStream(FILE_PATH))) {
            return in.readInt();
        } catch (IOException e) {
            e.printStackTrace();
            return 1;
        }
    }

    public static void setMethod(int value) {
        try (DataOutputStream out = new DataOutputStream(Files.newOutputStream(FILE_PATH))) {
            out.writeInt(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
