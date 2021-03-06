package extremecarpaccio;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.port;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.*;

import spark.ResponseTransformer;
import spark.Spark;

public class HttpServer {
    private static final Logger logger = LoggerFactory.getLogger(HttpServer.class);

    public static void main(String[] args) {
        start(1337);
    }

    public static void start(int port) {
        port(port);
        configureRoutes();
    }

    public static void stop() {
        Spark.stop();
    }

    private static void configureRoutes() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ResponseTransformer asJson = new JsonResponseTransformer(gson);

        get("/ping", (req, res) -> "pong");
        post("/feedback", (req, res) -> {
            JsonObject body = gson.fromJson(req.body(), JsonObject.class);
            String feedbackType = body.get("type").getAsString();
            String feedbackContent = body.get("content").getAsString();

            if ("ERROR".equals(feedbackType)) {
                logger.error(feedbackContent);
            } else {
                logger.info(feedbackContent);
            }

            return "";
        }, asJson);
        post("/order", (req, res) -> {
            try {
                Order order = gson.fromJson(req.body(), Order.class);
                logger.info(order.toString());
                return order.getTotal();
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
            res.status(400);
            logger.info("400 sent !");
            return "";
        }, asJson);
        post("/", (req, res) -> {
            JsonObject body = gson.fromJson(req.body(), JsonObject.class);
            logger.info("Incoming request on '/': {}", body.entrySet());
            return "";
        }, asJson);
    }

}
