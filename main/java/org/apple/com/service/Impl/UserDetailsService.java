package org.apple.com.service.Impl;

import jakarta.transaction.Transactional;
import org.apple.com.Entity.UserDetails;
import org.apple.com.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserDetailsService {


    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public UserDetails create(UserDetails userDetails) {
        return userDetailsRepository.save(userDetails);
    }

    public UserDetails getUserDetails(long id) {
        return userDetailsRepository.getUserDetailsById(id);
    }

}
