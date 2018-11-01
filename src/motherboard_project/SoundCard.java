// SoundCard class

package sound_card;

public class SoundCard{
    private double supportedChannel = 0.0;

    /**
     *  Function configures supported channel
     *  @param  channel: Channel in decimal format
     *  @return 1 if chanel succussfully configured or error code (less than 0)
     */
    public int ConfigureChannel(double channel){
        if (supportedChannel != 0.0){
            return -2;
        } else if (channel > 1.0) {
            supportedChannel = channel;
        } else {
            return -1;
        }
        return 1;
    }

    /**
     *  Function checks if input channel supported
     *  @param  channel: Channel value
     *  @return 1 if channel supported, else error code (less than 0)
     */
    public int IfChannelSupported(double channel){
        if (supportedChannel >= channel){
            return 1;
        }
        return -1;
    }

    /**
     *  Function returs supported channel types
     *  @param  none
     *  @return Pull of supported channels in decimal format
     */
    public double GetSupportedChannel(){
        return supportedChannel;
    }

    /**
     *  Function checks if sound card configured
     *  @param  none
     *  @return 1 if sound card configured, else error code (less than 0)
     */
    public int IsReady(){
        if (supportedChannel != 0.0){
            return 1;
        }
        return -1;
    }
}
