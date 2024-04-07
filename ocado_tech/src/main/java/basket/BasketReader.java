package basket;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BasketReader {

    public List<String> readBasketItems(String absolutePathToBasketFile) {
        JSONParser parser = new JSONParser();
        List<String> basketItems = null;

        try (FileReader reader = new FileReader(absolutePathToBasketFile)) {
            JSONArray jsonArray = (JSONArray) parser.parse(reader);
            basketItems = jsonArray.subList(0, jsonArray.size());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return basketItems;
    }
}
