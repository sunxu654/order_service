package net.xdclass.order_service.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import net.xdclass.order_service.domain.ProductOrder;
import net.xdclass.order_service.service.ProductClient;
import net.xdclass.order_service.service.ProductOrderService;
import net.xdclass.order_service.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

//    @Qualifier("product-service")
@Autowired
    private ProductClient productClient;
    @Override

    public Object save(int userId, int productId) {
        HashMap<String, Object> msg = new HashMap<>();

        String response = productClient.findById(userId);
        JsonNode jsonNode = JsonUtils.str2JsonNode(response);


        //TODO 获取商品详情,用productId,填入productOder里
        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreateTime(new Date());
        productOrder.setUserId(userId);
        productOrder.setTadeNo(UUID.randomUUID().toString());
        productOrder.setProductName(jsonNode.get("name").toString());
        productOrder.setPrice(Integer.parseInt(jsonNode.get("price").toString()));
        msg.put("code", 0);
        msg.put("data",productOrder);
        return msg;
    }



}
