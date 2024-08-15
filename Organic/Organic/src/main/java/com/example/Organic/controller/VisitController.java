package com.example.Organic.controller;

import com.example.Organic.entity.Visit;
import com.example.Organic.Service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visit")
@CrossOrigin
public class VisitController {

    private final VisitService visitService;

    @Autowired
    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping
    public List<Visit> getAllVisits() {
        return visitService.getAllVisits();
    }

    @GetMapping("/{id}")
    public Visit getVisitById(@PathVariable Long id) {
        return visitService.getVisitById(id);
    }

    @PostMapping
    public Visit addVisit(@RequestBody Visit visit) {
        return visitService.addVisit(visit);
    }

    @PutMapping("/{id}")
    public boolean updateVisit(@PathVariable Long id, @RequestBody Visit newVisit) {
        return visitService.updateVisit(id, newVisit);
    }

    @DeleteMapping("/{id}")
    public Visit deleteVisit(@PathVariable Long id) {
        return visitService.deleteVisit(id);
    }
}
