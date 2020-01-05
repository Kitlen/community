package life.majiang.community.provider;

import com.alibaba.fastjson.JSON;
import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.dto.GithupUser;
import okhttp3.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

/**
 * qingcong All rights reserved.
 * <p>
 * Author: kitlen
 * Version: 1.0
 * Created Time: 2019-12-24
 * <p>
 * Revision History:
 * Version          Date               Author			Comments
 * 1.0         	2019-12-24		kitlen			Create file
 * =========================================================================
 */
@Component
public class GithupProvider {
    public String getAccessToken(AccessTokenDTO dto) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(dto));
        Request request = new Request.Builder()
            .url("https://github.com/login/oauth/access_token")
            .post(body)
            .build();
        try (Response response = client.newCall(request).execute()) {
            String resStr = response.body().string();
            //access_token=931eb302e67bbb25d325ab4bb7d7a628b070d646&scope=user&token_type=bearer
            System.out.println(resStr);
            String accessToken = resStr.split("&")[0].split("=")[1];
            return accessToken;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public GithupUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
            .url("https://api.github.com/user?access_token=" + accessToken)
            .build();
        try {
            Response response = client.newCall(request).execute();
            String body = response.body().string();
            GithupUser githupUser = JSON.parseObject(body, GithupUser.class);
            return githupUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

}
