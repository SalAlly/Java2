package AllySalLab2;

class PreferredCustomer extends Customer {
    private double purchases;
    private int discountLevel;

    public PreferredCustomer(String name, String address, String telephone, int customerNumber, boolean onMailingList) {
        super(name, address, telephone, customerNumber, onMailingList);
        this.purchases = 0.0;
        this.discountLevel = 0;
    }

   
    public double getPurchases() {
        return purchases;
    }

    public int getDiscountLevel() {
        return discountLevel;
    }

  
    public void makePurchase(double amount) {
        purchases += amount;
        updateDiscountLevel();
    }

    private void updateDiscountLevel() {
        if (purchases >= 2000) {
            discountLevel = 10;
        } else if (purchases >= 1500) {
            discountLevel = 7;
        } else if (purchases >= 1000) {
            discountLevel = 6;
        } else if (purchases >= 500) {
            discountLevel = 5;
        }
    }
}