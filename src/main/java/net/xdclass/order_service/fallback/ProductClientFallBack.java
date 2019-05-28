package net.xdclass.order_service.fallback;

import com.sun.webkit.PolicyClient;
import net.xdclass.order_service.service.ProductClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
//@FeignClient(name="")
public class ProductClientFallBack implements ProductClient {

    @Override
    public String findById(int id) {
        System.out.println("fegin 调用失败,fallback函数");
        return null;
    }
}
