public class CustomString{

    // instance variables (declare here).
    private char[] value;

    // Default constructor.
    public CustomString(){
    }

    // Constructor with arguments.
    public CustomString(char[] value){
        this.value = value;
    }

    // Constructor with arguments.
    public CustomString(String value){
        this.value = new char[value.length()];
        for (int i = 0; i < this.value.length; i++){
            this.value[i] = value.charAt(i);
        }
    }

    // Instance method.
    public int length(){
        return this.value.length;
    }

    // Instance method.
    public char randomChar(){
        int randomIndex = this.randomNumber(); // calling a private method within our class.
        return this.value[randomIndex];
    }

    // Instance method.
    public char charAt(int i){
        return this.value[i];
    }

    public CustomString substring(int i, int j){

        char[] substring = new char[j - i];
        for (int start = i; start < j; start++){
            substring[start-i] = this.value[start];
        }

        return new CustomString(substring);
    }

    // Private instance method (used internally to the class).
    private int randomNumber(){
        return (int)(Math.random() * this.value.length);
    }

    public String toString(){
        String returnString = "";
        for (int i = 0; i < this.value.length; i++){
            returnString += this.value[i];
        }
        return returnString;
    }


    public static void main(String[] args) {
        CustomString myString= new CustomString("Hello");
        System.out.println(myString);
        myString.toLowerCase();
        System.out.println(myString);

    }
}