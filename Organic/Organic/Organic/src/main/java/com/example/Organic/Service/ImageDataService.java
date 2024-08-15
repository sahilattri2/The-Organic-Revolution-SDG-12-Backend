package com.example.Organic.Service;

import com.example.Organic.Repository.ImageDataRepository;
import com.example.Organic.entity.ImageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import jakarta.transaction.Transactional;

import java.io.IOException;
import java.util.*;

@Service
public class ImageDataService {

    @Autowired
    private ImageDataRepository imageDataRepository;

    public ImageUploadResponse uploadImage(MultipartFile file, String title, String description, String language) throws IOException {
        imageDataRepository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(file.getBytes()) // Changed from compressImage to just file.getBytes()
                .title(title)
                .description(description)
                .language(language) // Set language
                .build());

        return new ImageUploadResponse("Image uploaded successfully: " + file.getOriginalFilename());
    }

    @Transactional
    public ImageData getInfoByImageByName(String name) {
        Optional<ImageData> dbImage = imageDataRepository.findByName(name);
        return dbImage.orElse(null);
    }

    @Transactional
    public byte[] getImage(String name) {
        Optional<ImageData> dbImage = imageDataRepository.findByName(name);
        return dbImage.map(ImageData::getImageData).orElse(new byte[0]);
    }

    @Transactional
    public List<ImageData> getAllImages() {
        return imageDataRepository.findAll();
    }

    @Transactional
    public List<ImageData> getImagesByLanguage(String language) {
        return imageDataRepository.findByLanguage(language);
    }

    @Transactional
    public Map<String, String> getImageDetails(String name) {
        ImageData imageData = getInfoByImageByName(name);
        if (imageData != null) {
            String base64Image = Base64.getEncoder().encodeToString(imageData.getImageData());
            Map<String, String> response = new HashMap<>();
            response.put("name", imageData.getName());
            response.put("type", imageData.getType());
            response.put("title", imageData.getTitle());
            response.put("description", imageData.getDescription());
            response.put("imageData", base64Image);
            response.put("language", imageData.getLanguage());
            return response;
        }
        return null;
    }

    @Transactional
    public List<Map<String, String>> getAllImageDetails() {
        List<ImageData> images = getAllImages();
        if (!images.isEmpty()) {
            List<Map<String, String>> response = new ArrayList<>();
            for (ImageData imageData : images) {
                String base64Image = Base64.getEncoder().encodeToString(imageData.getImageData());
                Map<String, String> imageResponse = new HashMap<>();
                imageResponse.put("name", imageData.getName());
                imageResponse.put("type", imageData.getType());
                imageResponse.put("title", imageData.getTitle());
                imageResponse.put("description", imageData.getDescription());
                imageResponse.put("imageData", base64Image);
                imageResponse.put("language", imageData.getLanguage());
                response.add(imageResponse);
            }
            return response;
        }
        return null;
    }

    @Transactional
    public List<Map<String, String>> getImageDetailsByLanguage(String language) {
        List<ImageData> images = getImagesByLanguage(language);
        if (!images.isEmpty()) {
            List<Map<String, String>> response = new ArrayList<>();
            for (ImageData imageData : images) {
                String base64Image = Base64.getEncoder().encodeToString(imageData.getImageData());
                Map<String, String> imageResponse = new HashMap<>();
                imageResponse.put("name", imageData.getName());
                imageResponse.put("type", imageData.getType());
                imageResponse.put("title", imageData.getTitle());
                imageResponse.put("description", imageData.getDescription());
                imageResponse.put("imageData", base64Image);
                imageResponse.put("language", imageData.getLanguage());
                response.add(imageResponse);
            }
            return response;
        }
        return null;
    }
}
