# springboot-api-demo


## Hosts 配置

```
[mysql ip address]   mysql
127.0.0.1   hunter

```

## 无授权访问

```
http://hunter:8080/api/noauth/hello
```

## 需要授权访问

### 获取授权令牌（token）

#### Header
```
Authorization:Basic bW9iaWxlOg==
```

#### form-data
```
username:Frank
password:frank
grant_type:password
```


