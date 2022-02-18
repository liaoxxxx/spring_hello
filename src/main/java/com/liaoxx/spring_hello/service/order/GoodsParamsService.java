package com.liaoxx.spring_hello.service.order;

import com.liaoxx.spring_hello.component.PriceCalcComponent;
import com.liaoxx.spring_hello.component.UserPriceResult;
import com.liaoxx.spring_hello.constants.MainState;
import com.liaoxx.spring_hello.constants.OrderConst;
import com.liaoxx.spring_hello.entity.goods.Goods;
import com.liaoxx.spring_hello.entity.goods.GoodsOption;
import com.liaoxx.spring_hello.entity.goods.GoodsOptionDto;
import com.liaoxx.spring_hello.entity.user.UserDto;
import com.liaoxx.spring_hello.exception.ServiceException;
import com.liaoxx.spring_hello.param.api.order.OrderSkuParams;
import com.liaoxx.spring_hello.repository.goods.GoodsOptionRepository;
import com.liaoxx.spring_hello.repository.goods.GoodsRepository;
import com.liaoxx.spring_hello.rpc.GoodsRpc;
import com.liaoxx.spring_hello.rpc.UserRpc;
import com.liaoxx.spring_hello.service.user.UserService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class GoodsParamsService {

    @Resource
    UserService userService;

    @Resource
    GoodsOptionRepository optionRepository;

    @Resource
    GoodsRepository goodsRepo;
    /*
     *  集合获取不同来源的商品的信息
     */
    public List<OrderSkuParams> orderGoodsParams(List<OrderSkuParams> params, int uid, HttpServletRequest request) throws ServiceException {
        List<OrderSkuParams> paramsList = new ArrayList<>();
        double payPrice=0.00;
        List<GoodsOption> ordinaryList = new ArrayList<>();
        //获取商品信息
        UserDto user = userService.find(uid);
        if (user == null) {
            throw new ServiceException("该用户暂时无法下单!");
        }
        //普通商品
        ordinaryList = ordinarySku(params, request);
        if (ordinaryList==null||ordinaryList.isEmpty()) {
            throw new ServiceException(" 商品中包含有下架商品(ordinaryGoodsList not found)");
        }
        //spell, err :=spellSku(params)
        //special, err :=specialSku(params, c)
        //suit, err :=suitSku(params, c)
        // seckillList, err :=seckillSku(params, c)
        // if err != nil {
        //     return nil,0, fmt.Errorf("%v", err)
        // }
        for (OrderSkuParams inputSkuParam : params) {
            OrderSkuParams orderSkuParam = new OrderSkuParams();
            orderSkuParam = inputSkuParam;
            orderSkuParam.goods_option = new GoodsOptionDto();
            Optional<Goods> goodsOptional =goodsRepo.findById(orderSkuParam.goods_id);
            if (goodsOptional.isEmpty()){
                throw new ServiceException("商品中包含有下架商品") ;
            }
            orderSkuParam.goods = goodsOptional.get();
            Map<String, Object> optionWhere = new HashMap<>();
            optionWhere.put("id", orderSkuParam.option_id);
            //校验商品库存
            GoodsOptionDto goodsOption = GoodsRpc.RPC_Get_GoodsOptionGet(optionWhere);
            if (goodsOption == null) {
                throw new ServiceException("商品中包含有下架商品(GoodsOption not found )");
            }
            if (goodsOption.getStock() < inputSkuParam.number) {
                throw new ServiceException(" 商品库存不足");
            }

            //拼团
            //  if inputSkuParam.Ty == model.OrderTySpell {
            //      for _, goodsOption :=range spell {
            //          source_id:=util.Int64s(goodsOption.Source_id)
            //          if
            //          goodsOption.Goods_id == inputSkuParam.Goods_id && inputSkuParam.Option_id == goodsOption.Option_id && inputSkuParam.Source_id == source_id
            //          {
            //              goodsOption.Ty_name = "拼团商品"
            //              orderSkuParam.GoodsOption = goodsOption
            //          }
            //      }
            //      if len(spell) == 0 {
            //          throw new ServiceException("请选商品");
            //      }
            //  }
            //普通商品
            if (inputSkuParam.ty == OrderConst.OrderTy ){

                for (GoodsOption ordinaryGoods : ordinaryList ){
                    int source_id =Integer.parseInt(goodsOption.getSource_id()) ;
                    if (goodsOption.getGoods_id() == inputSkuParam.goods_id && inputSkuParam.option_id == goodsOption.getOptionId() &&  inputSkuParam.source_id == source_id)
                    {
                        goodsOption.setTy_name("普通商品") ;
                        orderSkuParam.goods_option = goodsOption;
                    }
                }
                if (ordinaryList.size() == 0 ){
                    throw new ServiceException("请选商品");
                }
            }
            //专场
            // if inputSkuParam.Ty == model.OrderTySpecial {
            //     for _, goodsOption :=range special {
            //         source_id:=util.Int64s(goodsOption.Source_id)
            //         if
            //         goodsOption.Goods_id == inputSkuParam.Goods_id && inputSkuParam.Option_id == goodsOption.Option_id && inputSkuParam.Source_id == source_id
            //         {
            //             goodsOption.Ty_name = "专场商品"
            //             orderSkuParam.GoodsOption = goodsOption
            //         }
            //     }
            //     if len(special) == 0 {
            //         throw new ServiceException("请选商品");
            //     }
            // }
            //套照够
            //  if inputSkuParam.Ty == model.OrderTySuit {
            //      for _, goodsOption :=range suit {
            //          source_id:=util.Int64s(goodsOption.Source_id)
            //          if
            //          goodsOption.Goods_id == inputSkuParam.Goods_id && inputSkuParam.Option_id == goodsOption.Option_id && inputSkuParam.Source_id == source_id
            //          {
            //              goodsOption.Ty_name = "套装购商品"
            //              orderSkuParam.GoodsOption = goodsOption
            //          }
            //      }
            //      if len(suit) == 0 {
            //          throw new ServiceException("请选商品");
            //      }
            //  }
            //  //秒杀
            //  if inputSkuParam.Ty == model.OrderTySeckill {
            //      for _, goodsOption :=range seckillList {
            //          if goodsOption.Goods_id == inputSkuParam.Goods_id && goodsOption.Id == inputSkuParam.Option_id {
            //              goodsOption.Ty_name = "秒杀商品"
            //              orderSkuParam.GoodsOption = goodsOption
            //          }
            //      }
            //      if len(seckillList) == 0 {
            //          throw new ServiceException("请选商品");
            //
            //      }
            //  }

            if (orderSkuParam.goods_option == null || orderSkuParam.goods_option.getState() != MainState.StateOK ){
                assert orderSkuParam.goods_option != null;
                throw new ServiceException (orderSkuParam.goods_option.getTitle()+"inputSkuParam,已经下架,规格:"+orderSkuParam.goods_option.getAttr()+inputSkuParam );
            }

            if (inputSkuParam.goods_option.getStock() == 0 ){
                throw new ServiceException("您下单的%v过于火爆,目前已经没有库存了,请选择其他商品");
            }
            //如果是套装购,则走他的规则
            UserPriceResult userPriceRes=UserRpc.Get_UserPrice(request, orderSkuParam.goods_option.getCostprice(), orderSkuParam.goods_option.getProductprice(), orderSkuParam.goods_option.getMarketprice());
            orderSkuParam.costprice = userPriceRes.price ;                                                                                        //商品原价
            orderSkuParam.price =  orderSkuParam.costprice * orderSkuParam.number; //商品支付原价
            payPrice += orderSkuParam.price;
            //算出基础佣金
            orderSkuParam.commission_price = userPriceRes.earnPrice * 0.2 * inputSkuParam.number;
            orderSkuParam.second_commission_price = userPriceRes.earnPrice * 0.8 * inputSkuParam.number;
            orderSkuParam.resource_id = inputSkuParam.resource_id;
            orderSkuParam.source_id = inputSkuParam.source_id;
            orderSkuParam.source_name = orderSkuParam.goods_option.getSource_name();
            orderSkuParam.ty = inputSkuParam.ty;
            paramsList.add( orderSkuParam);
        }
        if (paramsList.size() != params.size() ){
            throw new ServiceException("商品中包含有下架商品");
        }

        return paramsList;
    }

/*    private List<GoodsOption> spellSku(List<OrderSkuParams> params) throws ServiceException {
        List<GoodsOption> optionList=new ArrayList<>();
        var (
                ids        []int64
        option_ids []int64
        spell_ids  []int64
        item       []map[string]interface{}
	)
        //组装第一个数据
        for _, vv := range params {
            if vv.Ty == model.OrderTySpell {
                ids = append(ids, vv.Goods_id)
                option_ids = append(option_ids, vv.Option_id)
                spell_ids = append(spell_ids, vv.Source_id)
                t := map[string]interface{}{
                    "option_id": vv.Option_id,
                            "goods_id":  vv.Goods_id,
                            "spell_id":  vv.Source_id,
                }
                item = append(item, t)
            }
        }
        if len(item) == 0 {
            return
        }
        //获取拼团数据
        items, err := rpc.Goods.RPC_Get_GoodsSpellGoodsOptionGetIds(spell_ids, option_ids, ids, map[string]interface{}{}, item)
        if len(items) == 0 || err != nil {
           throw new ServiceException ("团购商品中包含有下架商品,请重新选择商品");
        }
        r = items
        return
    }*/

    private List<GoodsOption> ordinarySku(List<OrderSkuParams> skuParamsList, HttpServletRequest request) throws ServiceException {


        List<Integer> ids = new ArrayList<>();
        List<Integer> optionIds = new ArrayList<>();
        List<Map<String, Integer>> item = new ArrayList<>();
        List<GoodsOption> optionList = new ArrayList<>();
        //组装第一个数据


        for (OrderSkuParams param : skuParamsList) {
            if (param.ty == OrderConst.OrderTy) {
                ids.add(param.goods_id);
                optionIds.add(param.option_id);

                Map<String, Integer> optionTmp = new HashMap<>();
                optionTmp.put("option_id", param.option_id);
                optionTmp.put("goods_id", param.goods_id);
                item.add(optionTmp);
            }
        }


        if (item.size() == 0) {
            return null;
        }
        optionList = optionRepository.findAllById(optionIds);
        if (optionList.size() == 0) {
            throw new ServiceException("团购商品中包含有下架商品,请重新选择商品");
        }
        for (int i = 0; i < optionList.size(); i++) {
            GoodsOption option = optionList.get(i);
            UserPriceResult result = PriceCalcComponent.UserPricePremium(request, option.getCostprice(), option.getProductprice(), option.getMarketprice());
            option.setCostprice(result.price);
            option.setProductprice(result.salePrice);
            option.setMarketprice(result.scribingPrice);
            option.setSource_id("0");
            optionList.set(i, option);
        }
        return optionList;
    }

   /* public List<GoodsOption> specialSku(List<OrderSkuParams> skuParamsList, HttpServletRequest request){
        List<GoodsOption> optionList =new ArrayList<>();


        var (
                ids         []int64
        option_ids  []int64
        special_ids []int64
        item        []map[string]interface{}
	)
        //组装第一个数据
        for _, vv := range params {
            if vv.Ty == model.OrderTySpecial {
                ids = append(ids, vv.Goods_id)
                option_ids = append(option_ids, vv.Option_id)
                special_ids = append(special_ids, vv.Source_id)
                t := map[string]interface{}{
                    "option_id":  vv.Option_id,
                            "goods_id":   vv.Goods_id,
                            "special_id": vv.Source_id,
                }
                item = append(item, t)
            }
        }
        if len(item) == 0 {
            return
        }
        //获取专场数据
        optionList= rpc.Goods.RPC_Get_GoodsSpecialGoodsOptionGetIds(special_ids, option_ids, ids, map[string]interface{}{}, item)
        _Rs := []*model.GoodsOption{}
        for _, v := range items {
            t := &model.GoodsOption{}
            v.Costprice, v.Productprice, v.Marketprice = rpc.User.RPC_Get_UserPricePremium(c, v.Costprice, v.Productprice, v.Marketprice)
            t = v
            _Rs = append(_Rs, t)
        }

        if len(items) == 0 || err != nil {
            return nil, fmt.Errorf("团购商品中包含有下架商品,请重新选择商品")
        }
        r = _Rs
        return

        return optionList;
    }*/
}
