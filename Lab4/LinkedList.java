public class LinkedList{
  public Node head;
  
  
  /* First Constructor:
   * Creates a linked list using the values from the given array. head will refer
   * to the Node that contains the element from a[0]
   */ 
  public LinkedList(Object [] a){
    head=new Node(a[0],null);
    Node tail=head;
    for(int i=1;i<a.length;i++){
      Node x=new Node(a[i],null);
      tail.next=x;
      tail=x;//tail=tail.next;
    }
  }
  
  /* Second Constructor:
   * Sets the value of head. head will refer
   * to the given LinkedList
   */
  public LinkedList(Node h){
    head=h;
  }
  
  /* Counts the number of Nodes in the list */
  public int countN(){
    int c=0;
    for (Node n = head; n != null; n = n.next) 
      c++;
    return c; // please remove this line!
  }
  
  /* prints the elements in the list */
  public void printList(){
    for (Node n = head; n != null; n = n.next)    
      System.out.print(n.element +" "); 
    System.out.println();
  }
  
  // returns the reference of the Node at the given index. For invalid index return null.
  public Node nodeAt(int idx){
    Node n=head;
    for(int i=0;i<idx && n!=null ;i++,n=n.next);
    
    return n;
  }
  
  
// returns the element of the Node at the given index. For invalid idx return null.
  public Object get(int idx){
    Node n=head;
    for(int i=0;i<idx && n!=null ;i++,n=n.next);
    
    return n.element;
    
  }
  
  
  
  /* updates the element of the Node at the given index. 
   * Returns the old element that was replaced. For invalid index return null.
   * parameter: index, new element
   */
  public Object set(int idx, Object elem){
    Node n=nodeAt(idx);
    if(idx<0 || n==null)
      return null; // please remove this line!
    else{
      Object oldElement=n.element;
      n.element=elem;
      return oldElement;
    }
  }
  
  
  /* returns the index of the Node containing the given element.
   if the element does not exist in the List, return -1.
   */
  public int indexOf(Object elem){
    int i=0;
    for(Node n=head;n!=null;n=n.next,i++){
      if(n.element.equals(elem))
        return i;
    }
    return -1; // please remove this line!
  }
  
  // returns true if the element exists in the List, return false otherwise.
  public boolean contains(Object elem){
    int i=0;
    for(Node n=head;n!=null;n=n.next,i++){
      if(n.element.equals(elem))
        return true;
    }
    return false; // please remove this line!
  }
  
  // Makes a duplicate copy of the given List. Returns the reference of the duplicate list.
  public Node copyList(){
    Node x=new Node(head.next,null);
    Node tail=x;
    for(Node i=head.next;i!=null;i=i.next){
      Node n=new Node(i.next,null);
      tail.next=n;tail=n;
    }
    return x; // please remove this line!
  }
  
  // Makes a reversed copy of the given List. Returns the head reference of the reversed list.
  public Node reverseList(){
    Node x=new Node(head.next,null);
    Node newHead=x;
    for(Node i=head.next;i!=null;i=i.next){
      Node n=new Node(i.next,null);
      newHead=n; 
    }
    return newHead;
    
  }
  
  /* inserts Node containing the given element at the given index
   * Check validity of index.
   */
  public void insert(Object elem, int idx){
    if(idx==0){
      Node newNode=new Node(elem,null);
      newNode.next=head;
      head=newNode;
    }
    else{
      Node pred=nodeAt(idx-1);
      Node s=pred.next;
      Node newNode=new Node(elem,null);
      newNode.next=s;
      pred.next=newNode;
    }
  }
  
  
  /* removes Node at the given index. returns element of the removed node.
   * Check validity of index. return null if index is invalid.
   */
  public Object remove(int index){
    if(index==0){
      Node removedNode=head;
      head=head.next;
      removedNode.next=null;
      return removedNode.element;
    }
    else{
      Node pred=nodeAt(index-1);
      Node removedNode=pred.next;
      pred.next=removedNode.next;//pred.next=pred.next.next
      removedNode.next=null;
      return removedNode.element;
    }
  }
  
  // Rotates the list to the left by 1 position.
  public void rotateLeft(){
    Node tail=nodeAt(countN()-1);
    tail.next=head;
    Node copy=head;
    head=head.next;
    copy.next=null;
  }
  
  // Rotates the list to the right by 1 position.
  public void rotateRight(){
    Node tail=nodeAt(countN()-1);
    Node   ntail=nodeAt(countN()-2);
    tail.next=head;
    head=tail; 
    ntail.next=null;
  }
}