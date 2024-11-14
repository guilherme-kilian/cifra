/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graub.cifra;

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
    
    public void Cifra(int vetor){
        var ascii = ((int)this.Value) + vetor;
        
        if(isLowerCaseLetter(this.Value)){
                       
            if(ascii < 97){
                var diff = 122 - (97 - ascii);
                this.Value = (char)diff;                
            }
            else if(ascii > 122){
                var diff = 97 + (ascii - 122);
                this.Value = (char)diff;
            }
            else{
                this.Value = (char)ascii;
            }
        }
        else if(isUpperCaseLetter(this.Value)){
            if(ascii < 65){
                var diff = 90 - (65 - ascii);
                this.Value = (char)diff;
            }
            else if(ascii > 90){
                var diff = 65 + (ascii - 90);
                this.Value = (char)diff;
            }
            else{
                this.Value = (char)ascii;
            }
        }
    }
    
    private static boolean isLowerCaseLetter(char c) {
        return (c >= 'a' && c <= 'z');
    }
    
    private static boolean isUpperCaseLetter(char c) {
        return (c >= 'A' && c <= 'Z');
    }
}
