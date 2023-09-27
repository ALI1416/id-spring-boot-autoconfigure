package cn.z.id.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <h1>高性能雪花ID生成器配置属性</h1>
 *
 * <p>
 * createDate 2021/02/25 14:40:55
 * </p>
 *
 * @author ALI[ali-k@foxmail.com]
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "id")
public class IdProperties {

    /**
     * 机器码(默认值0)
     */
    private long machineId = 0L;
    /**
     * 机器码位数(默认值8)
     */
    private long machineBits = 8L;
    /**
     * 序列号位数(默认值12)
     */
    private long sequenceBits = 12L;

    public long getMachineId() {
        return machineId;
    }

    public void setMachineId(long machineId) {
        this.machineId = machineId;
    }

    public long getMachineBits() {
        return machineBits;
    }

    public void setMachineBits(long machineBits) {
        this.machineBits = machineBits;
    }

    public long getSequenceBits() {
        return sequenceBits;
    }

    public void setSequenceBits(long sequenceBits) {
        this.sequenceBits = sequenceBits;
    }

}
