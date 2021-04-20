package com.mercatrucho.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercatrucho.dtos.User;
import spark.Request;
import spark.Response;
import javax.servlet.http.HttpServletResponse;

public class UserControllers {

    //getHello /hello?user="Peter"     Hello Peter
    public static String getHello(Request req, Response res) {
        String user=req.queryParams("user");

        if (user == null) {
            res.status(HttpServletResponse.SC_BAD_REQUEST);
            return "User not exist";
        }

        res.status(HttpServletResponse.SC_OK);
        return "Hello " + user;
    }

    //getHola /hola?usuario="Pedro"     Hola Pedro
    public static String getHola(Request req,Response res){
        String usuario=req.queryParams("usuario");

        if (usuario==null){
            res.status(HttpServletResponse.SC_BAD_REQUEST);
            return "No existe el usuario";
        }

        res.status(HttpServletResponse.SC_OK);
        return "Hola " + usuario;

    }

    //postCreate /user/create?id=1&name=Alejandro&address=Colombia
    public static Object postCreate(Request req, Response res) {
        String id = req.queryParams("id");
        String name= req.queryParams("name");
        String address= req.queryParams("address");

        if (id==null|| name==null || address==null){
            res.status(HttpServletResponse.SC_BAD_REQUEST);
            return "Parámetros incorrectos";
        }

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAddress(address);


        //Transformar a json
        ObjectMapper mapper= new ObjectMapper();
        String json;

        try {
            json = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            res.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Se rompio json: " + e.getMessage();
        }

        res.header("Content-type","application/json");
        res.status(HttpServletResponse.SC_OK);
        return json;

    }
}
