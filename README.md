# object-oriented-programming

간단한 구현 내용을 8단계에 나누어 리팩토링한 레포지토리입니다.

<br>

## 리팩토링 내용 

#### step 1 : Oracle 접속 및 user 데이터 삽입, 조회 기능 구현
  - Oracle을 연결하고, 간단히 구현한 코드를 UserDao에 작성한다.

#### step 2 : 관심사 분리 (SOC, Seperation Of Concern)
  - connection 관련 중복 코드를 제거하여 유지보수성과 코드의 가독성 향상한다.

#### step 3 : 상속
  - UserDao를 추상 클래스로 변경하여 클래스가 재사용에 유리해지도록 변경한다.

#### step 4 : 의존성 주입 (Dependency Injection)
  - UserDao가 ConnectionGenerator를 생성하지 않고도 생성자를 통해서 주입받을 수 있도록 SimpleConnectionGenerator 필드를 생성하여 주입한다.

#### step 5 : 인터페이스
  - 인터페이스를 통해 실제 Connection을 생성하는 구현체와 연결되도록 한다. UserDao 클래스는 ConnectionGenerator 인터페이스의 구현체를 직접 다루지 않고 추상화된 인터페이스에만 의존할 수 있다.

#### step 6 : 의존성 주입 (Dependency Injection)
  - 생성자 주입을 통해 class 간의 연관관계를 없애고, runtime object 관계를 설정한다. ConnectionGenerator 인터페이스의 구현체가 변경되어도, UserDao 코드는 변경되지 않을 것이다. 기존 코드를 수정하지 않고도 새로운 요구사항에 대응할 수 있어 개방 폐쇄 원칙(OCP)을 준수할 것이다.

#### step 7 : 팩토리 메서드 패턴 (Factory Method Pattern)
  - 객체 생성을 DaoFactory에 위임하여 main(UserDaoTest)과의 역할을 분리한다. 새로운 구현 클래스가 추가되어도 기존 Factory 코드의 수정없이 새로운 Factory를 추가할 수 있다. 객체를 생성할 때 어떤 클래스의 인스턴스를 만들지 DaoFactory가 결정한다. 이것은 인스턴스 생성을 서브 클래스에게 위임한 것으로 Factory Method Pattern 생성 패턴을 사용하였다.

#### step 8 : 싱글톤 (Singleton)
  - DaoFactory 클래스에 싱글톤을 적용하여 객체를 반복해서 생성하는 것을 방지한다. 객체의 라이프 사이클을 관리한다는 점에서 DaoFactory는 스프링의 ApplicationContext와 비슷한 역할을 담당하며, ApplicationContext는 더 많은 기능과 유연성을 제공한다는 점에서 차이가 있다.