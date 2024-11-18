/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graub.cipher;

/**
 *
 * @author GKilian
 */
public class DoubleLinkedList {
    public Node Head;
    public Node Tail;

    public void Add(Node node){
        if(Head == null){
            Head = node;
        }
        else if(Tail == null){
            Head.Next = node;
            Tail = node;
            Tail.Previous = Head;
        }
        else{
            Tail.Next = node;
            node.Previous = Tail;
            Tail = node;
        }
    }

    public void Encrypt(int value){
        var current = Head;

        while(current != null){
            current.Cipher(value);
            current = current.Next;
        }

        Show();
    }

    public void Decrypt(int value){
        value *= -1;
        Encrypt(value);
    }

    public void Show(){
        var current = Head;

        while(current != null){
            System.out.print(current.Value);
            current = current.Next;
        }

        System.out.println();
    }
}
