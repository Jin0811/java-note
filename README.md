# Java 快速迁移学习笔记

这个项目用于帮助有前端、JavaScript、TypeScript 基础的开发者快速迁移到 Java 后端开发。

学习方式参考之前的 Vue 笔记：每个知识点独立创建一个 Java 文件。后续可以直接在 IntelliJ IDEA 中打开文件、运行 `main` 方法、打断点调试、修改参数观察结果。

## 学习目标

1. 快速熟悉 Java 语言本身。
2. 用 JS/TS 已有经验理解 Java 的类型、类、接口、集合、异常等核心概念。
3. 为阅读公司内部 Java 后端项目做准备。
4. 后续逐步过渡到 Spring Boot、MySQL、接口开发和真实业务代码。

## 推荐学习路线

```text
Java 基础语法
-> 面向对象
-> 集合框架
-> 异常处理
-> 泛型
-> Lambda / Stream
-> IO 与文件
-> 日期时间
-> 多线程基础
-> JDBC / 数据库访问
-> Spring Boot 后端项目结构
-> 公司项目代码阅读与调试
```

## 目录规划

```text
src/
├─ basic/              Java 基础语法
├─ oop/                面向对象
├─ collection/         集合框架
├─ exception/          异常处理
├─ generic/            泛型
├─ lambda/             Lambda / Stream
├─ io/                 文件与输入输出
├─ datetime/           日期时间
├─ thread/             多线程基础
├─ jdbc/               数据库连接基础
├─ spring/             Spring / Spring Boot 预备知识
└─ projectcase/        模拟真实后端业务代码
```

## 当前阶段：basic

`basic` 目录用于掌握 Java 最基础的语法。这里的每个文件都包含一个 `main` 方法，可以单独运行。

```text
src/basic/
├─ HelloWorld.java          程序入口、控制台输出
├─ VariableAndType.java     变量、基础类型、字符串
├─ OperatorDemo.java        运算符
├─ IfElseDemo.java          条件判断
├─ ForLoopDemo.java         循环
├─ ArrayDemo.java           数组
└─ MethodDemo.java          方法定义与调用
```

## 学习建议

先按 `basic` 目录顺序阅读和运行代码。每看一个文件，建议做三件事：

1. 先运行，看控制台输出。
2. 给关键行打断点，观察变量变化。
3. 修改代码，比如换数据、换条件、换循环次数，再运行一次。

阅读时重点关注 Java 和 JS/TS 的差异：

```text
JS/TS 更灵活，Java 更强调明确类型和固定结构。
JS/TS 常用函数和对象组织逻辑，Java 后端项目通常用类、接口、包和分层组织逻辑。
JS/TS 运行时更动态，Java 编译阶段会提前发现大量类型错误。
```

后续进入 Spring Boot 后，可以把前端经验迁移成这样的理解：

```text
Controller  类似接口路由入口
Service     类似业务逻辑层
Mapper/DAO  类似数据库访问层
DTO/VO      类似前后端接口数据结构
Entity      类似数据库表对应的数据模型
```

