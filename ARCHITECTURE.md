# Intro.

# 1. Packages

- app: 각 도메인의 애플리케이션 전체가 들어가있는 패키지
- support: 공통적으로 사용하는 모듈들이 위치

도메인 패키지 구조는 다음으로 구성됨

- api: 외부에 노출되는 인터페이스
  - controller
  - messaging
  - whatever
- application: 애플리케이션
- domain: 순수 비즈니스 로직
  - 아무것도 의존해서는 안됨
- infrastructure: 외부에서 들어오거나 외부로 나가는 것에 대한 구현체들
  - 이 구조를 직접 의존하면 안됨
