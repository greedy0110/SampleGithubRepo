# SampleGithubRepo
koin + rxjava + retrofit 을 활용한 간단한 서버연동, 에러처리 repository 패턴 보여주는 앱

# Package 정리

## repository : ui 에서 접근해서 사용하는 data 형을 반환
- koin 을 사용해 repository 의 생성코드를 숨김

- remote : api call 이 일어남, 네트워크 통신함
- local : memory / local db 접근이 발생함, 네트워크 통신 내용을 캐싱해둠
- scheduler : rx scheulder 정의
- mapper : remote, db 에 종속된 데이터 형을 ui 에서 적용할 수 있는 data 형으로 반환

## data : ui 에서 접근해서 사용하는 자료형

## ui : activity, adapter, fragment 정리 해놓는 곳
- koin 을 사용해 repository 를 주입 받음
- repository 를 구독해서 데이터를 받아오거나, 데이터 변경을 함
