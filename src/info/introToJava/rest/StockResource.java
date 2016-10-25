package info.introToJava.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

// This is RESTful Endpoint
// Если придет запрос /stock, будет передано управнение этому классу
// @Path перед классом показывает к какому классу нужно обратиться
@Path("/stock")
public class StockResource {

    // @Produces - ответ может быть получен в формате xml или JSON(выбирается в параметре accept HTTP запроса)
    // @Path перед методом передает параметр, взятый после /stock, в метод
    // Если запрос от клиента придет методом GET
    @Produces({"application/xml", "application/json"})
    @Path("{symbol}")
    @GET
    public Stock getStock(@PathParam("symbol") String symb) {

        Stock stock = StockService.getStock(symb);

        if (stock == null) {
            return new Stock("NOT FOUND", 0.0, "--", "--");
        }

        // Возврат нужен фреймворку или сереверу, который имплементерует JAX-RS
        // В нашем случае Jersey framework
        return stock;
    }

    // Если запрос пришел методом POST
    // @Consumes - получение данных от клиента
    @POST
    @Consumes("application/x-www-forum-urlencoded")
    public Response addStock(@FormParam("symbol") String symb,
                             @FormParam("currency") String currency,
                             @FormParam("price") String price,
                             @FormParam("country") String country) {

        if (StockService.getStock(symb) != null) {
            return Response.status(Response.Status.BAD_REQUEST).
                    entity("Stock" + symb +
                    " already exists").type("text/plain").build();
        }

        double priceToUse;

        try {
            priceToUse = new Double(price);
        } catch (NumberFormatException e) {
            priceToUse = 0.0;
        }

        StockService.addStock(new Stock(symb, priceToUse, currency, country));

        return Response.ok().build();
    }
}
