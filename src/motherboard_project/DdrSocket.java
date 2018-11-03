// DDR socket class

package ddr_socket;

import ddr_device.DdrDevice;

public class DdrSocket{
    private String supportedFamilyTypes[];
    private int supportedFrequency[];
    private DdrDevice device;

    // Socket API --------------------------------------------------------------------------------------------
    /**
     *  Function configures supported DDR family types
     *  @param  familyTypePull: Pull of family types in text format
     *  @return Number of Configured family types or error code (less than 0)
     */
    public int ConfigureFamilyTypes(String ... familyTypePull){
        if (supportedFamilyTypes != null) {
            return -2;
        } else if (familyTypePull.length > 0) {
            supportedFamilyTypes = familyTypePull;
        } else {
            return -1;
        }
        return 1;
    }

    /**
     *  Functin configures support DDR frequency
     *  @param  frequencyPull: Pull of frequencies in decimal format
     *  @return Number of Configured frequencies or error code (less than 0)
     */
    public int ConfigureFrequency(int ... frequencyPull){
        if (supportedFrequency != null) {
            return -2;
        } else if (frequencyPull.length > 0) {
            supportedFrequency = frequencyPull;
        } else {
            return -1;
        }
        return 1;
    }

    /**
     *  Function checks is input family type sopported
     *  @param  familyType: DDR family type
     *  @return 1 if family type supported, else error code (less than 0)
     */
    public int IsFamilyTypesSupported(String familyType){
        if (supportedFamilyTypes != null){
            for (String check : supportedFamilyTypes){
                if (check.compareTo(familyType) == 0){
                    return 1;
                }
            }
        } else {
            return -22;
        }
        return -1;
    }

    /**
     *  Function checks is input frequency supported
     *  @param  frequencyValue: DDR frequency value
     *  @return 1 if frequency supported, else error code (less than 0)
     */
    public int IsFrequencySupported(int frequencyValue){
        if (supportedFrequency != null){
            for (int frequency : supportedFrequency){
                if (frequency == frequencyValue){
                    return 1;
                }
            }
        } else {
            return -22;
        }
        return -1;
    }

    /**
     *  Function returs supported famyly types
     *  @param  none
     *  @return Pull of supported families in text format
     */
    public String[] GetSupportedFamilies(){
        return supportedFamilyTypes;
    }

    /**
     *  Function returs supported frequencies
     *  @param  none
     *  @return Pull of supported frequencies in decimal format
     */
    public int[] GetSupportedFrequencies(){
        return supportedFrequency;
    }

    /**
     *  Function checks if DDR socket configured
     *  @param  none
     *  @return 1 if DDR socket configured, else error code (less than 0)
     */
    public int IsReady(){
        if ((supportedFamilyTypes != null) && (supportedFrequency != null)){
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
     *  @param  device: Configured DDR device object
     *  @return 1 if device was successfully inserted, else error code (less than 0)
     */
    public int InsertDevice(DdrDevice device){
        if (IsFree() < 0){                                              return -1;
        } else if (IsReady() < 0){                                      return -2;
        } else if (device == null){                                     return -3;
        } else if (device.IsConfigured() < 0){                          return -4;
        } else if (IsFamilyTypesSupported(device.GetFamilyType()) < 0){ return -5;
        } else if (IsFrequencySupported(device.GetFrequency()) < 0){    return -6; }
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
    public DdrDevice GetDevice(){ return device; }
}
