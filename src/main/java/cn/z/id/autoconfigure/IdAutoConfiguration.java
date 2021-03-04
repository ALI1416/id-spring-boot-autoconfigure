package cn.z.id.autoconfigure;

import cn.z.id.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

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
     * 日志实例
     */
    private final static Logger log = LoggerFactory.getLogger(IdAutoConfiguration.class);
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
    private final static long DEFAULT_SEQUENCE_BITS = 12L;
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
            String msg = "读取到配置文件";
            // machineId为null去设置默认值
            if (idProperties.getMachineId() == null) {
                idProperties.setMachineId(DEFAULT_MACHINE_ID);
            } else {
                msg += "，MACHINE_ID为" + idProperties.getMachineId();
            }
            // machineBits为null去设置默认值
            if (idProperties.getMachineBits() == null) {
                idProperties.setMachineBits(DEFAULT_MACHINE_BITS);
            } else {
                msg += "，MACHINE_BITS为" + idProperties.getMachineBits();
            }
            // sequenceBits为null去设置默认值
            if (idProperties.getSequenceBits() == null) {
                idProperties.setSequenceBits(DEFAULT_SEQUENCE_BITS);
            } else {
                msg += "，SEQUENCE_BITS为" + idProperties.getSequenceBits();
            }
            log.info(msg);
            // 初始化
            Id.init(idProperties.getMachineId(), idProperties.getMachineBits(), idProperties.getSequenceBits());
        }
    }

}
