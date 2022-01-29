package com.nettyproject.nettyserver;

import com.nettyproject.nettyserver.server.NettyServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication

public class NettyserverApplication implements CommandLineRunner {

    @Resource
    private NettyServer nettyServer;

    public static void main(String[] args) {
        SpringApplication.run(NettyserverApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        nettyServer.start();
        //确保springboot整个项目关闭时，nettyServer要关闭
        Runtime.getRuntime().addShutdownHook(new Thread(() -> nettyServer.destroy()));
    }

}
