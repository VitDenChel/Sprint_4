import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CheckNameCanBePrintedOnCardParameterizedTest {
    private final String name;
    private final boolean expected;

    public CheckNameCanBePrintedOnCardParameterizedTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] checkNameForCard() {
        return new Object[][]{
                {"null", false}, //пустое поле
                {"Я", false}, //1 символ
                {"Ян", false}, //2 символа
                {"Яна", false}, //3 символа без пробела
                {"Я н", true}, //3 символа с пробелом в середине
                {" Ян", false}, //3 символа с пробелом в начале
                {"Ян ", false}, //3 символа с пробелом в конце
                {"Я н ", false}, //4 символа с двумя пробелами
                {" Я н", false}, //4 символа с двумя пробелами
                {"Лена", false}, //4 символа без пробела
                {"Ян а", true}, //4 символа с пробелом в середине
                {" Лев ", false}, //5 символов с пробелами по краям
                {"Лев Иванов", true}, //10 символов с пробелом в середине
                {"Лев Ив анов", false}, //11 символов с двумя пробелами в середине
                {" Лев Иванов ", false}, //12 символов с тремя пробелами
                {"Даниил Александров", true}, //18 символов с пробелом в середине
                {"АлександраДенисова", false}, //18 символов без пробела
                {"АлександраДенисович", false}, //19 символов без пробела
                {"Александра Денисова", true}, //19 символов с пробелом в середине
                {" АлександраДенисова", false}, //19 символов с пробелом
                {"АлександраДенисова ", false}, //19 символов с пробелом в конце
                {"Александра Денисович", false}, //20 символов с пробелом в середине {"", false}, //0 символов
                {"Александр Александров", false}, //21 символов с пробелом в середине
                {"Александр АлександровАлександровАлександров", false}, //43 символа с пробелом в середине
        };
    }

    @Test
    public void CheckNameForPrintingOnCardTest() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        Assert.assertEquals(expected, actual);
    }
}



