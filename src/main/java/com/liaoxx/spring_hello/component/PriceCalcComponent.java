package com.liaoxx.spring_hello.component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liaoxx.spring_hello.entity.user.User;
import com.liaoxx.spring_hello.entity.user.UserDto;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;


@Component
public class PriceCalcComponent {


    public static UserPriceResult userPrice(HttpServletRequest request, double costprice, double productprice, double marketprice) {
        //算sku的价格
        double price = 0.00;
        double scribingPrice = marketprice;          //划线价
        double salePrice = productprice;             //销售价
        double earnPrice = productprice - costprice; //默认赚钱的佣金 如果是会员则是需要分佣的金额
        double spill = 0.00; //需要溢价多少
        UserPriceResult result = new UserPriceResult();

        UserDto user = JSONObject.parseObject((byte[]) request.getAttribute("user_info"), User.class);


        if (user.getId() == 0 || user.getGrade_id() == 0) {
            //会员
            result.price = productprice;

            if (request.getAttribute("premium") != "" && request.getAttribute("premium") != null && request.getAttribute("order") == null) {
                String isOperation = "+";
                float premium = (float) 0.0;
                String premiumStr = String.format("%s", request.getAttribute("premium"));
                String[] premiumArr = premiumStr.split("%");
                if (premiumArr.length > 1) {
                    isOperation = "*";
                    premium = Float.parseFloat(premiumArr[0]) / 100;
                } else {
                    premium = Float.parseFloat(premiumStr);
                }
                if (isOperation.equals("+")) {
                    result.price = result.price + premium;
                    earnPrice = earnPrice + premium;
                    salePrice = salePrice + premium;
                    scribingPrice = scribingPrice + premium;
                }
                if (isOperation.equals("*")) {
                    result.price = result.price + (result.price * premium);
                    salePrice = salePrice + (salePrice * premium);
                    salePrice = salePrice + (salePrice * premium);
                    scribingPrice = scribingPrice + (scribingPrice * premium);
                }
            }
        } else {
            //有级别的
            result.price = costprice;
            scribingPrice = marketprice;
            if (user.grade.getConsumption() != 0) {
                spill = (productprice - costprice) * ((user.grade.getConsumption()) / 100);
                //减去收益
                earnPrice = earnPrice * (1 - user.grade.getConsumption() / 100);
            }
        }
        price = result.price + spill;
        result.earnPrice = Double.parseDouble(String.format("%.2f", earnPrice)); //页面显示最终算的
        result.price = Double.parseDouble(String.format("%.2f", price));                   //页面显示最终算的
        result.scribingPrice = Double.parseDouble(String.format("%.2f", scribingPrice)); //页面显示最终算的
        result.salePrice = salePrice; //页面显示最终算的
        return result;
    }


    // 功能模块:用户根据等级规则得出一个价格用户最终能赚多少钱
    // 剩余问题:无
    // 优化问题:
    // 注意问题:
    public static UserPriceResult UserPricePremium(HttpServletRequest request, double costprice, double productprice, double marketprice) {
        // 	//算sku的价格
        double price = costprice;          //划线价
        double sale_price = productprice;    //划线价
        double scribing_price = marketprice; //划线价
        UserPriceResult result = new UserPriceResult(); //划线价

        if (request.getAttribute("premium") != "" && request.getAttribute("premium") != null) {
            String is_operation = "+";

            double premium;

            String premium_str = String.format("%s", request.getAttribute("premium"));
            String[] premium_arr = premium_str.split("%");
            if (premium_arr.length > 1) {
                is_operation = "*";
                premium = Double.parseDouble(premium_arr[0]) / 100;
            } else {
                premium = Double.parseDouble(premium_str);
            }
            if (is_operation.equals("+")) {
                price = price + premium;
                sale_price = sale_price + premium;
                scribing_price = scribing_price + premium;
            }
            if (is_operation.equals("*")) {
                price = price + (price * premium);
                sale_price = sale_price + (sale_price * premium);
                scribing_price = scribing_price + (scribing_price * premium);
            }

        }

        result.price = Double.parseDouble(String.format("%.2f", price));               //页面显示最终算的
        result.scribingPrice = Double.parseDouble(String.format("%.2f", scribing_price)); //页面显示最终算的
        result.salePrice = Double.parseDouble(String.format("%.2f", sale_price));        //页面显示最终算的
        return result;
    }

}

