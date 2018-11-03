// HDD device class

package hdd_device;

public class HddDevice{
    String vendorName;
    String interfaceType;
    String capacity;
    int powerRequierement;

    // Empty default constructor
    public HddDevice(){ return; }

    /**
     *  Function configures HDD device
     *  @param vendorName: Vendor name it text format
     *  @param interfaceType: Interface type in text format
     *  @param capacity: Drive capacity in text type
     *  @param powerRequierement: HDD power requirement in decimal format (W)
     */
    public HddDevice(String vendorName, String interfaceType, String capacity, int powerRequierement){
        this.vendorName         = vendorName;
        this.interfaceType      = interfaceType;
        this.capacity           = capacity;
        this.powerRequierement  = powerRequierement;
    }

    /**
     *  Funcitons below returns HDD device parameters
     *  @return vendorName: Vendor name it text format
     *  @return interfaceType: Interface type in text format
     *  @return capacity: Drive capacity in text type
     *  @return powerRequierement: HDD power requirement in decimal format (W)     *
     */
    public String GetVendorName()       { return vendorName; }
    public String GetInterfaceType()    { return interfaceType; }
    public String GetCapacity()         { return capacity; }
    public int GetPowerRequierement()   { return powerRequierement; }

    /**
     *  Function check is device configured
     *  @return 1 if device successfully configured, else error code (less than 0)
     */
    public int IsConfigured(){
        if (vendorName == null)     { return -1; }
        if (interfaceType == null)  { return -2; }
        if (capacity == null)       { return -3; }
        if (powerRequierement == 0) { return -4; }
        return 1;
    }
}
