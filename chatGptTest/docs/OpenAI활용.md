

### 이미지 자동생성
- http://13.124.18.52:8080/api/createImage?question=흰색 말티즈
- http://13.124.18.52:8080/api/createImage?question=골든 리트리버
- 약점 : 구체적으로 강아지 종류등 언급을 해야 제대로 된 이미지가 생성됨
- 한글 입력시 인식이 안되서, 내부적으로 번역처리후 PI호출함
- amazing question
```mermaid
an astronaut lounging in a tropical resort in space, vaporwave
an oil pastel drawing of an annoyed cat in a spaceship
an expressive oil painting of a basketball player dunking, depicted as an explosion of a nebula
```

### 반려동물과 채팅
- http://13.124.18.52:8080/api/chat?question=엄마가 많이 보고싶다.
- 시스템메시지로 상대방의 수준이나 상황을 지정할 수 있음


