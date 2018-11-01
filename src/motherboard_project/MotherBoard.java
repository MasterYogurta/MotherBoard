// MotherBoard class

package motherboard;

import cpu_socket.CpuSocket;
import ddr_socket.DdrSocket;
import sata_socket.SataSocket;
import pci_socket.PciSocket;
import sound_card.SoundCard;
import usb_hub.UsbHub;
import ethernet_modem.EthernetModem;

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
        for (DdrSocket socket : ddrSocket){
            if (socket.IsReady() < (0)){
                return debug.ErrorLog((-2), "Failed to configure ddrSocket");
            }
        }
        this.ddrSocket = ddrSocket;
        debug.UserLog("DdrSocket configured. " + "Number of sockets : " + ddrSocket.length);
        return 1;
    }
    public int ConfigureOnboardDevice(SataSocket ... sataSocket){
        for (SataSocket socket : sataSocket){
            if (socket.IsReady() < (0)){
                return debug.ErrorLog((-3), "Failed to configure sataSocket");
            }
        }
        this.sataSocket = sataSocket;
        debug.UserLog("SataSocket configured. " + "Number of sockets : " + sataSocket.length);
        return 1;
    }
    public int ConfigureOnboardDevice(PciSocket ... pciSocket){
        for (PciSocket socket : pciSocket){
            if (socket.IsReady() < (0)){
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
}
