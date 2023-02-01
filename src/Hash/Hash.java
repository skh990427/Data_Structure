package Hash;

class MyHash { //해쉬 클래스
    public Slot[] hashTable; //Slot 배열의 hashTable 선언

    public MyHash(Integer size) { //MyHash 클래스 객체를 생성시 사이즈를 입력받아
        this.hashTable = new Slot[size]; // 입력받은 size로 hashTable의 slot객체가 들어갈 slot사이즈 할당
    }

    public class Slot { //해쉬테이블에서 사용할 Slot 클래스
        String value;
        Slot (String value) { //Slot 생성시 값을 입력받아 클래스의 value 변수에 값을 할당
            this.value = value;
        }
    }

    public int HashFunc(String key) { //매우간단한 해쉬함수 사이즈로 나눠서 나머지를 리턴
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    /**
     * 해쉬 테이블에 데이터 추가
     */
    public boolean saveData(String key, String value) { //hashtable에 추가하고싶은 key값과 value값을 입력받아 추가하는 메서드
    int address = this.HashFunc(key); // 해쉬함수에 키값을 던져 키값에 매칭되는 값이 저장될 주소를 리턴
        if(this.hashTable[address] != null) { 
            this.hashTable[address].value = value; //해쉬테이블의 주소안에 널값이 아니면 바로 값 덮어씌우기
        } else {
            this.hashTable[address] = new Slot(value); //해쉬테이블의 주소가 비어있으면 새로운 슬롯을 생성하며 value값 할당
        }
        return true;
    }

    /**
     * 해쉬테이블에서 키값으로 value 꺼내기
     */
    public String getData(String key) { //매개변수로 key값을 받아 value값을 찾기
        int address = this.HashFunc(key); //key값에 매칭되는 주소를 찾아 address에 할당
        if(this.hashTable[address] != null) { // 해쉬테이블의 주소가 비어있지않으면
            return this.hashTable[address].value; //해쉬테이블의 주소의 value값을 리턴, hashTable[address] = new Slot(value)로 값을 할당함 Slot객체는 value값을 가지고있음
        } else {
            return null;
        }
    }
}

public class Hash {
    public static void main(String[] args) {
         //해쉬테이블에 데이터 추가, 꺼내기 test
        MyHash mainObject = new MyHash(20);

        mainObject.saveData("key1", "111111");
        mainObject.saveData("2yek", "222222");
        mainObject.saveData("k3e3y", "333333");

        System.out.println(mainObject.getData("key1"));
    }
}
