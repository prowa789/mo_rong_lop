package com.moronglop.security;

import com.moronglop.model.TaiKhoan;
import com.moronglop.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TaiKhoan taiKhoan = taiKhoanRepo.findByUsername(username);
        if(taiKhoan != null){
            return new CustomUserDetails(taiKhoan);
        }
        throw new UsernameNotFoundException(
                "User '" + username + "' not found");
    }
}
