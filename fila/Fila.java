public class Fila {
    private Person[] arrayPerson;
    private int index = 0;

    public Fila(int size){
        this.arrayPerson = new Person[size];
    }

    public void addClientInArray(Person person) {
        this.arrayPerson[index++] = person;
    }

    public void removeClientInArray() {
        Person[] auxArray = this.arrayPerson.clone();
        if (auxArray.length == 1) {
            auxArray[index--] = null;
            return;
        }
        for(int slowIndex = 0; slowIndex < index; slowIndex++) {
            auxArray[slowIndex] = auxArray[slowIndex++];
        }
        auxArray[index--] = null;
        this.arrayPerson = auxArray;
    }

    public Integer sizeQueueInArray() {
        return this.index;
    }

    public boolean clientInQueueInArray(Person person) {
        for (int ind = 0; ind < index; ind++) {
            if (this.arrayPerson[ind].equals(person))
                return true;
        }
        return false;
    }

    public String toStringInArray() {
        String resultado = "";
        for (int ind = 0; ind < index; ind++) {
            resultado += this.arrayPerson[ind] + "\n";
        }

        return resultado;
    }



}
