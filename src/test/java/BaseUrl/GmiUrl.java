package BaseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GmiUrl {

    protected RequestSpecification spec;
    @Before
    public void setUp() {
        spec = new RequestSpecBuilder().
                setContentType(ContentType.JSON).
                addHeader("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJrX3R3YWluIiwiYXV0aCI6IlJPTEVfQURNSU4sUk9MRV9NQU5BR0VSIiwiZXhwIjoxNjg4MzcxNzU0fQ.18Nx6VGQcyvNtOvUFHyDqz5oBEEQz33bKCpXJS8DIqPKdXYswI4iALy1kuD3MDzN5D9GWOwC2-NtGsHA5TN2FA").
                setBaseUri("https://gmibank.com/api").build();
    }
}
