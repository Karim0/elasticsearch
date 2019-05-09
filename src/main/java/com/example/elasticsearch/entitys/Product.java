package com.example.elasticsearch.entitys;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Setter
@Getter
//@Entity
@NoArgsConstructor
//@Table(name = "products")
@Document(indexName = "prod_indexes", type = "products")
public class Product {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    //@Column(name = "product_name_kk")
    private String productNameKk;
    //@Column(name = "product_name_ru")
    private String productNameRu;
    //@Column(name = "product_name_en")
    private String productNameEn;
    //@Column(name = "product_category_id")
    private Long productCategoryId;

    public Product(String productNameKk, String productNameRu, String productNameEn, Long productCategoryId) {
        this.productNameKk = productNameKk;
        this.productNameRu = productNameRu;
        this.productNameEn = productNameEn;
        this.productCategoryId = productCategoryId;
    }
}
