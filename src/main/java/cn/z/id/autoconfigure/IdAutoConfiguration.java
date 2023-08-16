package cn.z.id.autoconfigure;

import cn.z.id.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

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
@Configuration
@EnableConfigurationProperties(IdProperties.class)
public class IdAutoConfiguration {

    /**
     * 日志实例
     */
    private static final Logger log = LoggerFactory.getLogger(IdAutoConfiguration.class);
    /**
     * machineId默认值{@value}
     */
    private static final long DEFAULT_MACHINE_ID = 0L;
    /**
     * machineBits默认值{@value}
     */
    private static final long DEFAULT_MACHINE_BITS = 8L;
    /**
     * sequenceBits默认值{@value}
     */
    private static final long DEFAULT_SEQUENCE_BITS = 12L;
    /**
     * IdProperties
     */
    private final IdProperties idProperties;

    /**
     * 构造函数(自动注入)
     *
     * @param idProperties IdProperties
     */
    public IdAutoConfiguration(IdProperties idProperties) {
        this.idProperties = idProperties;
    }

    /**
     * 初始化
     */
    @PostConstruct
    public void init() {
        // 存在配置
        if (!(idProperties.getMachineId() == null && idProperties.getMachineBits() == null && idProperties.getSequenceBits() == null)) {
            String msg = "高性能雪花ID生成器配置：机器码MACHINE_ID ";
            // machineId为null去设置默认值
            if (idProperties.getMachineId() == null) {
                idProperties.setMachineId(DEFAULT_MACHINE_ID);
                msg += DEFAULT_MACHINE_ID + " (默认)";
            } else {
                msg += idProperties.getMachineId() + " ";
            }
            // machineBits为null去设置默认值
            msg += "，机器码位数MACHINE_BITS ";
            if (idProperties.getMachineBits() == null) {
                idProperties.setMachineBits(DEFAULT_MACHINE_BITS);
                msg += DEFAULT_MACHINE_BITS + " (默认)";
            } else {
                msg += idProperties.getMachineBits() + " ";
            }
            // sequenceBits为null去设置默认值
            msg += "，序列号位数SEQUENCE_BITS ";
            if (idProperties.getSequenceBits() == null) {
                idProperties.setSequenceBits(DEFAULT_SEQUENCE_BITS);
                msg += DEFAULT_SEQUENCE_BITS + " (默认)";
            } else {
                msg += idProperties.getSequenceBits();
            }
            log.info(msg);
            // 初始化
            Id.init(idProperties.getMachineId(), idProperties.getMachineBits(), idProperties.getSequenceBits());
        }
    }

}
