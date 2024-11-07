package decorator_design_pattern;

public class Customer {

    String customerName;

    int customerLoyaltyStatus;

    Order order;

    public Customer(String customerName, int customerLoyaltyStatus, Order order) {
        this.customerName = customerName;
        this.customerLoyaltyStatus = customerLoyaltyStatus;
        this.order = order;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerLoyaltyStatus() {
        return customerLoyaltyStatus;
    }

    public void setCustomerLoyaltyStatus(int customerLoyaltyStatus) {
        this.customerLoyaltyStatus = customerLoyaltyStatus;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
