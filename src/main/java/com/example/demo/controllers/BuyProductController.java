package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.ConstraintViolationException;


@Controller
public class BuyProductController {
    @Autowired
    private ApplicationContext context;
    @Autowired
    private ProductRepository productRepository = null;

    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID") int theId, Model theModel, RedirectAttributes redirectAttributes) {
        ProductService productService = context.getBean(ProductServiceImpl.class);
        int initialInv;

        Product product2=productService.findById(theId);
        initialInv = product2.getInv();
        try {
            product2.setInv(product2.getInv() - 1);
            productService.save(product2);

        }
        catch (ConstraintViolationException e ) {
            redirectAttributes.addFlashAttribute("failedmessage",
                    "Purchase failed! Inventory value must be positive");
            return "redirect:/mainscreen";  //

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            redirectAttributes.addFlashAttribute("failedmessage",
            "Purchase failed! Inventory value must be positive");
            return "redirect:/mainscreen";
        }

        if (product2.getInv() == initialInv - 1 && product2.getInv() >= 0) { // Double check if there was inventory to sell
            System.out.println(product2.getInv());
            redirectAttributes.addFlashAttribute("successmessage", "Purchase successful!");
        }
        else {
            redirectAttributes.addFlashAttribute("failedmessage", "Purchase failed!");
        }

        return "redirect:/mainscreen";  //
    }

}
