package cn.z.id.autoconfigure;

import cn.z.id.Id;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <h1>高性能雪花ID生成器SpringBoot自动配置测试</h1>
 *
 * <p>
 * createDate 2021/09/22 16:24:01
 * </p>
 *
 * @author ALI[ali-k@foxmail.com]
 * @since 1.0.0
 **/
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootApplication
@SpringBootTest
@Slf4j
class IdAutoConfigurationTest {

    /**
     * 直接调用
     */
    // @Test
    void test00Normal() {
        // id:
        //   sequence-bits: 22
        log.info("ID {}", Id.next());
        // INFO c.z.i.autoconfigure.IdAutoConfiguration  : 高性能雪花ID生成器配置：序列号位数SEQUENCE_BITS 22
        // INFO cn.z.id.Id                               : 高性能雪花ID生成器预初始化：序列号位数SEQUENCE_BITS 20 ；1ms最多生成ID 1048576 个，起始时间 2021-01-01 08:00:00.0 ，失效时间 2299-09-27 23:10:22.207 ，大约可使用 278 年
        // INFO cn.z.id.Id                               : 高性能雪花ID生成器初始化：序列号位数SEQUENCE_BITS 22 ；1ms最多生成ID 4194304 个，起始时间 2021-01-01 08:00:00.0 ，失效时间 2090-09-07 23:47:35.551 ，大约可使用 69 年
        // INFO c.z.i.a.IdAutoConfigurationTest          : Started IdAutoConfigurationTest in 0.899 seconds (JVM running for 1.828)
        // INFO c.z.i.a.IdAutoConfigurationTest          : ID 421236717568131072
    }

    /**
     * 没有配置
     */
    @Test
    void test01None() {
        // # 不需要配置
        log.info("ID {}", Id.next());
        // INFO cn.z.id.Id                               : 高性能雪花ID生成器预初始化：序列号位数SEQUENCE_BITS 20 ；1ms最多生成ID 1048576 个，起始时间 2021-01-01 08:00:00.0 ，失效时间 2299-09-27 23:10:22.207 ，大约可使用 278 年
        // INFO cn.z.id.Id                               : 高性能雪花ID生成器初始化：序列号位数SEQUENCE_BITS 20 ；1ms最多生成ID 1048576 个，起始时间 2021-01-01 08:00:00.0 ，失效时间 2299-09-27 23:10:22.207 ，大约可使用 278 年
        // INFO c.z.i.a.IdAutoConfigurationTest          : Started IdAutoConfigurationTest in 0.899 seconds (JVM running for 1.828)
        // INFO c.z.i.a.IdAutoConfigurationTest          : ID 105309244723560448
    }

    /**
     * 配置属性后又手动初始化
     */
    // @Test
    void test03Init() {
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
    }

}
