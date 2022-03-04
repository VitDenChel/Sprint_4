import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CheckNameCanBePrintedOnCardNegativeParameterizedTest {
    private final String name;
    private final boolean expected;

    public CheckNameCanBePrintedOnCardNegativeParameterizedTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] checkNameForCard() {
        return new Object[][]{
                {"", false}, //0 символов
                {"Я", false}, //1 символ
                {"Ян", false}, //2 символа
                {"Яна", false}, //3 символа без пробела
                {"Я н ", false}, //4 символа с двумя пробелами
                {" Я н", false}, //4 символа с двумя пробелами
                {" Лев ", false}, //5 символов с пробелами по краям
                {"Лев Ив анов", false}, //11 символов с двумя пробелами в середине
                {" Лев Иванов ", false}, //12 символов с тремя пробелами
                {"АлександраДенисович", false}, //19 символов без пробела
                {"                   ", false}, //19 пробелов
                {"Александр Александров", false}, //21 символов с пробелом в середине
                {"Александр АлександровАлександровАлександров", false}, //43 символа с пробелом в середине
        };
    }

    @Test
    public void CheckNameForPrintingOnCardNegativeTest() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        Assert.assertEquals(expected, actual);
    }
}
