import java.util.Scanner;
public class PersonDemo
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        safeInputObj sio = new safeInputObj(in);
        Person p1 = new Person("1", "John", "Doe", "Mr.",  1990);
        Person p2 = new Person("2", "Jane", "Smith", "Ms.",  1985);

        System.out.println(p1.getFullName());
        System.out.println(p2.getFormalName());
        System.out.println(p1.toCSV());

        String id = sio.getNonZeroLenString("Enter ID: ");
        System.out.println(id);
    }
}
