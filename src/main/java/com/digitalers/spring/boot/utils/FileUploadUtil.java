package com.digitalers.spring.boot.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	public static void guardarArchivo(MultipartFile multipartFile) throws IOException {
		if (multipartFile != null && !multipartFile.isEmpty()) {
			// ruta de donde guardo // solo funciona en el servidor local
			/*
			 * en otros casos se debe hacer application.yml application-qa.yml
			 * application-prod.yml
			 */

			String rutaCarpetaImg = "C:\\Users\\Rodrigo\\Documents\\workspace-spring-tool-suite-4-4.12.0.RELEASE\\carrito-compras-spring-boot\\src\\main\\resources\\static\\img";
			String fileName = multipartFile.getOriginalFilename();
			Path uploadPath = Paths.get(rutaCarpetaImg);

			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
			InputStream i = multipartFile.getInputStream();
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(i, filePath, StandardCopyOption.REPLACE_EXISTING);

		}
	}
}
