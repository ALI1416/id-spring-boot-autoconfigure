# High Performance Snowflake ID Generator Springboot Autoconfigure 高性能雪花ID生成器SpringBoot自动配置

[![License](https://img.shields.io/github/license/ali1416/id-spring-boot-autoconfigure?label=License)](https://opensource.org/licenses/BSD-3-Clause)
[![Java Support](https://img.shields.io/badge/Java-8+-green)](https://openjdk.org/)
[![Maven Central](https://img.shields.io/maven-central/v/cn.404z/id-spring-boot-autoconfigure?label=Maven%20Central)](https://mvnrepository.com/artifact/cn.404z/id-spring-boot-autoconfigure)
[![Tag](https://img.shields.io/github/v/tag/ali1416/id-spring-boot-autoconfigure?label=Tag)](https://github.com/ALI1416/id-spring-boot-autoconfigure/tags)
[![Repo Size](https://img.shields.io/github/repo-size/ali1416/id-spring-boot-autoconfigure?label=Repo%20Size&color=success)](https://github.com/ALI1416/id-spring-boot-autoconfigure/archive/refs/heads/master.zip)

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
    <version>2.5.0</version>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <version>2.7.9</version>
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
log.info("ID为：{}", Id.next());
```

结果

```txt
[main] INFO cn.z.id.autoconfigure.IdAutoConfiguration - 读取到配置，MACHINE_ID为0，MACHINE_BITS为8，SEQUENCE_BITS为14
[main] INFO cn.z.id.Id - 预初始化...
[main] INFO cn.z.id.Id - 初始化，MACHINE_ID为0，MACHINE_BITS为8，SEQUENCE_BITS为12
[main] INFO cn.z.id.Id - 最大机器码MACHINE_ID为255，1ms内最多生成Id数量为4096，时钟最早回拨到2021-01-01 08:00:00.0，可使用时间大约为278年，失效日期为2299-09-27 23:10:22.207
[main] INFO cn.z.id.Id - 手动初始化...
[main] INFO cn.z.id.Id - 初始化，MACHINE_ID为0，MACHINE_BITS为8，SEQUENCE_BITS为14
[main] INFO cn.z.id.Id - 最大机器码MACHINE_ID为255，1ms内最多生成Id数量为16384，时钟最早回拨到2021-01-01 08:00:00.0，可使用时间大约为69年，失效日期为2090-09-07 23:47:35.551
[main] INFO c.z.i.a.IdAutoConfigurationTest - Started App in 0.798 seconds (JVM running for 1.632)
[main] INFO c.z.i.a.IdAutoConfigurationTest - ID为：22502074365247488
```

### 不配置属性

配置文件

```yml
# 不需要配置
```

代码

```java
log.info("ID为：{}", Id.next());
```

结果

```txt
[main] INFO c.z.i.a.IdAutoConfigurationTest - Started App in 0.735 seconds (JVM running for 1.401)
[main] INFO cn.z.id.Id - 预初始化...
[main] INFO cn.z.id.Id - 初始化，MACHINE_ID为0，MACHINE_BITS为8，SEQUENCE_BITS为12
[main] INFO cn.z.id.Id - 最大机器码MACHINE_ID为255，1ms内最多生成Id数量为4096，时钟最早回拨到2021-01-01 08:00:00.0，可使用时间大约为278年，失效日期为2299-09-27 23:10:22.207
[main] INFO c.z.i.a.IdAutoConfigurationTest - ID为：5625838540161024
```

### 配置部分属性

配置文件

```yml
id:
  machine-id: 10
```

代码

```java
log.info("ID为：{}", Id.next());
```

结果

```txt
[main] INFO cn.z.id.autoconfigure.IdAutoConfiguration - 读取到配置，MACHINE_ID为10
[main] INFO cn.z.id.Id - 预初始化...
[main] INFO cn.z.id.Id - 初始化，MACHINE_ID为0，MACHINE_BITS为8，SEQUENCE_BITS为12
[main] INFO cn.z.id.Id - 最大机器码MACHINE_ID为255，1ms内最多生成Id数量为4096，时钟最早回拨到2021-01-01 08:00:00.0，可使用时间大约为278年，失效日期为2299-09-27 23:10:22.207
[main] INFO cn.z.id.Id - 手动初始化...
[main] INFO cn.z.id.Id - 初始化，MACHINE_ID为10，MACHINE_BITS为8，SEQUENCE_BITS为12
[main] INFO cn.z.id.Id - 最大机器码MACHINE_ID为255，1ms内最多生成Id数量为4096，时钟最早回拨到2021-01-01 08:00:00.0，可使用时间大约为278年，失效日期为2299-09-27 23:10:22.207
[main] INFO c.z.i.a.IdAutoConfigurationTest - Started App in 0.825 seconds (JVM running for 1.509)
[main] INFO c.z.i.a.IdAutoConfigurationTest - ID为：5626263803830272
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
log.info("ID为：{}", Id.next());
```

结果

```txt
[main] INFO cn.z.id.autoconfigure.IdAutoConfiguration - 读取到配置，MACHINE_ID为0，MACHINE_BITS为8，SEQUENCE_BITS为6
[main] INFO cn.z.id.Id - 预初始化...
[main] INFO cn.z.id.Id - 初始化，MACHINE_ID为0，MACHINE_BITS为8，SEQUENCE_BITS为12
[main] INFO cn.z.id.Id - 最大机器码MACHINE_ID为255，1ms内最多生成Id数量为4096，时钟最早回拨到2021-01-01 08:00:00.0，可使用时间大约为278年，失效日期为2299-09-27 23:10:22.207
[main] INFO cn.z.id.Id - 手动初始化...
[main] INFO cn.z.id.Id - 初始化，MACHINE_ID为0，MACHINE_BITS为8，SEQUENCE_BITS为6
[main] INFO cn.z.id.Id - 最大机器码MACHINE_ID为255，1ms内最多生成Id数量为64，时钟最早回拨到2021-01-01 08:00:00.0，可使用时间大约为17851年，失效日期为19860-03-05 19:03:41.311
[main] INFO c.z.i.a.IdAutoConfigurationTest - Started App in 0.754 seconds (JVM running for 1.378)
[main] WARN cn.z.id.Id - 已经初始化过了，不可重复初始化！
[main] INFO c.z.i.a.IdAutoConfigurationTest - ID为：87913675669504
```

## 交流

- [x] QQ：`1416978277`
- [x] 微信：`1416978277`
- [x] 支付宝：`1416978277@qq.com`

![交流](https://cdn.jsdelivr.net/gh/ALI1416/ALI1416/image/contact.png)

## 赞助

![赞助](https://cdn.jsdelivr.net/gh/ALI1416/ALI1416/image/donate.png)
