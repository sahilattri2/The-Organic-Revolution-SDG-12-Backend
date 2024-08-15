package com.example.Organic.controller;

import com.example.Organic.entity.Login;
import com.example.Organic.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public List<Login> getAllLogins() {
        return loginService.getAllLogins();
    }

    @GetMapping("/{username}")
    public ResponseEntity<Login> getLoginByUsername(@PathVariable String username) {
        Login login = loginService.getLoginByUsername(username);
        if (login == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(login);
    }

    @PostMapping
    public ResponseEntity<Login> addLogin(@RequestBody Login login) {
        Login savedLogin = loginService.addLogin(login);
        return ResponseEntity.status(201).body(savedLogin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateLogin(@PathVariable Long id, @RequestBody Login newLogin) {
        boolean updated = loginService.updateLogin(id, newLogin);
        if (updated) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(404).body(false);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Login> deleteLogin(@PathVariable Long id) {
        Login deletedLogin = loginService.deleteLogin(id);
        if (deletedLogin != null) {
            return ResponseEntity.ok(deletedLogin);
        }
        return ResponseEntity.status(404).body(null);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Map<String, String>> authenticateUser(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        Login login = loginService.getLoginByUsername(username);

        if (login == null) {
            return ResponseEntity.status(404).body(Map.of("message", "User not registered"));
        }

        if (!login.getPassword().equals(password)) {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid credentials"));
        }

        return ResponseEntity.ok(Map.of("message", "Login successful"));
    }
}
