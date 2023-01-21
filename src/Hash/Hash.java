package Hash;

class MyHash { //해쉬 클래스
    public Slot[] hashTable;

    public MyHash(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String value;
        Slot (String value) {
            this.value = value;
        }
    }
}

public class Hash {
    public static void main(String[] args) {

    }
}
