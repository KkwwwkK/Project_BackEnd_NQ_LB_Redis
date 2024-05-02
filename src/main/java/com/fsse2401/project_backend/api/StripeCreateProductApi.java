package com.fsse2401.project_backend.api;


import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Product;
import com.stripe.param.ProductCreateParams;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class StripeCreateProductApi {

    @PostMapping("/v1/products")
    public void createProduct() throws StripeException{
        Stripe.apiKey = "sk_test_51PBpckBLB2CmbGe0fNrazNx1RXeIuzzr2PuW1mMYYfyBZ8Ea5VRgqSDDFifOJxskqxR7pKDE7aQirmJ12O4vU3Ly0093jnmOZS";

        ProductCreateParams params =
                ProductCreateParams.builder().setName("Gold Plan").build();

        Product product = Product.create(params);
    }
}
