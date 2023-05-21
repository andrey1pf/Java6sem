package com.example.lab8;

import com.example.lab8.Entities.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "http://localhost:4200")
public class interfaceController {

    @Autowired
    private interfaceRepo interfaceRepo;

    @GetMapping
    public Iterable<Projects> getUsers() {
        return interfaceRepo.findAll();
    }

    @GetMapping("/{id}")
    public Projects getUserById(@PathVariable Integer id) {
        return interfaceRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Projects not found"));
    }

    @PostMapping
    public Projects addUser(@RequestBody Projects project) {
        return interfaceRepo.save(project);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        interfaceRepo.deleteById(id);
    }
}

