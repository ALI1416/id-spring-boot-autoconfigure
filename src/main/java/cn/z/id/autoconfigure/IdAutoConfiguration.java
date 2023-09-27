package cn.z.id.autoconfigure;

import cn.z.id.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * <h1>高性能雪花ID生成器自动配置</h1>
 *
 * <p>
 * createDate 2021/02/25 14:41:05
 * </p>
 *
 * @author ALI[ali-k@foxmail.com]
 * @since 1.0.0
 */
@EnableConfigurationProperties(IdProperties.class)
public class IdAutoConfiguration {

    /**
     * 日志实例
     */
    private static final Logger log = LoggerFactory.getLogger(IdAutoConfiguration.class);

    /**
     * 构造函数(自动注入)
     *
     * @param idProperties IdProperties
     */
    public IdAutoConfiguration(IdProperties idProperties) {
        log.info("高性能雪花ID生成器配置：机器码MACHINE_ID {} ，机器码位数MACHINE_BITS {} ，序列号位数SEQUENCE_BITS {}", idProperties.getMachineId(), idProperties.getMachineBits(), idProperties.getSequenceBits());
        Id.init(idProperties.getMachineId(), idProperties.getMachineBits(), idProperties.getSequenceBits());
    }

}
