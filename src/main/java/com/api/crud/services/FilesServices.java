package com.api.crud.services;

import jakarta.transaction.Transactional;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Transactional
public class FilesServices {

    private final Path fileStorageLocation = Paths.get("src/main/resources/pictures/");
    public String uploadFile(MultipartFile file) throws Exception {
        try {
            String fileName = UUID.randomUUID().toString();
            byte[] bytes = file.getBytes();
            String fileOriginalName = file.getOriginalFilename();

            long fileSize = file.getSize();
            long maxSize = 5 * 1024 * 1024;

            if (fileSize > maxSize) {
                throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "El tamaño debe de ser menor de 5MB");
            }

            if (!fileOriginalName.endsWith(".jpg") &&
                    !fileOriginalName.endsWith(".jpeg") &&
                    !fileOriginalName.endsWith(".png")) {
                throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "Solo JPG, JPEG, PNG están permitidos.");
            }

            String fileExtension = fileOriginalName.split("\\.")[1];
            String newFileName = fileName + "." + fileExtension;

            File folder = new File("src/main/resources/pictures");
            if (!folder.exists()) {
                folder.mkdir();
            }
            Path path = Paths.get("src/main/resources/pictures/" + newFileName);
            Files.write(path, bytes);

            return newFileName;
        } catch (IOException e) {
            throw new Exception(e);
        }
    }

    public Resource obtenerImagen(String nombreFichero) throws MalformedURLException {
        Path filePath = fileStorageLocation.resolve(nombreFichero).normalize();

        return new UrlResource(filePath.toUri());
    }
}
