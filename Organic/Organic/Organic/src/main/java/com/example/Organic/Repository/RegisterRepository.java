package com.example.Organic.Repository;

import com.example.Organic.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {
    List<Register> findByEmail(String email);
}
