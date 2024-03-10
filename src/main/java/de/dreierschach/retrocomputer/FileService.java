package de.dreierschach.retrocomputer;

import de.dreierschach.retrocomputer.basic.model.Memory;
import org.apache.commons.lang3.stream.Streams;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

@Component
public class FileService {
    private final Memory memory;

    public FileService(Memory memory) {
        this.memory = memory;
    }

    public static final String FILES_PATH = "retrocomputer/files";

    public List<String> dir() {
        var path = getPath();
        try (var in = Files.newDirectoryStream(path)) {
            return Streams.of(in.iterator())
                    .filter(Predicate.not(Files::isDirectory))
                    .map(p -> p.getFileName().toString())
                    .filter(name -> name.endsWith(".BAS"))
                    .map(s -> s.substring(0, s.indexOf(".BAS"))).sorted().toList();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public void save(String name) {
        var file = getPath().resolve(name + ".BAS");
        try {
            Files.write(file, memory.lines(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public void load(String name) {
        var file = getPath().resolve(name + ".BAS");
        memory.clearAll();
        try {
            Files.readAllLines(file, StandardCharsets.UTF_8).forEach(memory::addLines);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public void delete(String name) {
        var file = getPath().resolve(name + ".BAS");
        try {
            Files.delete(file);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public Path getPath() {
        try {
            var result = Paths.get(System.getProperty("user.home"), FILES_PATH);
            Files.createDirectories(result);
            return result;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
