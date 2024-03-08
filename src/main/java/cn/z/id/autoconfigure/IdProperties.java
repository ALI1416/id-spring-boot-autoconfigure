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
     * 序列号位数(默认值20)
     */
    private long sequenceBits = 20L;

    public long getSequenceBits() {
        return sequenceBits;
    }

    public void setSequenceBits(long sequenceBits) {
        this.sequenceBits = sequenceBits;
    }

}
