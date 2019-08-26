package com.zhaojun.weichat.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.zhaojun.weichat.common.annotaion.XStreamCDATA;
import lombok.Data;

/**
 * @author ZhaoJun
 * @date 2019/8/22 14:54
 */
@Data
public class Music {
    @XStreamAlias("Title")
    @XStreamCDATA
    private String title;
    @XStreamAlias("Description")
    @XStreamCDATA
    private String description;
    @XStreamAlias("MusicUrl")
    @XStreamCDATA
    private String musicUrl;
    @XStreamAlias("HQMusicUrl")
    @XStreamCDATA
    private String hQMusicUrl;
    @XStreamAlias("ThumbMediaId")
    @XStreamCDATA
    private String thumbMediaId;

}
