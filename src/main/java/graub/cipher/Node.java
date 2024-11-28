/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graub.cipher;

/**
 *
 * @author GKilian
 */
public class Node {
    public char Value;
    public Node Next;
    public Node Previous;

    public Node(char Value) {
        this.Value = Value;
    }

    // Metodo responsável por criptografar o caractere atual. Baseia-se na tabela ASCII.
    public void Cipher(int vector) {
        int minValue; // Limite inferior para o intervalo de letras (ASCII).
        int maxValue; // Limite superior para o intervalo de letras (ASCII).

        // Verifica se o caractere é uma letra minúscula ou maiúscula.
        // Esses valores (97 a 122 para minúsculas e 65 a 90 para maiúsculas) correspondem aos códigos ASCII das letras.
        // Isso impede que o deslocamento transforme a letra em um caractere inválido.
        if (isLowerCaseLetter(this.Value)) {
            maxValue = 122; // 'z' em ASCII.
            minValue = 97;  // 'a' em ASCII.
        }
        else if (isUpperCaseLetter(this.Value)) {
            maxValue = 90;  // 'Z' em ASCII.
            minValue = 65;  // 'A' em ASCII.
        }
        else {
            return; // Se não for uma letra, o metodo encerra sem alterar o caractere.
        }

        // Soma o deslocamento ao valor ASCII da letra atual.
        var ascii = ((int) this.Value) + vector;

        // Processa o valor ASCII ajustando-o para mantê-lo dentro dos limites.
        ProcessCipher(ascii, minValue, maxValue);
    }

    // Metodo auxiliar para ajustar o valor cifrado ao intervalo permitido.
    // Garante que o deslocamento funcione de forma cíclica (como um loop), mantendo-o dentro dos limites.
    private void ProcessCipher(int ascii, int minAsciiValue, int maxAsciiValue) {
        if (ascii < minAsciiValue) {
            // Se o valor for menor que o limite inferior, ajusta-o para o final do intervalo.
            var diff = maxAsciiValue - (minAsciiValue - ascii - 1);
            this.Value = (char) diff; // Define o novo valor cifrado.
        }
        else if (ascii > maxAsciiValue) {
            // Se o valor exceder o limite superior, ajusta-o para o início do intervalo.
            var diff = minAsciiValue + (ascii - maxAsciiValue - 1);
            this.Value = (char) diff;
        }
        else {
            // Se o valor estiver dentro dos limites, aplica diretamente.
            this.Value = (char) ascii;
        }
    }


    private static boolean isLowerCaseLetter(char c) {
        return (c >= 'a' && c <= 'z');
    }

    private static boolean isUpperCaseLetter(char c) {
        return (c >= 'A' && c <= 'Z');
    }
}
