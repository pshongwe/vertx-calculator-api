package com.example;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(VertxUnitRunner.class)
public class CalculatorVerticleTest {

    private Vertx vertx;

    @Before
    public void setUp(TestContext context) {
        vertx = Vertx.vertx();
        vertx.deployVerticle(CalculatorVerticle.class.getName(), context.asyncAssertSuccess());
    }

    @After
    public void tearDown(TestContext context) {
        vertx.close(context.asyncAssertSuccess());
    }

    @Test
    public void testAddition(TestContext context) {
        final Async async = context.async();
        vertx.createHttpClient().request(HttpMethod.POST, 8888, "localhost", "/add")
                .compose(req -> req.putHeader("content-type", "application/json")
                        .send("{\"num1\": 5, \"num2\": 3}"))
                .compose(resp -> {
                    context.assertEquals(200, resp.statusCode());
                    return resp.body();
                })
                .onSuccess(body -> {
                    JsonObject expected = new JsonObject().put("result", 8.0);
                    JsonObject actual = new JsonObject(body.toString());
                    context.assertEquals(expected, actual);
                    async.complete();
                })
                .onFailure(context::fail);
    }

    @Test
    public void testSubtraction(TestContext context) {
        final Async async = context.async();
        vertx.createHttpClient().request(HttpMethod.POST, 8888, "localhost", "/subtract")
                .compose(req -> req.putHeader("content-type", "application/json")
                        .send("{\"num1\": 5, \"num2\": 3}"))
                .compose(resp -> {
                    context.assertEquals(200, resp.statusCode());
                    return resp.body();
                })
                .onSuccess(body -> {
                    JsonObject expected = new JsonObject().put("result", 2.0);
                    JsonObject actual = new JsonObject(body.toString());
                    context.assertEquals(expected, actual);
                    async.complete();
                })
                .onFailure(context::fail);
    }

    @Test
    public void testMultiplication(TestContext context) {
        final Async async = context.async();
        vertx.createHttpClient().request(HttpMethod.POST, 8888, "localhost", "/multiply")
                .compose(req -> req.putHeader("content-type", "application/json")
                        .send("{\"num1\": 5, \"num2\": 3}"))
                .compose(resp -> {
                    context.assertEquals(200, resp.statusCode());
                    return resp.body();
                })
                .onSuccess(body -> {
                    JsonObject expected = new JsonObject().put("result", 15.0);
                    JsonObject actual = new JsonObject(body.toString());
                    context.assertEquals(expected, actual);
                    async.complete();
                })
                .onFailure(context::fail);
    }

    @Test
    public void testDivision(TestContext context) {
        final Async async = context.async();
        vertx.createHttpClient().request(HttpMethod.POST, 8888, "localhost", "/divide")
                .compose(req -> req.putHeader("content-type", "application/json")
                        .send("{\"num1\": 6, \"num2\": 3}"))
                .compose(resp -> {
                    context.assertEquals(200, resp.statusCode());
                    return resp.body();
                })
                .onSuccess(body -> {
                    JsonObject expected = new JsonObject().put("result", 2.0);
                    JsonObject actual = new JsonObject(body.toString());
                    context.assertEquals(expected, actual);
                    async.complete();
                })
                .onFailure(context::fail);
    }

    @Test
    public void testDivisionByZero(TestContext context) {
        final Async async = context.async();
        vertx.createHttpClient().request(HttpMethod.POST, 8888, "localhost", "/divide")
                .compose(req -> req.putHeader("content-type", "application/json")
                        .send("{\"num1\": 6, \"num2\": 0}"))
                .compose(resp -> {
                    context.assertEquals(400, resp.statusCode());
                    return resp.body();
                })
                .onSuccess(body -> {
                    JsonObject expected = new JsonObject().put("error", "Cannot divide by zero");
                    JsonObject actual = new JsonObject(body.toString());
                    context.assertEquals(expected, actual);
                    async.complete();
                })
                .onFailure(context::fail);
    }
}
