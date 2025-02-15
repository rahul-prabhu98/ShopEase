package controller;

import entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.AdminService;
import service.OrderService;
import service.ProductService;
import service.UserService;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @GetMapping("/verify/credentials")
    public String verifyCredentials(@ModelAttribute("admin")Admin admin, Model model){
        if(adminService.verifyCredentials(admin.getEmail(), admin.getPassword())){
            return "/admin/home";
        }

        model.addAttribute("error", "Invalid Email or Password");
        return "Login";
    }

    @GetMapping("/admin/home")
    public String adminHomePage(Model model){
        model.addAttribute("adminList", adminService.getAllAdmin());
        model.addAttribute("userList", userService.getAllUser());
        model.addAttribute("orderList", orderService.getAllOrder());
        model.addAttribute("productList", productService.getAllProduct());

        return "AdminHomePage";
    }

    @GetMapping("/add/admin")
    public String createAdmin(){
        return "AddAdmin";
    }

    @PostMapping("/add/admin")
    public String createAdmin(Admin admin){
        adminService.createAdmin(admin);
        return "/admin/home";
    }

    @GetMapping("/update/admin/{id}")
    public String updateAdmin(@PathVariable Long id, Model model){
        model.addAttribute("admin", adminService.getAdminById(id));

        return "UpdateAdmin";
    }

    @PostMapping("/update/admin")
    public String updateAdmin(Admin admin){
        adminService.updateAdmin(admin);
        return "/admin/home";
    }

    @DeleteMapping("/delete/admin/{id")
    public String deleteAdmin(@PathVariable Long id){
        adminService.deleteAdmin(id);
        return "/admin/home";
    }
}
