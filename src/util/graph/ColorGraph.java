package util.graph;

import util.graph.*;
import util.intset.*;
import java.util.*;
import java.io.*;

public class ColorGraph {
    public  Graph          G;
    public  int            R;
    public  int            K;
    private Stack<Integer> pile;
    public  IntSet         enleves;
    public  IntSet         deborde;
    public  int[]          couleur;
    public  Node[]         int2Node;
    static  int            NOCOLOR = -1;

    public ColorGraph(Graph G, int K, int[] phi){
	this.G       = G;
	this.K       = K;
	pile         = new Stack<Integer>(); 
	R            = G.nodeCount();
	couleur      = new int[R];
	enleves      = new IntSet(R);
	deborde        = new IntSet(R);
	int2Node     = G.nodeArray();
	for(int v=0; v < R; v++){
	    int preColor = phi[v];
	    if(preColor >= 0 && preColor < K)
		couleur[v] = phi[v];
	    else
		couleur[v] = NOCOLOR;
	}
    }

    /*-------------------------------------------------------------------------------------------------------------*/
    /* associe une couleur à tous les sommets se trouvant dans la pile */
    /*-------------------------------------------------------------------------------------------------------------*/
    
    public void selection()
    {
        while (!pile.empty()){
            Node n = int2Node[pile.pop()];
            IntSet C = couleursVoisins(n.mykey);
            if (C.getSize() != K){
                couleur[n.mykey] = choisisCouleur(C);
            }
        }
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/
    /* récupère les couleurs des voisins de t */
    /*-------------------------------------------------------------------------------------------------------------*/
    
    public IntSet couleursVoisins(int t)
    {
        Node n = int2Node[t];
        int nbVoisins = nbVoisins(t);
        IntSet result = new IntSet(nbVoisins);
        for(NodeList nl=n.adj(); nl!=null; nl=nl.tail){
            int c = couleur[nl.head.mykey];
            result.add(c);
        }
        return result;
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/
    /* recherche une couleur absente de colorSet */
    /*-------------------------------------------------------------------------------------------------------------*/
    
    public int choisisCouleur(IntSet colorSet)
    {
        for (int i = 0; i < K ; i++) {
            if(!colorSet.isMember(i)){
                return i;
            }
        }
        return NOCOLOR;
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/
    /* calcule le nombre de voisins du sommet t */
    /*-------------------------------------------------------------------------------------------------------------*/
    
    public int nbVoisins(int t)
    {
        Node n = int2Node[t];
        int result = 0;
        for(NodeList nl=n.adj(); nl!=null; nl=nl.tail){
            ++result;
        }
        return result;
    }

    /*-------------------------------------------------------------------------------------------------------------*/
    /* simplifie le graphe d'interférence g                                                                        */
    /* la simplification consiste à enlever du graphe les temporaires qui ont moins de k voisins                   */
    /* et à les mettre dans une pile                                                                               */
    /* à la fin du processus, le graphe peut ne pas être vide, il s'agit des temporaires qui ont au moins k voisin */
    /*-------------------------------------------------------------------------------------------------------------*/

    public void simplification()
    {
        int nbPrecolor = getNbPrecolor();
        int N = R - nbPrecolor;
        boolean modif = true;
        while(pile.size() != N && modif){
            modif = false;
            NodeList list = G.nodes();
            for (NodeList nl=list; nl!=null; nl=nl.tail){
                int t = nl.head.mykey;
                if (!enleves.isMember(t)){
                    if (nbVoisins(t) < K && couleur[t] == NOCOLOR){
                        pile.push(t);
                        enleves.add(t);
                        modif = true;
                    }
                }
            }
        }
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------*/
    
    public void debordement()
    {
        while(pile.size() != R){
            for (Node s : G.nodeArray()) {
                if (!enleves.isMember(s.mykey) && !deborde.isMember(s.mykey) && couleur[s.mykey] == NOCOLOR){
                    pile.push(s.mykey);
                    deborde.add(s.mykey);
                    break;
                }
            }

            simplification();
        }
    }


    /*-------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------*/

    public void coloration()
    {
	this.simplification();
	this.debordement();
	this.selection();
    }

    void affiche()
    {
	System.out.println("vertex\tcolor");
	for(int i = 0; i < R; i++){
	    System.out.println(i + "\t" + couleur[i]);
	}
    }
    
    private int getNbPrecolor(){
        int nbPrecolor = 0;
        for (int i:couleur){
            if(i != NOCOLOR){
                ++nbPrecolor;
            }
        }
        return nbPrecolor;
    }

}
