public class PersonDemo
{
    public static void main(String[] args)
    {
        Person p1 = new Person("1", "John", "Doe", "Mr.", "1, John, Doe, Mr., 1990", 1990);
        Person p2 = new Person("2", "Jane", "Smith", "Ms.", "2, Jane, Smith, Ms., 1985", 1985);

        System.out.println(p1.getFullName());
        System.out.println(p2.getFormalName());
        System.out.println(p1.toCSV());
    }
}
