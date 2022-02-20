import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
class Main {
    public static void main(String[] args) {
        MyWindow mw = new MyWindow();
    }
}

class MyWindow extends Frame implements ActionListener {
    TextArea ta;
    MenuItem mopen, msave;
    MyWindow() {
        setTitle("テキストエディタ");
        setSize(800, 600);
        ta = new TextArea();
        add(ta);MenuBar mbar = new MenuBar();
        Menu menu = new Menu("ファイル");
        mopen =  new MenuItem("開く");
        msave =  new MenuItem("保存");
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
        if(e.getSource() == mopen) loadFile();
        if(e.getSource() == msave) saveFile();
    }
    void loadFile() {
        FileDialog fd = new FileDialog(this, "Load, FileDidalog.LOAD");
        fd.setVisible(true);
        String di = fd.getDirectory();
        String fi = fd.getFile();
        System.out.println("選択したディレクトリ " + di);
        System.out.println("選択したファイル " + fi);
        if(fi != null) {
            String kaigyo = System.getProperty("line.separator");
            FileReader fr;
            BufferedReader br;
            try {
                fr = new FileReader(di+fi);
                br = new BufferedReader(fr);
                ta.setText("");
                while(true) {
                    String str = br.readLine();
                    if(str == null) break;
                    ta.setText(ta.getText() + str +kaigyo);
                }
                br.close();
                fr.close();                       
            }
            catch(IOException e) {
                System.out.println("ファイルが読み込めません");
            }
        }
    }
    void saveFile() {
        FileDialog fd = new FileDialog(this, "Save", FileDialog.SAVE);
        fd.setVisible(true);
        String di = fd.getDirectory();
        String fi = fd.getFile();
        if(fi != null) {
            try {
                FileWriter fw = new FileWriter(di+fi);
                fw.write( ta.getText() );
                fw.close();
            }
            catch(IOException e) {
                System.out.println("ファイルが書き込めません");
            }
        }
    }
}
class WinListener extends WindowAdapter {
    public void windowClosing(WindowEvent e) { System.exit(0); }
}