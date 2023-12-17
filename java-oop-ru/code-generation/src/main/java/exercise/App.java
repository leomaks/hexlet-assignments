package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;


// BEGIN
class App {
    public static void save(Path path, Car car) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(path.toFile(), car);
    }

    public static Car extract(Path path) throws IOException {
        String str = Files.readString(path);
        Car car = Car.unserialized(str);
        return car;
    }
}
