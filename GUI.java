/**
 * Implementierung der GUI zum Bin�ren Suchbaum.
 * 
 * @author M. Hoffmann
 * @version 13.01.2018
 */

import java.awt.*;
import java.awt.event.*;

public class GUI extends Frame{
    private TextField tfDialog, tfFrage, tfLsgJa, tfLsgNein, tfAnzeige;
    private Button btInsert, btRemove, btReset, btInOrder, btPreOrder, btPostOrder;
    private Label lbAnzeige;
    private Suchbaum sB;

    /**
     * Konstruktor f�r Objekte der Klasse GUI
     */
    public GUI(){
        super("Bin�rer Suchbaum");
        setLayout(null);
        setBounds(0,0,1200,650);

        sB = new Suchbaum();
        
        WindowAdapter wl = new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            };
        addWindowListener(wl); 
      
        tfDialog = new TextField();
        tfDialog.setBounds(40,450,40,20);
        add(tfDialog);

        btReset = new Button("Reset");
        btReset.setBounds(220,420,80,20);
        btReset.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    sB = new Suchbaum();
                    repaint();
                }
            });
        add(btReset);

        btInsert = new Button("Insert");
        btInsert.setBounds(20,420,80,20);
        btInsert.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    sB.insertSB(new Entry(Integer.parseInt(tfDialog.getText())));
                    repaint();
                }
            });
        add(btInsert);

        btRemove = new Button("Remove");
        btRemove.setBounds(120,420,80,20);
        btRemove.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    sB.removeSB(new Entry(Integer.parseInt(tfDialog.getText())));
                    repaint();
                }
            });
        add(btRemove);
                      
        lbAnzeige = new Label("Anzeige Knoteninhalte nach Durchlaufordnung:");
        lbAnzeige.setBounds(20,480,300,20);
        add(lbAnzeige);

        tfAnzeige = new TextField();
        tfAnzeige.setBounds(40,510,400,20);
        tfAnzeige.setEditable(false);
        add(tfAnzeige);
        
        btInOrder = new Button("InOrder");
        btInOrder.setBounds(20,540,80,20);
        btInOrder.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    tfAnzeige.setText(sB.inOrder(sB.getTree()));
                }
            });
        add(btInOrder);
        
        btPreOrder = new Button("PreOrder");
        btPreOrder.setBounds(120,540,80,20);
        btPreOrder.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    tfAnzeige.setText(sB.preOrder(sB.getTree()));
                }
            });
        add(btPreOrder);
        
        btPostOrder = new Button("PostOrder");
        btPostOrder.setBounds(220,540,80,20);
        btPostOrder.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    tfAnzeige.setText(sB.postOrder(sB.getTree()));
                }
            });
        add(btPostOrder);
              
        setVisible(true);
    }
    
    public void paint(Graphics g){
        g.setColor(Color.darkGray);
        g.drawRect(20,50,1160,350); 
        zeichnen(g, sB.getTree(), 20, 1180, 2, 0, 0);        
    }

    public void zeichnen(Graphics g, BinarySearchTree<Entry> b, int l, int r, int t, int horizontal, int vertikal) {
        g.setFont(new Font("Serif", Font.PLAIN, 12));
        if (b != null && b.isEmpty() == false){
            String s = Integer.toString(b.getContent().getWert());
            int x = (int) ((l+r - s.length()*6-horizontal) / 2);
            g.setColor(Color.blue);
            g.drawString(s, x, t*39+vertikal);
            int x1 = (int) ((l+r)/2);
            int y1 = t*39 + 6;
            int x2 = (int) ((l+x1)/2);
            int x3 = (int) ((x1+r)/2);
            int y2 = y1 + 39;
            g.setColor(Color.red);
            if (!b.getLeftTree().isEmpty()){
                g.drawLine(x1, y1, x2, y2);
            }else{
                g.fillOval(x1-3, y1-3, 6, 6);
            }
            if (!b.getRightTree().isEmpty()){
                g.drawLine(x1, y1, x3, y2);
            }else{
                g.fillOval(x1-3, y1-3, 6, 6);
            }
            zeichnen(g, b.getLeftTree(),  l, (int)(l+r)/2, t+1, 20, 0);
            zeichnen(g, b.getRightTree(),  (int) (l+r)/2, r, t+1, -30, 6);
        }

    }

}
