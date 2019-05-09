package com.example.elasticsearch.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

//@Configuration
public class ESConfig {
    //@Value("${elasticsearch.host:localhost}")
    //public String host;
    //@Value("${elasticsearch.port:9300}")
    //public int port;

    @Value("${elasticsearch.index.name}")
    private String indexName;
    @Value("${elasticsearch.name.type}")
    private String nameType;

    //@Bean
    //public Client client(){
    //    Settings settings = Settings.builder()
    //            .put("cluster.name", "prod_indexes")
    //            .put("client.transport.sniff", false)
    //            .put( "client.transport.ignore_cluster_name", true)
    //            .build();
    //    TransportClient client = null;sad
    //    try {
    //        client = TransportClient.builder().build()
    //                .addTransportAddress(new
    //                        InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
//
    //    } catch (UnknownHostException e) {
    //        e.printStackTrace();
    //    }
    //    return client;
    //}
}
