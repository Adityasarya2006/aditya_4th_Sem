public class PetrolMileageCalculator {

    // Shows arithmetic operators: + - * / %
    // Example: Petrol and Mileage Calculation

    public static void main(String[] args) {

        // Store values
        int petrolLitres = 5;     // petrol filled
        int distanceKm = 250;     // distance travelled
        int petrolPrice = 105;    // price per litre

        // Total petrol cost
        int totalCost = petrolLitres * petrolPrice;

        // Mileage calculation
        int mileage = distanceKm / petrolLitres;

        // Extra example using modulus operator
        int remainder = distanceKm % petrolLitres;

        // Display results
        System.out.println("Petrol Filled:   " + petrolLitres + " litres");
        System.out.println("Distance Travelled: " + distanceKm + " km");
        System.out.println("Petrol Price:    Rs." + petrolPrice);

        System.out.println("Total Cost:      Rs." + totalCost);
        System.out.println("Mileage:         " + mileage + " km/litre");

        System.out.println("Remainder using % operator: " + remainder);

    }
}