import java.util.Scanner;
public class Nguoi {
	private String hoTen;
    private int Tuoi;
    private String gioiTinh;

    public Nguoi() {
    }

    public Nguoi(String hoTen, int Tuoi, String gioiTinh) {
        this.hoTen = hoTen;
        this.Tuoi = Tuoi;
        this.gioiTinh = gioiTinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setTuoi(int Tuoi) {
        this.Tuoi = Tuoi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void nhapNguoi() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho ten :");
        hoTen = sc.nextLine();
        System.out.print("Nhap tuoi:");
        Tuoi = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap gioi tinh :");
        gioiTinh = sc.nextLine();
    }
}
