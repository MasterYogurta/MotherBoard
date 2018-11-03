// CPU Device class

package cpu_device;

public class CpuDevice{
    private String vendorName;
    private String socketType;
    private int coresNumber;
    private double coreFrequency;
    private int powerRequierement;

    // Empty default constructor
    public CpuDevice(){ return; }

    /**
     *  Constructor configures CPU device
     *  @param vendorName: Vendor name in text format
     *  @param socketType: Socket type in text format
     *  @param coresNumber: Number of CPU cores in decimal format
     *  @param coreFrequency: Core frequency in decimal format (GHz)
     *  @param powerRequierement: CPU power reqierement in decimal format (W)
     */
    public CpuDevice(String vendorName, String socketType, int coresNumber, double coreFrequency, int powerRequierement){
        this.vendorName         = vendorName;
        this.socketType         = socketType;
        this.coresNumber        = coresNumber;
        this.coreFrequency      = coreFrequency;
        this.powerRequierement  = powerRequierement;
    }

    /**
     *  functions below returns CPU device parameters
     *  @param  none
     *  @return vendorName: Vendor name in text format
     *  @return socketType: Socket type in text format
     *  @return coresNumber: Number of CPU cores in decimal format
     *  @return coreFrequency: Core frequency in decimal format (GHz)
     *  @return powerRequierement: CPU power reqierement in decimal format (W)
     */
     public String GetVendorName()     { return vendorName; }
     public String GetSocketType()     { return socketType; }
     public int GetCoresNumber()       { return coresNumber; }
     public double GetCoreFrequency()  { return coreFrequency; }
     public int GetPowerRequierement() { return powerRequierement; }

    /**
     *  Funciton checks is device configured
     *  @param  none
     *  @return 1 if device successfully configured, else error code (less than 0)
     */
    public int IsConfigured(){
        if (vendorName == null)     { return -1; }
        if (socketType == null)     { return -2; }
        if (coresNumber == 0)       { return -3; }
        if (coreFrequency == 0)     { return -4; }
        if (powerRequierement == 0) { return -5; }
        return 1;
    }
}
