package com.hello.core.lifecycle;

//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
//public class NetworkClient implements InitializingBean, DisposableBean {
    String url;

    public NetworkClient() {
        System.out.println("constructor url");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String msg) {
        System.out.println("call: " + url + ", msg = " + msg);
    }

    public void disconnect() {
        System.out.println("close");
    }

    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("initial msg");
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }

    //InitializingBean interface 구현했을 때
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("NetworkClient.afterPropertiesSet");
//        connect();
//        call("initial msg");
//    }
//
    //DisposableBean interface 구현했을 때
//    @Override
//    public void destroy() throws Exception {
//        disconnect();
//    }
}
