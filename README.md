# Greeting Birthday
### version1 - Simple Message
---
Send simple greeting birthday message to those clients 
whose birthday is today
curl -X GET "http://localhost:8080/api/greeting/birthday"

### version2- Tailer-Made Message
---
Send greeting birthday message with tailer-made message to those clients
whose birthday is today
curl -X GET "http://localhost:8080/api/greeting/birthday?type=tailer"
type: tailer for tailer-made message, simple for simple message

### version3 - Message with an Elder Picture for those whose age is over 49
---
Send simple greeting birthday message with picture to those clients
whose birthday is today and age is over 49
curl -X GET "http://localhost:8080/api/greeting/birthday?type=simple"

