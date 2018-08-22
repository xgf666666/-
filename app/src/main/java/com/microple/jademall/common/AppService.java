package com.microple.jademall.common;



import com.xx.baseutilslibrary.network.entity.BaseResponseEntity;


import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
public interface AppService {
    /**
     * 注册
     */
    @FormUrlEncoded
    @POST("login/reg")
    Observable<BaseResponseEntity<Object>> register(@Field("phone") String mobile,
                                                    @Field("pwd") String pwd,
                                                    @Field("yzm") String yzm);

}


