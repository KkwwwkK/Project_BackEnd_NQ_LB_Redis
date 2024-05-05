package com.fsse2401.project_backend.api;

import com.fsse2401.project_backend.config.EnvConfig;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({
        EnvConfig.DEV_BASE_URL,
        EnvConfig.PROD_BASE_URL,
        EnvConfig.PROD_S3_BASE_URL
})
public class CheckOutApi {
//    @PostMapping("/public/checkout")
//    public void checkout() throws StripeException {
//        Stripe.apiKey = "sk_test_51PBpckBLB2CmbGe0fNrazNx1RXeIuzzr2PuW1mMYYfyBZ8Ea5VRgqSDDFifOJxskqxR7pKDE7aQirmJ12O4vU3Ly0093jnmOZS";
//
//        String YOUR_DOMAIN = "http://localhost:5173";
//        SessionCreateParams params =
//        SessionCreateParams.builder()
//                .setMode(SessionCreateParams.Mode.PAYMENT)
//                .setSuccessUrl(YOUR_DOMAIN + "/thankyou")
//                .setCancelUrl(YOUR_DOMAIN + "/error")
//                .addLineItem(
//                        SessionCreateParams.LineItem.builder()
//                                .setQuantity(1L)
//                                // Provide the exact Price ID (for example, pr_1234) of the product you want to sell
//                                .setPrice("price_1PBqEOBLB2CmbGe0VeEYpNNV")
//                                .build())
//                .build();
//        Session session = Session.create(params);
//        System.out.println(session.getId());
//        System.out.println(session.getUrl());
//    }

    @PostMapping("/public/checkout")
    public String checkout() throws StripeException {
        Stripe.apiKey = "sk_test_51PBpckBLB2CmbGe0fNrazNx1RXeIuzzr2PuW1mMYYfyBZ8Ea5VRgqSDDFifOJxskqxR7pKDE7aQirmJ12O4vU3Ly0093jnmOZS";

        String YOUR_DOMAIN = "http://localhost:5173";
        SessionCreateParams params =
                SessionCreateParams.builder()
                        .setMode(SessionCreateParams.Mode.PAYMENT)
                        .setSuccessUrl(YOUR_DOMAIN + "/thankyou")
                        .setCancelUrl(YOUR_DOMAIN + "/error")
                        .addLineItem(
                                SessionCreateParams.LineItem.builder()
                                        .setQuantity(1L)
                                        // Provide the exact Price ID (for example, pr_1234) of the product you want to sell
                                        .setPrice("price_1PBqEOBLB2CmbGe0VeEYpNNV")
                                        .build())
                        .build();
        Session session = Session.create(params);
        // for secure guarantee of payment
//        session.setSuccessUrl(YOUR_DOMAIN + "/thankyou?session_id=" + session.getId());
//        System.out.println(session.getId());
//        System.out.println(session.getUrl());
        return session.getUrl();
    }
}
