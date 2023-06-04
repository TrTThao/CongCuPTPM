import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;
public class SinhVien extends Nguoi implements Serializable {
	private String maSV;
    private Diem diem = new Diem();

    public void nhapSV() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhap ma sinh vien :");
            maSV = sc.nextLine();
            super.nhapNguoi();
            System.out.println("Nhap diem sinh vien");
            diem.nhapDiem();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SinhVien() {
    }

    public SinhVien(String maSV) {
        this.maSV = maSV;
    }

    public SinhVien(String maSV, Diem diem, String hoTen, int Tuoi, String gioiTinh) {
        super(hoTen, Tuoi, gioiTinh);
        this.maSV = maSV;
        this.diem = diem;
    }

    public void xuatDLSV() {
        System.out.printf("%20s %20s %20d %20s %20f %20f %20f %20f %n", maSV, super.getHoTen(), super.getTuoi(), super.getGioiTinh(), diem.getDiemToan(), diem.getDiemLy(), diem.getDiemHoa(), diem.getDiemTB());
    }

    public Diem getDiem() {
        return diem;
    }

    public void setDiem(Diem diem) {
        this.diem = diem;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.maSV);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SinhVien other = (SinhVien) obj;
        return Objects.equals(this.maSV, other.maSV);
    }

    public static void xuatTieuDe() {
        System.out.printf("%20s %20s %20s %20s %20s %20s %20s %20s %n", "Mã sinh viên ", "Họ tên", "Tuổi", "Giới tính", "Điêm Toán", "Điểm Lý", "Điểm Hóa", "Điểm TB");
    }
}
