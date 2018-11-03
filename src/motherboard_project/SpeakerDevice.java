// Speaker device class

package speaker_device;

public class SpeakerDevice{
    private double channel;

    // Empty default constructor
    public SpeakerDevice(){ return; }

    /**
     *  Function configures Speaker device
     *  @param  channel: Sound channel in decimal format
     */
    public SpeakerDevice(double channel){
        this.channel = channel;
    }

    /**
     *  Functions below returns Speaker device parameters
     *  @return channel: Sound channel in decimal format
     */
    public double GetChannel()  { return channel; }

    /**
     *  Function checks is device configured
     *  @return 1 if device successfully configured, else error code (less than 0)
     */
    public int IsConfigured(){
        if (channel == 0.0) { return -1; }
        return 1;
    }
}
