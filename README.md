# tigertouch
JavaFX example of a stacked window system for embeded RPI.

I use this method on a RPI 4 system with only a touch monitor attached and no mouse or keyboard.

This does not require X to be running on the RPI 4, which cuts down on memory and CPU load. Without
X loaded the GUI runs in the framebuffer /dev/fb0.

I have only been able to get this to work using the Java 32 bit version of BellSoft Leberia JDK full. The
64 bit version seems to be missing the monocle jar and .so files. If anyone knows how to get this to
work let me know please.

This method is not completely my idea, some of this code was taken from someone else but sadly
I did not keep track of who.

I heavily modified it a lot by adding the RefreshScene interface and stored other data.

# Features

- Uses a stacked pane.
- Uses a FIFO to manage Scenes.
- Uses push and pop to traverse Scenes
- Stores data on each scene.
- Calls methods to refreash scene, when you come back to it.
- Calls method when leaving a scene.
- Programmatically press a button and navagate scenes.

# Running tigertouch

Install RPI 32 or 64 bit OS.  If you want thinga to run faster boot from a SSD drive instead of the SD card
the instructions to do this.

[Install OS on SSD](https://linuxhint.com/how_to_boot_raspberry_pi_4_from_usb_ssd/)

The RPI OS can be either 32 bit or 64 bit but must run 32 bit Java.  Use [BellSoft](https://bell-sw.com) to
download the version you need. I have tested Java 16 and 18.

Once you download the BellSoft Java .deb package, to install it on a RPI 4 use the following command.

sudo apt install -y ./bellsoft-jdk18.0.1.1+2-linux-arm32-vfp-hflt-full.deb 

Your version maybe different.

Clone the repository from github.

git clone git@github.com:tigerkelly/tigertouch.git

The clone account contains the source code to the tigertouch GUI in the tigertouch directory and also
contains a compiled jar with supported jars to run tigertouch.

The tigertouch directory is an export of a Eclipse project, so import this into Eclipse if you want to compile
from source or make changes.

To run without compiling the java source. In the pi home directory.

tar xvzf TigerTouch.tgz

The directory TigerTouch directory from the archive about contains jars and other files need to run tigertouch.
The bin directory will contain the shell script call tigertouch thay will exec the TigerTouch example program.

The command line to execute the test program is pretty long, so it became a script.
