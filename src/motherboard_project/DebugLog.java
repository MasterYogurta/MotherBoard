// Debug log

package debug_log;

public class DebugLog{
    private final boolean useUserLog = true;
    private final boolean useErrorLog = false;

    public void UserLog(String ... userMessage){
        if (useUserLog == true){
            System.out.print("[MSG] : ");
            for (String message : userMessage){
                System.out.print(message);
            }
            System.out.println();
        }
    }

    /**
     *  Error log funciton
     *  @param  errorCode: Code of error
     *  @param  errorMessage: Custom message
     *  @return errorCode
     */
    public int ErrorLog(int errorCode, String ... errorMessage){
        if (useErrorLog == true){
            if (errorCode < 0){
                System.out.print("[ERROR] : (" + errorCode + ") | ");
            } else {
                System.out.print("[SUC] : (" + errorCode + ") | ");
            }
            for (String message : errorMessage){
                System.out.print(" " + message);
            }
            System.out.println();
        }
        return errorCode;
    }
}
