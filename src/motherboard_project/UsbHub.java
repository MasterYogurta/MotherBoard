// USB hub class

package usb_hub;

public class UsbHub{
    private String supportedInterfaces[];

    /**
     *  Function configures supported interface types
     *  @param  interfaceTypePull: Pull if interface types in text format
     *  @return Number of configured interfaces or error code (less than 0)
     */
    public int ConfigureInterface(String ... interfaceTypePull){
        return 0;
    }

    /**
     *  Function checks if input USB interface type supported
     *  @param  interfaceType: USB interface type
     *  @return 1 if interface supported, else error code (less than 0)
     */
    public int IfInterfaceSupported(String interfaceType){
        return 0;
    }

    /**
     *  Function checks if USB hub configured
     *  @param  none
     *  @return 1 if USB hub configured, else error code (less than 0)
     */
    public int IsReady(){
        return 0;
    }
}
