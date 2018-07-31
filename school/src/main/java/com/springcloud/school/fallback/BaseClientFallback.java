package com.springcloud.school.fallback;

import com.springcloud.school.client.BaseClient;
import com.springcloud.school.dto.Response;
import org.springframework.stereotype.Component;

/**
 * @author huangzurong
 */
@Component
public class BaseClientFallback<T,ID> implements BaseClient<T,ID> {

    @Override
    public Response<T> findById(ID id) {
        Response<T> response = new Response<>();
        response.setCode(Response.INTERNAL_ERROR);
        response.setMessage("请求失败：网络错误");
        return response;
    }
}
