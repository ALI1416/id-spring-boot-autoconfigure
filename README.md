# High Performance Snowflake ID Generator Springboot Autoconfigure (Single Version) 高性能雪花ID生成器SpringBoot自动配置(单机版)

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

### 支持版本

- [主线版本](https://github.com/ALI1416/id-spring-boot-autoconfigure/tree/master)
- [单机版](https://github.com/ALI1416/id-spring-boot-autoconfigure/tree/single) 去除`机器码`、`机器码位数`字段，不支持分布式

## 依赖导入

```xml
<dependency>
  <groupId>cn.404z</groupId>
  <artifactId>id-spring-boot-autoconfigure</artifactId>
  <version>3.3.0.single</version>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter</artifactId>
  <version>2.7.18</version>
</dependency>
```

## 使用方法

### 直接调用

```java
// id:
//   sequence-bits: 22
log.info("ID {}", Id.next());
// INFO c.z.i.autoconfigure.IdAutoConfiguration  : 高性能雪花ID生成器配置：序列号位数SEQUENCE_BITS 22
// INFO cn.z.id.Id                               : 高性能雪花ID生成器预初始化：序列号位数SEQUENCE_BITS 20 ；1ms最多生成ID 1048576 个，起始时间 2021-01-01 08:00:00.0 ，失效时间 2299-09-27 23:10:22.207 ，大约可使用 278 年
// INFO cn.z.id.Id                               : 高性能雪花ID生成器初始化：序列号位数SEQUENCE_BITS 22 ；1ms最多生成ID 4194304 个，起始时间 2021-01-01 08:00:00.0 ，失效时间 2090-09-07 23:47:35.551 ，大约可使用 69 年
// INFO c.z.i.a.IdAutoConfigurationTest          : Started IdAutoConfigurationTest in 0.899 seconds (JVM running for 1.828)
// INFO c.z.i.a.IdAutoConfigurationTest          : ID 421236717568131072
```

### 没有配置

```java
// # 不需要配置
log.info("ID {}", Id.next());
// INFO cn.z.id.Id                               : 高性能雪花ID生成器预初始化：序列号位数SEQUENCE_BITS 20 ；1ms最多生成ID 1048576 个，起始时间 2021-01-01 08:00:00.0 ，失效时间 2299-09-27 23:10:22.207 ，大约可使用 278 年
// INFO cn.z.id.Id                               : 高性能雪花ID生成器初始化：序列号位数SEQUENCE_BITS 20 ；1ms最多生成ID 1048576 个，起始时间 2021-01-01 08:00:00.0 ，失效时间 2299-09-27 23:10:22.207 ，大约可使用 278 年
// INFO c.z.i.a.IdAutoConfigurationTest          : Started IdAutoConfigurationTest in 0.899 seconds (JVM running for 1.828)
// INFO c.z.i.a.IdAutoConfigurationTest          : ID 105309244723560448
```

### 配置属性后又手动初始化

```java
// id:
//   sequence-bits: 22
Id.init(20);
log.info("ID {}", Id.next());
// INFO c.z.i.autoconfigure.IdAutoConfiguration  : 高性能雪花ID生成器配置：序列号位数SEQUENCE_BITS 22
// INFO cn.z.id.Id                               : 高性能雪花ID生成器预初始化：序列号位数SEQUENCE_BITS 20 ；1ms最多生成ID 1048576 个，起始时间 2021-01-01 08:00:00.0 ，失效时间 2299-09-27 23:10:22.207 ，大约可使用 278 年
// INFO cn.z.id.Id                               : 高性能雪花ID生成器初始化：序列号位数SEQUENCE_BITS 22 ；1ms最多生成ID 4194304 个，起始时间 2021-01-01 08:00:00.0 ，失效时间 2090-09-07 23:47:35.551 ，大约可使用 69 年
// INFO c.z.i.a.IdAutoConfigurationTest          : Started IdAutoConfigurationTest in 0.899 seconds (JVM running for 1.828)
// WARN cn.z.id.Id                               : 已经初始化过了，不可重复初始化！
// INFO c.z.i.a.IdAutoConfigurationTest          : ID 421237292171001856
```

更多请见[测试](./src/test)

## 更新日志

[点击查看](./CHANGELOG.md)

## 关于

<picture>
  <source media="(prefers-color-scheme: dark)" srcset="https://www.404z.cn/images/about.dark.svg">
  <img alt="About" src="https://www.404z.cn/images/about.light.svg">
</picture>
