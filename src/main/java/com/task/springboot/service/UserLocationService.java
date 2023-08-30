package com.task.springboot.service;

import com.task.springboot.model.UserLocation;

import java.util.List;

public interface UserLocationService {

    UserLocation createUserLocation(UserLocation userLocation);

    UserLocation updateUserLocation(Long id, UserLocation updatedUserLocation);

    List<UserLocation> getAllUsers(int ps, int pn);

    void deleteUserLocation(Long id);
}
