package com.example.Organic.controller;

import org.springframework.web.bind.annotation.*;
import com.example.Organic.entity.Register;
import com.example.Organic.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/register")
@CrossOrigin
public class RegisterController {

    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping
    public List<Register> getAllRegisters() {
        return registerService.getAllRegisters();
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> getRegisterByEmail(@PathVariable String email) {
        List<Register> users = registerService.getRegisterByEmail(email);
        if (users.isEmpty()) {
            return ResponseEntity.status(404).body(Map.of("message", "User not registered"));
        } else if (users.size() > 1) {
            return ResponseEntity.status(409).body(Map.of("message", "Multiple users found with the same email"));
        }
        return ResponseEntity.ok(users.get(0));
    }

    @PostMapping
    public ResponseEntity<?> addRegister(@RequestBody Register register) {
        try {
            Register savedRegister = registerService.addRegister(register);
            return ResponseEntity.ok(savedRegister);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Map.of("message", "Registration failed"));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRegister(@PathVariable Long id, @RequestBody Register newRegister) {
        boolean updated = registerService.updateRegister(id, newRegister);
        if (updated) {
            return ResponseEntity.ok(Map.of("message", "Update successful"));
        } else {
            return ResponseEntity.status(404).body(Map.of("message", "User not found"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRegister(@PathVariable Long id) {
        Register deletedRegister = registerService.deleteRegister(id);
        if (deletedRegister != null) {
            return ResponseEntity.ok(deletedRegister);
        } else {
            return ResponseEntity.status(404).body(Map.of("message", "User not found"));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        String password = requestBody.get("password");
        List<Register> users = registerService.getRegisterByEmail(email);

        if (users.isEmpty()) {
            return ResponseEntity.status(404).body(Map.of("message", "User not registered"));
        } else if (users.size() > 1) {
            return ResponseEntity.status(409).body(Map.of("message", "Multiple users found with the same email"));
        }

        Register user = users.get(0);

        if (!user.getPassword().equals(password)) {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid credentials"));
        }

        return ResponseEntity.ok(Map.of("message", "Login successful"));
    }
}
