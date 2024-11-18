package graub.cipher;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var scanner = new Scanner(System.in);

        System.out.println("Informe a frase");
        char[] sentence = scanner.nextLine().toCharArray();

        var list = new DoubleLinkedList();

        for (char c : sentence) {
            var node = new Node(c);
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