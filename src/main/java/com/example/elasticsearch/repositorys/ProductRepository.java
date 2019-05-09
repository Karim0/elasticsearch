package com.example.elasticsearch.repositorys;

import com.example.elasticsearch.entitys.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, Long> {

    //@Query("select p from Product p where p.productNameEn like %?1% or " +
    //        "p.productNameKk like %?1% or p.productNameRu like %?1%")
    //List<Product> findByName(String name);

    Page<Product> findByProductNameEn(String name, Pageable pageable);
}
