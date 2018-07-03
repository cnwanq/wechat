package com.wanq.wechat.mp.handler;

import com.wanq.wechat.mp.builder.TextBuilder;
import com.wanq.wechat.mp.util.JsonUtils;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MsgHandler extends AbstractHandler {
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context,
                                    WxMpService wxMpService,
                                    WxSessionManager sessionManager) throws WxErrorException {
        if (wxMessage.getMsgType().equals(WxConsts.XmlMsgType.EVENT)) {
            // TODO: 可以选择将消息保持到本地
        }

        // 当用户输入关键词“你好”，“客服”等，并且有客户在线试，把消息转发给客服
        try {
            if (StringUtils.startsWithAny(wxMessage.getContent(), "你好", "客服")
                    && wxMpService.getKefuService().kfOnlineList().getKfOnlineList().size() > 0) {
                return WxMpXmlOutMessage.TRANSFER_CUSTOMER_SERVICE()
                        .fromUser(wxMessage.getToUser())
                        .toUser(wxMessage.getFromUser())
                        .build();
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        // TODO: 组装回复消息
        String content = "收到消息内容："+JsonUtils.toJson(wxMessage);

        return new TextBuilder().build(content, wxMessage, wxMpService);
    }
}
