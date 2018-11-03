// SoundCard class

package sound_card;

import speaker_device.SpeakerDevice;

public class SoundCard{
    private double supportedChannel = 0.0;
    private SpeakerDevice device;

    // Socket API --------------------------------------------------------------------------------------------
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

    // Device API --------------------------------------------------------------------------------------------
    /**
     *  Function checks is current socket free
     *  @param  none
     *  @return 1 if socket is free, else error code (less than 0)
     */
    public int IsFree(){
        if (device == null){ return 1; }
        return -1;
    }

    /**
     *  Funciton inserts given device in socket
     *  @param  device: Configured Speaker device object
     *  @return 1 if device was successfully inserted, else error code (less than 0)
     */
    public int InsertDevice(SpeakerDevice device){
        if (IsFree() < 0){                                              return -1;
        } else if (IsReady() < 0){                                      return -2;
        } else if (device == null){                                     return -3;
        } else if (device.IsConfigured() < 0){                          return -4;
        } else if (IfChannelSupported(device.GetChannel()) < 0){        return -5; }
        this.device = device;
        return 1;
    }

    /**
     *  Function ejects device from socket
     *  @param  none
     *  @return 1 if device was successfully ejected, else error code (less than 0)
     */
    public int EjectDevice(){
        if (IsFree() > 0){ return -1; }
        device = null;
        return 1;
    }

    /**
     *  Function returns object with current inserted device
     *  @param  none
     *  @return @device
     */
    public SpeakerDevice GetDevice(){ return device; }
}
