
public class ReturnObjectImpl implements ReturnObject {

    private boolean containsError; // false
    private ErrorMessage errorMsg; // null
    private Object operationResult; // null

    // constructor is used to indicate the operation
    // was successful
    public ReturnObjectImpl(Object operationResult) {
        this.containsError = false;
        this.errorMsg = ErrorMessage.NO_ERROR;
        this.operationResult = operationResult;
    }

    // constructor is used to indicate we cannot retrieve the
    // computation result and it sets an error message
    // passed as an argument
    public ReturnObjectImpl(ErrorMessage errorMsg) {
        this.containsError = true;
        this.errorMsg = errorMsg;
        this.operationResult = null;
    }

    @Override
    public boolean hasError() {
        if (containsError) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ErrorMessage getError() {
        if (!hasError()) {
            errorMsg = ErrorMessage.NO_ERROR;
            return errorMsg;
        } else {
            return errorMsg;
        }
    }

    @Override
    public Object getReturnValue() {
        if (hasError()) {
            return null;
        } else {
            return operationResult;
        }
    }

}
