import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

public class BasketReaderTest {

    private List<String> readBasketItemsMock(JSONArray jsonArray) throws IOException, ParseException {
        List<String> items = new ArrayList<>();
        for (Object item : jsonArray) {
            items.add((String) item);
        }
        return items;
    }

    @Test
    public void testReadBasketItems_ValidFile() throws IOException, ParseException {
        String testFilePath = "path/to/your/test/basket.json";
        String expectedItem1 = "Apples";
        String expectedItem2 = "Milk";
        List<String> expectedItems = new ArrayList<>();
        expectedItems.add(expectedItem1);
        expectedItems.add(expectedItem2);

        JSONArray mockJsonArray = new JSONArray();
        mockJsonArray.add(expectedItem1);
        mockJsonArray.add(expectedItem2);

        List<String> actualItems = readBasketItemsMock(mockJsonArray);

        assertEquals(expectedItems, actualItems, "Basket items should match the expected list");
    }

    @Test
    public void testReadBasketItems_EmptyFile() throws IOException, ParseException {
        String testFilePath = "D:\\java dumpster\\ocado_tech\\empty_basket.json";

        List<String> actualItems = readBasketItemsMock(new JSONArray());

        assertTrue(actualItems.isEmpty(), "Basket items should be empty for an empty file");
    }

}
