// PCI socket class

package pci_socket;

public class PciSocket{
    private int supportedBusWidth;
    private int currentBusWidth;

    /**
     *  Function configures supported bus width
     *  @param  busWidth: Bus width in decimal format
     *  @return 1 if bus width configured or error code (less than 0)
     */
    public int ConfigureBusWidth(int busWidth){
        return 0;
    }

    /**
     *  Function checks if input bus width supported
     *  @param  busWidth: Bus width value
     *  @return 1 if bus width supported, else error code (less than 0)
     */
    public int IfBusWidthSupported(String busWidth){
        return 0;
    }

    /**
     *  Function checks if PCI socket configured
     *  @param  none
     *  @return 1 if PCI socket configured, else error code (less than 0)
     */
    public int IsReady(){
        return 0;
    }
}
