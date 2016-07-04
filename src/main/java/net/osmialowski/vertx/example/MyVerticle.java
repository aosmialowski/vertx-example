package net.osmialowski.vertx.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class MyVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> future) {
        vertx.createHttpServer()
                .requestHandler(request -> {
                    request.response().end("<h1>Hello World</h1><h2>Sample Vert.x Application</h2>");
                })
                .listen(8800, result -> {
                    if (result.succeeded()) {
                        future.complete();
                    } else {
                        future.fail(result.cause());
                    }
                });
    }
}