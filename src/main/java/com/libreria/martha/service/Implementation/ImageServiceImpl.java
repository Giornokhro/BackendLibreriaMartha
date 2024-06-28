package com.libreria.martha.service.Implementation;

import com.libreria.martha.service.ImageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public String saveImage(MultipartFile image) throws IOException {
        // Verifica que el directorio de destino exista
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // Obtén el nombre único del archivo
        String imageName = UUID.randomUUID().toString() + "_" + image.getOriginalFilename();

        // Guarda el archivo en el sistema de archivos
        Path filePath = Paths.get(uploadPath + File.separator + imageName);
        Files.write(filePath, image.getBytes());

        return imageName;
    }

    @Override
    public byte[] getImage(String imageName) throws IOException {
        Path imagePath = Paths.get(uploadPath + File.separator + imageName);
        return Files.readAllBytes(imagePath);
    }
}
