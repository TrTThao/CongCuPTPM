import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class QLSV {
	public static ArrayList<SinhVien> dsSinhViens = new ArrayList<SinhVien>();
    public static Scanner sc = new Scanner(System.in);
    
    private static void menu() {
        System.out.println("1. Nhap thong tin sinh vien");
        System.out.println("2. Hien thi danh sach sinh vien");
        System.out.println("3. Hien thi sinh vien co diem trung binh lown hon 5 ");
        System.out.println("4. Hien thi sinh vien co diem trung binh thap nhat");
        System.out.println("5. Hien thi sinh vien co diem trung binh cao nhat");
        System.out.println("6. Sua thong tin sinh vien");
        System.out.println("7. Tim thong tin theo ma sinh vien");
        System.out.println("8. Sap xep");
        System.out.println("9. Xoa sinh vien theo ma sinh vien");
        System.out.println("10. Thoat");
        System.out.println("==================================");
    }

    public static void main(String[] args) {
        System.out.println("QUAN LY SINH VIEN");
        do {
            menu();
            try {
                System.out.print("Lua chon cua ban la :");
                int luaChon = Integer.parseInt(sc.nextLine());
                switch (luaChon) {
                    case 1:
                        nhapSinhVien();
                        break;
                    case 2:
                        hienThiSinhVien();
                        break;
                    case 3:
                        TimKiem();
                        break;
                    case 4:
                        minDTB();
                        break;
                    case 5:
                        maxDTB();
                        break;
                    case 6:
                        suaThongTin();
                        break;
                    case 7:
                        hienThiSVTheoMaSV();
                        break;
                    case 8:
                        sapXep();
                        break;
                    case 9:
                        xoaSV();
                        break;
                    case 10:
                        System.out.println("BYE");
                        System.exit(1);
                        break;
                    default:
                        System.out.println("Ban nhap sai lua chon roi, moi nhap lai");
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (true);
    }

    private static void nhapSinhVien() {
        SinhVien sv = new SinhVien();
        sv.nhapSV();
        dsSinhViens.add(sv);
    }

    private static void hienThiSinhVien() {
        SinhVien.xuatTieuDe();
        for (SinhVien it : dsSinhViens) {
            it.xuatDLSV();
        }
    }

    private static void TimKiem() {
        SinhVien.xuatTieuDe();
        int dem = 0;
        for (SinhVien it : dsSinhViens) {
            if (it.getDiem().getDiemTB() >= 5) {
                dem++;
                it.xuatDLSV();
            }
        }
        if (dem == 0) {
            System.out.println("Khong co sinh vien nao !");
        }
    }

    private static void minDTB() {
        double min = Double.MAX_VALUE;
        int viTri = -1;
        for (int i = 0; i < dsSinhViens.size(); i++) {
            if (dsSinhViens.get(i).getDiem().getDiemTB() < min) {
                min = dsSinhViens.get(i).getDiem().getDiemTB();
                viTri = i;
            }
        }
        SinhVien.xuatTieuDe();
        for (SinhVien it : dsSinhViens) {
            if (it.getDiem().getDiemTB() == min) {
                System.out.println("Vị trí : " + viTri);
                it.xuatDLSV();
            }

        }
    }

    private static void maxDTB() {
        double max = Double.MIN_VALUE;
        int viTri = -1;
        for (int i = 0; i < dsSinhViens.size(); i++) {
            if (dsSinhViens.get(i).getDiem().getDiemTB() > max) {
                max = dsSinhViens.get(i).getDiem().getDiemTB();
                viTri = i;
            }
        }
        SinhVien.xuatTieuDe();
        for (SinhVien it : dsSinhViens) {
            if (it.getDiem().getDiemTB() == max) {
                System.out.println("Vị trí : " + viTri);
                it.xuatDLSV();
            }
        }
    }

    private static void suaThongTin() {
        System.out.println("Nhap lai ma sinh vien can sua : ");
        String maSV = sc.nextLine();
        int index = dsSinhViens.indexOf(new SinhVien(maSV));
        if (index >= 0) {
            System.out.println("Nhap la thong tin sinh vien !");
            dsSinhViens.get(index).nhapSV();
        } else {
            System.out.println("Khong co sinh vien co ma sinh vien theo yeu cau sua!");
        }
    }

    private static void sapXep() {
        Comparator<SinhVien> comparator = new Comparator<SinhVien>() {
            public int compare(SinhVien o1, SinhVien o2) {
                if (o1.getDiem().getDiemTB() - o2.getDiem().getDiemTB() > 0) {
                    return 1;
                } else if (o1.getDiem().getDiemTB() - o2.getDiem().getDiemTB() < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        Collections.sort(dsSinhViens, comparator);
        hienThiSinhVien();
    }

    private static void hienThiSVTheoMaSV() {
        System.out.println("Nhap ma sinh vien can tim : ");
        String maSV = sc.nextLine();
        int index = dsSinhViens.indexOf(new SinhVien(maSV));
        if (index >= 0) {
            SinhVien.xuatTieuDe();
            dsSinhViens.get(index).xuatDLSV();
        } else {
            System.out.println("Khong co sinh vien can tim");
        }
    }

    private static void xoaSV() {
        System.out.println("Nhap ma sinh vien can xoa : ");
        String maSV = sc.nextLine();
        int index = dsSinhViens.indexOf(new SinhVien(maSV));
        if (index >= 0) {
            dsSinhViens.remove(new SinhVien(maSV));
            System.out.println("Xoa thanh cong");
        } else {
            System.out.println("khong co sinh vien co ma sinh vien theo yeu cau xoa");

        }
    }
}
