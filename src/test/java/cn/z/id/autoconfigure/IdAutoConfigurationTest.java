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
    @Test
    void test00Normal() {
        log.info("ID {}", Id.next());
        // INFO c.z.i.autoconfigure.IdAutoConfiguration  : 读取配置...
        // INFO c.z.i.autoconfigure.IdAutoConfiguration  : 机器码MACHINE_ID 0 ，机器码位数MACHINE_BITS 8 ，序列号位数SEQUENCE_BITS 14
        // INFO cn.z.id.Id                               : 预初始化...
        // INFO cn.z.id.Id                               : 机器码MACHINE_ID 0 ，机器码位数MACHINE_BITS 8 ，序列号位数SEQUENCE_BITS 12
        // INFO cn.z.id.Id                               : 最大机器码MACHINE_ID 255 ，1ms内最多生成ID数量 4096 ，时钟最早回拨到 2021-01-01 08:00:00.0 ，可使用时间大约 278 年，失效时间 2299-09-27 23:10:22.207
        // INFO cn.z.id.Id                               : 初始化...
        // INFO cn.z.id.Id                               : 机器码MACHINE_ID 0 ，机器码位数MACHINE_BITS 8 ，序列号位数SEQUENCE_BITS 14
        // INFO cn.z.id.Id                               : 最大机器码MACHINE_ID 255 ，1ms内最多生成ID数量 16384 ，时钟最早回拨到 2021-01-01 08:00:00.0 ，可使用时间大约 69 年，失效时间 2090-09-07 23:47:35.551
        // INFO c.z.i.a.IdAutoConfigurationTest          : Started IdAutoConfigurationTest in 0.899 seconds (JVM running for 1.828)
        // INFO c.z.i.a.IdAutoConfigurationTest          : ID 339682552790908928
    }

    /**
     * 没有配置
     */
    // @Test
    void test01None() {
        log.info("ID {}", Id.next());
        // INFO cn.z.id.Id                               : 预初始化...
        // INFO cn.z.id.Id                               : 机器码MACHINE_ID 0 ，机器码位数MACHINE_BITS 8 ，序列号位数SEQUENCE_BITS 12
        // INFO cn.z.id.Id                               : 最大机器码MACHINE_ID 255 ，1ms内最多生成ID数量 4096 ，时钟最早回拨到 2021-01-01 08:00:00.0 ，可使用时间大约 278 年，失效时间 2299-09-27 23:10:22.207
        // INFO c.z.i.a.IdAutoConfigurationTest          : Started IdAutoConfigurationTest in 0.899 seconds (JVM running for 1.828)
        // INFO c.z.i.a.IdAutoConfigurationTest          : ID 84920754824544256
    }

    /**
     * 配置部分属性
     */
    // @Test
    void test02Part() {
        log.info("ID {}", Id.next());
        // INFO c.z.i.autoconfigure.IdAutoConfiguration  : 读取配置...
        // INFO c.z.i.autoconfigure.IdAutoConfiguration  : 机器码MACHINE_ID 10 ，机器码位数MACHINE_BITS 8 (默认)，序列号位数SEQUENCE_BITS 12 (默认)
        // INFO cn.z.id.Id                               : 预初始化...
        // INFO cn.z.id.Id                               : 机器码MACHINE_ID 0 ，机器码位数MACHINE_BITS 8 ，序列号位数SEQUENCE_BITS 12
        // INFO cn.z.id.Id                               : 最大机器码MACHINE_ID 255 ，1ms内最多生成ID数量 4096 ，时钟最早回拨到 2021-01-01 08:00:00.0 ，可使用时间大约 278 年，失效时间 2299-09-27 23:10:22.207
        // INFO cn.z.id.Id                               : 初始化...
        // INFO cn.z.id.Id                               : 机器码MACHINE_ID 10 ，机器码位数MACHINE_BITS 8 ，序列号位数SEQUENCE_BITS 12
        // INFO cn.z.id.Id                               : 最大机器码MACHINE_ID 255 ，1ms内最多生成ID数量 4096 ，时钟最早回拨到 2021-01-01 08:00:00.0 ，可使用时间大约 278 年，失效时间 2299-09-27 23:10:22.207
        // INFO c.z.i.a.IdAutoConfigurationTest          : Started IdAutoConfigurationTest in 0.899 seconds (JVM running for 1.828)
        // INFO c.z.i.a.IdAutoConfigurationTest          : ID 84920800342220800
    }

    /**
     * 配置属性后又手动初始化
     */
    // @Test
    void test03Init() {
        Id.init(20, 6, 10);
        log.info("ID {}", Id.next());
        // INFO c.z.i.autoconfigure.IdAutoConfiguration  : 读取配置...
        // INFO c.z.i.autoconfigure.IdAutoConfiguration  : 机器码MACHINE_ID 0 ，机器码位数MACHINE_BITS 8 ，序列号位数SEQUENCE_BITS 6
        // INFO cn.z.id.Id                               : 预初始化...
        // INFO cn.z.id.Id                               : 机器码MACHINE_ID 0 ，机器码位数MACHINE_BITS 8 ，序列号位数SEQUENCE_BITS 12
        // INFO cn.z.id.Id                               : 最大机器码MACHINE_ID 255 ，1ms内最多生成ID数量 4096 ，时钟最早回拨到 2021-01-01 08:00:00.0 ，可使用时间大约 278 年，失效时间 2299-09-27 23:10:22.207
        // INFO cn.z.id.Id                               : 初始化...
        // INFO cn.z.id.Id                               : 机器码MACHINE_ID 0 ，机器码位数MACHINE_BITS 8 ，序列号位数SEQUENCE_BITS 6
        // INFO cn.z.id.Id                               : 最大机器码MACHINE_ID 255 ，1ms内最多生成ID数量 64 ，时钟最早回拨到 2021-01-01 08:00:00.0 ，可使用时间大约 17851 年，失效时间 19860-03-05 19:03:41.311
        // INFO c.z.i.a.IdAutoConfigurationTest          : Started IdAutoConfigurationTest in 0.899 seconds (JVM running for 1.828)
        // WARN cn.z.id.Id                               : 已经初始化过了，不可重复初始化！
        // INFO c.z.i.a.IdAutoConfigurationTest          : ID 1326888443904000
    }

}
