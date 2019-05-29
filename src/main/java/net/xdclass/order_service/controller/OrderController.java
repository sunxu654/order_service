package net.xdclass.order_service.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import net.xdclass.order_service.domain.ProductOrder;
import net.xdclass.order_service.service.ProductOrderService;
import net.xdclass.order_service.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/order/")
@RefreshScope
public class OrderController {
    @Autowired
    private ProductOrderService productOrderService;

    @RequestMapping("save")
    @HystrixCommand(fallbackMethod = "saveOrderFail")

    public Object save(@RequestParam("user_id") int userId, @RequestParam("product_id") int productId) {

        return productOrderService.save(userId, productId);
    }

    private Object saveOrderFail(int userId, int productId) {
        HashMap<String, Object> msg = new HashMap<>();

        msg.put("code", -1);
        msg.put("data","抢没了");


        return msg;
    }
}

