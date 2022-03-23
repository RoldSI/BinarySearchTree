import java.util.concurrent.ThreadLocalRandom;

/**
 * Beschreiben Sie hier die Klasse Suchbaum.
 * 
 * @author M. Hoffmann 
 * @version 13.01.2018
 */
public class Suchbaum
{
    private BinarySearchTree<Entry> searchT;

    /**
     * Konstruktor für Objekte der Klasse Suchbaum
     */
    public Suchbaum()
    {
        init();
    }

    public BinarySearchTree<Entry> getTree(){
        return searchT;
    }
    
    /**
     * Anlegen eines vorgegebenen Suchbaumes
     */
    public void init(){
        searchT = new BinarySearchTree<Entry>();
        for(int i = 0; i<100; i++) {
            int randomInt = ThreadLocalRandom.current().nextInt(-10, 10 + 1);
            this.searchT.insert(new Entry(randomInt));
        }
        /*this.searchT.insert(new Entry(0));
        this.searchT.insert(new Entry(-1));
        this.searchT.insert(new Entry(2));
        this.searchT.insert(new Entry(-3));
        this.searchT.insert(new Entry(4));
        this.searchT.insert(new Entry(-5));
        this.searchT.insert(new Entry(6));
        this.searchT.insert(new Entry(-7));
        this.searchT.insert(new Entry(8));
        this.searchT.insert(new Entry(-9));
        this.searchT.insert(new Entry(10));
        this.searchT.insert(new Entry(-11));
        this.searchT.insert(new Entry(12));*/
    }
    
    public void insertSB(Entry pIn){
        this.searchT.insert(pIn);
    }
    
    public void removeSB(Entry pOut){
        this.searchT.remove(pOut);
    }
    
    /**
     *  Rückgabe der Knoterninhalte in InOrder-Reihenfolge
     */
    public String inOrder(BinarySearchTree<Entry> pBaum){
        String ret = "";
        if (pBaum.getLeftTree().isEmpty()==false) {
            ret = ret + this.inOrder(pBaum.getLeftTree())+ " ";
        }
        ret = ret + Integer.toString(pBaum.getContent().getWert()) + " ";
        if (pBaum.getRightTree().isEmpty()==false) {
            ret = ret + this.inOrder(pBaum.getRightTree())+ " ";
        }
        
        return ret;
    }
    
        /**
     *  Rückgabe der Knoterninhalte in PreOrder-Reihenfolge
     */
    public String preOrder(BinarySearchTree<Entry> pBaum){
        String ret = "";
        ret = ret + Integer.toString(pBaum.getContent().getWert()) + " ";
        if (pBaum.getLeftTree().isEmpty()==false) {
            ret = ret + this.preOrder(pBaum.getLeftTree())+ " ";
        }
        if (pBaum.getRightTree().isEmpty()==false) {
            ret = ret + this.preOrder(pBaum.getRightTree())+ " ";
        }
        
        return ret;
    }
    
        /**
     *  Rückgabe der Knoterninhalte in PostOrder-Reihenfolge
     */
    public String postOrder(BinarySearchTree<Entry> pBaum){
        String ret = "";
        if (pBaum.getLeftTree().isEmpty()==false) {
            ret = ret + this.postOrder(pBaum.getLeftTree())+ " ";
        }
        if (pBaum.getRightTree().isEmpty()==false) {
            ret = ret + this.postOrder(pBaum.getRightTree())+ " ";
        }
        ret = ret + Integer.toString(pBaum.getContent().getWert()) + " ";
        
        return ret;
    }
}
