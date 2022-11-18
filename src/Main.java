public class Main {
    public static void main(String[] args) {
        try {
            jdbcDriver driver = new jdbcDriver();
            if (driver.tryConnection()) {
                System.out.println("Success");
            } else {
                System.out.println("Failed");
            }
            driver.delete(2);
            driver.add(2, "Ahmed Adel", "01022222222");
            driver.update(1, "01011111111");
            driver.add(3, "Muhannad Essam", "01033333333");
            driver.delete(3);
            driver.searchId(1);
            driver.searchName("Ahmed Adel");
            driver.getAllData();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}