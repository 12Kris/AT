package task_16;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import task_16.requests.BoardRequest;
import task_16.requests.CardRequest;
import task_16.requests.OrganizationRequest;
import task_16.responses.CardResponse;
import task_16.responses.OrganizationResponse;
import task_16.responses.BoardResponse;

import static io.restassured.RestAssured.given;

public class Task_16TrelloTest {

    private static final String KEY = System.getenv("KEY");
    private static final String TOKEN = System.getenv("TOKEN");

    @Test
    void trelloTest(){

        OrganizationRequest createOrgRequest = new OrganizationRequest("TestOrganizationName", "https://developer.atlassian.com/");

        // Create organization
        Response organizationCreateResponse = given()
                .queryParam("displayName", createOrgRequest.getDisplayName())
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .queryParam("website", createOrgRequest.getWebsite())
                .queryParam("name", createOrgRequest.getName())
                .when()
                .post("https://api.trello.com/1/organizations")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        OrganizationResponse organizationResponse = organizationCreateResponse.as(OrganizationResponse.class);
        Assert.assertEquals(organizationResponse.getDisplayName(), "MyFirstOrganization", "Organization display name does not match!");
        String organizationID = organizationCreateResponse.jsonPath().getString("id");
        System.out.println("Organization ID: " + organizationID);


        BoardRequest createBoardRequest = new BoardRequest("Task_15", organizationID);
        // Create a board
        Response boardCreateResponse = given()
                .queryParam("name", "Task_15")
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .queryParam("idOrganization", organizationID)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .post("https://api.trello.com/1/boards")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        BoardResponse boardResponse = boardCreateResponse.as(BoardResponse.class);
        String boardID = boardCreateResponse.jsonPath().getString("id");
        System.out.println("Board ID: " + boardID);

        // Create a list
        Response listCreateResponse = given()
                .queryParam("name", "TrelloList")
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .queryParam("idBoard", boardID)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .post("https://api.trello.com/1/lists")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        String listID = listCreateResponse.jsonPath().getString("id");
        System.out.println("List ID: " + listID);

        CardRequest createCardRequest = new CardRequest("To do", listID);

        // Create a card
        Response cardCreateResponse = given()
                .queryParam("name", "To do")
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .queryParam("idList", listID)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .post("https://api.trello.com/1/cards")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        CardResponse cardResponse = cardCreateResponse.as(CardResponse.class);
        String cardID = cardCreateResponse.jsonPath().getString("id");
        System.out.println("Card ID: " + cardID);

        // Set a due date
        Response setDateResponse = given()
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .body("{\"due\": \"2024-11-12T18:30:00Z\"}")
                .log().all()
                .when()
                .put("https://api.trello.com/1/cards/" + cardID)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        String dueDate = setDateResponse.jsonPath().getString("due");
        System.out.println("Updated Due Date: " + dueDate);

        // Update the due date
        Response updateDateResponse = given()
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .body("{\"due\": \"2024-11-15T12:00:00Z\"}")
                .log().all()
                .when()
                .put("https://api.trello.com/1/cards/" + cardID)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        String updatedDueDate = updateDateResponse.jsonPath().getString("due");
        System.out.println("Updated Due Date Again: " + updatedDueDate);

        // Delete the due date
        Response deleteDateResponse = given()
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .body("{\"due\": null}")
                .log().all()
                .when()
                .put("https://api.trello.com/1/cards/" + cardID)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        String deletedDate = deleteDateResponse.jsonPath().getString("due");
        System.out.println("Deleted Due Date: " + deletedDate);

    }
}


/*
Create a new card on a board. Check that the API call returns a success status code and that the card is created with the
name provided in the API call.
Add a due date to the card. Check that the API call returns a success status code and that the due date is added to the card.
Update the due date of the card. Check that the API call returns a success status code and that the due date of the card is
updated as expected.
Delete the due date from the card. Check that the API call returns a success status code and that the due date is removed from
the card.
*/

/*
General task
Make restAssured TC using scenario from Task_15.
The same using any another API client.
Add Request and Response clases for each unique endpoints.
Validate Response Object using your own class comparator.





*/