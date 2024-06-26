package pe.edu.cibertec.waformulariosspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.waformulariosspring.model.LoginModel;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("loginModel", new LoginModel());
        model.addAttribute("mostrarMensaje", false);
        return "login";
    }

    @PostMapping("/login")
    public String validarLogin
            (@ModelAttribute("loginModel") LoginModel loginModel, Model model){
        if(loginModel.getUsuario().equals("vfalconim") &&
        loginModel.getPassword().equals("123")) {
            model.addAttribute("mensaje", "Bienvenido: "
                    + loginModel.getUsuario());
            return "home";
        }
        model.addAttribute("mensaje", "Usuario y/o " +
                "password incorrecto");
        model.addAttribute("mostrarMensaje", true);
        return "login";
    }
}
