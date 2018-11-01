// Ethernet Modem class

package ethernet_modem;

public class EthernetModem{
    private String supportedStandard[];

    /**
     *  Function configures supported standard types
     *  @param  standardPull: Pull if interface types in text format
     *  @return Number of configured standards or error code (less than 0)
     */
    public int ConfigureInterface(String ... standardPull){
        return 0;
    }

    /**
     *  Function checks if input ethernet standard interface type supported
     *  @param  standardType: ethernet standard interface type
     *  @return 1 if standard supported, else error code (less than 0)
     */
    public int IfStandardSupported(String standardType){
        return 0;
    }

    /**
     *  Function checks if ethernet modem configured
     *  @param  none
     *  @return 1 if ethernet modem configured, else error code (less than 0)
     */
    public int IsReady(){
        return 0;
    }
}
