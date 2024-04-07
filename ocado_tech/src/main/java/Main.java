import java.util.List;
import java.util.Map;

import basket.BasketSplitter;
import basket.BasketReader;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: jar -j jarname absolute_path_to_the_basket");
            return;
        }

        String absolutePathToBasketFile = args[0];
        int totalDeliveryMethods = 0;

        BasketReader reader = new BasketReader();
        List<String> basketItems = reader.readBasketItems(absolutePathToBasketFile);

        BasketSplitter splitter = new BasketSplitter("D:/java dumpster/ocado_tech/config.json");
        Map<String, List<String>> dividedProducts = splitter.split(basketItems);

        for (Map.Entry<String, List<String>> entry : dividedProducts.entrySet()) {
            System.out.println("Delivery Method: " + entry.getKey());
            System.out.println("Products: " + entry.getValue());
            System.out.println("\n");
            totalDeliveryMethods += entry.getKey().equals("") ? 0 : 1;
        }
        System.out.println("Minimum found number of deliveries:" + totalDeliveryMethods);
    }
}
