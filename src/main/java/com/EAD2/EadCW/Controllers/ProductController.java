package com.EAD2.EadCW.Controllers;

import com.EAD2.EadCW.Model.Product;
import com.EAD2.EadCW.Model.ProductDto;
import com.EAD2.EadCW.Service.ProductsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.*;
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
        List<Product> products=repo.findAll(Sort.by(Sort.Direction.DESC, "id"));
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
        if (productDto.getImageFile().isEmpty()) {
            result.addError(new FieldError("productDto", "imageFile", "Image file is required"));
        }

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

    @GetMapping("/edit")
    public String showEditPage(Model model, @RequestParam int id) {
        try{
            Product products=repo.findById(id).get();
            model.addAttribute("products",products);

            ProductDto productsDto=new ProductDto();
            productsDto.setName(products.getName());
            productsDto.setBrand(products.getBrand());
            productsDto.setCategory(products.getCategory());
            productsDto.setDescription(products.getDescription());
            productsDto.setPrice(products.getPrice());

            model.addAttribute("productDto", productsDto);

        }
        catch (Exception ex){
            System.out.println("Exception :"+ex.getMessage());
            return "redirect:/products";
        }
        return "products/EditProducts";
    }

    @PostMapping("/edit")
    public String updateProduct(Model model,@RequestParam int id,
                                @Valid @ModelAttribute ProductDto productDto,BindingResult result){

        try{
            Product products=repo.findById(id).get();
            model.addAttribute("products",products);

            if(result.hasErrors()){
                return "products/EditProducts";
            }

            if(!productDto.getImageFile().isEmpty()){
                //delete old image
                String uploadDir="Public/images/";
                Path oldImagePath = Paths.get(uploadDir+products.getImageFileName());
                try{
                    Files.delete(oldImagePath);
                }
                catch (Exception ex){
                    System.out.println("Exception :"+ex.getMessage());
                }
                // save new image file
                MultipartFile image =productDto.getImageFile();
                Date createDate=new Date();
                String storageFileName= createDate.getTime()+"_"+image.getOriginalFilename();

                try(InputStream inputStream = image.getInputStream()) {
                    Files.copy(inputStream,Paths.get(uploadDir+storageFileName), StandardCopyOption.REPLACE_EXISTING);

                }
                products.setImageFileName(storageFileName);
            }

            products.setName(productDto.getName());
            products.setBrand(productDto.getBrand());
            products.setCategory(productDto.getCategory());
            products.setDescription(productDto.getDescription());
            products.setPrice(productDto.getPrice());

            repo.save(products);

        }
        catch(Exception ex){
            System.out.println("Exception :"+ex.getMessage());

        }

        return "redirect:/products";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int id) {
        try {
            Product product = repo.findById(id).get();

            // delete product image
            Path imagePath = Paths.get("public/images/" + product.getImageFileName());

            try {
                Files.delete(imagePath);
            }
            catch (Exception ex){
                System.out.println("Exception :"+ex.getMessage());
            }

            // delete the product
            repo.delete(product);
        }
        catch (Exception ex){
            System.out.println("Exception :"+ex.getMessage());
        }

        return "redirect:/products";
    }

}
