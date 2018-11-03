// Ethernet Modem class

package ethernet_modem;

import ethernet_device.EthernetDevice;

public class EthernetModem{
    private String supportedStandards[];
    private EthernetDevice device;

    // Modem API ---------------------------------------------------------------------------------------------
    /**
     *  Function configures supported standard types
     *  @param  standardPull: Pull if interface types in text format
     *  @return Number of configured standards or error code (less than 0)
     */
    public int ConfigureInterface(String ... standardPull){
        if (supportedStandards != null) {
            return -2;
        } else if (standardPull.length > 0) {
            supportedStandards = standardPull;
        } else {
            return -1;
        }
        return 1;
    }

    /**
     *  Function checks if input ethernet standard interface type supported
     *  @param  standardType: ethernet standard interface type
     *  @return 1 if standard supported, else error code (less than 0)
     */
    public int IfStandardSupported(String standardType){
        if (supportedStandards != null){
            for (String check : supportedStandards){
                if (check.compareTo(standardType) == 0){
                    return 1;
                }
            }
        } else {
            return -22;
        }
        return -1;
    }

    /**
     *  Function returs supported standard types
     *  @param  none
     *  @return Pull of supported standards in text format
     */
    public String[] GetSupportedStandards(){
        return supportedStandards;
    }

    /**
     *  Function checks if ethernet modem configured
     *  @param  none
     *  @return 1 if ethernet modem configured, else error code (less than 0)
     */
    public int IsReady(){
        if (supportedStandards != null){
            return 1;
        }
        return -22;
    }
    // Device API --------------------------------------------------------------------------------------------
    /**
     *  Function checks is current modem free
     *  @param  none
     *  @return 1 if modem is free, else error code (less than 0)
     */
    public int IsFree(){
        if (device == null){ return 1; }
        return -1;
    }

    /**
     *  Funciton connects given device to modem
     *  @param  device: Configured Ethernet device object
     *  @return 1 if device was successfully inserted, else error code (less than 0)
     */
    public int InsertDevice(EthernetDevice device){
        if (IsFree() < 0){                                              return -1;
        } else if (IsReady() < 0){                                      return -2;
        } else if (device == null){                                     return -3;
        } else if (device.IsConfigured() < 0){                          return -4;
        } else if (IfStandardSupported(device.GetStandard()) < 0){      return -5; }
        this.device = device;
        return 1;
    }

    /**
     *  Function disconnects device from modem
     *  @param  none
     *  @return 1 if device was successfully disconnected, else error code (less than 0)
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
    public EthernetDevice GetDevice(){ return device; }
}
