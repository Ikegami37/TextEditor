import java.awt.*;
import java.awt.event.*;
class Main {
    public static void main(String[] args) {
        MyWindow mw = new MyWindow();
    }
}

class MyWindow extends Frame {
    MyWindow() {
        setTitle("テキストエディタ");
        setSize(800, 600);
        TextArea ta = new TextArea();
        add(ta);
        setVisible(true);
        addWindowListener(new WinListener() );
    }
}
class WinListener extends WindowAdapter {
    public void windowClosing(WindowEvent e) { System.exit(0); }
}