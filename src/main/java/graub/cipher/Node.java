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

    public void Cipher(int vector){
        int minValue;
        int maxValue;

        if(isLowerCaseLetter(this.Value)){
            maxValue = 122;
            minValue = 97;
        }
        else if(isUpperCaseLetter(this.Value)){
            maxValue = 90;
            minValue = 65;
        }
        else
            return;

        var ascii = ((int)this.Value) + vector;
        ProcessCipher(ascii, minValue, maxValue);
    }

    private void ProcessCipher(int ascii, int minAsciiValue, int maxAsciiValue){
        if(ascii < minAsciiValue){
            var diff = maxAsciiValue - (minAsciiValue - ascii);
            this.Value = (char)diff;
        }
        else if(ascii > maxAsciiValue){
            var diff = minAsciiValue + (ascii - maxAsciiValue);
            this.Value = (char)diff;
        }
        else{
            this.Value = (char)ascii;
        }
    }

    private static boolean isLowerCaseLetter(char c) {
        return (c >= 'a' && c <= 'z');
    }

    private static boolean isUpperCaseLetter(char c) {
        return (c >= 'A' && c <= 'Z');
    }
}
