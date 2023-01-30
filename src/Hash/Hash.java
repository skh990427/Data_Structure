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

    public int HashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    /**
     * 해쉬 테이블에 데이터 추가
     */
    public boolean saveData(String key, String value) { 
    Integer address = this.HashFunc(key);
        if(this.hashTable[address] != null) {
            this.hashTable[address].value = value;
        } else {
            this.hashTable[address] = new Slot(value);
        }
        return true;
    }
}

public class Hash {
    public static void main(String[] args) {

    }
}
