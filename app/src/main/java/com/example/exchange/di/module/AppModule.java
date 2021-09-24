package com.example.exchange.di.module;

import android.app.Application;
import android.content.Context;

import com.example.exchange.BuildConfig;
import com.example.exchange.data.db.DBHelperImpl;
import com.example.exchange.data.db.IDBHelper;
import com.example.exchange.util.Constant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    @Singleton
    @Provides
    static Context provideContext(Application application) {
        return application;
    }

    @Singleton
    @Provides
    static Retrofit provideRetrofitInstance(Gson gson, RxJava2CallAdapterFactory adapterFactory,
                                            OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.SERVER_URL)
                .addCallAdapterFactory(adapterFactory)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    static Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Singleton
    @Provides
    static RxJava2CallAdapterFactory provideRxJava2CallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Singleton
    @Provides
    static OkHttpClient provideOkHttpClient( HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }

    @Singleton
    @Provides
    static HttpLoggingInterceptor provideHttpLogInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            return interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            return interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
    }

    @Singleton
    @Provides
    static IDBHelper provideDBHelper(DBHelperImpl dbHelper){
        return dbHelper;
    }

    @Provides
    static String provideDBName(){
        return Constant.DB_NAME;
    }

}
