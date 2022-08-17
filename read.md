<h2>로컬 실행 방법</h2>

<p> ide: intellij </p>
<p> port: 8088 사용</p>
<p> 실행 방법 : 같이 첨부된 ably.jar 파일을 java -jar ably.jar 실행어로 실행</p>
<br/>

<p> 테스트 방법: </p>

### 회원가입
POST http://localhost:8088/user/sign
Content-Type: application/json

< post.json

### 로그인
POST http://localhost:8088/user/login
Content-Type: application/json

< login.json

### 상세보기
GET http://localhost:8088/user/1

### 비밀번호 초기화
GET http://localhost:8088/user/reset-password/1

