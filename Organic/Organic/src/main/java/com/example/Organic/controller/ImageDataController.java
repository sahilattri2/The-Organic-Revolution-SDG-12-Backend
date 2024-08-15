package com.example.Organic.controller;

import com.example.Organic.Service.ImageDataService;
import com.example.Organic.Service.ImageUploadResponse;
import com.example.Organic.entity.ImageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/images")
public class ImageDataController {

    @Autowired
    private ImageDataService imageDataService;

    @PostMapping
    public ResponseEntity<ImageUploadResponse> uploadImage(
            @RequestParam("image") MultipartFile file,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("language") String language) throws IOException {

        ImageUploadResponse response = imageDataService.uploadImage(file, title, description, language);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/info/{name}")
    public ResponseEntity<ImageData> getImageInfoByName(@PathVariable("name") String name) {
        ImageData image = imageDataService.getInfoByImageByName(name);

        if (image != null) {
            return ResponseEntity.status(HttpStatus.OK).body(image);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<Map<String, String>> getImageByName(@PathVariable("name") String name) {
        Map<String, String> response = imageDataService.getImageDetails(name);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Map<String, String>>> getAllImages(@RequestParam(required = false) String language) {
        List<Map<String, String>> response = (language != null) ?
                imageDataService.getImageDetailsByLanguage(language) :
                imageDataService.getAllImageDetails();
        if (response != null) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/language/{language}")
    public ResponseEntity<List<Map<String, String>>> getImagesByLanguage(@PathVariable("language") String language) {
        List<Map<String, String>> response = imageDataService.getImageDetailsByLanguage(language);
        if (response != null && !response.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
