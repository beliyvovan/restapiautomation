package tests_nested_resources

import common.BaseTest
import io.restassured.RestAssured
import org.hamcrest.Matchers.`is`
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import tests_resources.posts

@RunWith(JUnit4::class)

class post_todos : BaseTest() {

    companion object {
        const val API_URL = "$BASE_API_URL/public/v1/users/100/todos"
    }

    @Test
    fun unSeccessPost() {
        RestAssured.`when`()
            .post(posts.API_URL)
            .then()
            .assertThat()
            .statusCode(401)
            .and()
            .body("message", `is`("Authentication failed"))

    }
}