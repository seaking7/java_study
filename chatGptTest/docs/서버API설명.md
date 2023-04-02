
## 로그인
### 구글 로그인
- 로그인 요청
localhost:8080/oauth2/authorization/google
- 인증 후 로그인 확인
http://localhost:8080/api/session

### 네이버 로그인
- 로그인 요청
localhost:8080/oauth2/authorization/naver
- 인증 후 로그인 확인
http://localhost:8080/api/session



## API 요청에 대한 실패시 응답방식
- 400오류, 500 오류 등 오류에 대해서는 아래와 같이 code, message 형태로 응답이 됩니다.
```
{
  "returnCode": "1000",
  "message": "You need to login"
}
```
- 정상응답의 경우 아래와 같이 정의된 json 데이터가 응답됩니다.
```
{
  "id": 1,
  "email": "seaking7@gmail.com",
  "name": "김태경",
  "photo": "https://lh3.googleusercontent.com/a/AGNmyxZynzAUXvVgeX1rSY-DiDck5gMGpyE2YwAb_C0W4A=s96-c"
}
```

## Swagger로 API 전문 확인
http://localhost:8080/swagger-ui/index.html

