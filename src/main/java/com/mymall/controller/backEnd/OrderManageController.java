package com.mymall.controller.backEnd;


import com.github.pagehelper.PageInfo;
import com.mymall.common.Const;
import com.mymall.common.ResponseCode;
import com.mymall.common.ServerResponse;
import com.mymall.pojo.User;
import com.mymall.service.IOrderService;
import com.mymall.service.IUserService;
import com.mymall.vo.OrderVo;
import net.sf.jsqlparser.schema.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/manage/order")
public class OrderManageController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IOrderService iOrderService;


    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<PageInfo> orderList(HttpSession session,
                                              @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                              @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"please log in as administrator");
        }
        if(iUserService.checkRoleAdmin(user).isSuccess()){

            return iOrderService.manageList(pageNum,pageSize);

        }else {
            return ServerResponse.createByErrorMessage("Unauthorized user, please log in as administrator");
        }
    }

    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse<OrderVo> orderDetail(HttpSession session, Long orderNo){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"please log in as administrator");
        }
        if(iUserService.checkRoleAdmin(user).isSuccess()){

            return iOrderService.manageDetail(orderNo);

        }else {
            return ServerResponse.createByErrorMessage("Unauthorized user, please log in as administrator");
        }
    }

    @RequestMapping("search.do")
    @ResponseBody
    public ServerResponse<PageInfo> orderSearch(HttpSession session, Long orderNo,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                               @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"please log in as administrator");
        }
        if(iUserService.checkRoleAdmin(user).isSuccess()){
            return iOrderService.manageSearch(orderNo,pageNum,pageSize);
        }else {
            return ServerResponse.createByErrorMessage("Unauthorized user, please log in as administrator");
        }
    }

    @RequestMapping("send_goods.do")
    @ResponseBody
    public ServerResponse<String> orderSendGoods(HttpSession session, Long orderNo){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"please log in as administrator");
        }
        if(iUserService.checkRoleAdmin(user).isSuccess()){
            return iOrderService.manageSendGoods(orderNo);
        }else {
            return ServerResponse.createByErrorMessage("Unauthorized user, please log in as administrator");
        }
    }


}
