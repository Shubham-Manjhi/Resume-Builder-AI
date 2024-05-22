package org.apple.com.service;

import org.apple.com.Entity.UserDetails;

public interface UserDetailsService {

    UserDetails create(UserDetails userDetails);

    UserDetails getUserDetails(long id);

}
