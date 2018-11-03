// CPU socket class

package cpu_socket;

import cpu_device.CpuDevice;

public class CpuSocket{
    private String supportedSockets[];
    private CpuDevice device;

    // Socket API --------------------------------------------------------------------------------------------
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
     *  Function returs supported socket types
     *  @param  none
     *  @return Pull of supported sockets in text format
     */
    public String[] GetSupportedSockets(){
        return supportedSockets;
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
     *  Function inserts device in socket
     *  @param  device: Configured CPU device object
     *  @return 1 if device was successfully inserted, else error code (less than 0)
     */
    public int InsertDevice(CpuDevice device){
        if (IsFree() < 0){                                          return -1;
        } else if (IsReady() < 0){                                  return -2;
        } else if (device == null){                                 return -3;
        } else if (device.IsConfigured() < 0){                      return -4;
        } else if (IfSocketSupported(device.GetSocketType()) < 0){  return -5; }
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
    public CpuDevice GetDevice(){ return device; }
}
