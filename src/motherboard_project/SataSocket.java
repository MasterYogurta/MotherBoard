// SATA socket class

package sata_socket;

public class SataSocket{
    private String supportedInterfaces[];

    /**
     *  Function configures supported interface types
     *  @param  interfaceTypePull: Pull if interface types in text format
     *  @return Number of configured interfaces or error code (less than 0)
     */
    public int ConfigureInterface(String ... interfaceTypePull){
        if (supportedInterfaces != null) {
            return -2;
        } else if (interfaceTypePull.length > 0) {
            supportedInterfaces = interfaceTypePull;
        } else {
            return -1;
        }
        return 1;
    }

    /**
     *  Function checks if input SATA interface type supported
     *  @param  interfaceType: SATA interface type
     *  @return 1 if interface supported, else error code (less than 0)
     */
    public int IfInterfaceSupported(String interfaceType){
        if (supportedInterfaces != null){
            for (String check : supportedInterfaces){
                if (check.compareTo(interfaceType) == 0){
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
        if (supportedInterfaces != null){
            return 1;
        }
        return -22;
    }
}
