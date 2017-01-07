
public class ArrayListImplTest {

    public static void main(String[] args) {

        ArrayListImpl someList = new ArrayListImpl();
        someList.add(8);
        someList.add(10);
        someList.add(44);
        System.out.println(someList);

        System.out.println(someList.get(1).getReturnValue());
        System.out.println(someList.get(3).getReturnValue());

        System.out.println(someList.remove(1).getReturnValue());
        System.out.println(someList);

        System.out.println(someList.remove(99).getError());
        System.out.print("remove(99): ");
        System.out.println(someList);

        System.out.println(someList.remove(-1).getError());
        System.out.println(someList);

        System.out.println(someList.remove(1).getReturnValue());
        System.out.println(someList);

    }

}
