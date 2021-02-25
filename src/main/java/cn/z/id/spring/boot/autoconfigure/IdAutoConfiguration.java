package cn.z.id.spring.boot.autoconfigure;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import cn.z.id.Id;

/**
 * <h1>高性能Id生成器自动配置</h1>
 *
 * <p>
 * createDate 2021/02/25 14:41:05
 * </p>
 *
 * @author ALI[ali-k@foxmail.com]
 * @since 1.0.0
 */
@Configuration
@EnableConfigurationProperties(IdProperties.class)
public class IdAutoConfiguration {

    /**
     * machineId默认值{@value}
     */
    private final static long DEFAULT_MACHINE_ID = 0L;
    /**
     * machineBits默认值{@value}
     */
    private final static long DEFAULT_MACHINE_BITS = 8L;
    /**
     * sequenceBits默认值{@value}
     */
    private final static long DEFAULT_SEQUENCE_BITS = 14L;

    /**
     * IdProperties
     */
    @Autowired
    IdProperties idProperties;

    /**
     * 初始化
     */
    @PostConstruct
    private void init() {
        // 存在配置
        if (!(idProperties.getMachineId() == null && idProperties.getMachineBits() == null
                && idProperties.getSequenceBits() == null)) {
            // machineId为null去设置默认值
            if (idProperties.getMachineId() == null) {
                idProperties.setMachineId(DEFAULT_MACHINE_ID);
            }
            // machineBits为null去设置默认值
            if (idProperties.getMachineBits() == null) {
                idProperties.setMachineBits(DEFAULT_MACHINE_BITS);
            }
            // sequenceBits为null去设置默认值
            if (idProperties.getSequenceBits() == null) {
                idProperties.setSequenceBits(DEFAULT_SEQUENCE_BITS);
            }
            // 初始化高性能Id生成器
            Id.init(idProperties.getMachineId(), idProperties.getMachineBits(), idProperties.getSequenceBits());
        }
    }

}
