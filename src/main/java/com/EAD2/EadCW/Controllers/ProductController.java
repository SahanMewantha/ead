package com.EAD2.EadCW.Controllers;

import com.EAD2.EadCW.Model.Product;
import com.EAD2.EadCW.Model.ProductDto;
import com.EAD2.EadCW.Service.ProductsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductsRepository repo;

    @GetMapping({""})
    public String showProductsList(Model model) {
        List<Product> products=repo.findAll();
        model.addAttribute("products",products);
        return "products/index";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        ProductDto productDto=new ProductDto();
        model.addAttribute("productDto", productDto);
        return "products/CreateProduct";
    }

    @PostMapping("/create")
    public String createProduct(
            @Valid @ModelAttribute ProductDto productDto,
            BindingResult result)
    {
        if(result.hasErrors()){
            return "products/CreateProduct";
        }

        MultipartFile image =productDto.getImageFile();
        Date createDate=new Date();
        String storageFileName= createDate.getTime()+"_"+image.getOriginalFilename();

        try {
            String uploadDir="Public/images/";
            Path uploadPath= Paths.get(uploadDir);

            if(!Files.exists(uploadPath)){
                Files.createDirectories(uploadPath);
            }
            try(InputStream inputStream = image.getInputStream()) {
                Files.copy(inputStream,Paths.get(uploadDir+storageFileName), StandardCopyOption.REPLACE_EXISTING);

            }
        }
        catch (Exception ex){
            System.out.println("Exception :"+ex.getMessage());
        }



        Product products=new Product();
        products.setName(productDto.getName());
        products.setBrand(productDto.getBrand());
        products.setCategory(productDto.getCategory());
        products.setDescription(productDto.getDescription());
        products.setPrice(productDto.getPrice());
        products.setCreateAt(createDate);
        products.setImageFileName(storageFileName);

        repo.save(products);

        return "redirect:/products";

    }

}
