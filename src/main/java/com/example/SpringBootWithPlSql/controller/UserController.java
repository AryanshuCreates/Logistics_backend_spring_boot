package com.example.SpringBootWithPlSql.controller;

import com.example.SpringBootWithPlSql.entities.User;
import com.example.SpringBootWithPlSql.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/load")

public class UserController {

    @Autowired
    private UserRepo userRepo;
    @PostMapping("/save")
    public ResponseEntity<String> insertLoad(@RequestParam User user){
        userRepo.save(user);
        return ResponseEntity.ok("Loads details added successfully");
    }

    @GetMapping
    public ResponseEntity<List<User>> getLoad(@RequestParam String shipperId){
        List<User> loads = userRepo.findByShipperId(shipperId);
        return ResponseEntity.ok(loads);
    }

    @GetMapping("/{loadId}")
    public ResponseEntity<User> getLoadById(@PathVariable Long loadId) {
        Optional<User> load = userRepo.findById(loadId);
        return load.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{loadId}")
    public ResponseEntity<String> updateLoad(@PathVariable Long loadId, @RequestBody User updatedLoad) {
        // Update the load in the database
        userRepo.findById(loadId).ifPresent(existingLoad -> {
            existingLoad.setLoadingPoint(updatedLoad.getLoadingPoint());
            existingLoad.setUnloadingPoint(updatedLoad.getUnloadingPoint());
            existingLoad.setProductType(updatedLoad.getProductType());
            existingLoad.setTruckType(updatedLoad.getTruckType());
            existingLoad.setNoOfTrucks(updatedLoad.getNoOfTrucks());
            existingLoad.setWeight(updatedLoad.getWeight());
            existingLoad.setComment(updatedLoad.getComment());
            existingLoad.setDate(updatedLoad.getDate());

            userRepo.save(existingLoad);
        });
        return ResponseEntity.ok("Load updated successfully");
    }
    @DeleteMapping("/{loadId}")
    public ResponseEntity<String> deleteLoad(@PathVariable Long loadId) {
        // Delete the load from the database
        userRepo.deleteById(loadId);
        return ResponseEntity.ok("Load deleted successfully");
    }


}
