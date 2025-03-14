package com.example.ecomProject;

import io.helidon.microprofile.server.Server;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.auth.LoginConfig;

import java.util.logging.*;

@ApplicationScoped
@ApplicationPath("/ecom")
@LoginConfig(authMethod = "MP-JWT")
public class Ecom extends Application {

    private static final Logger logger = Logger.getLogger(Ecom.class.getName());
    public static void main(String[] args) {
        logger.log(Level.INFO, "Starting Ecom Application");
        Server.builder().build().start();
    }
}
