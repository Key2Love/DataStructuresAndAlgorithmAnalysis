package charpter3;

public  class Node<AnyType>{
    public AnyType data;
    public Node<AnyType> prev;
    public Node<AnyType> next;

    public Node(AnyType d, Node<AnyType> p, Node<AnyType> n){
        data = d;
        prev = p;
        next = n;
    }
}
