package Hash;

class MyHashChaining { //해쉬 클래스
    public Slot[] hashTable;

    public MyHashChaining(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String key; //slot을 생성할때 key값도 추가하여 같이 저장
        String value;
        Slot next; // 링크드리스트로 사용하기때문에 다음을 가리키는 Slot의 next 객체 생성 *선언하여 생성할때 값이 들어간다기보단 Slot이 들어갈 공간? 느낌
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
        int address = this.HashFunc(key); //값이 들어갈 주소를 address에 할당
        if(this.hashTable[address] != null) { //값이 저잘될 주소에 이미 값이 있다면 체이닝하여 값을 찾아야함
            Slot findSlot = this.hashTable[address];//찾을 주소 Slot클래스의 findSlot객체 생성
            Slot prevSlot = this.hashTable[address];//현재 주소 Slot클래스의 prevSlot객체 생성

            while(findSlot != null) { //findSlot이 널값이 아니라면 반복
                if(findSlot.key == key) { //findSlot의 키값과, 입력받은 key값이 같다면
                    findSlot.value = value; //그 주소에 바로 value값 덮어씌우기
                    return true;
                } else { //findSlot의 키값과 입력받은 키값이 다르다면?
                    prevSlot = findSlot; //현재슬롯 = findSlot
                    findSlot = findSlot.next; // findSlot은 findSlot의 다음 슬롯을 할당
                }
            }
            prevSlot.next = new Slot(key, value); //while문을 다 돌아 탈출했다면 key에 매칭되는 값이 없다는것으로 현재슬롯의 다음슬롯에 새 슬롯을 할당하여 key와 value값을 할당
        } else {
            this.hashTable[address] = new Slot(key, value); // 값이 저장될 주소에 값이 없다면 바로 Slot을 생성하여 key와 value값을 할당
        }
        return true;
    }

    /**
     * 해쉬테이블에서 키값으로 value 꺼내기
     */
    public String getData(String key) {
        int address = this.HashFunc(key);
        if(this.hashTable[address] != null) { //해쉬테이블의 주소에 값이 있다면
            Slot findSlot = this.hashTable[address]; //findSlot객체를 생성하여 현재 주소의 헤드를 할당
            while(findSlot != null) { //findSlot이 null이 아니라면 반복
                if(findSlot.key == key) { //findSlot의 키값이 입력받은 key값과 동일하면
                    return findSlot.value; //findSlot의 value값을 할당
                } else {
                    findSlot = findSlot.next; //key값이 동일하지 않으면 findSlot에 다음 슬롯을 할당
                }
            }
            return null; // while문을 돌아도 key값과 매칭되는게 없으면 null을 리턴
        } else {
            return null; //해쉬테이블의 주소에 값이 없으면 바로 null을 리턴
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