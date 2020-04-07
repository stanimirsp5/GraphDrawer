public class Bag<Item>{
    private Node first;
    private int size;

    private class Node{
        Item item;
        Node next;
    }

    public int size(){ return size;}

    public void add(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }
    private boolean hasNext(Node node){
        return node.next != null;
    }

    public void print(){
        Node node = first;
        while (true){
            System.out.println(node.item);
            if(!hasNext(node)){
                break;
            }
            node = node.next;
        }
    }
    public int[] getConnectedVertices(){
        Node node = first;
        int[] connectedVertices = new int[size];
        int i =0;
        while (true){
            connectedVertices[i] =Integer.parseInt(node.item.toString()); // attempting to cast an Object to an int
            if(!hasNext(node)){
                break;
            }
            node = node.next;
            i++;
        }
        return connectedVertices;
    }
}
