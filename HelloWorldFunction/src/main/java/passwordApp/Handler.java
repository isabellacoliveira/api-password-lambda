package passwordApp;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import passwordApp.services.PasswordService;
import passwordApp.exceptions.*;

import java.util.HashMap;
import java.util.Map;

public class Handler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private final PasswordService passwordService = new PasswordService();

    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-Custom-Header", "application/json");

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent().withHeaders(headers);

        try {
            System.out.println("Recebido Body: " + input.getBody());

            String requestBody = input.getBody();
            if (requestBody == null || requestBody.trim().isEmpty()) {
                return response.withStatusCode(400).withBody("{\"error\": \"Body is required\"}");
            }

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(requestBody);
            String password = jsonNode.has("password") ? jsonNode.get("password").asText() : "";

            try {
                String validationMessage = passwordService.checkPassword(password);
                return response.withStatusCode(200).withBody("{\"message\": \"" + validationMessage + "\"}");
            } catch (NotEmptyException | HasUpperException | HasLowerException | HasSpecialCharacterException |
                     MinimunCharactersException | RepeatedCharacterException e) {
                return response.withStatusCode(400).withBody("{\"error\": \"" + e.getMessage() + "\"}");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return response.withStatusCode(500).withBody("{\"error\": \"Internal Server Error\"}");
        }
    }
}
