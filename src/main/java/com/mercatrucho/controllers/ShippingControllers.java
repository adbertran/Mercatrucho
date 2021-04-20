package com.mercatrucho.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercatrucho.dtos.Product;
import com.mercatrucho.dtos.Shipping;
import spark.Request;
import spark.Response;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class ShippingControllers {

    public static Object processBuy(Request req, Response res) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Product product = mapper.readValue(req.bodyAsBytes(), Product.class);
        Shipping shipping = processShipping(product);

        String json;

        try {
            json = mapper.writeValueAsString(shipping);
        } catch (JsonProcessingException e) {
            res.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Se rompio json: " + e.getMessage();
        }

        res.header("Content-type","application/json");
        res.status(HttpServletResponse.SC_OK);
        return json;
    }

    private static Shipping processShipping(Product p) {
        return new Shipping(p.getSeller(),p.getName(),p.getDescription(),p.getPrice(),"18/04/2021",true);
    }

}