public class CircularArray{
  
  private int start;
  private int size;
  private Object [] cir;
  
  /*
   * if Object [] lin = {10, 20, 30, 40, null}
   * then, CircularArray(lin, 2, 4) will generate
   * Object [] cir = {40, null, 10, 20, 30}
   */
  public CircularArray(Object [] lin, int st, int sz){
    start=st;size=sz;
    cir=new Object[lin.length];
    for(int i=0;i<lin.length;i++){
      cir[(st+i)%lin.length]= lin[i];
    }
  }
  
  //Prints from index --> 0 to cir.length-1
  public void printFullLinear(){
    System.out.println();
    for(Object k:cir)
      System.out.print(k+ " ");
  }
  
  // Starts Printing from index start. Prints a total of size elements
  public void printForward(){
    System.out.println();
    for(int i=0;i< size;i++){
      System.out.print(cir[(start+i)%cir.length]+" ");
    }
  }
  
  
  public void printBackward(){
    System.out.println();
    for(int i=size;i>=  0;i--){
      System.out.print(cir[(start+i)%cir.length]+" ");
    }
  }
  
  // With no null cells
  public void linearize(){
    Object []l=new Object[size];
    for(int i=0,j=start;i<size;i++,j=(j+1)%cir.length)
      l[i]=cir[j];
    cir=l;//start=0;
  }
  
  // Do not change the Start index
  public void resizeStartUnchanged(int newcapacity){
    Object []n=new Object[newcapacity];
    int i=start;int j=start;
    for(int x=0;x<size;x++){
      n[i]=cir[j];
      i=(i+1)% n.length;
      j=(j+1)%cir.length;
    }
    cir=n;
  }
  
  // Start index becomes zero
  public void resizeByLinearize(int newcapacity){
    Object []n=new Object[newcapacity];
    int i=0;
    int j=start;
    for(int x=0;x<size;x++){
      n[i]=cir[j];
      i++;
      j=(j+1)%cir.length;
    }
    cir=n;start=0;    
  }
  
  /* pos --> position relative to start. Valid range of pos--> 0 to size.
   * Increase array length by 3 if size==cir.length
   * use resizeStartUnchanged() for resizing.
   */
  public void insertByRightShift(Object elem, int pos){
    if(pos>start && pos<=size  ){
      if(!(size==cir.length)){
        int index=(start+pos)%cir.length;
        int nShift=size-pos;
        int from=(start+size-1)%cir.length;
        int to=(from+1)%cir.length;
        for(int x=1;x<=nShift;x++){
          cir[to]=cir[from];
          to=from;
          from--;
          if(from<0)
            from=cir.length-1;
        }
        cir[index]=elem;size++;start=(start+1)%cir.length;
      }
      else{
        resizeStartUnchanged(size+3);
        insertByRightShift(  elem,   pos);
      }
    }
  }
  
  public void insertByLeftShift(Object elem, int pos){
    if(pos>start && pos<=size  ){
      if(!(size==cir.length)){
        int index=(start+pos)%cir.length;
        int nShift=pos+1;
        int from=start  ;
        int to= start-1;
        if(to<0) to=cir.length-1;
        for(int x=1;x<=nShift;x++){
          cir[to]=cir[from];
          to=from;
          from=(from+1)%cir.length;
          
        }
        cir[index]=elem;size++;start=(start-1) ;
        if(start<0) start=cir.length-1;   
      }
      else{
        resizeStartUnchanged(size+3);
        insertByLeftShift(  elem,   pos);
      }
    }
  }
  
  /* parameter--> pos. pos --> position relative to start.
   * Valid range of pos--> 0 to size-1
   */
  public void removeByLeftShift(int pos){
    //TO DO
  }
  
  /* parameter--> pos. pos --> position relative to start.
   * Valid range of pos--> 0 to size-1
   */
  public void removeByRightShift(int pos){
    if(pos>=0 && pos<size){
      int nShift =pos;
      int index=(start+pos)%cir.length;
      int to=index;
      int from=index-1;
      if(from<0) from=cir.length-1;
      for(int i=0;i<nShift;i++){
        cir[to]=cir[from];
        to=from;
        from=from-1;
        if(from<0) from=cir.length-1;
      }
      cir[start]=null;
      size--;start=(start+1)%cir.length;
    }
  }
  
  
  //This method will check whether the array is palindrome or not
  public void palindromeCheck(){
    boolean status=true;int n=size/2;
    for(int c=0,s=start,t=start+size-1;c<n;s++,c++,t--){
      if(t<0) t=cir.length-1;
      if(cir[s%cir.length]!=cir[t%cir.length]) status=false;
    }
    if(status==true) System.out.println("Yes! A Palindrome!!");
    else System.out.println("No! Not A Palindrome!!");
  }
  
  
  //This method will sort the values by keeping the start unchanged
  public void sort(){
    for(int i=0;i<cir.length-1;i++){
      Object min= cir[i];int min_index=i;
      for(int j=0;j<cir.length;j++){
        if(cir[j].compareTo(min)<0) min_index=j;
      }
       Object temp=cir[i];
      cir[i]=cir[min_index];cir[min_index]=temp;
    }
  }
  
  //This method will check the given array across the base array and if they are equivalent interms of values return true, or else return false
  public boolean equivalent(CircularArray k){
    int flag=1;
    if(k.length.compareTo(cir.length)==0 ){
      for(int i=0;i<size;i++){
        if(k[i]==cir[i]){
        }
          else{
          flag=0;
          break;
        }
        if(flag==1) return true;
        return false ;
      }
    }
    else return false;
  }
}