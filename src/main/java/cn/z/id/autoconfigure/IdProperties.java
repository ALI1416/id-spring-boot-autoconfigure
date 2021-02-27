package cn.z.id.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <h1>高性能Id生成器配置属性</h1>
 *
 * <p>
 * createDate 2021/02/25 14:40:55
 * </p>
 *
 * @author ALI[ali-k@foxmail.com]
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = IdProperties.ID_PREFIX)
public class IdProperties {

    /**
     * 前缀{@value}
     */
    public static final String ID_PREFIX = "id";
    /**
     * 机器码(默认值0)
     */
    private Long machineId;
    /**
     * 机器码位数(默认值8)
     */
    private Long machineBits;
    /**
     * 序列号位数(默认值12)
     */
    private Long sequenceBits;

    public Long getMachineId() {
        return machineId;
    }

    public void setMachineId(Long machineId) {
        this.machineId = machineId;
    }

    public Long getMachineBits() {
        return machineBits;
    }

    public void setMachineBits(Long machineBits) {
        this.machineBits = machineBits;
    }

    public Long getSequenceBits() {
        return sequenceBits;
    }

    public void setSequenceBits(Long sequenceBits) {
        this.sequenceBits = sequenceBits;
    }

}
