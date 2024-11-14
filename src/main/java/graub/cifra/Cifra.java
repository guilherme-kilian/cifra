/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package graub.cifra;

import java.util.Scanner;
/**
 *
 * @author GKilian
 */
public class Cifra {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        
        System.out.println("Informe a frase");
        char[] sentence = scanner.nextLine().toCharArray();
        
        var list = new DoubleLinkedList();
        
        for(int i = 0; i < sentence.length; i++){
            var node = new Node(sentence[i]);
            list.Add(node);
        }
                
        System.out.println("Informe o numero de deslocamentos");
        int increment = scanner.nextInt();
        
        list.Encrypt(increment);       
        
        System.out.println("Deseja descriptografar?");
        var answer = new Scanner(System.in).nextLine();
        
        if(answer.equalsIgnoreCase("sim") || answer.equalsIgnoreCase("s")){
            list.Decrypt(increment);
        }

        System.out.println("Eh isso");
    }
}
