package com.moronglop.controller;

import com.moronglop.model.LopDangKi;
import com.moronglop.model.SinhVien;
import com.moronglop.repository.LopDangKiRepository;
import com.moronglop.repository.SinhVienRepository;
import com.moronglop.security.CustomUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/sv/mrl")
public class LopDangKiController {

    private SinhVienRepository sinhVienRepo;
    private LopDangKiRepository lopDangKiRepo;


    public LopDangKiController(SinhVienRepository sinhVienRepo, LopDangKiRepository lopDangKiRepo) {
        this.sinhVienRepo = sinhVienRepo;
        this.lopDangKiRepo = lopDangKiRepo;
    }

    @ModelAttribute("sv")
    public SinhVien sv(@AuthenticationPrincipal CustomUserDetails taiKhoan){
        SinhVien sv = sinhVienRepo.findByTaiKhoan(taiKhoan.getTaiKhoan());
        return sv;
    }

    @ModelAttribute(name = "lyDoList")
    List<String> danhSachLydo(){
        List<String> lyDoList = Arrays.asList("Lớp đầy","Trùng lịch",
                "Bị hạn chế tín chỉ","Bị cảnh cáo học tập","Lý do khác");
        return lyDoList;
    }

    @GetMapping
    public String homeMrl(Model model, @AuthenticationPrincipal CustomUserDetails taiKhoan){
        SinhVien sv = sinhVienRepo.findByTaiKhoan(taiKhoan.getTaiKhoan());
        List<LopDangKi> lopDkList = lopDangKiRepo.findAllBySinhVienOrderByThoiGianDKAsc(sv);
        model.addAttribute("lopDkList",lopDkList);
        return "sv-list-mrl";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") String id,Model model){
        LopDangKi lopDk = lopDangKiRepo.findById(id).get();
        model.addAttribute("lopDk",lopDk);
        return "sv-sualop";
    }

    @PostMapping("/edit/{id}")
    public String postEdit(@PathVariable("id") String id,
                           @ModelAttribute("lopDk") LopDangKi thongTin){
        LopDangKi lopDk = lopDangKiRepo.findById(id).get();
        lopDk.updateThongTinDK(thongTin);
        lopDangKiRepo.save(lopDk);
        return "redirect:/sv/mrl";
    }
    @GetMapping("/add")
    public String showAdd(Model model){
        model.addAttribute("lopDk",new LopDangKi());
        return "sv-dangkilop";
    }
    @PostMapping("/add")
    public String postAdd(@ModelAttribute("lopDk") LopDangKi lopDk,
                          @AuthenticationPrincipal CustomUserDetails taiKhoan){

        SinhVien sv = sinhVienRepo.findByTaiKhoan(taiKhoan.getTaiKhoan());

        lopDk.setSinhVien(sv);
        lopDangKiRepo.save(lopDk);
        return "redirect:/sv/mrl";
    }
    @GetMapping("/delete/{id}")
    public String deleteLopDk(@PathVariable("id") String id){
        lopDangKiRepo.deleteById(id);
        return "redirect:/sv/mrl";
    }
}

