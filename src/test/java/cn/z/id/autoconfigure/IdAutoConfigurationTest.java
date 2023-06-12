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
        log.info("ID为：{}", Id.next());
        // [main] INFO cn.z.id.autoconfigure.IdAutoConfiguration - 读取到配置，MACHINE_ID为0，MACHINE_BITS为8，SEQUENCE_BITS为14
        // [main] INFO cn.z.id.Id - 预初始化...
        // [main] INFO cn.z.id.Id - 初始化，MACHINE_ID为0，MACHINE_BITS为8，SEQUENCE_BITS为12
        // [main] INFO cn.z.id.Id - 最大机器码MACHINE_ID为255，1ms内最多生成Id数量为4096，时钟最早回拨到2021-01-01 08:00:00
        // .0，可使用时间大约为278年，失效日期为2299-09-27 23:10:22.207
        // [main] INFO cn.z.id.Id - 手动初始化...
        // [main] INFO cn.z.id.Id - 初始化，MACHINE_ID为0，MACHINE_BITS为8，SEQUENCE_BITS为14
        // [main] INFO cn.z.id.Id -  最大机器码MACHINE_ID为255，1ms内最多生成Id数量为16384，时钟最早回拨到2021-01-01 08:00:00
        // .0，可使用时间大约为69年，失效日期为2090-09-07 23:47:35.551
        // [main] INFO c.z.i.a.IdAutoConfigurationTest - Started App in 0.798 seconds (JVM running for 1.632)
        // [main] INFO c.z.i.a.IdAutoConfigurationTest - ID为：22502074365247488
    }

    /**
     * 没有配置
     */
    // @Test
    void test01None() {
        log.info("ID为：{}", Id.next());
        // [main] INFO c.z.i.a.IdAutoConfigurationTest - Started App in 0.735 seconds (JVM running for 1.401)
        // [main] INFO cn.z.id.Id - 预初始化...
        // [main] INFO cn.z.id.Id - 初始化，MACHINE_ID为0，MACHINE_BITS为8，SEQUENCE_BITS为12
        // [main] INFO cn.z.id.Id - 最大机器码MACHINE_ID为255，1ms内最多生成Id数量为4096，时钟最早回拨到2021-01-01 08:00:00
        // .0，可使用时间大约为278年，失效日期为2299-09-27 23:10:22.207
        // [main] INFO c.z.i.a.IdAutoConfigurationTest - ID为：5625838540161024
    }

    /**
     * 配置部分属性
     */
    // @Test
    void test02Part() {
        log.info("ID为：{}", Id.next());
        // [main] INFO cn.z.id.autoconfigure.IdAutoConfiguration - 读取到配置，MACHINE_ID为10
        // [main] INFO cn.z.id.Id - 预初始化...
        // [main] INFO cn.z.id.Id - 初始化，MACHINE_ID为0，MACHINE_BITS为8，SEQUENCE_BITS为12
        // [main] INFO cn.z.id.Id - 最大机器码MACHINE_ID为255，1ms内最多生成Id数量为4096，时钟最早回拨到2021-01-01 08:00:00
        // .0，可使用时间大约为278年，失效日期为2299-09-27 23:10:22.207
        // [main] INFO cn.z.id.Id - 手动初始化...
        // [main] INFO cn.z.id.Id - 初始化，MACHINE_ID为10，MACHINE_BITS为8，SEQUENCE_BITS为12
        // [main] INFO cn.z.id.Id - 最大机器码MACHINE_ID为255，1ms内最多生成Id数量为4096，时钟最早回拨到2021-01-01 08:00:00
        // .0，可使用时间大约为278年，失效日期为2299-09-27 23:10:22.207
        // [main] INFO c.z.i.a.IdAutoConfigurationTest - Started App in 0.825 seconds (JVM running for 1.509)
        // [main] INFO c.z.i.a.IdAutoConfigurationTest - ID为：5626263803830272
    }

    /**
     * 配置属性后又手动初始化
     */
    // @Test
    void test03Init() {
        Id.init(20, 6, 10);
        log.info("ID为：{}", Id.next());
        // [main] INFO cn.z.id.autoconfigure.IdAutoConfiguration - 读取到配置，MACHINE_ID为0，MACHINE_BITS为8，SEQUENCE_BITS为6
        // [main] INFO cn.z.id.Id - 预初始化...
        // [main] INFO cn.z.id.Id - 初始化，MACHINE_ID为0，MACHINE_BITS为8，SEQUENCE_BITS为12
        // [main] INFO cn.z.id.Id - 最大机器码MACHINE_ID为255，1ms内最多生成Id数量为4096，时钟最早回拨到2021-01-01 08:00:00
        // .0，可使用时间大约为278年，失效日期为2299-09-27 23:10:22.207
        // [main] INFO cn.z.id.Id - 手动初始化...
        // [main] INFO cn.z.id.Id - 初始化，MACHINE_ID为0，MACHINE_BITS为8，SEQUENCE_BITS为6
        // [main] INFO cn.z.id.Id - 最大机器码MACHINE_ID为255，1ms内最多生成Id数量为64，时钟最早回拨到2021-01-01 08:00:00
        // .0，可使用时间大约为17851年，失效日期为19860-03-05 19:03:41.311
        // [main] INFO c.z.i.a.IdAutoConfigurationTest - Started App in 0.754 seconds (JVM running for 1.378)
        // [main] WARN cn.z.id.Id - 已经初始化过了，不可重复初始化！
        // [main] INFO c.z.i.a.IdAutoConfigurationTest - ID为：87913675669504
    }

}
