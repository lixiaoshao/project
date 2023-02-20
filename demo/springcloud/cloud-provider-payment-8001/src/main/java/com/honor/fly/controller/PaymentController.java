package com.honor.fly.controller;

import com.honor.fly.entity.CommonResult;
import com.honor.fly.entity.Payment;
import com.honor.fly.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * com.honor.fly.controller
 *
 * @author honor-ljp
 * 2023/1/11 15:27
 */
@Controller
@RequestMapping("/payment")
public class PaymentController extends BaseController {

    @Autowired
    PaymentService paymentService;
    @Value("${server.port}")
    private String port;
    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("/discovery")
    public CommonResult discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("service = " + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        instances.forEach(s -> System.out.println(s.getInstanceId() + "\t" + s.getServiceId() + "\t"
                + s.getHost() + "\t" + s.getPort() + "\t" + s.getUri() + "\n"));
        return success();
    }
    @RequestMapping("/getPayment/{id}")
    public CommonResult getPayment(@PathVariable Long id, HttpServletRequest request)
    {
        String header = request.getHeader("X-Request-red");
        System.out.println("header = " + header);
        System.out.println("port = " + port);
        return success(paymentService.getPaymentById(id));

    }

    @PostMapping("/create")
    public CommonResult getPayment(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {
            return success(result);
        }
        logger.error("create失败");
        return fail(100001, "插入失败!");
    }
}
