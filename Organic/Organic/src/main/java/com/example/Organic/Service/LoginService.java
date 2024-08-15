package com.example.Organic.Service;

import com.example.Organic.entity.Login;
import com.example.Organic.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.boot.CommandLineRunner;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService implements CommandLineRunner {

    private final LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public List<Login> getAllLogins() {
        return loginRepository.findAll();
    }

    public Login getLoginByUsername(String username) {
        return loginRepository.findByUsername(username);
    }

    public Login addLogin(Login login) {
        return loginRepository.save(login);
    }

    public boolean updateLogin(Long id, Login newLogin) {
        if (loginRepository.existsById(id)) {
            newLogin.setId(id);
            loginRepository.save(newLogin);
            return true;
        }
        return false;
    }

    public Login deleteLogin(Long id) {
        Optional<Login> login = loginRepository.findById(id);
        if (login.isPresent()) {
            loginRepository.deleteById(id);
            return login.get();
        }
        return null;
    }

    @Override
    public void run(String... args) throws Exception {
        // Adding initial data
        loginRepository.save(new Login("admin", "admin123"));
        loginRepository.save(new Login("user1", "password1"));
        loginRepository.save(new Login("user2", "password2"));
    }
}
