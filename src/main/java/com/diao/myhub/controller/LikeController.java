package com.diao.myhub.controller;

import com.diao.myhub.dto.GreatDTO;
import com.diao.myhub.enums.LikeStatusEnum;
import com.diao.myhub.enums.LikeTypeEnum;
import com.diao.myhub.exception.CustomizeError;
import com.diao.myhub.exception.CustomizeException;
import com.diao.myhub.model.Great;
import com.diao.myhub.model.User;
import com.diao.myhub.service.GreatService;
import com.diao.myhub.service.QuestionService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * @author Morty
 */
@Controller
public class LikeController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private GreatService greatService;
    @RequestMapping(value = "/like",method = RequestMethod.POST)
    @ResponseBody
    @Transactional(rollbackFor = RuntimeException.class)
    public String like(@RequestBody  GreatDTO greatDTO , HttpServletRequest req){
        User user = (User) req.getSession().getAttribute("user");
        // 支持匿名评论,先更新问题以及评论数据库中点赞数量
        if (LikeTypeEnum.LIKE_TYPE_QUESTION.getType()==greatDTO.getType()){
            if (LikeStatusEnum.LIKE_STATUS_LIKED.getStatus()==greatDTO.getStatus()){
              questionService.updateLikeInc(greatDTO.getLikeId());
            }
            else if (LikeStatusEnum.LIKE_STATUS_UNLIKE.getStatus()==greatDTO.getStatus()){
                questionService.updateLikeDec(greatDTO.getLikeId());
            }
        }else if (LikeTypeEnum.LIKE_TYPE_COMMENT.getType()==greatDTO.getType()){}
        // 如果用户不为空,记录或修改点赞对象和用户的关系
        if (user!=null){
            List<Great> record =  greatService.getLikeRecord(user.getId(),greatDTO.getType(),greatDTO.getLikeId());
            Great great = new Great();
            BeanUtils.copyProperties(greatDTO,great);
            great.setUserId(user.getId());
            if (record==null||record.size()==0){
                greatService.createRecord(great);
            }else {
                // 刷新数据库记录当中的点赞状态
                record.get(0).setStatus(greatDTO.getStatus());
                greatService.updateRecord(record.get(0));
            }
        }
        return "ok";
    }
}
