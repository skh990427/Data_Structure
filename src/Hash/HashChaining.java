package Hash;

class MyHashChaining { //해쉬 클래스
    public Slot[] hashTable;

    public MyHashChaining(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String key;
        String value;
        Slot next;
        Slot (String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public int HashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    /**
     * 해쉬 테이블에 데이터 추가
     */
    public boolean saveData(String key, String value) {
        int address = this.HashFunc(key);
        if(this.hashTable[address] != null) {
            Slot findSlot = this.hashTable[address];
            Slot prevSlot = this.hashTable[address];
            while(findSlot != null) {
                if(findSlot.key == key) {
                    findSlot.value = value;
                    return true;
                } else {
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            prevSlot.next = new Slot(key, value);
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    /**
     * 해쉬테이블에서 키값으로 value 꺼내기
     */
    public String getData(String key) {
        int address = this.HashFunc(key);
        if(this.hashTable[address] != null) {
            Slot findSlot = this.hashTable[address];
            while(findSlot != null) {
                if(findSlot.key == key) {
                    return findSlot.value;
                } else {
                    findSlot = findSlot.next;
                }
            }
            return null;
        } else {
            return null;
        }
    }
}

public class HashChaining {
    public static void main(String[] args) {
        //해쉬테이블 체이닝 기법
        MyHashChaining mainObject = new MyHashChaining(20);

        mainObject.saveData("DaveLee", "01022223333");
        mainObject.saveData("fun-coding", "01033334444");
        mainObject.saveData("David", "01044445555");
        mainObject.saveData("Dave", "01055556666");

        System.out.println(mainObject.getData("Dave"));
    }
}