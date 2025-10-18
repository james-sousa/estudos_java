public class Pilha {

    private Person[] arrayPerson;
    private int index = 0;

    public Pilha(int size){
        this.arrayPerson = new Person[size];
    }

    public void addInarray(Person person){
        if(index < arrayPerson.length)
            this.arrayPerson[index++] = person;
        else
            System.out.println("A pilha está cheia!");
    }

    public void removeInArray() {
        if(index > 0)
            this.arrayPerson[--index] = null;
        else
            System.out.println("A pilha está vazia!");
    }

    public Integer sizeInArray() {
        return this.index;
    }

    public boolean clientInArray(Person person) {
        for(int ind = 0; ind < index; ind++) {
            if(this.arrayPerson[ind].equals(person))
                return true;
        }
        return false;
    }

    public String toStringInArray() {
        String resultado = "";
        for(int ind = 0; ind < index; ind++)
            resultado += this.arrayPerson[ind] + "\n";
        return resultado;
    }
}
