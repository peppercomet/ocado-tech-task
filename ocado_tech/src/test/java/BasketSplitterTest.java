import static org.junit.Assert.assertEquals;

import basket.BasketSplitter;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BasketSplitterTest {

    @Test
    public void testSplit() {
        BasketSplitter splitter = new BasketSplitter("D:\\java dumpster\\ocado_tech\\config.json");

        List<String> items = Arrays.asList(
                "Cookies Oatmeal Raisin",
                "Cheese Cloth",
                "English Muffin",
                "Ecolab - Medallion"
        );

        Map<String, List<String>> dividedProducts = splitter.split(items);

        System.out.println(dividedProducts);

        assertEquals(2, dividedProducts.size());

        assertEquals(Arrays.asList("Cookies Oatmeal Raisin", "Cheese Cloth"), dividedProducts.get("Pick-up point"));
        assertEquals(Arrays.asList("English Muffin", "Ecolab - Medallion"), dividedProducts.get("Mailbox delivery"));

    }
}
