
package graphs;

/**
 * @author Nishu
 *
 */
class Neighbor {	
	public int vertexNum;
	public Neighbor next;
	public Neighbor(int vnum , Neighbor nbr){
		this.vertexNum = vnum;
		this.next = nbr;
	}
}