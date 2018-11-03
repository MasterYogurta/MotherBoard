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
import ddr_device.DdrDevice;
import ethernet_device.EthernetDevice;
import gpu_device.GpuDevice;
import hdd_device.HddDevice;
import speaker_device.SpeakerDevice;
import usb_flash.UsbFlash;

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
    // Onboard socket API
    private CpuApi cpuApi               = new CpuApi();
    private DdrApi ddrApi               = new DdrApi();
    private EthernetApi ethernetApi     = new EthernetApi();
    private PciApi pciApi               = new PciApi();
    private SataApi sataApi             = new SataApi();
    private SoundcardApi soundcardApi   = new SoundcardApi();
    private UsbApi usbApi               = new UsbApi();
    // Other
    private DebugLog debug = new DebugLog();

    //--------------------------------------------------------------------------------------------------
    /**
     *  Funcitons below configure onboard devices and sockets : CPU, DDR, SATA, PCI, SoundCard, USB Hub and Ethernet Modem
     *  @param cpuSocket: Configured CpuSocket object
     *  @param ddrSocket: Configured DdrSocket object
     *  @param sataSocket: Configured SataSocket object
     *  @param pciSocket: Configured PciSocket object
     *  @param soundCard: Configured SoundCard object
     *  @param usbHub: Configured UsbHub object
     *  @param ethernetModem: Configured EthernetModem object
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
    //--------------------------------------------------------------------------------------------------
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
    //--------------------------------------------------------------------------------------------------
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
    //--------------------------------------------------------------------------------------------------
    // Insert given device
    /**
     *  Function inserts given device to CPU socket
     *  @param  device: Configured CPU device object
     *  @return 1 if device successfully inserted, else error code (less than 0)
     */
    public int InsertDevice(CpuDevice device){
        return ((cpuApi.InsertDevice(cpuSocket, device) < 0) ? -1 : 1);
    }
    /**
     *  Function inserts given device to specify DDR socket
     *  @param  device: Configured DDR device object
     *  @param  socketNum: Number of socket to insert device
     *  @return 1 if device was successfully inserted, else error code (less than 0)
     */
    public int InsertDevice(DdrDevice device, int socketNum){
        if (socketNum > ddrSocket.length){ return -22; }
        return ((ddrApi.InsertDevice(ddrSocket[socketNum - 1], device) < 0) ? -1 : 1);
    }
    /**
     *  Funciton connects given device to ethernet modem
     *  @param  device: Configured Ethernet device
     *  @retrun 1 if device was successfully connected, else error code (less than 0)
     */
    public int InsertDevice(EthernetDevice device){
        return ((ethernetApi.InsertDevice(ethernetModem, device) < 0) ? -1 : 1);
    }
    /**
    *  Function inserts given device to specify PCI socket
    *  @param  device: Configured GPU device object
    *  @param  socketNum: Number of socket to insert device
    *  @return 1 if device was successfully inserted, else error code (less than 0)
     */
    public int InsertDevice(GpuDevice device, int socketNum){
        if (socketNum > pciSocket.length){ return -22; }
        return ((pciApi.InsertDevice(pciSocket[socketNum - 1], device) < 0) ? -1 : 1);
    }
    /**
     *  Function inserts given device to specify SATA socket
     *  @param  device: Configured HDD device object
     *  @param  socketNum: Number of socket to insert device
     *  @return 1 if device was successfully inserted, else error code (less than 0)
     */
    public int InsertDevice(HddDevice device, int socketNum){
        if (socketNum > sataSocket.length){ return -22; }
        return ((sataApi.InsertDevice(sataSocket[socketNum - 1], device) < 0) ? -1 : 1);
    }
    /**
     *  Funciton connects given device to ethernet modem
     *  @param  device: Configured Ethernet device
     *  @retrun 1 if device was successfully connected, else error code (less than 0)
     */
    public int InsertDevice(SpeakerDevice device){
        return ((soundcardApi.InsertDevice(soundCard, device) < 0) ? -1 : 1);
    }
    /**
     *  Funciton connects given device to USB hub
     *  @param  device: Configured USB flash device
     *  @retrun 1 if device was successfully connected, else error code (less than 0)
     */
    public int InsertDevice(UsbFlash device){
        return ((usbApi.InsertDevice(usbHub, device) < 0) ? -1 : 1);
    }
    //--------------------------------------------------------------------------------------------------
    // Eject given device
    /**
     *  Function ejects CPU device
     *  @param  device: Empty CPU device object
     *  @return CPU device object, if it exists, else null
     */
    public CpuDevice EjectDevice(CpuDevice device){
        device = cpuApi.GetDevice(cpuSocket);
        cpuApi.EjectDevice(cpuSocket);
        return device;
    }
    /**
     *  Function ejects DDR device from specify DDR socket
     *  @param  device: Empty DDR device object
     *  @param  socketNum: Number of socket to eject device
     *  @return DDR device object, if it exists, else null
     */
    public DdrDevice EjectDevice(DdrDevice device, int socketNum){
        if (socketNum > ddrSocket.length){ return null; }
        device = ddrApi.GetDevice(ddrSocket[socketNum - 1]);
        ddrApi.EjectDevice(ddrSocket[socketNum - 1]);
        return device;
    }
    /**
     *  Function disconnects Ethernet device from modem
     *  @param  device: Empty Ethernet device object
     *  @return Ethernet device object, if it exists, else null
     */
    public EthernetDevice EjectDevice(EthernetDevice device){
        device = ethernetApi.GetDevice(ethernetModem);
        ethernetApi.EjectDevice(ethernetModem);
        return device;
    }
    /**
     *  Function ejects DDR device from specify DDR socket
     *  @param  device: Empty DDR device object
     *  @param  socketNum: Number of socket to eject device
     *  @return DDR device object, if it exists, else null
     */
    public GpuDevice EjectDevice(GpuDevice device, int socketNum){
        if (socketNum > pciSocket.length){ return null; }
        device = pciApi.GetDevice(pciSocket[socketNum - 1]);
        pciApi.EjectDevice(pciSocket[socketNum - 1]);
        return device;
    }
    /**
     *  Function ejects HDD device from specify SATA socket
     *  @param  device: Empty HDD device object
     *  @param  socketNum: Number of socket to eject device
     *  @return HDD device object, if it exists, else null
     */
    public HddDevice EjectDevice(HddDevice device, int socketNum){
        if (socketNum > sataSocket.length){ return null; }
        device = sataApi.GetDevice(sataSocket[socketNum - 1]);
        sataApi.EjectDevice(sataSocket[socketNum - 1]);
        return device;
    }
    /**
     *  Function disconnects Speaker device from soundcard
     *  @param  device: Empty Ethernet device object
     *  @return Ethernet device object, if it exists, else null
     */
    public SpeakerDevice EjectDevice(SpeakerDevice device){
        device = soundcardApi.GetDevice(soundCard);
        soundcardApi.EjectDevice(soundCard);
        return device;
    }
    /**
     *  Function disconnects USB flash device from USB hub
     *  @param  device: Empty USB flash device object
     *  @return USB flash device object, if it exists, else null
     */
    public UsbFlash EjectDevice(UsbFlash device){
        device = usbApi.GetDevice(usbHub);
        usbApi.EjectDevice(usbHub);
        return device;
    }
    // *******************************************************************************************************
    // Onboard sockets API
    // *******************************************************************************************************
    // CPU socket API
    private class CpuApi{
        /**
         *  @see    cpu_socket.CpuSocket.IsFree
         */
        public int IsFree(CpuSocket socket){
            int endcode;
            endcode = socket.IsFree();
            return debug.ErrorLog(endcode, "CpuApi > IsFree");
        }
        /**
         *  @see    cpu_socket.CpuSocket.InsertDevice
         */
        public int InsertDevice(CpuSocket socket, CpuDevice device){
            int endcode;
            endcode = socket.InsertDevice(device);
            return debug.ErrorLog(endcode, "CpuApi > InsertDevice");
        }
        /**
         *  @see    cpu_socket.CpuSocket.EjectDevice
         */
        public int EjectDevice(CpuSocket socket){
            int endcode;
            endcode = socket.EjectDevice();
            return debug.ErrorLog(endcode, "CpuApi > EjectDevice");
        }
        /**
         *  @see    cpu_socket.CpuSocket.GetDevice
         */
        public CpuDevice GetDevice(CpuSocket socket){
            CpuDevice device;
            device = socket.GetDevice();
            debug.ErrorLog(((device == null) ? -1 : 1), "CpuApi > GetDevice");
            return device;
        }
    }
    //--------------------------------------------------------------------------------------------------
    // DDR socket API
    private class DdrApi{
        /**
         *  @see    ddr_socket.DdrSocket.IsFree
         */
        public int IsFree(DdrSocket socket){
            int endcode;
            endcode = socket.IsFree();
            return debug.ErrorLog(endcode, "DdrApi > IsFree");
        }
        /**
         *  @see    ddr_socket.DdrSocket.InsertDevice
         */
        public int InsertDevice(DdrSocket socket, DdrDevice device){
            int endcode;
            endcode = socket.InsertDevice(device);
            return debug.ErrorLog(endcode, "DdrApi > InsertDevice");
        }
        /**
         *  @see    ddr_socket.DdrSocket.EjectDevice
         */
        public int EjectDevice(DdrSocket socket){
            int endcode;
            endcode = socket.EjectDevice();
            return debug.ErrorLog(endcode, "DdrApi > EjectDevice");
        }
        /**
         *  @see    ddr_socket.DdrSocket.GetDevice
         */
        public DdrDevice GetDevice(DdrSocket socket){
            DdrDevice device;
            device = socket.GetDevice();
            debug.ErrorLog(((device == null) ? -1 : 1), "DdrApi > GetDevice");
            return device;
        }
    }
    //--------------------------------------------------------------------------------------------------
    // Ethernet modem API
    private class EthernetApi{
        /**
         *  @see    ethernet_modem.EthernetModem.IsFree
         */
        public int IsFree(EthernetModem modem){
            int endcode;
            endcode = modem.IsFree();
            return debug.ErrorLog(endcode, "EthernetApi > IsFree");
        }
        /**
         *  @see    ethernet_modem.EthernetModem.InsertDevice
         */
        public int InsertDevice(EthernetModem modem, EthernetDevice device){
            int endcode;
            endcode = modem.InsertDevice(device);
            return debug.ErrorLog(endcode, "EthernetApi > InsertDevice");
        }
        /**
         *  @see    ethernet_modem.EthernetModem.EjectDevice
         */
        public int EjectDevice(EthernetModem modem){
            int endcode;
            endcode = modem.EjectDevice();
            return debug.ErrorLog(endcode, "EthernetApi > EjectDevice");
        }
        /**
         *  @see    ethernet_modem.EthernetModem.GetDevice
         */
        public EthernetDevice GetDevice(EthernetModem modem){
            EthernetDevice device;
            device = modem.GetDevice();
            debug.ErrorLog(((device == null) ? -1 : 1), "EthernetApi > GetDevice");
            return device;
        }
    }
    //--------------------------------------------------------------------------------------------------
    // PCI cocket API
    private class PciApi{
        /**
         *  @see    pci_socket.PciSocket.IsFree
         */
        public int IsFree(PciSocket socket){
            int endcode;
            endcode = socket.IsFree();
            return debug.ErrorLog(endcode, "PciApi > IsFree");
        }
        /**
         *  @see    pci_socket.PciSocket.InsertDevice
         */
        public int InsertDevice(PciSocket socket, GpuDevice device){
            int endcode;
            endcode = socket.InsertDevice(device);
            return debug.ErrorLog(endcode, "PciApi > InsertDevice");
        }
        /**
         *  @see    pci_socket.PciSocket.EjectDevice
         */
        public int EjectDevice(PciSocket socket){
            int endcode;
            endcode = socket.EjectDevice();
            return debug.ErrorLog(endcode, "PciApi > EjectDevice");
        }
        /**
         *  @see    pci_socket.PciSocket.GetDevice
         */
        public GpuDevice GetDevice(PciSocket socket){
            GpuDevice device;
            device = socket.GetDevice();
            debug.ErrorLog(((device == null) ? -1 : 1), "PciApi > GetDevice");
            return device;
        }
    }
    //--------------------------------------------------------------------------------------------------
    // SATA cocket API
    private class SataApi{
        /**
         *  @see    sata_socket.SataSocket.IsFree
         */
        public int IsFree(SataSocket socket){
            int endcode;
            endcode = socket.IsFree();
            return debug.ErrorLog(endcode, "SataApi > IsFree");
        }
        /**
         *  @see    sata_socket.SataSocket.InsertDevice
         */
        public int InsertDevice(SataSocket socket, HddDevice device){
            int endcode;
            endcode = socket.InsertDevice(device);
            return debug.ErrorLog(endcode, "SataApi > InsertDevice");
        }
        /**
         *  @see    sata_socket.SataSocket.EjectDevice
         */
        public int EjectDevice(SataSocket socket){
            int endcode;
            endcode = socket.EjectDevice();
            return debug.ErrorLog(endcode, "SataApi > EjectDevice");
        }
        /**
         *  @see    sata_socket.SataSocket.GetDevice
         */
        public HddDevice GetDevice(SataSocket socket){
            HddDevice device;
            device = socket.GetDevice();
            debug.ErrorLog(((device == null) ? -1 : 1), "SataApi > GetDevice");
            return device;
        }
    }
    //--------------------------------------------------------------------------------------------------
    // Soundcard API
    private class SoundcardApi{
        /**
         *  @see    sound_card.SoundCard.IsFree
         */
        public int IsFree(SoundCard chip){
            int endcode;
            endcode = chip.IsFree();
            return debug.ErrorLog(endcode, "SoundcardApi > IsFree");
        }
        /**
         *  @see    sound_card.SoundCard.InsertDevice
         */
        public int InsertDevice(SoundCard chip, SpeakerDevice device){
            int endcode;
            endcode = chip.InsertDevice(device);
            return debug.ErrorLog(endcode, "SoundcardApi > InsertDevice");
        }
        /**
         *  @see    sound_card.SoundCard.EjectDevice
         */
        public int EjectDevice(SoundCard chip){
            int endcode;
            endcode = chip.EjectDevice();
            return debug.ErrorLog(endcode, "SoundcardApi > EjectDevice");
        }
        /**
         *  @see    sound_card.SoundCard.GetDevice
         */
        public SpeakerDevice GetDevice(SoundCard chip){
            SpeakerDevice device;
            device = chip.GetDevice();
            debug.ErrorLog(((device == null) ? -1 : 1), "SoundcardApi > GetDevice");
            return device;
        }
    }
    //--------------------------------------------------------------------------------------------------
    // USB hub API
    private class UsbApi{
        /**
         *  @see    usb_hub.UsbHub.IsFree
         */
        public int IsFree(UsbHub socket){
            int endcode;
            endcode = socket.IsFree();
            return debug.ErrorLog(endcode, "UsbApi > IsFree");
        }
        /**
         *  @see    usb_hub.UsbHub.InsertDevice
         */
        public int InsertDevice(UsbHub socket, UsbFlash device){
            int endcode;
            endcode = socket.InsertDevice(device);
            return debug.ErrorLog(endcode, "UsbApi > InsertDevice");
        }
        /**
         *  @see    usb_hub.UsbHub.EjectDevice
         */
        public int EjectDevice(UsbHub socket){
            int endcode;
            endcode = socket.EjectDevice();
            return debug.ErrorLog(endcode, "UsbApi > EjectDevice");
        }
        /**
         *  @see    usb_hub.UsbHub.GetDevice
         */
        public UsbFlash GetDevice(UsbHub socket){
            UsbFlash device;
            device = socket.GetDevice();
            debug.ErrorLog(((device == null) ? -1 : 1), "UsbApi > GetDevice");
            return device;
        }
    }
}
