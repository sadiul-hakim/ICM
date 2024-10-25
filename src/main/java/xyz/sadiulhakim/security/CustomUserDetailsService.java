package xyz.sadiulhakim.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import xyz.sadiulhakim.data.Data;
import xyz.sadiulhakim.data.DataRepository;
import xyz.sadiulhakim.exception.ApplicationException;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    private final DataRepository dataRepository;

    public CustomUserDetailsService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Data data = dataRepository.getData();
        if (!data.getUsername().equals(username)) {
            throw new ApplicationException("Invalid credentials!");
        }

        return new CustomUserDetails(data.getUsername(), data.getPassword());
    }
}
