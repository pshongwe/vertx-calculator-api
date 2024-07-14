package com.example;

import com.example.handlers.AddHandler;
import com.example.handlers.SubtractHandler;
import com.example.handlers.MultiplyHandler;
import com.example.handlers.DivideHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class CalculatorVerticle extends AbstractVerticle {

    @Override
    public void start() {
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());

        router.post("/add").handler(new AddHandler());
        router.post("/subtract").handler(new SubtractHandler());
        router.post("/multiply").handler(new MultiplyHandler());
        router.post("/divide").handler(new DivideHandler());

        vertx.createHttpServer()
                .requestHandler(router)
                .listen(8888, result -> {
                    if (result.succeeded()) {
                        System.out.println("Server started on port 8888");
                    } else {
                        System.err.println("Server failed to start: " + result.cause());
                    }
                });
    }

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new CalculatorVerticle());
    }
}
