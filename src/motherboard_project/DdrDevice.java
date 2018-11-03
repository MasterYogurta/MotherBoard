// RAM device calss

package ddr_device;

public class DdrDevice{
    private String vendorName;
    private String familyType;
    private int frequency;
    private String timing;
    private int powerRequierement;

    // Empty default constructor
    public DdrDevice() { return; }

    /**
     *  Constructor configures DDR device
     *  @param  vendorName: Vendor name in text format
     *  @param  familyType: Family type in text format
     *  @param  frequency: Frequency value in decimal format
     *  @param  timing: Timing time in text format
     *  @param  powerRequierement: DDR power reqierement in decimal format (W)
     */
    public DdrDevice(String vendorName, String familyType, int frequency, String timing, int powerRequierement){
        this.vendorName         = vendorName;
        this.familyType         = familyType;
        this.frequency          = frequency;
        this.timing             = timing;
        this.powerRequierement  = powerRequierement;
    }

    /**
     *  Funcitons below return DDR device parameters
     *  @return vendorName: Vendor name in text format
     *  @return familyType: Family type in text format
     *  @return frequency: Frequency value in decimal format
     *  @return timing: Timing time in text format
     *  @return powerRequierement: Power requirement
     */
     public String GetVendorName()      { return vendorName; }
     public String GetFamilyType()      { return familyType; }
     public int GetFrequency()          { return frequency; }
     public String GetTiming()          { return timing; }
     public int GetPowerRequierement()  { return powerRequierement; }

     /**
      * Function checks is device configured
      * @return 1 if device successfully configured, else error code (less than 0)
      */
     public int IsConfigured(){
         if (vendorName == null)        { return -1;}
         if (familyType == null)        { return -2;}
         if (frequency == 0)            { return -3;}
         if (timing == null)            { return -4;}
         if (powerRequierement == 0)    { return -5;}
         return 1;
     }
}
