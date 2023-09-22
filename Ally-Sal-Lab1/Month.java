package AllySalLab1;


public class Month {
public static void main(String[] args) {

    Month january = new Month();
    Month february = new Month (2);
    Month march = new Month("march");
    Month april = new Month(4);
    Month may = new Month(5);
    Month june = new Month(6);
    Month july = new Month(7);
    Month august = new Month(8);
    Month semptember = new Month(9);
    Month october = new Month(10);
    Month november = new Month(11);
    Month december = new Month(12);
    System.out.println(january.getMonthNumber());
    System.out.println(april.getMonthNumber());
    System.out.println(march.getMonthName());
    System.out.println(february.lessThan(may));
    System.out.println(july.greaterThan(june));
    System.out.println(august.equals(semptember));
    november.setMonthNumber(13);
    System.out.println(november.getMonthNumber());
    System.out.println(october.toString());
    System.out.println(december.getMonthName());
    





}
   
    private int monthNumber;

    public Month() {
        monthNumber = 1;
    }

    public Month(int monthNumber) {
        if (monthNumber >= 1 && monthNumber <= 12) {
            this.monthNumber = monthNumber;
        } else {
            this.monthNumber = 1;
        }
    }

    public Month(String monthName) {
        switch (monthName.toLowerCase()) {
            case "january":
                this.monthNumber = 1;
                break;
            case "february":
                this.monthNumber = 2;
                break;
            case "march":
                this.monthNumber = 3;
                break;
            case "april":
                this.monthNumber = 4;
                break;
            case "may":
                this.monthNumber = 5;
                break;
            case "june":
                this.monthNumber = 6;
                break;
            case "july":
                this.monthNumber = 7;
                break;
            case "august":
                this.monthNumber = 8;
                break;
            case "september":
                this.monthNumber = 9;
                break;
            case "october":
                this.monthNumber = 10;
                break;
            case "november":
                this.monthNumber = 11;
                break;
            case "december":
                this.monthNumber = 12;
                break;
            default:
                this.monthNumber = 1;
                break;
        }
    }

    public void setMonthNumber(int monthNumber) {
        if (monthNumber >= 1 && monthNumber <= 12) {
            this.monthNumber = monthNumber;
        } else {
            this.monthNumber = 1;
        }
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public String getMonthName() {
        switch (monthNumber) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "Invalid Month";
        }
    }

    public String toString() {
        return getMonthName();
    }

    public boolean equals(Month otherMonth) {
        return this.monthNumber == otherMonth.monthNumber;
    }

    public boolean greaterThan(Month otherMonth) {
        return this.monthNumber > otherMonth.monthNumber;
    }

    public boolean lessThan(Month otherMonth) {
        return this.monthNumber < otherMonth.monthNumber;
    }
    
}

