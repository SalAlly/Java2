package AllySalLab2;

public class Main {
    public static void main(String[] args) {
        
        PreferredCustomer customer = new PreferredCustomer("Mik3e John", "123 Main St", "330-123-4567", 1001, true);

       
        customer.makePurchase(600);
        customer.makePurchase(800);
        customer.makePurchase(1600);

       
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Customer Address: " + customer.getAddress());
        System.out.println("Customer Telephone: " + customer.getTelephone());
        System.out.println("Customer Number: " + customer.getCustomerNumber());
        System.out.println("Is on Mailing List: " + customer.isOnMailingList());
        System.out.println("Total Purchases: $" + customer.getPurchases());
        System.out.println("Discount Level: " + customer.getDiscountLevel() + "%");
    }
}
