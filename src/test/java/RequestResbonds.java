import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResbonds {
    /*
 1) Postman manual test için kullanılır
 2) API otomasyonu için Rest-Assured Library kullanıyoruz
 3) Otomasyon kodlarının yazımı için şu adımların izlenmesi gerekir:
    a) Gereksinimleri anlama
    b) Test Case'i yazma:
        -Test yazmak için 'Gherkin Language' kullanıyoruz.
        x) Given: Ön koşullar --> Enpoint, Body ...
        y) When: Yapılacak işlemler --> Get, Put, Delete ...
        z) Then: Dönütler --> Assertion, Close ...
        t) And:  Art arda kullanılan aynı işlemler için and kullanılır
    c) Otomasyon kolarının yazma:
        i) Set the URL --> Endpoint'i kur
        ii) Set the expected data --> Beklenen veriyi kur
        iii) Send the request and get the response --> Request yolla, response al
        iv) Do Assertion --> Doğrulama yap
 */
    public static void main(String[] args) {
//        Otomasyon kolarının yazma:
//        i) Set the URL --> Endpoint'i kur
        String url = "https://restful-booker.herokuapp.com/booking/124";
//        ii) Set the expected data --> Beklenen veriyi kur
//        iii) Send the request and get the response --> Request yolla, response al
       Response response= given().get(url);
       response.prettyPrint();
//
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        System.out.println("response.getContentType() = " + response.getContentType());
        System.out.println("response.getStatusLine() = " + response.getStatusLine());
        System.out.println("response.getTime() = " + response.getTime());
        System.out.println("response.body() = " + response.body());
        System.out.println("response.getHeaders() = " + response.getHeaders());
        System.out.println("response.getHeader(\"Accept-Encoding\") = " + response.getHeader("Server"));

//        iv) Do Assertion --> Doğrulama yap
    }
}
