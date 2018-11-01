// CPU Device class

class CpuDevice{
    private String vendorName;
    private String socketType;
    private int coresNumber;
    private float coreFrequency;
    private int powerRequierement;

    /**
     *  Constructor configures CPU device
     *  @param vendorName: Vendor name in text format
     *  @param socketType: Socket type in text format
     *  @param coresNumber: Number of CPU cores in decimal format
     *  @param coreFrequency: Core frequency in decimal format (GHz)
     *  @param powerRequierement: CPU power reqierement in decimal format (W)
     */
    CpuDevice(String vendorName, String socketType, int coresNumber, float coreFrequency, int powerRequierement){
        this.vendorName         = vendorName;
        this.socketType         = socketType;
        this.coresNumber        = coresNumber;
        this.coreFrequency      = coreFrequency;
        this.powerRequierement  = powerRequierement;
    }
}
