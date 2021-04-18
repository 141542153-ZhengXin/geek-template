# geek-template
    【模块】项目标准模板

## 框架结构
`spring-boot` `mybatis-plus`

    spring-boot: 2.3.5.RELEASE
    mybatis-plus: 3.2.0

## 项目结构
``` 
├─src
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      └─geek
│  │  │          └─web
│  │  │              ├─config
│  │  │              ├─controller
│  │  │              ├─dao
│  │  │              │  └─mapper
│  │  │              ├─model
│  │  │              │  ├─dto
│  │  │              │  ├─entity
│  │  │              │  ├─enums
│  │  │              │  └─vm
│  │  │              ├─service
│  │  │              │  └─impl
│  │  │              └─util
│  │  └─resources
│  │      ├─mapper
│  │      └─script
│  └─test
│      └─java
``` 

## 功能
    请求日志: 拦截请求，打印参数日志

