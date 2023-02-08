package hello.core.singleton;

public class SingletonService {

    //1. 이렇게 선언하게 되면 클래스레벨의 스태틱 영역에 하나만 올라간다
    private static final SingletonService instance = new SingletonService();

    //2. 메서드로만 호출할 수 있도록 처리
    public static SingletonService getInstance() {
        return instance;
    }

    //3. 생성자를 private 으로 만들었기 때문에 다른곳에서 new 를 하지 못한다
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

    public static void main(String[] args) {

    }

    //싱글톤의 문제점
    //1. 코드가 많이 들어간다
    //2. 의존과계상 클라이언트가 구체 클래스에 의존 DIP 위반
    //3. OCP도 위반할 가능성이 높음
    //4. 테스트 어렵
    //5. 내부 속성을 변경하거나 초기화 하기 어렵다
    //6. private 생성자로 자식 클래스 만들기 어렵
    //7. 유연성 떨어짐
    //8. 안티 패턴으로도 불림

}
