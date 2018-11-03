// Ethernet device class

package ethernet_device;

public class EthernetDevice{
    public String standard;

    // Empty default constructor
    public EthernetDevice(){ return; }

    /**
     *  Constructor configures Ethernet device
     *  @param  standard: Standard type in text format
     */
    public EthernetDevice(String standard){
        this.standard = standard;
    }

    /**
     *  Functions below returns Ethernet device parameters
     *  @return standard: Standard type in text format
     */
    public String GetStandard() { return standard; }

    /**
     *  Funciton checks is device configured
     *  @return 1 if device successfully configured, else error code (less than 0)
     */
    public int IsConfigured(){
        if (standard == null)   { return -1; }
        return 1;
    }
}
