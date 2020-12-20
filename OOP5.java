class laba5;

public class jornal extends weapons {
	private int date;
	private int page;
	private boolean edition;
	public jornal(String place, int date) {
		super(place, date);
		this.date = 1987;
		this.page = 270;
		this.edition = true;
	}
	public jornal(String place, int date, int page, int edition, boolean stels) {
		super(place, date);
		this.date = date;
		this.page = page;
		this.stels = true;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public boolean isStels() {
		return stels;
	}
	public void setStels(boolean stels) {
		this.stels = stels;
    }
    public void CodeOfJornal();
}
Scanner sc = new Scanner (System.in);
		System.out.print("Enter code of Jornal (1-3): ");
		int N = sc.nextInt(); 
		if (N == 1) {
			System.out.println(N + " - Jornal");
			System.out.println("Country - USSR");
			System.out.println("1987");
			System.out.println("Languages - English");
		}
		if (N == 2) {
			System.out.println(N + " - VOGUE");
			System.out.println("Country - USSR");
			System.out.println("1947");
			System.out.println("Languages - English");
		}
