package com.orange.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceLoader {
	
	private static final Logger log = LoggerFactory.getLogger(ResourceLoader.class);
	// Loads a resource as an InputStream by first checking the classpath;
	// if not found, it falls back to loading the file from the file system.
	public static InputStream getSource(String path) throws IOException {
		log.info("reading resource from location: {}", path);
		InputStream stream = ResourceLoader.class.getClassLoader().getResourceAsStream(path);
		if(Objects.nonNull(stream)) {
			return stream;
		}
		return Files.newInputStream(Path.of(path));
	}		

}
