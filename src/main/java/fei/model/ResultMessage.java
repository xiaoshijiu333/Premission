package fei.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xiaoshijiu
 * @location Premission/fei.model
 * @date 2019/4/7
 */
@Setter@Getter
public class ResultMessage<T> {

    /**
     * @function: 响应码，响应信息，响应数据
     */
    private Integer resultCode;
    private String resultMes;
    private List<T> resultData;

    /**
     * @function: 返回成功信息
     */
    public static <T> ResultMessage succ(List<T> model) {
        ResultMessage<T> result = new ResultMessage<>();
        result.setResultCode(200);
        result.setResultMes("请求成功");
        result.setResultData(model);
        return result;
    }

    /**
     * @function: 返回成功信息，没有返回数据
     */
    public static <T> ResultMessage succ() {
        ResultMessage<T> result = new ResultMessage<>();
        result.setResultCode(200);
        result.setResultMes("请求成功");
        result.setResultData(null);
        return result;
    }

    /**
     * @function: 返回失败数据
     */
    public static <T> ResultMessage fail() {
        ResultMessage<T> result = new ResultMessage<>();
        result.setResultCode(500);
        result.setResultMes("请求失败");
        result.setResultData(null);
        return result;
    }
}
