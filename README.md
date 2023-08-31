# High Performance Snowflake ID Generator Springboot Autoconfigure 高性能雪花ID生成器SpringBoot自动配置

[![License](https://img.shields.io/github/license/ALI1416/id-spring-boot-autoconfigure?label=License)](https://www.apache.org/licenses/LICENSE-2.0.txt)
[![Java Support](https://img.shields.io/badge/Java-8+-green)](https://openjdk.org/)
[![Maven Central](https://img.shields.io/maven-central/v/cn.404z/id-spring-boot-autoconfigure?label=Maven%20Central)](https://mvnrepository.com/artifact/cn.404z/id-spring-boot-autoconfigure)
[![Tag](https://img.shields.io/github/v/tag/ALI1416/id-spring-boot-autoconfigure?label=Tag)](https://github.com/ALI1416/id-spring-boot-autoconfigure/tags)
[![Repo Size](https://img.shields.io/github/repo-size/ALI1416/id-spring-boot-autoconfigure?label=Repo%20Size&color=success)](https://github.com/ALI1416/id-spring-boot-autoconfigure/archive/refs/heads/master.zip)

[![Java CI](https://github.com/ALI1416/id-spring-boot-autoconfigure/actions/workflows/ci.yml/badge.svg)](https://github.com/ALI1416/id-spring-boot-autoconfigure/actions/workflows/ci.yml)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=ALI1416_id-spring-boot-autoconfigure&metric=coverage)
![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=ALI1416_id-spring-boot-autoconfigure&metric=reliability_rating)
![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=ALI1416_id-spring-boot-autoconfigure&metric=sqale_rating)
![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=ALI1416_id-spring-boot-autoconfigure&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=ALI1416_id-spring-boot-autoconfigure)

## 简介

本项目是[高性能雪花ID生成器](https://github.com/ALI1416/id)的SpringBoot自动配置

## 依赖导入

```xml
<dependency>
  <groupId>cn.404z</groupId>
  <artifactId>id-spring-boot-autoconfigure</artifactId>
  <version>2.8.0</version>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter</artifactId>
  <version>2.7.15</version>
</dependency>
```

## 使用方法

### 正常使用

配置文件

```yml
id:
  machine-id: 0
  machine-bits: 8
  sequence-bits: 14
```

代码

```java
log.info("ID {}", Id.next());
```

结果

```txt
INFO c.z.i.autoconfigure.IdAutoConfiguration  : 读取配置...
INFO c.z.i.autoconfigure.IdAutoConfiguration  : 机器码MACHINE_ID 0 ，机器码位数MACHINE_BITS 8 ，序列号位数SEQUENCE_BITS 14
INFO cn.z.id.Id                               : 预初始化...
INFO cn.z.id.Id                               : 机器码MACHINE_ID 0 ，机器码位数MACHINE_BITS 8 ，序列号位数SEQUENCE_BITS 12
INFO cn.z.id.Id                               : 最大机器码MACHINE_ID 255 ，1ms内最多生成ID数量 4096 ，时钟最早回拨到 2021-01-01 08:00:00.0 ，可使用时间大约 278 年，失效时间 2299-09-27 23:10:22.207
INFO cn.z.id.Id                               : 初始化...
INFO cn.z.id.Id                               : 机器码MACHINE_ID 0 ，机器码位数MACHINE_BITS 8 ，序列号位数SEQUENCE_BITS 14
INFO cn.z.id.Id                               : 最大机器码MACHINE_ID 255 ，1ms内最多生成ID数量 16384 ，时钟最早回拨到 2021-01-01 08:00:00.0 ，可使用时间大约 69 年，失效时间 2090-09-07 23:47:35.551
INFO c.z.i.a.IdAutoConfigurationTest          : Started IdAutoConfigurationTest in 0.899 seconds (JVM running for 1.828)
INFO c.z.i.a.IdAutoConfigurationTest          : ID 339682552790908928
```

### 不配置属性

配置文件

```yml
# 不需要配置
```

代码

```java
log.info("ID {}", Id.next());
```

结果

```txt
INFO cn.z.id.Id                               : 预初始化...
INFO cn.z.id.Id                               : 机器码MACHINE_ID 0 ，机器码位数MACHINE_BITS 8 ，序列号位数SEQUENCE_BITS 12
INFO cn.z.id.Id                               : 最大机器码MACHINE_ID 255 ，1ms内最多生成ID数量 4096 ，时钟最早回拨到 2021-01-01 08:00:00.0 ，可使用时间大约 278 年，失效时间 2299-09-27 23:10:22.207
INFO c.z.i.a.IdAutoConfigurationTest          : Started IdAutoConfigurationTest in 0.899 seconds (JVM running for 1.828)
INFO c.z.i.a.IdAutoConfigurationTest          : ID 84920754824544256
```

### 配置部分属性

配置文件

```yml
id:
  machine-id: 10
```

代码

```java
log.info("ID {}", Id.next());
```

结果

```txt
INFO c.z.i.autoconfigure.IdAutoConfiguration  : 读取配置...
INFO c.z.i.autoconfigure.IdAutoConfiguration  : 机器码MACHINE_ID 10 ，机器码位数MACHINE_BITS 8 (默认)，序列号位数SEQUENCE_BITS 12 (默认)
INFO cn.z.id.Id                               : 预初始化...
INFO cn.z.id.Id                               : 机器码MACHINE_ID 0 ，机器码位数MACHINE_BITS 8 ，序列号位数SEQUENCE_BITS 12
INFO cn.z.id.Id                               : 最大机器码MACHINE_ID 255 ，1ms内最多生成ID数量 4096 ，时钟最早回拨到 2021-01-01 08:00:00.0 ，可使用时间大约 278 年，失效时间 2299-09-27 23:10:22.207
INFO cn.z.id.Id                               : 初始化...
INFO cn.z.id.Id                               : 机器码MACHINE_ID 10 ，机器码位数MACHINE_BITS 8 ，序列号位数SEQUENCE_BITS 12
INFO cn.z.id.Id                               : 最大机器码MACHINE_ID 255 ，1ms内最多生成ID数量 4096 ，时钟最早回拨到 2021-01-01 08:00:00.0 ，可使用时间大约 278 年，失效时间 2299-09-27 23:10:22.207
INFO c.z.i.a.IdAutoConfigurationTest          : Started IdAutoConfigurationTest in 0.899 seconds (JVM running for 1.828)
INFO c.z.i.a.IdAutoConfigurationTest          : ID 84920800342220800
```

### 配置属性后又手动初始化

配置文件

```yml
id:
  machine-id: 0
  machine-bits: 8
  sequence-bits: 6
```

代码

```java
Id.init(20, 6, 10);
log.info("ID {}", Id.next());
```

结果

```txt
INFO c.z.i.autoconfigure.IdAutoConfiguration  : 读取配置...
INFO c.z.i.autoconfigure.IdAutoConfiguration  : 机器码MACHINE_ID 0 ，机器码位数MACHINE_BITS 8 ，序列号位数SEQUENCE_BITS 6
INFO cn.z.id.Id                               : 预初始化...
INFO cn.z.id.Id                               : 机器码MACHINE_ID 0 ，机器码位数MACHINE_BITS 8 ，序列号位数SEQUENCE_BITS 12
INFO cn.z.id.Id                               : 最大机器码MACHINE_ID 255 ，1ms内最多生成ID数量 4096 ，时钟最早回拨到 2021-01-01 08:00:00.0 ，可使用时间大约 278 年，失效时间 2299-09-27 23:10:22.207
INFO cn.z.id.Id                               : 初始化...
INFO cn.z.id.Id                               : 机器码MACHINE_ID 0 ，机器码位数MACHINE_BITS 8 ，序列号位数SEQUENCE_BITS 6
INFO cn.z.id.Id                               : 最大机器码MACHINE_ID 255 ，1ms内最多生成ID数量 64 ，时钟最早回拨到 2021-01-01 08:00:00.0 ，可使用时间大约 17851 年，失效时间 19860-03-05 19:03:41.311
INFO c.z.i.a.IdAutoConfigurationTest          : Started IdAutoConfigurationTest in 0.899 seconds (JVM running for 1.828)
WARN cn.z.id.Id                               : 已经初始化过了，不可重复初始化！
INFO c.z.i.a.IdAutoConfigurationTest          : ID 1326888443904000
```

更多请见[测试](./src/test)

## 更新日志

[点击查看](./CHANGELOG.md)

## 关于

<picture>
  <source media="(prefers-color-scheme: dark)" srcset="https://www.404z.cn/images/about.dark.svg">
  <img alt="About" src="https://www.404z.cn/images/about.light.svg">
</picture>
