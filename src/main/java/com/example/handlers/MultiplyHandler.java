package com.example.handlers;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import io.vertx.core.json.JsonObject;

public class MultiplyHandler implements Handler<RoutingContext> {
    @Override
    public void handle(RoutingContext context) {
        JsonObject body = context.getBodyAsJson();
        double num1 = body.getDouble("num1");
        double num2 = body.getDouble("num2");
        double result = num1 * num2;
        context.response()
                .putHeader("content-type", "application/json")
                .end(new JsonObject().put("result", result).encodePrettily());
    }
}
