package laba4;

public class Starter {
	public static void main(String[] args) {
		System.out.println("Books: ");

		var books = new books ("USSR", 1946, "USSR NEWS", 300);
		System.out.println("What book edition? " + books.getEdition());
		System.out.println("How many book per page? " + books.getPage());
		System.out.println("What is the qenre of the book ? " + books.getGenre());

		System.out.println("Journal: ");

		var jornals  = new jornals ("USSR", 1987, 250, 270, true);
		System.out.println("When was the log produced? " + jornals.getDate());
		System.out.println("Who participated in the shooting? " + jornals.getPage());
		System.out.println("What jornal edition? " + jornals.geteEdition());
		System.out.println("What year of issue is the jornal? " + jornals.getDate());
		System.out.println("Who is the editor of the jornal? " + jornals.isEditor());

		System.out.println("Electronic resource: ");

		electronic resource electronic resource = new electronic resource ("USA", "Ivanov", "Tilda", "English");
		System.out.println("Who founded this resource? " + electronic resource.getFounded());
		System.out.println("What platform is it on? " + rifles.getPlatform());
		System.out.println("What languages does it support? " + rifles.getLanguages());
		System.out.println("What is included in the resource? " + rifles.getIncluded());
} 
 лабораторная 4 ООП/Lab4/src/lab4/jornals.java 
@@ -0,0 +1,37 @@
package lab4;

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
	public aviation(String place, int date, int page, int edition, boolean stels) {
		super(place, date);
		this.calibr = calibr;
		this.speed = speed;
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
}
 38  лабораторная 4 ООП/Lab4/src/lab4/electronic resource.java 
@@ -0,0 +1,38 @@
package lab4;

public class el;electronic resource extends weapons {
	private double founded;
	private String platform;
	private int languages;
	public electronic resource(){};
	public electronic resource(String place, int date) {
		super(place, date);
		this.founded = Ivanov;
		this.platform = "Tilda";
		this.languages = English;
	}
	public electronic resource(String place, int date, double calibr, String model, int range) {
		super(place, date);
		this.founded = founded;
		this.platform = platform;
		this.languages = languages;
	}
	public double getFounded() {
		return founded;
	}
	public void setFounded(double founded) {
		this.founded = founded;
	}
	public String getPlatform() {
		return Platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public int getLanguages() {
		return languages;
	}
	public void setLanguages(int languages) {
		this.languages = languages;
	}
}
 19  лабораторная 4 ООП/Lab4/src/lab4/electronicresource.java 
@@ -0,0 +1,19 @@
package lab4;

public class books extends weapons {
	private int edition;
	private int page;
	public books(String place, int date) {
		super(place, date);
		this.edition = USSR NEWS;
		this.page = 300;
	}
	public books(String place, int date, int page, int edition) {
		super(place, date);
		this.page = page;
		this.edition = edition;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int Edition) {
		this.edition = edition;
	}
}
 23  лабораторная 4 ООП/Lab4/src/lab4/books.java 
@@ -0,0 +1,23 @@
package lab4;
}
