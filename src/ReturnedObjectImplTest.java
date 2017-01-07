
public class ReturnedObjectImplTest {

	public static void main(String[] args) {
		
		ErrorMessage err = ErrorMessage.INDEX_OUT_OF_BOUNDS;
		ReturnObjectImpl object1 = new ReturnObjectImpl(err);
		
		boolean test1 = object1.hasError();
		System.out.println(test1);
		System.out.println(object1.getError());
		System.out.println(object1.getReturnValue());
		
		String str = "whatever";
		ReturnObjectImpl object2 = new ReturnObjectImpl( str );
		System.out.println (object2.hasError());
		System.out.println (object2.getError());
		
		//object2.setOperationResult(null);
		//String s = (String)object2.getReturnValue();
		System.out.println ( object2.getReturnValue() );
		
	}
	
}

