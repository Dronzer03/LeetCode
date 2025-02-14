package HashTable;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CouponsWayfair {
    class Coupon {
        String couponName;
        String categoryName;
        Date lastModified;
        Double discount;

        public Coupon(String couponName, String categoryName, Date lastModified, Double discount) {
            this.couponName = couponName;
            this.categoryName = categoryName;
            this.lastModified = lastModified;
            this.discount = discount;
        }
    }
    Map<String, Coupon> couponsMap = new HashMap<>();
    Map<String, String> parentMap = new HashMap<>();
    Map<String, Double> priceMap = new HashMap<>();

    CouponsWayfair(String[][] coupons, String[][] categories, String[][] products) {
        for (String[] category : categories) {
            String categoryName = category[0];
            String parent = category[1];
            if (parent != null)
                parentMap.put(categoryName, parent);
        }

        for (String[] coupon : coupons) {
            String categoryName = coupon[0];
            String couponName = coupon[1];
            Date date = Date.from(LocalDate.parse(coupon[2]).atStartOfDay(ZoneId.systemDefault()).toInstant());
            Double discount = Double.parseDouble(coupon[3]);
            Coupon c = new Coupon(couponName, categoryName, date, discount);
            if (couponsMap.containsKey(categoryName)) {
                Coupon existing = couponsMap.get(categoryName);
                couponsMap.put(categoryName, c.lastModified.after(existing.lastModified) ? c : existing);
            } else {
                couponsMap.put(categoryName, c);
            }

        }

        for (String category : parentMap.keySet()) {
            if (!couponsMap.containsKey(category)) {
                findCoupon(category);
            }
        }

        for (String[] product : products) {
            String category = product[2];
            Double price = Double.parseDouble(product[1]);
            Coupon coupon = couponsMap.getOrDefault(category, null);
            if (coupon != null) {
                price -= price * coupon.discount / 100;
            }
            priceMap.put(product[0], price);
        }

    }
    public Coupon findCoupon(String category) {
        if (couponsMap.containsKey(category)) {
            return couponsMap.get(category);
        } else if (parentMap.containsKey(category)) {
            Coupon result = findCoupon(parentMap.get(category));
            if (!couponsMap.containsKey(category))
                couponsMap.put(category, result);
            return result;
        }
        return null;
    }

    public String findCouponName(String category) {
        Coupon result = findCoupon(category);
        return result == null ? null : result.couponName;
    }

    public Double findPrice(String productName) {
        return priceMap.getOrDefault(productName, null);
    }

    public static void main(String[] args) {
        String[][] coupons = {
                {"Comforter Sets", "Comforters Sale", "2020-01-01", "10.00"},
                {"Comforter Sets", "Cozy Comforter Coupon", "2020-01-01", "15.00"},
                {"Bedding", "Savings on Bedding", "2020-01-01", "10.00"},
                {"Bed & Bath", "Low price for Bed & Bath", "2020-01-01", "10.00"}
        };

        String [][] categories = {
                {"Comforter Sets", "Bedding"},
                {"Bedding", "Bed & Bath"},
                {"Bed & Bath", null},
                {"Soap Dispensers", "Bathroom Accessories"},
                {"Bathroom Accessories", "Bed & Bath"},
                {"Toy Organizers", "Baby And Kids"},
                {"Baby And Kids", null}
        };

        String[][] products = {
                {"Cozy Comforter Sets","100.00", "Comforter Sets"},
                {"All-in-one Bedding Set", "50.00", "Bedding"},
                {"Infinite Soap Dispenser", "500.00" ,"Bathroom Accessories"},
                {"Rainbow Toy Box","257.00", "Baby And Kids"}
        };

        CouponsWayfair couponsWayfair = new CouponsWayfair(coupons, categories, products);
        System.out.println(couponsWayfair.findCoupon("Bathroom Accessories").couponName);
        System.out.println(couponsWayfair.findCoupon("Comforter Sets"));
        System.out.println(couponsWayfair.findCoupon("Bedding"));
        System.out.println(couponsWayfair.findCoupon("Soap Dispensers"));
        System.out.println(couponsWayfair.findCoupon("Toy Organizers"));

        System.out.println(couponsWayfair.findPrice("Cozy Comforter Sets"));
    }
}
