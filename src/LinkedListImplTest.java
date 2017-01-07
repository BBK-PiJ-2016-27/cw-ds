
public class LinkedListImplTest {

    public static void main(String[] args) {

        LinkedListImpl myList = new LinkedListImpl();
        myList.add(6);
        myList.add(7);
        myList.add(8);

        System.out.println(myList.remove(0).getReturnValue());
        System.out.println(myList);
        System.out.println(myList.remove(0).getReturnValue());
        System.out.println(myList);

        System.out.println(myList.remove(0).getReturnValue());

        System.out.println(myList);

        ReturnObject ret = myList.remove(2);

        if (ret.hasError()) {
            System.out.println("error: " + ret.getError());
        } else {
            System.out.println("value: " + ret.getReturnValue());
        }
    }
}
