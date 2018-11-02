// MotherBoard class

package motherboard;

import cpu_socket.CpuSocket;
import ddr_socket.DdrSocket;
import sata_socket.SataSocket;
import pci_socket.PciSocket;
import sound_card.SoundCard;
import usb_hub.UsbHub;
import ethernet_modem.EthernetModem;

import cpu_device.CpuDevice;

import debug_log.DebugLog;

public class MotherBoard{
    // Onboard devices and sockets
    private CpuSocket cpuSocket;
    private DdrSocket ddrSocket[];
    private SataSocket sataSocket[];
    private PciSocket pciSocket[];
    private SoundCard soundCard;
    private UsbHub usbHub;
    private EthernetModem ethernetModem;
    // Onboard API
    private CpuApi cpuApi = new CpuApi();
    // Other
    private DebugLog debug = new DebugLog();

    //--------------------------------------------------------------------------------------------------------
    /**
     *  Funcitons below configure onboard devices and sockets : CPU, DDR, SATA, PCI, SoundCard, USB Hub and Ethernet Modem
     *  @param cpuSocket: Configred CpuSocket object
     *  @param ddrSocket: Configred DdrSocket object
     *  @param sataSocket: Configred SataSocket object
     *  @param pciSocket: Configred PciSocket object
     *  @param soundCard: Configred SoundCard object
     *  @param usbHub: Configred UsbHub object
     *  @param ethernetModem: Configred EthernetModem object
     *  @return 1 if socket or device configured, else error code (less than 0)
     */
    public int ConfigureOnboardDevice(CpuSocket cpuSocket){
        if (cpuSocket.IsReady() < (0)){
            return debug.ErrorLog((-1), "Failed to configure cpuSocket");
        }
        this.cpuSocket = cpuSocket;
        debug.UserLog("CpuSocket configured");
        return 1;
    }
    public int ConfigureOnboardDevice(DdrSocket ... ddrSocket){
        for (DdrSocket check : ddrSocket){
            if (check.IsReady() < (0)){
                return debug.ErrorLog((-2), "Failed to configure ddrSocket");
            }
        }
        this.ddrSocket = ddrSocket;
        debug.UserLog("DdrSocket configured. " + "Number of sockets : " + ddrSocket.length);
        return 1;
    }
    public int ConfigureOnboardDevice(SataSocket ... sataSocket){
        for (SataSocket check : sataSocket){
            if (check.IsReady() < (0)){
                return debug.ErrorLog((-3), "Failed to configure sataSocket");
            }
        }
        this.sataSocket = sataSocket;
        debug.UserLog("SataSocket configured. " + "Number of sockets : " + sataSocket.length);
        return 1;
    }
    public int ConfigureOnboardDevice(PciSocket ... pciSocket){
        for (PciSocket check : pciSocket){
            if (check.IsReady() < (0)){
                return debug.ErrorLog((-4), "Failed to configure pciSocket");
            }
        }
        this.pciSocket = pciSocket;
        debug.UserLog("PciSocket configured. " + "Number of sockets : " + pciSocket.length);
        return 1;
    }
    public int ConfigureOnboardDevice(SoundCard soundCard){
        if (soundCard.IsReady() < (0)){
            return debug.ErrorLog((-5), "Failed to configure soundCard");
        }
        this.soundCard = soundCard;
        debug.UserLog("SoundCard configured");
        return 1;
    }
    public int ConfigureOnboardDevice(UsbHub usbHub){
        if (usbHub.IsReady() < (0)){
            return debug.ErrorLog((-6), "Failed to configure usbHub");
        }
        this.usbHub = usbHub;
        debug.UserLog("UsbHub configured");
        return 1;
    }
    public int ConfigureOnboardDevice(EthernetModem ethernetModem){
        if (ethernetModem.IsReady() < (0)){
            return debug.ErrorLog((-7), "Failed to configure ethernetModem");
        }
        this.ethernetModem = ethernetModem;
        debug.UserLog("EthernetModem configured");
        return 1;
    }
    //--------------------------------------------------------------------------------------------------------
    /**
     *  Funciton checks is all motherboard sockets and onboard devices are configured
     *  @param  none
     *  @retrun 1 if all modules are configured, else error code (less than 0)
     */
    public int IsMotherBoardConfigured(){
        boolean configuredFlag = true;
        String nConfList = new String();

        if (cpuSocket == null)      { configuredFlag = false; nConfList += " cpuSocket"; }
        if (ddrSocket == null)      { configuredFlag = false; nConfList += " ddrSocket"; }
        if (sataSocket == null)     { configuredFlag = false; nConfList += " sataSocket"; }
        if (pciSocket == null)      { configuredFlag = false; nConfList += " pciSocket"; }
        if (soundCard == null)      { configuredFlag = false; nConfList += " soundCard"; }
        if (usbHub == null)         { configuredFlag = false; nConfList += " usbHub"; }
        if (ethernetModem == null)  { configuredFlag = false; nConfList += " ethernetModem"; }

        if (configuredFlag == true){
            debug.UserLog("All motherboard modules are configured");
            return 1;
        } else {
            return debug.ErrorLog(-1, "Motherboard is not configured. Modules:" + nConfList);
        }
    }
    //--------------------------------------------------------------------------------------------------------
    /**
     *  Function displays current motherboard configuration
     *  @param  none
     *  @return none
     */
    public void DisplayConfig(){
        // ethernetModem
        String[] textBuffer;
        String string = new String();
        int[] integerBuffer;
        int number;
        double dobuleBuffer;

        if (IsMotherBoardConfigured() > 0){
            // CPU Socket
            debug.UserLog("CPU:");
            textBuffer = cpuSocket.GetSupportedSockets();
            for (String check : textBuffer){ string += (" | " + check); }
            debug.UserLog("\tsupported sockets\t\t" + string);
            // DDR Socket
            debug.UserLog("DDR:");
            for (DdrSocket sock : ddrSocket){
                textBuffer = sock.GetSupportedFamilies();
                string = "";
                for (String check : textBuffer){ string += (" | " + check); }
                debug.UserLog("\tsupported families\t\t" + string);
            }
            for (DdrSocket sock : ddrSocket){
                integerBuffer = sock.GetSupportedFrequencies();
                string = "";
                for (int check : integerBuffer){ string += (" | " + String.valueOf(check)); }
                debug.UserLog("\tsupported frequencies\t" + string);
            }
            // SATA
            debug.UserLog("SATA:");
            for (SataSocket sock : sataSocket){
                textBuffer = sock.GetSupportedInterfaces();
                string = "";
                for (String check : textBuffer){ string += (" | " + check); }
                debug.UserLog("\tsupported interfaces\t" + string);
            }
            // PCI
            debug.UserLog("PCI:");
            for (PciSocket sock : pciSocket){
                number = sock.GetSupportedBusWidth();
                string = (" | " + String.valueOf(number));
                debug.UserLog("\tsupported bus width\t\t" + string);
            }
            // SoundCard
            debug.UserLog("SoundCard:");
            dobuleBuffer = soundCard.GetSupportedChannel();
            string = (" | " + String.valueOf(dobuleBuffer));
            debug.UserLog("\tsupported channels\t\t" + string);
            // USB Hub
            debug.UserLog("USB Hub:");
            textBuffer = usbHub.GetSupportedInterfaces();
            string = "";
            for (String check : textBuffer){ string += (" | " + check); }
            debug.UserLog("\tsupported interfaces\t" + string);
            // Ethernet Modem
            debug.UserLog("Ethernet Modem:");
            textBuffer = ethernetModem.GetSupportedStandards();
            string = "";
            for (String check : textBuffer){ string += (" | " + check); }
            debug.UserLog("\tsupported standards\t\t" + string);
        }
    }
    //--------------------------------------------------------------------------------------------------------
    // Insert given device
    /**
     *  Functions below inserts given device to specific socket
     *  @param  device: Object with configured device
     *  @return 1 if device successfully inserted, else error code (less than 0)
     */
    public int InsertDevice(CpuDevice device){
        int endcode;
        endcode = cpuApi.InsertDevice(cpuSocket, device);
        debug.ErrorLog(endcode, "CpuApi > InsertDevice");
        if (endcode < 0){
            return -1;
        }
        return 1;
    }
    //--------------------------------------------------------------------------------------------------------
    // CPU device API
    private class CpuApi{
        /**
         *  @see    cpu_socket.CpuSocket.IsFree
         */
        public int IsFree(CpuSocket socket){
            return socket.IsFree();
        }
        /**
         *  @see    cpu_socket.CpuSocket.InsertDevice
         */
        public int InsertDevice(CpuSocket socket, CpuDevice device){
            return socket.InsertDevice(device);
        }
        /**
         *  @see    cpu_socket.CpuSocket.EjectDevice
         */
        public int EjectDevice(CpuSocket socket){
            return socket.EjectDevice();
        }
        /**
         *  @see    cpu_socket.CpuSocket.GetDevice
         */
        public CpuDevice GetDevice(CpuSocket socket){
            return socket.GetDevice();
        }
    }
}
