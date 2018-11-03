// PCI socket class

package pci_socket;

import gpu_device.GpuDevice;

public class PciSocket{
    private int supportedBusWidth = 0;
    private GpuDevice device;

    // Socket API --------------------------------------------------------------------------------------------
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
    public int IsBusWidthSupported(int busWidth){
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
        if (supportedBusWidth > 0){
            return 1;
        }
        return -22;
    }
    // Device API --------------------------------------------------------------------------------------------
    /**
     *  Function checks is current socket free
     *  @param  none
     *  @return 1 if socket is free, else error code (less than 0)
     */
    public int IsFree(){
        if (device == null){ return 1; }
        return -1;
    }

    /**
     *  Funciton inserts given device in socket
     *  @param  device: Configured GPU device object
     *  @return 1 if device was successfully inserted, else error code (less than 0)
     */
    public int InsertDevice(GpuDevice device){
        if (IsFree() < 0){                                              return -1;
        } else if (IsReady() < 0){                                      return -2;
        } else if (device == null){                                     return -3;
        } else if (device.IsConfigured() < 0){                          return -4;
        } else if (IsBusWidthSupported(device.GetBusWidth()) < 0){      return -5; }
        this.device = device;
        return 1;
    }

    /**
     *  Function ejects device from socket
     *  @param  none
     *  @return 1 if device was successfully ejected, else error code (less than 0)
     */
    public int EjectDevice(){
        if (IsFree() > 0){ return -1; }
        device = null;
        return 1;
    }

    /**
     *  Function returns object with current inserted device
     *  @param  none
     *  @return @device
     */
    public GpuDevice GetDevice(){ return device; }
}
