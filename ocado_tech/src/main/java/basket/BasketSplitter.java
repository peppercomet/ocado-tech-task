package basket;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class BasketSplitter {

    private Map<String, List<String>> productDeliveryMap;

    public BasketSplitter(String absolutePathToConfigFile) {
        this.productDeliveryMap = loadDeliveryConfig(absolutePathToConfigFile);
    }

    public Map<String, List<String>> split(List<String> items) {
        Map<String, List<String>> dividedProducts = new TreeMap<>();
        int deliveryMethodCount = 0;

        for (String item : items) {
            List<String> deliveryMethods = productDeliveryMap.get(item);
            String bestMatch = null;
            int maxOverlap = 0;

            for (String method : deliveryMethods) {
                int overlap = 0;
                for (String existingGroupMethod : dividedProducts.keySet()) {
                    if (method.equals(existingGroupMethod)) {
                        overlap++;
                    }
                }
                if (overlap > maxOverlap) {
                    maxOverlap = overlap;
                    bestMatch = method;
                }
            }

            if (bestMatch == null) {
                String selectedMethod = deliveryMethods.iterator().next();
                dividedProducts.put(selectedMethod, new ArrayList<>());
                bestMatch = selectedMethod;
                ++deliveryMethodCount;
            }

            dividedProducts.get(bestMatch).add(item);
        }

        return dividedProducts;
    }


    private Map<String, List<String>> loadDeliveryConfig(String absolutePathToConfigFile) {
        JSONParser parser = new JSONParser();
        Map<String, List<String>> deliveryMap = new HashMap<>();

        try (FileReader reader = new FileReader(absolutePathToConfigFile)) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            for (Object key : jsonObject.keySet()) {
                String productName = (String) key;
                JSONArray deliveryMethodsArray = (JSONArray) jsonObject.get(key);
                List<String> deliveryMethods = new ArrayList<>();
                for (Object method : deliveryMethodsArray) {
                    deliveryMethods.add((String) method);
                }
                deliveryMap.put(productName, deliveryMethods);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return deliveryMap;
    }
}
