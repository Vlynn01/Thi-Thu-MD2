package QuanLySanPham;

import QuanLySanPham.manager.Manager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();

        int choice;
        do {
            String menu = """
                    ______________________________________________
                                Quản lý sản phẩm
                    1. Xem danh sách
                    2. Thêm mới
                    3. Cập nhật
                    4. Xóa
                    5. Sắp xếp
                    6. Tìm sản phẩm có giá đắt nhất
                    7. Đọc từ file
                    8. Ghi vào file
                    0. Thoát
                    
                    Nhập số để chọn chức năng:
                    """;
            System.out.println(menu);

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> manager.show();
                case 2 -> manager.add();
                case 3 -> manager.update();
                case 4 -> manager.delete();
                case 5 -> manager.sort();
                case 6 -> manager.findTheMostExpensiveProduct();
                case 7 -> manager.ReadFromFile();
                case 8 -> manager.WriteToFile();
            }
        } while (choice != 0);
    }

}
