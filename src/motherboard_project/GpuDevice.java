// GPU device class

package gpu_device;

public class GpuDevice{
    private String vendorName;
    private int busWidth;
    private String videoMemory;
    private String videoInterface;
    private int powerRequierement;

    // Empty default constructor
    public GpuDevice(){ return; }

    /**
     *  Function configures GPU device
     *  @param vendorName: Vendor name in text format
     *  @param busWidth: Bus width value
     *  @param videoMemory: Video memory size
     *  @param videoInterface: Video interface type
     *  @param powerRequierement: GPU power reqierement in decimal format (W)
     */
    public GpuDevice(String vendorName, int busWidth, String videoMemory, String videoInterface, int powerRequierement){
        this.vendorName         = vendorName;
        this.busWidth           = busWidth;
        this.videoMemory        = videoMemory;
        this.videoInterface     = videoInterface;
        this.powerRequierement  = powerRequierement;
    }

    /**
     *  Functions below return GPU device parameters
     *  @return vendorName: Vendor name in text format
     *  @return busWidth: Bus width value
     *  @return videoMemory: Video memory size
     *  @return videoInterface: Video interface type
     *  @return powerRequierement: GPU power reqierement in decimal format (W)
     */
     public String GetVendorName()      { return vendorName;}
     public int GetBusWidth()           { return busWidth;}
     public String GetVideoMemory()     { return videoMemory;}
     public String GetVideoInterface()  { return videoInterface;}
     public int GetPowerRequierement()  { return powerRequierement;}

    /**
     *  Function checks is device configured
     *  @return 1 if device successfully configured, else error code (less than 0)
     */
    public int IsConfigured(){
        if (vendorName == null)     { return -1;}
        if (busWidth == 0)          { return -2;}
        if (videoMemory == null)    { return -3;}
        if (videoInterface == null) { return -4;}
        if (powerRequierement == 0) { return -5;}
        return 1;
    }
}
