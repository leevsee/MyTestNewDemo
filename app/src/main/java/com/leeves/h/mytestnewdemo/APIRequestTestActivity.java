package com.leeves.h.mytestnewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Function：
 * Created by h on 2016/9/25.
 *
 * @author Leeves
 */
public class APIRequestTestActivity extends Activity {

    private Button mButton;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_request);
        mButton = (Button) findViewById(R.id.request_data_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mTextView = (TextView) findViewById(R.id.response_data_textView);

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://apis.baidu.com/")
//                .addConverterFactory(ScalarsConverterFactory.create())  //转换成String
//                .build();
//
//        IPQueryService service = retrofit.create(IPQueryService.class);//Java的动态代理模式
//
//        Call<String> call = service.getSearchIPData("182.90.3.204","38dc05aa7caf3e7d040b619c81841ce8");
//
//        call.enqueue(new Callback<String>() {
//                         @Override
//                         public void onResponse(Call<String> call, Response<String> response) {
//                             try {
//                                 JSONObject dataJson = new JSONObject(response.body());// response.body是一个String
//                                 JSONObject info = dataJson.getJSONObject("retData");
//                                 mTextView.setText(info.getString("province"));//可以直接显示在UI上
//                                 Log.i("根据IP地址获取到的国家是：",info.getString("country"));
//                             } catch (JSONException e) {
//                                 e.printStackTrace();
//                             }
//                         }
//
//                         @Override
//                         public void onFailure(Call<String> call, Throwable t) {
//                         }
//                     }
//        );

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubRequestAPI gitHubRequestAPI = retrofit.create(GitHubRequestAPI.class);

//        Call<List<GsonArrayExample>> call = gitHubRequestAPI.getGitHubSearch("square", "retrofit");
        Map<String,String> map = new HashMap<String, String>();
        map.put("q","retrofit");
        Call<GsonObjectExample> call = gitHubRequestAPI.getGitHubSearch(map);
        call.enqueue(new Callback<GsonObjectExample>() {

                         @Override
                         public void onResponse(Call<GsonObjectExample> call, Response<GsonObjectExample> response) {
                             GsonObjectExample gsonObjectExample = response.body();
                             Log.i("+++++++++++++++++",":"+gsonObjectExample.getItems());
                             List<GsonObjectExample.ItemsBean> list = gsonObjectExample.getItems();
//                             for (int i = 0; i < list.size(); i++) {
//                                 Log.i("__________________________",":"+list.get(i).getLogin());
//                             }
                             for (GsonObjectExample.ItemsBean i: list){
                                 Log.i("__________________________",":"+i.getLogin());
                                 mTextView.setText(i.getLogin());
                             }
                         }

                         @Override
                         public void onFailure(Call<GsonObjectExample> call, Throwable t) {

                         }
                     }
        );
//    public interface IPQueryService {
//        @GET("apistore/iplookupservice/iplookup")
//        Call<String> getSearchIPData(@Query("ip") String iPaddress, @Header("apikey") String apikey);
//    }
    }

    public interface GitHubRequestAPI {
//        @GET("repos/{user}/{repo}/contributors")
//        Call<List<GsonArrayExample>> getGitHubSearch(@Path("user") String userName, @Path("repo") String repoName);

        @GET("search/users")
        Call<GsonObjectExample> getGitHubSearch(@QueryMap Map<String,String> map);
    }


}
