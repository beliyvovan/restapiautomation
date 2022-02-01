package tests_resources

import common.BaseTest
import io.restassured.RestAssured
import org.hamcrest.Matchers
import org.hamcrest.Matchers.`is`
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)

class todos : BaseTest() {

    companion object {
        const val API_URL = "$BASE_API_URL/public/v1/todos"
    }

    @Test
    fun successGet() {
        RestAssured.`when`()
            .get(API_URL)
            .then()
            .assertThat()
            .statusCode(200)
            .and()
            .body("data.size()", `is`(20))
            .body("data[0]", Matchers.hasKey("id"))
            .body("data[0]", Matchers.hasKey("user_id"))
            .body("data[0]", Matchers.hasKey("title"))
            .body("data[0]", Matchers.hasKey("due_on"))
            .body("data[0]", Matchers.hasKey("status"))

    }


    @Test
    fun unSeccessPost() {
        RestAssured.`when`()
            .post(API_URL)
            .then()
            .assertThat()
            .statusCode(401)
            .and()
            .body("message", `is`("Authentication failed"))

    }

    @Test
    fun unSeccessPut() {
        RestAssured.`when`()
            .put(API_URL)
            .then()
            .assertThat()
            .statusCode(404)

    }

    @Test
    fun unSeccessPatch() {
        RestAssured.`when`()
            .patch(API_URL)
            .then()
            .assertThat()
            .statusCode(404)
    }

    @Test
    fun unSeccessDelete() {
        RestAssured.`when`()
            .delete(API_URL)
            .then()
            .assertThat()
            .statusCode(404)


    }

    @Test
    fun unSeccessOptions() {
        RestAssured.`when`()
            .options(API_URL)
            .then()
            .assertThat()
            .statusCode(404)


    }
}
