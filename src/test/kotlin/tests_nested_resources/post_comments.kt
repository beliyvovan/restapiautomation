package tests_nested_resources

import common.BaseTest
import io.restassured.RestAssured
import org.hamcrest.Matchers.`is`
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import tests_resources.posts

@RunWith(JUnit4::class)

class post_comments : BaseTest() {

    companion object {
        const val API_URL = "$BASE_API_URL/public/posts/100/comments"
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