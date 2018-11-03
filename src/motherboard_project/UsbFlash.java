// USB flash device

package usb_flash;

public class UsbFlash{
    public String interfaceType;
    public String capacity;

    // Empty default constructor
    public UsbFlash(){ return; }

    /**
     *  Funciton configures USB flash device
     *  @param  interfaceType: USB interface type in text format
     *  @param  capacity: USB flash capacity in text format
     */
    public UsbFlash(String interfaceType, String capacity){
        this.interfaceType  = interfaceType;
        this.capacity       = capacity;
    }

    /**
     *  Functions below returns USB flash device parameters
     *  @return interfaceType: USB interface type in text format
     *  @return capacity: USB flash capacity in text format
     */
    public String GetInterfaceType() { return interfaceType; }
    public String GetCapacity()     { return capacity; }

    /**
     *  Function checks is device configured
     *  @return 1 if device successfully configured, else error code (less than 0)
     */
    public int IsConfigured(){
        if (interfaceType == null)  { return -1; }
        if (capacity == null)       { return -2; }
        return 1;
    }
}
