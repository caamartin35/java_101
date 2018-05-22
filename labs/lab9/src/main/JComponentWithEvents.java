package main;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine.Info;
import javax.swing.Icon;
import javax.swing.JApplet;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class JComponentWithEvents extends JComponent implements MouseListener, MouseMotionListener, KeyListener, ComponentListener, ActionListener, Runnable {
    public static final char UP = '&';
    public static final char DOWN = '(';
    public static final char LEFT = '%';
    public static final char RIGHT = '\'';
    public static final char DELETE = '\u007f';
    public static final char HOME = '$';
    public static final char PAGE_UP = '!';
    public static final char PAGE_DOWN = '"';
    public static final char END = '#';
    public static final char SPACE = ' ';
    public static final char BACK_SPACE = '\b';
    public static final char ENTER = '\n';
    public static final char ESCAPE = '\u001b';
    public static final char SHIFT = '\u0010';
    public static final char CAPS_LOCK = '\u0014';
    public static final char CONTROL = '\u0011';
    public static final char ALT = '\u0012';
    public static final char F1 = 'p';
    public static final char F2 = 'q';
    public static final char F3 = 'r';
    public static final char F4 = 's';
    public static final char F5 = 't';
    public static final char F6 = 'u';
    public static final char F7 = 'v';
    public static final char F8 = 'w';
    public static final char F9 = 'x';
    public static final char F10 = 'y';
    public static final char F11 = 'z';
    public static final char F12 = '{';
    private static final int NO_REASON = 0;
    private static final int CHECK_VERSION_REASON = 1;
    private int privateConstructorReason = 0;
    public static final int version = 4;
    private static boolean checkedVersion = false;
    private static HashMap<String, Image> fileToImageMap = new HashMap();
    private int _defaultWidth;
    private int _defaultHeight;
    private boolean _paused = false;
    private boolean _exited = false;
    private char _pauseKey = 0;
    private char _unpauseKey = 'p';
    private static int width0 = -1;
    private static int height0 = -1;
    private boolean started = false;
    private boolean isApplet = true;
    private JApplet applet = null;
    private boolean timerStopped = false;
    private String[] warningMessage = null;
    private Timer timer;
    private int _timerDelay = 250;
    private MouseEvent currentMouseEvent = null;
    private KeyEvent currentKeyEvent = null;
    private boolean ignoreModifierKeys = true;
    private HashMap<String, byte[]> fileCache = new HashMap();
    private HashSet<String> badAppletLocations = new HashSet();
    private Sequencer sequencer = null;
    private ArrayList<Clip> wavClips = new ArrayList();

    public void start() {
    }

    public void timerFired() {
    }

    public void paint(Graphics2D var1) {
    }

    public void mousePressed(int var1, int var2) {
    }

    public void mouseDragged(int var1, int var2) {
    }

    public void mouseReleased(int var1, int var2) {
    }

    public void mouseClicked(int var1, int var2, int var3) {
    }

    public void mouseMoved(int var1, int var2) {
    }

    public void mouseEntered(int var1, int var2) {
    }

    public void mouseExited(int var1, int var2) {
    }

    public void keyPressed(char var1) {
    }

    public void keyReleased(char var1) {
    }

    public void keyTyped(char var1) {
    }

    public void componentResized() {
    }

    public void beep() {
        this.doBeep();
    }

    public void exit() {
        this.doExit();
    }

    public int getTimerDelay() {
        return this._timerDelay;
    }

    public void setTimerDelay(int var1) {
        this.doSetTimerDelay(var1);
    }

    public void stopTimer() {
        this.doStopTimer();
    }

    public boolean isPaused() {
        return this._paused;
    }

    public void setPaused(boolean var1) {
        this._paused = var1;
    }

    public char getPauseKey() {
        return this._pauseKey;
    }

    public void setPauseKey(char var1) {
        this._pauseKey = var1;
    }

    public char getUnpauseKey() {
        return this._unpauseKey;
    }

    public void setUnpauseKey(char var1) {
        this._unpauseKey = var1;
    }

    public void setIgnoreModifierKeys(boolean var1) {
        this.ignoreModifierKeys = var1;
    }

    public void play(String var1) {
        this.doPlay(var1, false);
    }

    public void loop(String var1) {
        this.doPlay(var1, true);
    }

    public void stopSounds() {
        this.doStopSounds();
    }

    public MouseEvent getMouseEvent() {
        return this.currentMouseEvent;
    }

    public KeyEvent getKeyEvent() {
        return this.currentKeyEvent;
    }

    private JComponentWithEvents(int var1) {
        this.privateConstructorReason = var1;
    }

    public static final int getVersion() {
        return 4;
    }

    private final void checkVersion() {
        if (!checkedVersion) {
            checkedVersion = true;
            (new Thread(new JComponentWithEvents(1))).start();
        }
    }

    private final void runVersionCheckerInstance() {
        try {
            String var1 = "http://kosbie.net/cmu/JComponentWithEvents/";
            Scanner var9 = null;

            try {
                var9 = new Scanner((new URL(var1)).openStream());
            } catch (Exception var7) {
                if (this.isApplet) {
                    return;
                }
            }

            if (var9 == null) {
                throw new RuntimeException("Cannot load version checker from " + var1);
            } else {
                boolean var3 = true;

                String var4;
                do {
                    if (!var9.hasNext()) {
                        throw new RuntimeException("Cannot find version number in JComponentWithEventsVersion.html");
                    }

                    var4 = var9.next();
                } while(!var4.startsWith("version="));

                var4 = var4.substring("version=".length());
                int var5 = 0;

                for(int var6 = 0; var6 < var4.length() && Character.isDigit(var4.charAt(var6)); ++var6) {
                    var5 = 10 * var5 + var4.charAt(var6) - 48;
                }

                this.checkVersion(var5);
            }
        } catch (Exception var8) {
            String var2 = "Error in JComponentWithEvent.checkVersion: \n  " + var8;
            this.showMessageDialog(var2);
            System.err.println(var2);
        }
    }

    private void checkVersion(int var1) {
        if (4 != var1) {
            String var2 = "http://kosbie.net/cmu/JComponentWithEvents/";
            String var3 = "A different version of JComponentWithEvents is available.\nYou are using version 4.\nThe current version is version " + var1 + ".\n" + "Please see the following web page to download the current version:\n" + "   " + var2;
            System.err.println(var3);
            this.showUrlInBrowser(var2);
            String var4 = var3 + "\n\nProceed with installed version anyway?";
            if (!this.showYesNoDialog(var4)) {
                this.exit();
            }

        }
    }

    private void showUrlInBrowser(String var1) {
        if (this.applet != null) {
            try {
                this.applet.getAppletContext().showDocument(new URL(var1), "_blank");
            } catch (Exception var3) {
                var3.printStackTrace();
            }
        } else {
            Object var2 = null;
            if (exec("iexplore.exe", var1) != null) {
                return;
            }

            if (exec("\"C:\\Program Files\\Internet Explorer\\IEXPLORE.EXE\"", var1) != null) {
                return;
            }

            if (exec("open", "-a", "Firefox.app", var1) != null) {
                return;
            }
        }

    }

    private static Process exec(String... var0) {
        try {
            return Runtime.getRuntime().exec(var0);
        } catch (Exception var2) {
            return null;
        }
    }

    public void showMessageDialog(String var1) {
        JOptionPane.showMessageDialog(this, var1);
    }

    public int showOptionDialog(String var1, String... var2) {
        int var3 = -1;

        while(var3 < 0) {
            var3 = JOptionPane.showOptionDialog(this, var1, "Please choose...", -1, 3, (Icon)null, var2, var2[0]);
            if (var3 < 0) {
                this.beep();
            }
        }

        return var3;
    }

    public boolean showYesNoDialog(String var1) {
        int var2 = -1;

        while(var2 < 0) {
            var2 = this.showOptionDialog(var1, "Yes", "No");
            if (var2 < 0) {
                this.beep();
            }
        }

        return var2 == 0;
    }

    public String showInputDialog(String var1) {
        String var2 = null;

        while(var2 == null) {
            var2 = JOptionPane.showInputDialog(this, var1);
            if (var2 == null) {
                this.beep();
            }
        }

        return var2;
    }

    public static void setLineThickness(Graphics var0, int var1) {
        if (var1 < 0) {
            var1 = 0;
        }

        ((Graphics2D)var0).setStroke(new BasicStroke((float)var1));
    }

    public static int getStringWidth(Graphics var0, Font var1, String var2) {
        FontMetrics var3 = var0.getFontMetrics(var1);
        Rectangle2D var4 = var3.getStringBounds(var2, var0);
        return (int)Math.round(var4.getWidth());
    }

    public static int getStringHeight(Graphics var0, Font var1, String var2) {
        FontMetrics var3 = var0.getFontMetrics(var1);
        Rectangle2D var4 = var3.getStringBounds(var2, var0);
        return (int)Math.round(var4.getHeight());
    }

    public static int getStringAscent(Graphics var0, Font var1, String var2) {
        FontMetrics var3 = var0.getFontMetrics(var1);
        return var3.getAscent();
    }

    public static void drawCenteredString(Graphics var0, String var1, int var2, int var3, int var4, int var5) {
        Font var6 = var0.getFont();
        int var7 = getStringWidth(var0, var6, var1);
        int var8 = getStringHeight(var0, var6, var1);
        int var9 = getStringAscent(var0, var6, var1);
        int var10 = var2 + (var4 - var7) / 2;
        int var11 = var3 + (var5 - var8) / 2 + var9;
        var0.drawString(var1, var10, var11);
    }

    public void drawImage(Graphics var1, String var2, int var3, int var4, double var5, double var7) {
        Image var9 = this.getImageFromFile(var2);
        this.drawImage(var1, var9, var3, var4, var5, var7);
    }

    public void drawCenteredImage(Graphics var1, String var2, int var3, int var4, double var5, double var7) {
        Image var9 = this.getImageFromFile(var2);
        this.drawCenteredImage(var1, var9, var3, var4, var5, var7);
    }

    public void drawImage(Graphics var1, Image var2, int var3, int var4, double var5, double var7) {
        double var9 = (double)var2.getWidth((ImageObserver)null);
        double var11 = (double)var2.getHeight((ImageObserver)null);
        Dimension var13 = this.getImageSize(var2, var5, var7);
        AffineTransform var14 = new AffineTransform();
        var14.translate((double)var3 + var13.getWidth() / 2.0D, (double)var4 + var13.getHeight() / 2.0D);
        var14.rotate(var7);
        var14.scale(var5, var5);
        var14.translate(-var9 / 2.0D, -var11 / 2.0D);
        ((Graphics2D)var1).drawImage(var2, var14, (ImageObserver)null);
    }

    public void drawCenteredImage(Graphics var1, Image var2, int var3, int var4, double var5, double var7) {
        Dimension var9 = this.getImageSize(var2, var5, var7);
        this.drawImage(var1, var2, var3 - (int)(var9.getWidth() / 2.0D), var4 - (int)(var9.getHeight() / 2.0D), var5, var7);
    }

    public Dimension getImageSize(String var1, double var2, double var4) {
        Image var6 = this.getImageFromFile(var1);
        return this.getImageSize(var6, var2, var4);
    }

    public Dimension getImageSize(Image var1, double var2, double var4) {
        double var6 = (double)var1.getWidth((ImageObserver)null);
        double var8 = (double)var1.getHeight((ImageObserver)null);
        AffineTransform var10 = new AffineTransform();
        var10.rotate(var4);
        var10.scale(var2, var2);
        var10.translate(-var6 / 2.0D, -var8 / 2.0D);
        double[] var11 = new double[]{0.0D, var6, var6, 0.0D};
        double[] var12 = new double[]{0.0D, 0.0D, var8, var8};
        double var13 = 0.0D;
        double var15 = 0.0D;
        double var17 = 0.0D;
        double var19 = 0.0D;
        Double var21 = new Double();
        Double var22 = new Double();

        for(int var23 = 0; var23 < 4; ++var23) {
            var21.setLocation(var11[var23], var12[var23]);
            var10.transform(var21, var22);
            if (var23 == 0) {
                var13 = var15 = var22.getX();
                var17 = var19 = var22.getY();
            } else {
                var13 = Math.min(var22.getX(), var13);
                var17 = Math.min(var22.getY(), var17);
                var15 = Math.max(var22.getX(), var15);
                var19 = Math.max(var22.getY(), var19);
            }
        }

        return new Dimension((int)(var15 - var13), (int)(var19 - var17));
    }

    public Image getImageFromFile(String var1) {
        Image var2 = (Image)fileToImageMap.get(var1);
        if (var2 != null) {
            return var2;
        } else {
            URL var3 = null;
            Object var6;
            if (this.applet != null) {
                try {
                    var3 = new URL(this.applet.getCodeBase(), var1);
                    var6 = this.applet.getImage(var3);
                } catch (Exception var5) {
                    throw new RuntimeException("" + var5);
                }
            } else {
                var6 = this.loadBufferedImage(var1);
            }

            fileToImageMap.put(var1, (Image) var6);
            return (Image)var6;
        }
    }

    public static boolean shapesIntersect(Shape var0, Shape var1) {
        Area var2 = new Area(var0);
        var2.intersect(new Area(var1));
        return !var2.isEmpty();
    }

    public InputStream getResourceAsStream(String var1) {
        InputStream var2 = this.getClass().getResourceAsStream(var1);
        if (var2 == null) {
            throw new RuntimeException("File " + var1 + " does not exist");
        } else {
            return var2;
        }
    }

    public BufferedImage loadBufferedImage(String var1) {
        InputStream var2 = this.getResourceAsStream(var1);

        try {
            return ImageIO.read(var2);
        } catch (Exception var4) {
            throw new RuntimeException(var4);
        }
    }

    public void saveBufferedImage(BufferedImage var1, String var2) {
        int var3 = var2.lastIndexOf(46);
        if (var3 < 0) {
            throw new RuntimeException("file must end in .jpg, .png, etc");
        } else {
            String var4 = var2.substring(var3 + 1);
            String[] var5 = ImageIO.getReaderFormatNames();
            if (Arrays.binarySearch(var5, var4) < 0) {
                throw new RuntimeException("Illegal format " + var4 + " not in " + Arrays.toString(var5));
            } else {
                try {
                    ImageIO.write(var1, var4, new File(var2));
                } catch (Exception var7) {
                    throw new RuntimeException(var7);
                }
            }
        }
    }

    public static synchronized JComponentWithEvents newInstance(Class var0, int var1, int var2) {
        JComponentWithEvents var3 = null;
        if (width0 != -1) {
            throw new RuntimeException("width0 is not -1");
        } else {
            try {
                width0 = var1;
                height0 = var2;
                var3 = (JComponentWithEvents)var0.newInstance();
            } catch (Exception var8) {
                System.out.println("Err!");
                var8.printStackTrace();
            } finally {
                width0 = -1;
                height0 = -1;
            }

            return var3;
        }
    }

    public JComponentWithEvents() {
        if (width0 != -1) {
            this._defaultWidth = width0;
            this._defaultHeight = height0;
            this.setPreferredSize(new Dimension(this._defaultWidth, this._defaultHeight));
        }
    }

    private void deferredDoStart() {
        if (!this.started) {
            this.start();
            this.repaint();
            this.started = true;
        }

    }

    public void run() {
        if (this.privateConstructorReason == 1) {
            this.runVersionCheckerInstance();
        } else {
            this.deferredDoStart();
        }

    }

    private void doStart() {
        SwingUtilities.invokeLater(this);
    }

    public int getWidth() {
        int var1 = super.getWidth();
        return var1 > 0 ? var1 : this._defaultWidth;
    }

    public int getHeight() {
        int var1 = super.getHeight();
        return var1 > 0 ? var1 : this._defaultHeight;
    }

    public void paint(Graphics var1) {
        super.paint(var1);
    }

    public void paintComponent(Graphics var1) {
        if (this.timer == null) {
            this.timer = new Timer(this._timerDelay, this);
            if (!this.timerStopped) {
                this.timer.start();
            }
        }

        if (this.started) {
            var1.setColor(Color.white);
            var1.fillRect(0, 0, this.getWidth(), this.getHeight());
            var1.setColor(Color.black);
            if (this.warningMessage != null) {
                var1.setColor(Color.red);
                var1.setFont(new Font("SansSerif", 1, 20));

                for(int var2 = 0; var2 < this.warningMessage.length; ++var2) {
                    var1.drawString(this.warningMessage[var2], 20, 30 + 30 * var2);
                }
            } else if (!this._paused && !this._exited) {
                HashMap var3 = this.getNonLocalVariableValues();
                this.paint((Graphics2D)var1);
                this.checkNonLocalVariableValues(var3);
            } else {
                var1.setFont(new Font("SansSerif", 1, 32));
                drawCenteredString(var1, this._exited ? "Exited!" : "Paused!", 0, 0, this.getWidth(), this.getHeight());
            }

        }
    }

    private void setWarningMessage(String... var1) {
        this.warningMessage = var1;
        this.beep();
        this.repaint();
    }

    private HashMap<Field, Object> getNonLocalVariableValues() {
        try {
            HashMap var1 = new HashMap();
            Field[] var2 = this.getClass().getDeclaredFields();
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                Field var5 = var2[var4];
                var5.setAccessible(true);
                var1.put(var5, this.get(this, var5));
            }

            return var1;
        } catch (Exception var6) {
            return null;
        }
    }

    private void checkNonLocalVariableValues(HashMap<Field, Object> var1) {
        if (var1 != null) {
            Field[] var2 = this.getClass().getDeclaredFields();
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                Field var5 = var2[var4];
                var5.setAccessible(true);
                Object var6 = var1.get(var5);
                Object var7 = this.get(this, var5);
                if (var6 != var7 && (var6 == null || !var6.equals(var7))) {
                    this.setWarningMessage("Warning:  Field changed in paint method!", "Field: " + var5.getName(), "   Changed from: " + var6, "   Changed to: " + var7, "Fields should only be changed in event handlers", "and never in paint methods!");
                }
            }

        }
    }

    private Object get(Object var1, Field var2) {
        var2.setAccessible(true);
        Object var3 = null;

        try {
            var3 = var2.get(var1);
        } catch (Exception var5) {
            ;
        }

        return var3;
    }

    private void doExit() {
        if (this.applet == null) {
            System.exit(0);
        } else {
            this._exited = this._paused = true;
            this.doStopSounds();
        }

    }

    private void doBeep() {
        Toolkit.getDefaultToolkit().beep();
    }

    private void doSetTimerDelay(int var1) {
        this.timerStopped = false;
        this._timerDelay = Math.max(1, var1);
        if (this.timer != null) {
            this.timer.setDelay(this._timerDelay);
            this.timer.setInitialDelay(this._timerDelay);
            this.timer.restart();
        }

    }

    private void doStopTimer() {
        this.timerStopped = true;
        if (this.timer != null) {
            this.timer.stop();
        }

    }

    public void componentShown(ComponentEvent var1) {
    }

    public void componentHidden(ComponentEvent var1) {
    }

    public void componentMoved(ComponentEvent var1) {
    }

    public void componentResized(ComponentEvent var1) {
        if (this.started && !this._paused) {
            this.componentResized();
            this.repaint();
        }
    }

    public void actionPerformed(ActionEvent var1) {
        if (this.started && !this._paused) {
            this.timerFired();
            this.repaint();
        }
    }

    public void mousePressed(MouseEvent var1) {
        if (this.started && !this._paused) {
            this.currentMouseEvent = var1;
            this.mousePressed(var1.getX(), var1.getY());
            this.currentMouseEvent = null;
            this.repaint();
        }
    }

    public void mouseReleased(MouseEvent var1) {
        if (this.started && !this._paused) {
            this.currentMouseEvent = var1;
            this.mouseReleased(var1.getX(), var1.getY());
            this.currentMouseEvent = null;
            this.repaint();
        }
    }

    public void mouseDragged(MouseEvent var1) {
        if (this.started && !this._paused) {
            this.currentMouseEvent = var1;
            this.mouseDragged(var1.getX(), var1.getY());
            this.currentMouseEvent = null;
            this.repaint();
        }
    }

    public void mouseEntered(MouseEvent var1) {
        if (this.started && !this._paused) {
            this.currentMouseEvent = var1;
            this.mouseEntered(var1.getX(), var1.getY());
            this.currentMouseEvent = null;
            this.repaint();
        }
    }

    public void mouseExited(MouseEvent var1) {
        if (this.started && !this._paused) {
            this.currentMouseEvent = var1;
            this.mouseExited(var1.getX(), var1.getY());
            this.currentMouseEvent = var1;
            this.repaint();
        }
    }

    public void mouseClicked(MouseEvent var1) {
        if (this.started && !this._paused) {
            this.currentMouseEvent = var1;
            this.mouseClicked(var1.getX(), var1.getY(), var1.getClickCount());
            this.currentMouseEvent = var1;
            this.repaint();
        }
    }

    public void mouseMoved(MouseEvent var1) {
        if (this.started && !this._paused) {
            this.currentMouseEvent = var1;
            this.mouseMoved(var1.getX(), var1.getY());
            this.currentMouseEvent = var1;
            this.repaint();
        }
    }

    public void keyReleased(KeyEvent var1) {
        if (this.started && !this._paused) {
            char var2 = this.getKeyEventChar(var1);
            if (var2 != 0) {
                this.currentKeyEvent = var1;
                this.keyReleased(var2);
                this.currentKeyEvent = null;
                this.repaint();
            }
        }
    }

    public void keyTyped(KeyEvent var1) {
        if (this.started && !this._paused) {
            char var2 = this.getKeyEventChar(var1);
            if (var2 != 0) {
                this.currentKeyEvent = var1;
                this.keyTyped(var2);
                this.currentKeyEvent = null;
                this.repaint();
            }
        }
    }

    public void keyPressed(KeyEvent var1) {
        if (this.started && !this._exited) {
            char var2 = this.getKeyEventChar(var1);
            if (var2 != 0) {
                this.currentKeyEvent = var1;
                if (!this._paused && var2 == this._pauseKey) {
                    this._paused = true;
                    this.doPauseSounds();
                } else if (this._paused && !this._exited && var2 == this._unpauseKey) {
                    this._paused = false;
                    this.doUnpauseSounds();
                } else {
                    this.keyPressed(var2);
                }

                this.currentKeyEvent = null;
                this.repaint();
            }
        }
    }

    private char getKeyEventChar(KeyEvent var1) {
        int var2 = var1.getKeyCode();
        char var3 = var1.getKeyChar();
        char var4 = var3 < '\uffff' ? var3 : (char)var2;
        if (this.ignoreModifierKeys && (var4 == 16 || var4 == 20 || var4 == 17 || var4 == 18)) {
            var4 = 0;
        }

        return var4;
    }

    private void addEventListeners() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        this.addComponentListener(this);
    }

    public static void launch() {
        launch(500, 400);
    }

    public static synchronized void launch(int var0, int var1) {
        try {
            Class var2 = null;
            StackTraceElement[] var3 = (new Exception()).getStackTrace();
            StackTraceElement[] var4 = var3;
            int var5 = var3.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                StackTraceElement var7 = var4[var6];
                Class var8 = Class.forName(var7.getClassName());
                if (!JComponentWithEvents.class.isAssignableFrom(var8)) {
                    break;
                }

                var2 = var8;
            }

            if (var2 == null) {
                throw new RuntimeException("No main class");
            }

            JComponentWithEvents var10 = newInstance(var2, var0, var1);
            var10.isApplet = false;
            JFrame var11 = new JFrame(var10.getClass().getName());
            var11.setDefaultCloseOperation(3);
            JPanel var12 = new JPanel();
            var12.setLayout(new BorderLayout());
            var12.add(var10);
            var11.setContentPane(var12);
            var11.pack();
            var11.setVisible(true);
            var10.launchApplet((JApplet)null);
        } catch (Exception var9) {
            System.out.println("Err!");
            var9.printStackTrace();
        }

    }

    public void launchApplet(JApplet var1) {
        try {
            this.checkVersion();
            this.applet = var1;
            this.addEventListeners();
            this.setFocusable(true);
            this.requestFocusInWindow();
            this.doStart();
        } catch (Exception var3) {
            System.out.println("Err!");
            var3.printStackTrace();
        }

    }

    private URL toUrl(String var1) throws Exception {
        if (var1 == null) {
            return null;
        } else {
            return var1.startsWith("http") ? new URL(var1) : (new File(var1)).toURI().toURL();
        }
    }

    private InputStream toInputStream(String var1) throws Exception {
        byte[] var2 = (byte[])this.fileCache.get(var1);
        if (var2 == null) {
            InputStream var3;
            if (var1.startsWith("http")) {
                var3 = (new URL(var1)).openStream();
            } else {
                var3 = this.getResourceAsStream(var1);
            }

            ByteArrayOutputStream var4 = new ByteArrayOutputStream();
            byte[] var5 = new byte[1024];

            int var6;
            while((var6 = var3.read(var5)) > 0) {
                var4.write(var5, 0, var6);
            }

            var2 = var4.toByteArray();
            this.fileCache.put(var1, var2);
        }

        return new ByteArrayInputStream(var2);
    }

    private boolean inSandbox() {
        SecurityManager var1 = System.getSecurityManager();
        if (var1 == null) {
            return false;
        } else {
            try {
                var1.checkExit(-1);
                return false;
            } catch (Exception var3) {
                return true;
            }
        }
    }

    public boolean isApplet() {
        return this.inSandbox();
    }

    private void doPlay(String var1, boolean var2) {
        if (var1 != null) {
            String var3 = null;
            if (!var1.endsWith("wav") && !var1.endsWith("mid") && !var1.endsWith("midi")) {
                (new StringBuilder()).append("Unknown file type: ").append(var1).toString();
            } else {
                try {
                    InputStream var4 = this.toInputStream(var1);
                    if (var1.endsWith("wav")) {
                        this.doPlayWav(var4, var2);
                    } else if (var1.endsWith("midi") || var1.endsWith("mid")) {
                        this.doPlayMidi(var4, var2);
                    }
                } catch (Exception var5) {
                    var3 = var5.getMessage();
                    if (!this.isApplet) {
                        var5.printStackTrace();
                        throw new RuntimeException(var3);
                    }

                    if (!this.badAppletLocations.contains(var1)) {
                        System.err.println("Applet cannot access: " + var1);
                    }

                    this.badAppletLocations.add(var1);
                }
            }

        }
    }

    private void doStopSounds() {
        this.doStopWavSounds();
        this.doStopMidiSounds();
    }

    private void doPauseSounds() {
        this.doPauseWavSounds();
        this.doPauseMidiSounds();
    }

    private void doUnpauseSounds() {
        this.doUnpauseWavSounds();
        this.doUnpauseMidiSounds();
    }

    private void doPlayMidi(InputStream var1, boolean var2) {
        try {
            this.doStopMidiSounds();
            this.sequencer = MidiSystem.getSequencer();
            this.sequencer.setSequence(MidiSystem.getSequence(var1));
            if (var2) {
                this.sequencer.setLoopCount(-1);
            }

            this.sequencer.open();
            this.sequencer.start();
        } catch (Exception var4) {
            this.midiError("" + var4);
        }

    }

    private void midiError(String var1) {
        System.err.println("Midi error: " + var1);
        this.sequencer = null;
    }

    private void doStopMidiSounds() {
        try {
            if (this.sequencer == null || !this.sequencer.isRunning()) {
                return;
            }

            this.sequencer.stop();
            this.sequencer.close();
        } catch (Exception var2) {
            this.midiError("" + var2);
        }

        this.sequencer = null;
    }

    private void doPauseMidiSounds() {
        try {
            if (this.sequencer == null || !this.sequencer.isRunning()) {
                return;
            }

            this.sequencer.stop();
        } catch (Exception var2) {
            this.midiError("" + var2);
        }

    }

    private void doUnpauseMidiSounds() {
        try {
            if (this.sequencer == null) {
                return;
            }

            this.sequencer.start();
        } catch (Exception var2) {
            this.midiError("" + var2);
        }

    }

    private void doPlayWav(InputStream var1, boolean var2) {
        try {
            AudioInputStream var3 = AudioSystem.getAudioInputStream(var1);
            AudioFormat var4 = var3.getFormat();
            Info var5 = new Info(Clip.class, var3.getFormat(), (int)var3.getFrameLength() * var4.getFrameSize());
            Clip var6 = (Clip)AudioSystem.getLine(var5);
            var6.open(var3);
            var6.start();
        } catch (Exception var7) {
            throw new RuntimeException("" + var7);
        }
    }

    private void doPauseWavSounds() {
        Iterator var1 = this.wavClips.iterator();

        while(var1.hasNext()) {
            Clip var2 = (Clip)var1.next();
            var2.stop();
        }

    }

    private void doUnpauseWavSounds() {
        Iterator var1 = this.wavClips.iterator();

        while(var1.hasNext()) {
            Clip var2 = (Clip)var1.next();
            var2.start();
        }

    }

    private void doStopWavSounds() {
        Iterator var1 = this.wavClips.iterator();

        while(var1.hasNext()) {
            Clip var2 = (Clip)var1.next();
            var2.stop();
        }

        this.wavClips.clear();
    }

    public static void main(String[] var0) {
        launch(500, 300);
    }
}

