// DDR socket class

package ddr_socket;

public class DdrSocket{
    private String supportedFamilyTypes[];
    private int supportedFrequency[];

    /**
     *  Function configures supported DDR family types
     *  @param  familyTypePull: Pull of family types in text format
     *  @return Number of configred family types or error code (less than 0)
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
     *  @return Number of configred frequencies or error code (less than 0)
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
     *  Function checks if input family type sopported
     *  @param  familyType: DDR family type
     *  @return 1 if family type supported, else error code (less than 0)
     */
    public int IfFamilyTypesSupported(String familyType){
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
     *  Function checks if input frequency supported
     *  @param  frequencyValue: DDR frequency value
     *  @return 1 if frequency supported, else error code (less than 0)
     */
    public int IfFrequencySupported(int frequencyValue){
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
}
