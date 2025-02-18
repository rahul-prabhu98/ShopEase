package controller;

import entity.Admin;
import entity.Order;
import entity.Product;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.AdminService;
import service.OrderService;
import service.ProductService;
import service.UserService;

import java.util.Date;

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
    private User user;

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

        return "UpdateUser";
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

    @GetMapping("/user/login")
    public String userLogin(User user, Model model){
        if(userService.verifyCredentials(user.getEmail(), user.getPassword())){
            user = userService.findUserByEmail(user.getEmail());
            model.addAttribute("orderList", orderService.findOrdersByUser(user));
            return "ProductPage";
        }

        model.addAttribute("error","Invalid email or password");
        return "Login";
    }

    @GetMapping("/place/order")
    public String placeOrder(Order order, Model model) {
        double totalAmount = order.getPrice() * order.getQuantity();
        order.setAmount(totalAmount);
        order.setUser(user);
        order.setDate(new Date());

        orderService.createOrder(order);
        model.addAttribute("amount", totalAmount);
        return "OrderStatus";
    }

    @GetMapping("/product/search")
    public String productSearch(String name, Model model){
        Product product = productService.findProductByName(name);
        if(product != null){
            model.addAttribute("orderList", orderService.findOrdersByUser(user));
            model.addAttribute("product", product);
            return "ProductPage";
        }
        model.addAttribute("error", "Sorry! Product was not found");
        model.addAttribute("orderList", orderService.findOrdersByUser(user));
        return "ProductPage";
    }
}
