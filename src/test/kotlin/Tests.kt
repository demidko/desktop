import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test

class Tests {
  @Test
  fun testExample() {
    assertThat(2 + 2, equalTo(4))
  }
}