package com.example.Organic.Service;

import com.example.Organic.entity.Visit;
import com.example.Organic.Repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VisitService {

    private final VisitRepository visitRepository;

    @Autowired
    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public List<Visit> getAllVisits() {
        return visitRepository.findAll();
    }

    public Visit getVisitById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    public Visit addVisit(Visit visit) {
        // Add default data if needed
        if (visit.getPreferredAppointmentTime() == null) {
            visit.setPreferredAppointmentTime(LocalDateTime.now());
        }
        return visitRepository.save(visit);
    }

    public boolean updateVisit(Long id, Visit newVisit) {
        if (visitRepository.existsById(id)) {
            newVisit.setId(id);
            visitRepository.save(newVisit);
            return true;
        }
        return false;
    }

    public Visit deleteVisit(Long id) {
        Optional<Visit> visit = visitRepository.findById(id);
        if (visit.isPresent()) {
            visitRepository.deleteById(id);
            return visit.get();
        }
        return null;
    }
}
