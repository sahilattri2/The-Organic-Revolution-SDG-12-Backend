package com.example.Organic.Service;

import com.example.Organic.entity.Register;
import com.example.Organic.Repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.boot.CommandLineRunner;

import java.util.List;
import java.util.Optional;

@Service
public class RegisterService implements CommandLineRunner {

    private final RegisterRepository registerRepository;

    @Autowired
    public RegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    public List<Register> getAllRegisters() {
        return registerRepository.findAll();
    }

    public List<Register> getRegisterByEmail(String email) {
        return registerRepository.findByEmail(email);
    }

    public Register addRegister(Register register) {
        return registerRepository.save(register);
    }

    public boolean updateRegister(Long id, Register newRegister) {
        if (registerRepository.existsById(id)) {
            newRegister.setId(id);
            registerRepository.save(newRegister);
            return true;
        }
        return false;
    }

    public Register deleteRegister(Long id) {
        Optional<Register> register = registerRepository.findById(id);
        if (register.isPresent()) {
            registerRepository.deleteById(id);
            return register.get();
        }
        return null;
    }

    @Override
    public void run(String... args) throws Exception {
        // Adding initial data
        registerRepository.save(new Register("john_doe", "john@example.com", "password123"));
        registerRepository.save(new Register("jane_doe", "jane@example.com", "password123"));
        registerRepository.save(new Register("alice", "alice@example.com", "password123"));
    }
}
