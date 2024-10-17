package com.EAD2.EadCW.Service;

import com.EAD2.EadCW.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository <Product,Integer> {
}
