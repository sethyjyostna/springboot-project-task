package com.task.springboot.controller;

import com.task.springboot.model.UserLocation;
import com.task.springboot.service.UserLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-locations")
public class UserLocationController {
    @Autowired
    private UserLocationService userLocationService;


    @PostMapping()
    public UserLocation createUserLocation(@RequestBody UserLocation userLocation) {
        UserLocation response = userLocationService.createUserLocation(userLocation);
        return response;
    }

    @PatchMapping("/{id}")
    public UserLocation updateUserLocation(@PathVariable Long id, @RequestBody UserLocation updatedUserLocation) {
        UserLocation response = userLocationService.updateUserLocation(id, updatedUserLocation);
        return response;
    }

    @GetMapping("/all/users/{count}")
    public List<UserLocation> getAllUsers(@RequestParam(name = "ps", required = false, defaultValue = "20") Integer ps,
                                          @RequestParam(name = "pn", required = false, defaultValue = "1") Integer pn) {
        return userLocationService.getAllUsers(ps, pn);
    }

    @DeleteMapping("/{id}")
    public void deleteUserLocation(@PathVariable Long id) {
        userLocationService.deleteUserLocation(id);
    }
}
