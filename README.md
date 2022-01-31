1.eureka-server-port = 1010


2.netty-server-port = 2020


3.websocket-request-url = 
ws://localhost:2020/socket/?EIO=3&transport=websocket


####测试用Json
```json
//bind user 1
{
  "type":"1",
  "data":{"token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLlvKDkuIkiLCJpc3MiOiJpc3MiLCJpZCI6IjEzMjY2NzQ2NDU3IiwiZXhwIjoxNjU4NTUyMDMzLCJpYXQiOjE2NDM1NTIwMzN9.iNRYKpnkBk3y_XwCMn-M5SRNV8BU0nG-O4CQ5e3He7o"}
}
//bind user 2
{
  "type":"1",
  "data":{"token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLmnY7lm5siLCJpc3MiOiJpc3MiLCJpZCI6IjEzMjY2NzQ2NDU2IiwiZXhwIjoxNjU4NTUyMDMzLCJpYXQiOjE2NDM1NTIwMzN9.7--2-mdQjZEYfjqgCe23FDJTTYRmBVGWNqryTszbYVg"}
}

//one on one
{
  "type":"2",
  "data":{"token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLlvKDkuIkiLCJpc3MiOiJpc3MiLCJpZCI6IjEzMjY2NzQ2NDU3IiwiZXhwIjoxNjU4NTUyMDMzLCJpYXQiOjE2NDM1NTIwMzN9.iNRYKpnkBk3y_XwCMn-M5SRNV8BU0nG-O4CQ5e3He7o",
    "sender":"13266746457",
    "receiver":"13266746456"
  }
}
{
  "type":"2",
  "data":{"token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLmnY7lm5siLCJpc3MiOiJpc3MiLCJpZCI6IjEzMjY2NzQ2NDU2IiwiZXhwIjoxNjU4NTUyMDMzLCJpYXQiOjE2NDM1NTIwMzN9.7--2-mdQjZEYfjqgCe23FDJTTYRmBVGWNqryTszbYVg",
    "sender":"13266746456",
    "receiver":"13266746457"
  }
}

//group
{
  "type":"3",
  "data":{"token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTaGFHb3UiLCJpc3MiOiJpc3MiLCJpZCI6IjEzMjY2NzQ2NDUxIiwiZXhwIjoxNjU4NjEzMTE2LCJpYXQiOjE2NDM2MTMxMTZ9.vhdV9q4hLG31RawlvoLgB5raapoK9vWqfxUcMbNnnMo",
    "sender":"13266746451",
    "message":"大家好我是13266746451 user，我会唱跳 rap ，和打篮球，想来本群找个女朋友，不知道有没有人喜欢我.大家好我是13266746451 user，我会唱跳 rap ，和打篮球，想来本群找个女朋友，不知道有没有人喜欢我.大家好我是13266746451 user，我会唱跳 rap ，和打篮球，想来本群找个女朋友，不知道有没有人喜欢我",
    "receivers":["13266746452","13266746453","13266746454","13266746455"]
  }
}
```
![](https://tva1.sinaimg.cn/large/008i3skNly1gywwojm2rrj30xk0u0tbt.jpg)