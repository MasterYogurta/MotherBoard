// Main class

package motherboard_project;

import motherboard.MotherBoard;

import cpu_socket.CpuSocket;
import ddr_socket.DdrSocket;
import sata_socket.SataSocket;
import pci_socket.PciSocket;
import sound_card.SoundCard;
import usb_hub.UsbHub;
import ethernet_modem.EthernetModem;

import debug_log.DebugLog;

public class Main {
    private static DebugLog debug = new DebugLog();

    public static void main(String[] args) {
        ConfigureMotherboard();
    }

    public static void ConfigureMotherboard(){
        CpuSocket cpuSocket1            = new CpuSocket();
        DdrSocket ddrSocket1            = new DdrSocket();
        SataSocket sataSocket1          = new SataSocket();
        PciSocket pciSocket1            = new PciSocket();
        SoundCard soundCard1            = new SoundCard();
        UsbHub usbHub1                  = new UsbHub();
        EthernetModem ethernetModem1    = new EthernetModem();

        MotherBoard motherboard1        = new MotherBoard();

        cpuSocket1.ConfigureSocket("22", "AM3825", "MahNigga");

        motherboard1.ConfigureOnboardDevice(cpuSocket1);
        motherboard1.ConfigureOnboardDevice(ddrSocket1);
        motherboard1.ConfigureOnboardDevice(sataSocket1);
        motherboard1.ConfigureOnboardDevice(pciSocket1);
        motherboard1.ConfigureOnboardDevice(soundCard1);
        motherboard1.ConfigureOnboardDevice(usbHub1);
        motherboard1.ConfigureOnboardDevice(ethernetModem1);
    }
}
