// OOП2.cpp : Этот файл содержит функцию "main". Здесь начинается и заканчивается выполнение программы.
//public class Program {

public class Program {

public static void main(String[] args)
{
	people people = new people("Maria Ivanova", 5.6);
	people1.GetInfoofPeople();
	Subject subject1 = new Subject("math");
	subject.GetSubject();
	Client client1 = new Client("Roman Petrov", "PE");
	client1.GetInfoofClient();
	Client client2 = new Client("Natalia Vladimirovna", "Math");
	client2.GetInfoofClient()
}
}

public class Subject {

	private String nameSubject;

	public Subject(String nameSubject)
	{
		this.nameSubject = nameSubject;
	}

	public void GetSibject()
	{
		System.out.printf("The %s starts now\n", nameSubject);

	}

}

public class Client {

	private String name;
	private String LastName;
	private String nameSubjects;

	public Client(String name, String LastName, String nameSubjects)
	{
		this.name = name;
		this.LastName = LastName;
		ths.nameSubjects = nameSubjects;
	}
	public void GetInfoofClient()
	{

		System.out.printf("Client %s %s starts a %s lesson\n", name, LastName, nameSubjects);


	}
}

public class people {

	private String name;
	private String LastName;
	private double rating;

	public people(String name, String LastName, double rating)
	{
		this.name = name;
		this.LastName = LastName;
		this.rating = ratting;
	}

	public void GetInfoofPeople()
	{
		System.out.printf("Pupli %s %s came to the lesson and his rating(%s) increased by 1\n", name, LastName, rating);