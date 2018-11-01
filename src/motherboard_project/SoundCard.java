// SoundCard class

package sound_card;

public class SoundCard{
    private float supportedChannel;
    private float currentChannel;

    /**
     *  Function configures supported channel
     *  @param  channel: Channel in decimal format
     *  @return 1 if chanel succussfully configured or error code (less than 0)
     */
    public int ConfigureChannel(float channel){
        return 0;
    }

    /**
     *  Function checks if input channel supported
     *  @param  channel: Channel value
     *  @return 1 if channel supported, else error code (less than 0)
     */
    public int IfChannelSupported(float channel){
        return 0;
    }

    /**
     *  Function checks if sound card configured
     *  @param  none
     *  @return 1 if sound card configured, else error code (less than 0)
     */
    public int IsReady(){
        return 0;
    }
}
