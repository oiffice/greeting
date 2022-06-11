# Greeting Birthday
### version1 - Simple Message
---
Send simple greeting birthday message to those clients 
whose birthday is today <br/>
curl -X GET "http://localhost:8080/api/greeting/birthday"

### version2- Tailer-Made Message
---
Send greeting birthday message with tailer-made message to those clients
whose birthday is today <br/>
curl -X GET "http://localhost:8080/api/greeting/birthday?type=tailer"
type: tailer for tailer-made message, simple for simple message
