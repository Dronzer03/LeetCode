package Arrays;

import java.util.*;

public class OrderManagementSystemWayfair {
}

interface IOrder {
    String getName();
    void setName(String name);
    double getPrice();
    void setPrice(double price);
}

interface IOrderSystem {
    void addToCart(IOrder order);
    void removeFromCart(IOrder order);
    double calculateTotalAmount();
    Map<String, Double> categoryDiscounts();
    Map<String, Integer> cartItems();
}

class Order implements IOrder {
    String name;
    double price;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}

class OrderManagementSystem implements IOrderSystem {
    Map<String, Integer> cartItemsCount = new HashMap<>();
    Map<String, Double> categoryDiscounts = new HashMap<>();
    Map<String, Set<IOrder>> cart = new HashMap<>();
    Map<String, Integer> discountPercentage = new HashMap<>();
    double totalAmount = 0;

    OrderManagementSystem() {
        discountPercentage.put("CHEAP", 10);
        discountPercentage.put("MODERATE", 20);
        discountPercentage.put("EXPENSIVE", 30);
    }

    @Override
    public void addToCart(IOrder order) {
        if (Objects.nonNull(order)) {
            String name = order.getName();
            String category = findCategory(order.getPrice());
            double discount = getDiscount(order, category);
            categoryDiscounts.put(category, categoryDiscounts.getOrDefault(category, 0.0) + discount);

            double finalPrice = order.getPrice() - discount;
            cart.putIfAbsent(name, new HashSet<>());
            cart.get(name).add(order);
            cartItemsCount.put(name, cartItemsCount.getOrDefault(name, 0) + 1);
            totalAmount += finalPrice;
        }
    }

    @Override
    public void removeFromCart(IOrder order) {
        if (cart.containsKey(order.getName())) {
            Set<IOrder> orders = cart.get(order.getName());
            if (orders.contains(order)) {
                orders.remove(order);
                cartItemsCount.put(order.getName(), cartItemsCount.get(order.getName()) - 1);
                String category = findCategory(order.getPrice());
                double discount = getDiscount(order, category);
                totalAmount -= order.getPrice() + discount;
                categoryDiscounts.put(category, categoryDiscounts.get(category) - discount);
            }
        }
    }

    @Override
    public double calculateTotalAmount() {
        return totalAmount;
    }

    @Override
    public Map<String, Double> categoryDiscounts() {
        return categoryDiscounts;
    }

    @Override
    public Map<String, Integer> cartItems() {
        return cartItemsCount;
    }

    private double getDiscount(IOrder order, String category) {
        double discountPercent = getDiscountPercentage(category);
        return order.getPrice() * discountPercent / 100 ;
    }

    private int getDiscountPercentage(String category) {
        return discountPercentage.get(category);
    }

    private String findCategory(double price) {
        if (price < 10) {
            return "CHEAP";
        } else if (price >= 10 && price <= 20) {
            return "MODERATE";
        } else {
            return "EXPENSIVE";
        }
    }
}