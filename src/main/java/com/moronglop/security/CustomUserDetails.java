package com.moronglop.security;

import com.moronglop.model.TaiKhoan;
import com.moronglop.model.VaiTro;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Data
public class CustomUserDetails implements UserDetails {
    private TaiKhoan taiKhoan;

    public CustomUserDetails(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        VaiTro vaiTro = taiKhoan.getVaiTro();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(vaiTro.getTen()));

        return authorities;
    }

    @Override
    public String getPassword() {
        return taiKhoan.getPassword();
    }

    @Override
    public String getUsername() {
        return taiKhoan.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean hasRole(String roleName) {
        return this.taiKhoan.hasRole(roleName);
    }
}
