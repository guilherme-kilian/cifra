package graub.cipher;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Lendo a frase digitada pelo usuário.
        var scanner = new Scanner(System.in);

        // A frase será convertida em um array de caracteres, onde cada caractere da frase será um item do array.
        System.out.println("Informe a frase");
        char[] sentence = scanner.nextLine().toCharArray();

        var list = new DoubleLinkedList();

        // Adicionando cada caractere do array como um nodo na lista duplamente encadeada.
        for (char c : sentence) {
            var node = new Node(c);
            list.Add(node);
        }

        // Solicitando o número de deslocamentos para criptografia.
        System.out.println("Informe o numero de deslocamentos");
        int increment = scanner.nextInt();

        list.Encrypt(increment); // Criptografando a lista.

        // Perguntando ao usuário se deseja descriptografar.
        System.out.println("Deseja descriptografar?");
        var answer = new Scanner(System.in).nextLine();

        if (answer.equalsIgnoreCase("sim") || answer.equalsIgnoreCase("s")) {
            list.Decrypt(increment); // Descriptografando a lista se o usuário confirmar.
        }

        System.out.println("Eh isso"); // Finalizando o programa.
    }
}