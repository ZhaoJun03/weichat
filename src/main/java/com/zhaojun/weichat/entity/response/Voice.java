package com.zhaojun.weichat.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author ZhaoJun
 * @date 2019/8/22 14:27
 */
@Data
public class Voice {
    @XStreamAlias("MediaId")
    private String mediaId;
}
