package QuanLySanPham.manager;

import QuanLySanPham.product.Product;
import QuanLySanPham.io.IOProduct;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Product> products = new ArrayList<>();

    public Product infProduct() {

        System.out.println("Nhập mã sản phẩm: ");
        String code = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập số lượng sản phẩm: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mô tả sản phẩm: ");
        String describe = scanner.nextLine();

        Product product = new Product(code, name, price, quantity, describe);
        System.out.println(product);
        return product;
    }

    public void show() {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public void add() {
        Product product = infProduct();
        products.add(product);
    }

    public void update() {
        System.out.println("Nhập mã sản phẩm bạn muốn sửa: ");
        String code = scanner.nextLine();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCode().equals(code)) {
                products.set(i, infProduct());
            }
        }
    }

    public void delete() {
        System.out.println("Nhập mã sản phẩm bạn muốn xóa:  ");
        String code = scanner.nextLine();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCode().equals(code)) {
                products.remove(i);
                break;
            }
        }
    }

    public void sort() {
        int choose = 2;
        System.out.println("1. Giá tăng dần");
        System.out.println("2. Giá giảm dần");
        System.out.println("Nhập số để lựa chọn: ");
        do {
            if (choose > 2) System.out.println("Vui lòng nhập lại");
            choose = Integer.parseInt(scanner.nextLine());
        } while (choose > 2);

        switch (choose) {
            case 1 -> ascending();
            case 2 -> decrease();
        }
    }


    public void ascending() {
        Product temp;
        for (int i = 0; i < products.size() - 1; i++) {
            for (int j = i + 1; j < products.size(); j++) {
                if (products.get(i).getPrice() > products.get(j).getPrice()) {
                    temp = products.get(i);
                    products.set(i, products.get(j));
                    products.set(j, temp);
                }
            }
        }
        show();

    }

    public void decrease() {

        Product temp;
        for (int i = 0; i < products.size() - 1; i++) {
            for (int j = i + 1; j < products.size(); j++) {
                if (products.get(i).getPrice() < products.get(j).getPrice()) {
                    temp = products.get(i);
                    products.set(i, products.get(j));
                    products.set(j, temp);
                }
            }
        }

        show();

    }

    public void findTheMostExpensiveProduct() {
        double max = products.get(0).getPrice();
        for (int i = 1; i < products.size(); i++) {
            if (max < products.get(i).getPrice()) {
                max = products.get(i).getPrice();
            }
        }
        for (Product product : products) {
            if (max == product.getPrice()) {
                String str = product.toString();
                System.out.println(str);
            }
        }
    }


    public void ReadFromFile() {
        products = IOProduct.read();
    }


    public void WriteToFile() {

        IOProduct.write(products);
    }


}
