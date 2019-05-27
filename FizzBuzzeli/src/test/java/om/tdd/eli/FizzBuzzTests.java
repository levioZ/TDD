package om.tdd.eli;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;
public class FizzBuzzTests
{
    @ParameterizedTest(name = "should return {0} given {1}")
    @CsvSource({
            "1,'1'",
            "3,'Fizz'",
            "5,'Buzz'",
            "15,'FizzBuzz'"
    })
    public void test(int input, String words)
    {
      assertThat(FizzBuzz.of(input)).isEqualTo(words);
    }
}
