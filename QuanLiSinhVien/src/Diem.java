import java.io.Serializable;
import java.util.Scanner;
public class Diem implements Serializable {
	private double diemToan, diemLy, diemHoa, diemTB;

    public Diem() {
    }

    public Diem(double diemToan, double diemLy, double diemHoa) {
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
    }

    public double getDiemToan() {
		return diemToan;
	}

	public void setDiemToan(double diemToan) {
		this.diemToan = diemToan;
	}

	public double getDiemLy() {
		return diemLy;
	}

	public void setDiemLy(double diemLy) {
		this.diemLy = diemLy;
	}

	public double getDiemHoa() {
		return diemHoa;
	}

	public void setDiemHoa(double diemHoa) {
		this.diemHoa = diemHoa;
	}

	public void nhapDiem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Diem toan :");
        diemToan = Double.parseDouble(sc.nextLine());
        System.out.print("Diem ly :");
        diemLy = Double.parseDouble(sc.nextLine());
        System.out.print("Diem hoa :");
        diemHoa = Double.parseDouble(sc.nextLine());
    }
    public double getDiemTB(){
        return (diemToan+diemLy+diemHoa)/3;
    }
}
