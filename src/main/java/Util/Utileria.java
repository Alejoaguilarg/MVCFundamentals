package Util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class Utileria {

    public static String guardarArchivo(MultipartFile multiPart, String ruta) {
        String nombreOriginal = multiPart.getOriginalFilename();
        nombreOriginal.replace(" ", "-");
        String nombreFinal = ramdomAlphaNumeric(8) + nombreOriginal;
        try {
            File imageFile = new File(ruta + nombreFinal);
            System.out.println("archivo: " + imageFile.getAbsolutePath());
            multiPart.transferTo(imageFile);
            return nombreFinal;
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
            return null;
        }
    }

    public static String ramdomAlphaNumeric(int count) {
        String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVXYZ0123456789";
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * CARACTERES.length());
            builder.append(CARACTERES.charAt(character));
        }
        return builder.toString();
    }

}
