// Ethernet Modem class

package ethernet_modem;

public class EthernetModem{
    private String supportedStandards[];

    /**
     *  Function configures supported standard types
     *  @param  standardPull: Pull if interface types in text format
     *  @return Number of configured standards or error code (less than 0)
     */
    public int ConfigureInterface(String ... standardPull){
        if (supportedStandards != null) {
            return -2;
        } else if (standardPull.length > 0) {
            supportedStandards = standardPull;
        } else {
            return -1;
        }
        return 1;
    }

    /**
     *  Function checks if input ethernet standard interface type supported
     *  @param  standardType: ethernet standard interface type
     *  @return 1 if standard supported, else error code (less than 0)
     */
    public int IfStandardSupported(String standardType){
        if (supportedStandards != null){
            for (String check : supportedStandards){
                if (check.compareTo(standardType) == 0){
                    return 1;
                }
            }
        } else {
            return -22;
        }
        return -1;
    }

    /**
     *  Function returs supported standard types
     *  @param  none
     *  @return Pull of supported standards in text format
     */
    public String[] GetSupportedStandards(){
        return supportedStandards;
    }

    /**
     *  Function checks if ethernet modem configured
     *  @param  none
     *  @return 1 if ethernet modem configured, else error code (less than 0)
     */
    public int IsReady(){
        if (supportedStandards != null){
            return 1;
        }
        return -22;
    }
}
