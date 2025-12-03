package net.laedanrex.santa;

import lombok.experimental.UtilityClass;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

@UtilityClass
public class ResourcesUtils {

    public static URL getResourceUrl(String fileName) {
        return ResourcesUtils.class.getClassLoader().getResource(fileName);
    }

    public static URI getResourceUri(String fileName) throws URISyntaxException {
        return getResourceUrl(fileName).toURI();
    }

    public static Path getResourcePath(String fileName) throws URISyntaxException {
        return Paths.get(getResourceUri(fileName));
    }

    public static File getResourceFile(String fileName) throws URISyntaxException {
        return new File(getResourceUri(fileName));
    }

}
