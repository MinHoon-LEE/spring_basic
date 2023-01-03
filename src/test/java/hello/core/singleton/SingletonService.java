package hello.core.singleton;

public class SingletonService {
    // Spring 이 실행될떄 하나만 만들어 놓는다
    private static final SingletonService instance = new SingletonService();

    // 매번 같은 객체를 반환 하게 되어있다.
    public static SingletonService getInstance(){
        return instance;
    }

    // 함부로 외부에서 객체를 생성하지 못하게 막는다 .
    private SingletonService(){

    }

}
