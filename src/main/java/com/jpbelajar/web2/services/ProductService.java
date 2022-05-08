package com.jpbelajar.web2.services;

import com.jpbelajar.web2.models.entities.Product;
import com.jpbelajar.web2.models.entities.Supplier;
import com.jpbelajar.web2.models.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierService supplierService;

    public Product save(Product product){
        return productRepository.save(product);
    }

    public Product findOne(Long id){
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent()){
            return null;
        }
        return product.get();
    }

    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }

    public void removeOne(Long id){
        productRepository.deleteById(id);
    }

    public List<Product> findByName(String name){
        return productRepository.findByNameContains(name);
    }

    public void addSupplier(Supplier supplier, Long productId){
        Product product = findOne(productId);
        if(product == null){
            throw new RuntimeException("Product with id: " + productId + " not found");
        }
        product.getSuppliers().add(supplier);
        save(product);
    }

    public Product findByProductName(String name){
        return productRepository.findProductByName(name);
    }

    public List<Product> findByProductNameLike(String name){
        return productRepository.findProductByNameLike("%"+name+"%");
    }

    public List<Product> findByProductUsingCategory(Long categoryId){
        return productRepository.findProductByCategory(categoryId);
    }

    public List<Product> findBySupplier(Long supplierId){
        Supplier supplier = supplierService.findOne(supplierId);
        if(supplier == null){
            return new ArrayList<Product>();
        }
        return productRepository.findProductBySupplier(supplier);
    }
}
