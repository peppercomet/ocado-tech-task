# Basket Splitter Library - Recruitment task for Ocado Technology
Artyom_Zelenovski_Java_Wroclaw

## Run Locally
```bash
java -jar ocado_tech.jar <absolute_path_to_the_basket>
```
Replace <absolute_path_to_the_basket> with the absolute path to your basket file.
## Algorithm Functionality

Algorithm splits a list of items into a map of delivery methods with the best overlap. It does this by iterating through the input list of items and finding the best delivery method for each item based on existing groups.
For each item, the method finds the list of available delivery methods and selects the one with the maximum overlap with existing groups. If no best match is found, a new delivery method group is created.
The method populates the output map with the chosen delivery methods as keys and lists of items as values.

Time Complexity:
```bash
T(n, m, z) = O(n) * O(m) * O(z) = O(n * m * z)
```
Where,
-  'n' factor comes from iterating through the n basket items.
-  'm' factor comes from the average number of delivery methods checked per item.
-  'z' factor comes from the potential need to compare against all existing m delivery groups in the worst case for each item.

The limited basket size (100 items) and delivery options (10 per item) keep n and m relatively constant, which significantly reduces the practical complexity of the algorithm compared to the theoretical worst-case scenario.
## Testing

To run the tests:

- Compile the test files along with the application files.
- Execute the test class using a JUnit test runner.
