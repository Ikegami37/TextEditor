import java.awt.*;
import java.awt.event.*;
class Main {
    public static void main(String[] args) {
        MyWindow mw = new MyWindow();
    }
}

class MyWindow extends Frame implements ActionListener {
    TextArea ta;
    MyWindow() {
        setTitle("テキストエディタ");
        setSize(800, 600);
        ta = new TextArea();
        add(ta);MenuBar mbar = new MenuBar();
        Menu menu = new Menu("ファイル");
        MenuItem mopen =  new MenuItem("開く");
        MenuItem msave =  new MenuItem("保存");
        mopen.addActionListener(this);
        msave.addActionListener(this);
        menu.add(mopen);
        menu.add(msave);
        mbar.add(menu);
        setMenuBar(mbar);
        setVisible(true);
        addWindowListener(new WinListener() );
    }
    public void actionPerformed(ActionEvent e) {
        ta.setText("メニュー項目が選ばれました");
    }
}
class WinListener extends WindowAdapter {
    public void windowClosing(WindowEvent e) { System.exit(0); }
}