package com.example.elasticsearch.dao.imp;

import com.example.elasticsearch.dao.ProductDAO;
import com.example.elasticsearch.entitys.Product;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

@Repository
public class ProductDAOImp implements ProductDAO {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Value("${elasticsearch.index.name}")
    private String indexName;

    @Value("${elasticsearch.name.type}")
    private String nameType;

    @Autowired
    private ElasticsearchTemplate esTemplate;

    @Override
    public List<Product> getAllProduct() {
        SearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery()).build();
        return esTemplate.queryForList(query, Product.class);
    }

    @Override
    public Product getProductById(Long id) {
        SearchQuery query = new NativeSearchQueryBuilder()
                .withFilter(QueryBuilders.matchQuery("productId", id)).build();
        List<Product> list = esTemplate.queryForList(query, Product.class);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Product addNewProduct(Product product) {
        IndexQuery index = new IndexQuery();

        index.setIndexName(indexName);
        index.setType(nameType);
        index.setObject(product);

        LOG.info("Product indexed: {}", esTemplate.index(index));
        esTemplate.refresh(indexName);
        return product;
    }

    @Override
    public List<Product> getProductByName(String name) {
        SearchQuery query = new NativeSearchQueryBuilder()
                .withFilter(QueryBuilders.matchQuery("productNameKk", name))
                .withFilter(QueryBuilders.matchQuery("productNameRu", name))
                .withFilter(QueryBuilders.matchQuery("productNameEn", name))
                .build();
        return esTemplate.queryForList(query, Product.class);
    }
}
