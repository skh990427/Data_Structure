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

    /**
     * 해쉬테이블에서 키값으로 value 꺼내기
     */
    public String getData(String key) {
        Integer address = this.HashFunc(key);
        if(this.hashTable[address] != null) {
            return this.hashTable[address].value;
        } else {
            return null;
        }
    }
}

public class Hash {
    public static void main(String[] args) {
        /**
         * 해쉬테이블에 데이터 추가, 꺼내기 test
         */
        MyHash mainObject = new MyHash(20);

        mainObject.saveData("key1", "111111");
        mainObject.saveData("2yek", "222222");
        mainObject.saveData("k3e3y", "333333");

        System.out.println(mainObject.getData("key1"));
    }
}
