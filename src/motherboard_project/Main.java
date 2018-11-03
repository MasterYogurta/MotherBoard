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

import cpu_device.CpuDevice;
import ddr_device.DdrDevice;
import ethernet_device.EthernetDevice;
import gpu_device.GpuDevice;
import hdd_device.HddDevice;
import speaker_device.SpeakerDevice;
import usb_flash.UsbFlash;

import debug_log.DebugLog;

public class Main {
    private static DebugLog debug = new DebugLog();

    public static void main(String[] args) {
        ConfigureMotherboard();

        String string = new String();
    }

    public static void ConfigureMotherboard(){
        // Motherboard sockets
        CpuSocket cpuSocket1            = new CpuSocket();
        DdrSocket ddrSocket1            = new DdrSocket();
        DdrSocket ddrSocket2            = new DdrSocket();
        SataSocket sataSocket1          = new SataSocket();
        PciSocket pciSocket1            = new PciSocket();
        SoundCard soundCard1            = new SoundCard();
        UsbHub usbHub1                  = new UsbHub();
        EthernetModem ethernetModem1    = new EthernetModem();

        MotherBoard motherboard1        = new MotherBoard();

        // Sockets configuration
        cpuSocket1.ConfigureSocket("22", "AM3825", "MahNigga");
        ddrSocket1.ConfigureFamilyTypes("DDR2", "DDR3");
        ddrSocket1.ConfigureFrequency(2222, 1300, 2666);
        ddrSocket2.ConfigureFamilyTypes("DDR2", "DDR3", "DDR4");
        ddrSocket2.ConfigureFrequency(2600, 1800, 2222);
        sataSocket1.ConfigureInterface("SATA 1.0", "SATA 2.0");
        pciSocket1.ConfigureBusWidth(128);
        soundCard1.ConfigureChannel(5.0);
        usbHub1.ConfigureInterface("USB 1.0", "USB 2.0");
        ethernetModem1.ConfigureInterface("10Mbit", "100Mbit");

        // Peripheral devices
        CpuDevice cpuDevice1            = new CpuDevice("AMD", "22", 6, 4.4, 120);
        DdrDevice ddrDevice1            = new DdrDevice("Samsung", "DDR4", 2222, "16-12-13", 22);
        DdrDevice ddrDevice2            = new DdrDevice("ZalupaKonya", "DDR3", 1300, "13-10-11", 1);
        EthernetDevice ethernetDevice1  = new EthernetDevice("100Mbit");
        GpuDevice gpuDevice1            = new GpuDevice("Radeon", 128, "4Gb", "DVI", 220);
        HddDevice hddDevice1            = new HddDevice("Samsung", "SATA 2.0", "256Gb", 20);
        SpeakerDevice speakerDevice1    = new SpeakerDevice(3.0);
        UsbFlash usbFlash1              = new UsbFlash("USB 2.0", "8Gb");

        // Configure motherboard
        motherboard1.IsMotherBoardConfigured();
        motherboard1.ConfigureOnboardDevice(cpuSocket1);
        motherboard1.ConfigureOnboardDevice(ddrSocket1, ddrSocket2);
        motherboard1.ConfigureOnboardDevice(sataSocket1);
        motherboard1.ConfigureOnboardDevice(pciSocket1);
        motherboard1.ConfigureOnboardDevice(soundCard1);
        motherboard1.IsMotherBoardConfigured();
        motherboard1.ConfigureOnboardDevice(usbHub1);
        motherboard1.ConfigureOnboardDevice(ethernetModem1);
        motherboard1.IsMotherBoardConfigured();

        motherboard1.DisplayConfig();

        // Insert devices
        motherboard1.DisplayPeripheral();
        motherboard1.InsertDevice(cpuDevice1);
        motherboard1.InsertDevice(ddrDevice1, 2);
        motherboard1.InsertDevice(ddrDevice2, 1);
        motherboard1.InsertDevice(ethernetDevice1);
        motherboard1.InsertDevice(gpuDevice1, 1);
        motherboard1.InsertDevice(hddDevice1, 1);
        motherboard1.InsertDevice(speakerDevice1);
        motherboard1.InsertDevice(usbFlash1);

        // Eject devices
        motherboard1.DisplayPeripheral();
        motherboard1.EjectDevice(cpuDevice1);
        motherboard1.EjectDevice(ddrDevice1, 2);
        motherboard1.EjectDevice(ddrDevice2, 1);
        motherboard1.EjectDevice(ethernetDevice1);
        motherboard1.EjectDevice(gpuDevice1, 1);
        motherboard1.EjectDevice(hddDevice1, 1);
        motherboard1.EjectDevice(speakerDevice1);
        motherboard1.EjectDevice(usbFlash1);
        motherboard1.DisplayPeripheral();
    }
}
