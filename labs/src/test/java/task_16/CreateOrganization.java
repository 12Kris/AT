package task_16;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CreateOrganization {
    private static final String KEY = "df12c6b02399539cc398e08610571fcd";
    private static final String TOKEN = "ATTA453fc002be3d115fc14deb8cc1962fd58b15661650eef21d4ed85ef9eb458e4938D07DD0";
    @Test
    void createOrganization() throws IOException, InterruptedException, URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/organizations?key=" + KEY + "&token=" + TOKEN + "&displayName=TestOrganizationName"))
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse <String> createOrganizationResponse = HttpClient.newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(createOrganizationResponse.body());
        Assert.assertEquals(createOrganizationResponse.statusCode(), 200, "Invalid StatusCode");
    }
}