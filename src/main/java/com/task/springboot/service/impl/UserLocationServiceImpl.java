package com.task.springboot.service.impl;

import com.task.springboot.model.UserLocation;
import com.task.springboot.repository.UserLocationRepository;
import com.task.springboot.service.UserLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLocationServiceImpl implements UserLocationService {

    @Autowired
    private UserLocationRepository userLocationRepository;

    @Override
    public UserLocation createUserLocation(UserLocation userLocation) {
        return userLocationRepository.save(userLocation);
    }

    @Override
    public UserLocation updateUserLocation(Long id, UserLocation updatedUserLocation) {
        UserLocation userLocation = userLocationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userLocation.setName(updatedUserLocation.getName());
        userLocation.setLatitude(updatedUserLocation.getLatitude());
        userLocation.setLongitude(updatedUserLocation.getLongitude());
        userLocation.setExcluded(updatedUserLocation.isExcluded());

        return userLocationRepository.save(userLocation);
    }

    @Override
    public List<UserLocation> getAllUsers(int ps, int pn) {
        if(pn > 0) {
            pn = pn - 1;
        }
        Pageable page = Pageable.ofSize(ps).withPage(pn);
        Page<UserLocation> userLocationPage = userLocationRepository.findAll(page);
        List<UserLocation> userLocations = userLocationPage.getContent();

        return userLocations;
    }

    @Override
    public void deleteUserLocation(Long id) {
        userLocationRepository.deleteById(id);
    }
}
