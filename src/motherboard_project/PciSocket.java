// PCI socket class

package pci_socket;

public class PciSocket{
    private int supportedBusWidth = 0;

    /**
     *  Function configures supported bus width
     *  @param  busWidth: Bus width in decimal format
     *  @return 1 if bus width configured or error code (less than 0)
     */
    public int ConfigureBusWidth(int busWidth){
        if (supportedBusWidth != 0) {
            return -2;
        } else if (busWidth > 0) {
            supportedBusWidth = busWidth;
        } else {
            return -1;
        }
        return 1;
    }

    /**
     *  Function checks if input bus width supported
     *  @param  busWidth: Bus width value
     *  @return 1 if bus width supported, else error code (less than 0)
     */
    public int IfBusWidthSupported(int busWidth){
        if (supportedBusWidth >= busWidth){
            return 1;
        }
        return -1;
    }

    /**
     *  Function returs supported bus width
     *  @param  none
     *  @return Pull of supported bus widht in decimal format
     */
    public int GetSupportedBusWidth(){
        return supportedBusWidth;
    }
    
    /**
     *  Function checks if PCI socket configured
     *  @param  none
     *  @return 1 if PCI socket configured, else error code (less than 0)
     */
    public int IsReady(){
        if (supportedBusWidth != 0){
            return 1;
        }
        return -22;
    }
}
