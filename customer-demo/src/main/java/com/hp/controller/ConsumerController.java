package com.hp.controller;

import com.hp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@RestController
@RequestMapping("consumer")
public class ConsumerController {
    @Autowired
    private RestTemplate template;

    @Autowired
    private DiscoveryClient discoveryClient;
   /* @GetMapping("/{i}")
    public User getUser(@PathVariable("i") Long id){
        //调用user-service方法
       User user= template.getForObject("http://localhost:8092/user/"+id, User.class);
        System.out.println("sssss"+user);
       return user;
    }*/
   /*@GetMapping("/{i}")
   public User getUser(@PathVariable("i") Long id){
       //调用user-service方法
        List<ServiceInstance> instances=discoveryClient.getInstances("user-service");
        ServiceInstance serviceInstance=instances.get(0);
        String url="http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/"+"/user/"+id;
       User user= template.getForObject(url,User.class);
        return user;
   }*/
   @GetMapping("/{i}")
   public User getUser(@PathVariable("i") Long id){
       //调用user-service方法
       String url="http://user-service/user/"+id;
       User user= template.getForObject(url,User.class);
       return user;
   }
}
