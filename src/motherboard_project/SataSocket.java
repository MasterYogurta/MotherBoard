// SATA socket class

package sata_socket;

import hdd_device.HddDevice;

public class SataSocket{
    private String supportedInterfaces[];
    private HddDevice device;

    // Socket API --------------------------------------------------------------------------------------------
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
     *  Function returs supported interface types
     *  @param  none
     *  @return Pull of supported interfaces in text format
     */
    public String[] GetSupportedInterfaces(){
        return supportedInterfaces;
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
     *  @param  device: Configured HDD device object
     *  @return 1 if device was successfully inserted, else error code (less than 0)
     */
    public int InsertDevice(HddDevice device){
        if (IsFree() < 0){                                                  return -1;
        } else if (IsReady() < 0){                                          return -2;
        } else if (device == null){                                         return -3;
        } else if (device.IsConfigured() < 0){                              return -4;
        } else if (IfInterfaceSupported(device.GetInterfaceType()) < 0){    return -5; }
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
    public HddDevice GetDevice(){ return device; }
}
