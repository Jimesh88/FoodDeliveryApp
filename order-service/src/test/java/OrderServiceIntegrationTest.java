import com.github.tomakehurst.wiremock.client.WireMock;
import com.jimesh.orderservice.OrderServiceApplication;
import com.jimesh.orderservice.dto.OrderDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = OrderServiceApplication.class
)
@AutoConfigureWireMock(port = 0)
@ActiveProfiles("test") // forces Spring to read application-test.yml
public class OrderServiceIntegrationTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Test
    void testOrderWithUserDetails(){
        WireMock.stubFor(WireMock.get("/v1/users/123").willReturn(WireMock.aResponse()
                .withHeader("Content-Type","application/json").withBody(
                                """
                                    {
                                      "name": "Jimesh Naik",
                                       "email": "jimesh@example.com",
                                        "phone": "19999999999",
                                        "address": "123, Satellite Road, Ahmedabad"
                                    }
                                """
                ).withStatus(200)));

        OrderDto order = new OrderDto();
        order.setUserId(123);
        order.setRestaurantId(UUID.randomUUID());
        order.setItemIds(List.of(UUID.randomUUID(), UUID.randomUUID()));
        order.setTotalPrice(45.50);
        order.setStatus("PENDING");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OrderDto> requestEntity = new HttpEntity<>(order, headers);

        ResponseEntity<OrderDto> response = testRestTemplate.exchange(
                "http://localhost:" + port + "/v1/orders",
                HttpMethod.POST,
                requestEntity,
                OrderDto.class
        );

        // Assertions
        assertThat(response.getStatusCode().value()).isEqualTo(200); // or 201
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getUserId()).isEqualTo(123);

        // Verify User Service was called
        verify(getRequestedFor(urlPathEqualTo("/v1/users/123")));
    }
}
