package com.moronglop.controller;

import com.moronglop.model.SinhVien;
import com.moronglop.model.TaiKhoan;
import com.moronglop.repository.LopDangKiRepository;
import com.moronglop.repository.SinhVienRepository;
import com.moronglop.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sv")
public class ProfileSVController {
    @Autowired
    private SinhVienRepository sinhVienRepo;
    @Autowired
    private LopDangKiRepository lopDangKiRepo;

    @ModelAttribute("sv")
    public SinhVien sv(@AuthenticationPrincipal CustomUserDetails taiKhoan){
        SinhVien sv = sinhVienRepo.findByTaiKhoan(taiKhoan.getTaiKhoan());
       return sv;
    }

    @GetMapping
    public String homeSv(Model model,@AuthenticationPrincipal CustomUserDetails taiKhoan){
        SinhVien sv = sinhVienRepo.findByTaiKhoan(taiKhoan.getTaiKhoan());
        model.addAttribute("soLuongDk",lopDangKiRepo.countLopDangKiBySinhVien(sv));
        return "sv-mrl";
    }

    @GetMapping("/lienhe")
    public String showTtlh(Model model, @AuthenticationPrincipal CustomUserDetails taiKhoan){
        return "sv-ttlh";
    }
    @PostMapping("/lienhe")
    public String postTtlh(@ModelAttribute("sv") SinhVien sv,@AuthenticationPrincipal CustomUserDetails taiKhoan) {
        SinhVien sv1 = sinhVienRepo.findByTaiKhoan(taiKhoan.getTaiKhoan());
        sv1.setDienThoai(sv.getDienThoai());
        sv1.setEmail(sv.getEmail());
        sinhVienRepo.save(sv1);
        return "redirect:/sv/lienhe";
    }

    @GetMapping("/canhan")
    public String showTtcn(Model model,@AuthenticationPrincipal CustomUserDetails taiKhoan){
        return "sv-ttcn";
    }
    @PostMapping("/canhan")
    public String postTtcn(@ModelAttribute("sv") SinhVien sv
            ,@ModelAttribute("ngaySinh") String ngaySinh
            ,@AuthenticationPrincipal CustomUserDetails taiKhoan) {
        SinhVien sv1 = sinhVienRepo.findByTaiKhoan(taiKhoan.getTaiKhoan());
        Date ngaySinh1 = null;
        try {
            ngaySinh1 = new SimpleDateFormat("dd/MM/yyyy").parse(ngaySinh);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sv1.updateTtcn(sv);
        sv1.setNgaySinh(ngaySinh1);
        sinhVienRepo.save(sv1);
        return "redirect:/sv/canhan";
    }
    @GetMapping("/hanhchinh")
    public String showHanhChinh(Model model,@AuthenticationPrincipal CustomUserDetails taiKhoan){
        return "sv-hanhchinh";
    }
    @PostMapping("/hanhchinh")
    public String postHanhChinh(@ModelAttribute SinhVien sv,
                                @AuthenticationPrincipal CustomUserDetails taiKhoan){
        SinhVien sv1 = sinhVienRepo.findByTaiKhoan(taiKhoan.getTaiKhoan());
        sv1.updateTthc(sv);
        sinhVienRepo.save(sv1);
        return "redirect:/sv/hanhchinh";
    }
    
    @GetMapping("/baomat")
    public String showBaoMat(){
        return "sv-baomat";
    }
    @PostMapping("/baomat")
    public String postBaoMat(@ModelAttribute SinhVien sv){
        return "redirect:/sv/baomat";
    }
}
