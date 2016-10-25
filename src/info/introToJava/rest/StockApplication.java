package info.introToJava.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

// Identify the base URL with annotation @ApplicationPath
// Базовый класс RESTful сервиса
// extends Application позволяет не конфигурировать web.xml для веб сервиса
@ApplicationPath("restfulstocks")
public class StockApplication extends Application {
}
