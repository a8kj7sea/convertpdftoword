import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main implements ActionListener {
  public JFrame jf = new JFrame("PDF TO WORD | BY ANONYMOUS");
  
  public JPanel jp = new JPanel();
  
  public JButton jb = new JButton();
  
  public File f1;
  
  public void init() {
    Start();
  }
  
  public void Start() {
    JFrameFeatures();
    JPanelFeatuers();
    JButtonFeatuers();
  }
  
  public static void main(String[] args) {
    (new Main()).Start();
  }
  
  public void JFrameFeatures() {
    this.jf.add(this.jp);
    this.jf.setSize(450, 340);
    this.jf.setDefaultCloseOperation(3);
    this.jf.setVisible(true);
  }
  
  public void JPanelFeatuers() {
    this.jp.setLayout(new BorderLayout());
    this.jp.add(this.jb);
  }
  
  public void JButtonFeatuers() {
    this.jb.addActionListener(this);
  }
  
  public void actionPerformed(ActionEvent e) {
    try {
      $();
    } catch (ClassNotFoundException e1) {
      e1.printStackTrace();
    } 
  }
  
  public void $() throws ClassNotFoundException {
    JFileChooser fc = new JFileChooser();
    fc.setCurrentDirectory(new File("."));
    fc.setFileSelectionMode(0);
    fc.setDialogTitle("Please Choose PDF File !! (ONLY PDF)");
    int returnVal = fc.showSaveDialog(this.jf);
    if (returnVal == 0) {
      File file = fc.getSelectedFile();
      if (!file.getName().endsWith(".pdf")) {
        JOptionPane.showMessageDialog(null, "Please Choose PDF File again !! (name.pdf)", 
            "WE HAVE WRONG USED HERE !!", 0);
      } else {
        JOptionPane.showMessageDialog(null, "Please wait ...!");
        String dirpath = file.getParent();
        String filename = randomname();
        String filepath = file.getAbsolutePath();
        String finalpathdx = String.valueOf(dirpath) + "\\" + filename + ".docx";
        this.f1 = new File(finalpathdx);
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(filepath);
        pdf.saveToFile(finalpathdx, FileFormat.DOCX);
        if (this.f1.exists())
          JOptionPane.showMessageDialog(null, "Done !!", "Have a good day !", 
              1); 
      } 
    } 
  }
  
  public String randomname() {
    Random r = new Random();
    long time = System.currentTimeMillis() / 1000L;
    String out = "";
    char[] c = "abcdefghijklmnopqrstuvwxyz123456789".toCharArray();
    for (int x = 0; x <= 8; x++)
      out = String.valueOf(out) + c[r.nextInt(c.length)]; 
    return String.valueOf(out) + "-" + time;
  }
}
