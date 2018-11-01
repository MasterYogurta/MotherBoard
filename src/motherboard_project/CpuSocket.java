// CPU socket class

package cpu_socket;

public class CpuSocket{
    private String supportedSockets[];

    /**
     *  Function configures supported socket types
     *  @param  socketPull: Pull of sockets types in text format
     *  @return Number of configured sockets or error code (less than 0)
     */
    public int ConfigureSocket(String ... socketPull){
        if (supportedSockets != null) {
            return -2;
        } else if (socketPull.length > 0) {
            supportedSockets = socketPull;
        } else {
            return -1;
        }
        return 1;
    }

    /**
     *  Function checks if input CPU socket type sopported
     *  @param  socketType: CPU socket type
     *  @return 1 if socket supported, else error code (less than 0)
     */
    public int IfSocketSupported(String socketType){
        if (supportedSockets != null){
            for (String check : supportedSockets){
                if (check.compareTo(socketType) == 0){
                    return 1;
                }
            }
        } else {
            return -22;
        }
        return -1;
    }

    /**
     *  Function checks if CPU socket configured
     *  @param  none
     *  @return 1 if CPU socket configured, else error code (less than 0)
     */
    public int IsReady(){
        if (supportedSockets != null){
            return 1;
        }
        return -22;
    }
}
