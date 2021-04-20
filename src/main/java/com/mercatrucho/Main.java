package com.mercatrucho;

import com.mercatrucho.config.Config;
import com.mercatrucho.controllers.ShippingControllers;
import com.mercatrucho.controllers.UserControllers;

import static spark.Spark.get;
import static spark.Spark.post;

public class Main {
    public static void main (String[] args){
        Config.init();


        get("/user/hello", UserControllers::getHello);
        get("/usuario/hola", UserControllers::getHola);
        post("/user/create",UserControllers::postCreate);
        post ("/user/buy", ShippingControllers::processBuy);
    }

}
