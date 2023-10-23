package allysalLab3;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

class InvalidEmployeeDataException extends Exception {
    private static final long serialVersionUID = 1L; //StackOverflow

    public InvalidEmployeeDataException(String message) {
        super(message);
    }
}

class Payroll implements Serializable {
    private static final long serialVersionUID = 1L; //StackOverflow
    private String name;
    private String idNumber;
    private double hourlyPayRate;
    private double hoursWorked;

    public Payroll(String name, String idNumber) throws InvalidEmployeeDataException {
        if (name.isEmpty() || idNumber.isEmpty() || idNumber.equals("0")) {
            throw new InvalidEmployeeDataException("Invalid employee name or ID number.");
        }
        this.name = name;
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) throws InvalidEmployeeDataException {
        if (hourlyPayRate < 0 || hourlyPayRate > 25) {
            throw new InvalidEmployeeDataException("Invalid hourly pay rate.");
        }
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) throws InvalidEmployeeDataException {
        if (hoursWorked < 0 || hoursWorked > 84) {
            throw new InvalidEmployeeDataException("Invalid hours worked.");
        }
        this.hoursWorked = hoursWorked;
    }

    public double calculateGrossPay() {
        return hourlyPayRate * hoursWorked;
    }

    public void serializeToFile(String fileName) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {	//cousin
            objectOut.writeObject(this);
        }
    }

    public static Payroll deserializeFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            return (Payroll) objectIn.readObject();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter employee details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("ID Number: ");
        String idNumber = scanner.nextLine();

        try {
            Payroll employee = new Payroll(name, idNumber);

            System.out.print("Hourly Pay Rate: ");
            double hourlyPayRate = scanner.nextDouble();
            employee.setHourlyPayRate(hourlyPayRate);

            System.out.print("Hours Worked: ");
            double hoursWorked = scanner.nextDouble();
            employee.setHoursWorked(hoursWorked);

            double grossPay = employee.calculateGrossPay();
            System.out.println("Gross Pay: $" + grossPay);

            System.out.print("Enter a file name to serialize the object: ");
            String fileName = scanner.next();
            try {
                employee.serializeToFile(fileName);
                System.out.println("Object serialized to " + fileName);
            } catch (IOException e) {
                System.out.println("Serialization failed: " + e.getMessage());
            }
        } catch (InvalidEmployeeDataException | InputMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
